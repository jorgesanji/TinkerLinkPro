package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.SourceImageType;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategorySelectionScreen extends TLBaseView {

    public interface Listener {
        void onSelectGeoPositionPressed();

        void onSelectCategoryPressed();

        void onImageSourceSelected(SourceImageType type);
    }

    // Vars
    private Listener listener;

    // Views

    @BindView(R.id.addImageCategory)
    protected View mAddImageCategory;

    @BindView(R.id.addImageCard)
    protected View mAddImageCard;

    public CategorySelectionScreen(Context context) {
        super(context);
    }

    public CategorySelectionScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CategorySelectionScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CategorySelectionScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_categories_selection;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    private void selectSourceForImage(View anchorView) {
        PopupMenu popup = new PopupMenu(getContext(), anchorView);
        popup.getMenuInflater().inflate(R.menu.camera_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_camera:
                        listener.onImageSourceSelected(SourceImageType.CAMERA);
                        break;
                    case R.id.action_gallery:
                        listener.onImageSourceSelected(SourceImageType.GALLERY);
                        break;
                }
                return true;
            }
        });

        popup.show();
    }

    // Actions
    @OnClick(R.id.selectGeoPosition)
    protected void selectGeoPositionPressed() {
        listener.onSelectGeoPositionPressed();
    }

    @OnClick(R.id.selectorCategory)
    protected void selectCategoryPressed() {
        listener.onSelectCategoryPressed();
    }

    @OnClick(R.id.addImageCategory)
    protected void addImageCategoryPressed() {
        selectSourceForImage(mAddImageCategory);
    }

    @OnClick(R.id.addImageCard)
    protected void addImageCard() {
        selectSourceForImage(mAddImageCard);
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}
