package com.cronosgroup.tinkerlink.model.manager;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;

import com.cronosgroup.core.utils.BitmapUtils;
import com.cronosgroup.core.utils.FilePath;
import com.cronosgroup.core.utils.FileUtils;
import com.cronosgroup.core.view.crop.CropActivity;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/27/15.
 */
public class AppImagePickerManager {

    public interface IOPickerImageSelector {

        void onMultiImagesSelected(List<Bitmap> images);

        void onImageSelected(Bitmap original, Bitmap cropped);

        void onCancel();

        void onError();
    }

    public static final String IMAGE_TO_CROP = "bitmapToCrop";
    public static final String IMAGE_ORIGINAL = "bitmapOriginal";
    public static final String IMAGE_CROPPED = "bitmapCropped";

    private static final int CAMERA_CAPTURE = 2000;
    private static final int IMAGE_PICKER = 3000;
    private static final int CROP_CAPTURE = 4000;
    private static final int DEFAULT_SIZE = 400;

    private Object Owner;
    private boolean cropImage;
    private boolean multipleSelection = false;
    private IOPickerImageSelector listener;
    private AppPermissionsManager permissionsManager;
    private File output = null;

    public AppImagePickerManager() {
        this(null, null, false);
    }

    public AppImagePickerManager(Object owner, IOPickerImageSelector listener, boolean cropImage) {
        this.Owner = owner;
        this.listener = listener;
        this.cropImage = cropImage;
        this.permissionsManager = new AppPermissionsManager(getContext());
    }

    private AppCompatActivity getActivity() {
        if (Owner instanceof AppCompatActivity) {
            return (AppCompatActivity) Owner;
        }

        return null;
    }

    private Fragment getFragment() {
        if (Owner instanceof Fragment) {
            return (Fragment) Owner;
        }

        return null;
    }

    private Activity getContext() {
        return (getActivity() != null) ? getActivity() : (getFragment() != null) ? getFragment().getActivity() : null;
    }

    private void selectImage(Intent data) {
        Uri selectedImageUri = data.getData();

        if (selectedImageUri != null) {
            try {
                String file = FilePath.getPath(getContext(), selectedImageUri);
                Bitmap bitmap = BitmapUtils.decodeScaledBitmap(file, DEFAULT_SIZE, DEFAULT_SIZE);
                Pair<File, Bitmap> pair = FileUtils.saveBitmapInFile(getContext(), bitmap, IMAGE_ORIGINAL);
                File fileTemp = pair.first;
                if (isCropImage()) {
                    showCrop(fileTemp.getAbsolutePath());
                } else {
                    getListener().onImageSelected(pair.second, null);
                }
            } catch (Exception exception) {
                if (getListener() != null) {
                    getListener().onError();
                    return;
                }
            }
        } else if (getListener() != null) {
            getListener().onError();
            return;
        }
    }

    private void showCrop(String path) {
        if (path != null) {
            Intent cropIntent = new Intent(getContext(), CropActivity.class);
            cropIntent.putExtra(IMAGE_TO_CROP, path);
            if (getFragment() != null) {
                getFragment().startActivityForResult(cropIntent, CROP_CAPTURE);
            } else {
                getActivity().startActivityForResult(cropIntent, CROP_CAPTURE);
            }
        } else if (getListener() != null) {
            getListener().onError();
            return;
        }
    }

    //Public methods

    public boolean isCropImage() {
        return cropImage;
    }

    public void setCropImage(boolean cropImage) {
        this.cropImage = cropImage;
    }

    public IOPickerImageSelector getListener() {
        return listener;
    }

    public void setListener(IOPickerImageSelector listener) {
        this.listener = listener;
    }

    public Object getOwner() {
        return Owner;
    }

    public boolean isMultipleSelection() {
        return multipleSelection;
    }

    public void setMultipleSelection(boolean multipleSelection) {
        this.multipleSelection = multipleSelection;
    }

    public void setOwner(Object owner) {
        this.Owner = owner;
        this.permissionsManager.setContext(getContext());
    }

    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        if (resultCode == Activity.RESULT_CANCELED) {
            if (getListener() != null) {
                getListener().onCancel();
            }
        } else {

            if (data != null && (data.getExtras() != null || data.getData() != null)) {

                if (isCropImage() && requestCode == CROP_CAPTURE) {
                    Bitmap original = BitmapUtils.decodeFromFile(data.getExtras().getString(IMAGE_ORIGINAL));
                    Bitmap cropped = BitmapUtils.decodeFromFile(data.getExtras().getString(IMAGE_CROPPED));
                    getListener().onImageSelected(original, cropped);
                } else {

                    if (requestCode == IMAGE_PICKER) {

                        if (isMultipleSelection()) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                ClipData clip = data.getClipData();
                                List<Bitmap> bitmapList = new ArrayList<>();

                                if (clip != null) {
                                    for (int i = 0; i < clip.getItemCount(); i++) {
                                        Uri uri = clip.getItemAt(i).getUri();
                                        String file = FilePath.getPath(getContext(), uri);
                                        Bitmap bitmap = BitmapUtils.decodeScaledBitmap(file, DEFAULT_SIZE, DEFAULT_SIZE);
                                        bitmapList.add(bitmap);
                                    }

                                    if (getListener() != null) {
                                        getListener().onMultiImagesSelected(bitmapList);
                                        return;
                                    }

                                } else {
                                    if (getListener() != null) {
                                        getListener().onError();
                                        return;
                                    }
                                }

                            } else {
                                selectImage(data);
                            }
                        } else {
                            selectImage(data);
                        }
                    }
                }
            } else if (requestCode == CAMERA_CAPTURE) {
                if (output != null) {

                    AsyncLoader asyncLoader = new AsyncLoader<Bitmap>() {
                        @Override
                        public Bitmap doInBackground() {
                            return isCropImage() ? null : BitmapUtils.compress(BitmapUtils.decodeFromFile(output.getAbsolutePath()), 50);
                        }

                        @Override
                        public void postProcess(Bitmap bitmap) {
                            if (isCropImage()) {
                                showCrop(output.getAbsolutePath());
                            } else {
                                getListener().onImageSelected(bitmap, null);
                            }

                            output = null;
                        }
                    };

                    asyncLoader.start();

                } else if (getListener() != null) {
                    getListener().onError();
                    return;
                }
            }
        }
    }

    public boolean launchCamera() {
        if (permissionsManager.checkCameraPermissions()) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            output = new File(dir, IMAGE_ORIGINAL + ".jgeg");
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));

            if (getFragment() != null) {
                getFragment().startActivityForResult(cameraIntent, CAMERA_CAPTURE);
            } else {
                getActivity().startActivityForResult(cameraIntent, CAMERA_CAPTURE);
            }


            return true;
        }

        return false;
    }

    public boolean launchGallery() {
        if (permissionsManager.checkGalleryPermissions()) {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            if (isMultipleSelection()) {
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            }

            if (getFragment() != null) {
                getFragment().startActivityForResult(intent, IMAGE_PICKER);
            } else {
                getActivity().startActivityForResult(intent, IMAGE_PICKER);
            }

            return true;
        }

        return false;
    }

    public AppPermissionsManager getPermissionsManager() {
        return permissionsManager;
    }
}
