package com.cronosgroup.tinkerlink.model.manager;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class AppLocationManager {

    private static final String TAG = AppLocationManager.class.toString();
    private static final int MAX_ADDRESS = 2;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

    private Context mContext;
    private LocationManager mLocationManager;
    private Location userLocation;

    private AppPermissionsManager appPermissionsManager;

    private Geocoder mGeoceoder;
    private boolean updatePlaces;
    private List<Address> places;

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            userLocation = location;
            if (updatePlaces) {
                places = retrieveUserInformationFromLocation();
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    public AppLocationManager(Context context) {
        this.mContext = context;
        this.mGeoceoder = new Geocoder(mContext);
        this.appPermissionsManager = new AppPermissionsManager(context);
        initLocationManager();
    }

    private void initLocationManager() {
        this.mLocationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
    }

    private boolean isGPSEnabled() {
        return mLocationManager != null && mLocationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private boolean isNetworkEnabled() {
        return mLocationManager != null && mLocationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    private Location getLastKnownLocation() {
        if (appPermissionsManager.checkLocationPermissions()) {
            try {
                if (isGPSEnabled()) {
                    return mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                } else if (isNetworkEnabled()) {
                    return mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }
            } catch (SecurityException ex) {
                Log.d("", "");
            }
        }
        return null;
    }


    // Public methods

    public void setContext(Activity mContext) {
        this.mContext = mContext;
    }

    public boolean isUpdatePlaces() {
        return updatePlaces;
    }

    public void setUpdatePlaces(boolean updatePlaces) {
        this.updatePlaces = updatePlaces;
    }

    public Location getCurrentLocation() {
        return (userLocation != null) ? userLocation : getLastKnownLocation();
    }

    public List<Address> retrieveUserInformationFromLocation() {
        Location currentLocation = getCurrentLocation();

        try {
            if (currentLocation != null) {
                return mGeoceoder.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), MAX_ADDRESS);
            }
        } catch (IOException exception) {
            Log.d(TAG, "Error retrive Address");
        }

        return null;
    }

    public void startLocationUpdates() {
        if (appPermissionsManager.checkLocationPermissions()) {
            try {
                if (isNetworkEnabled()) {
                    mLocationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, locationListener);

                } else if (isGPSEnabled()) {
                    mLocationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, locationListener);

                } else {
                    Log.d(TAG, "GPS disabled");
                }
            } catch (SecurityException ex) {
                Log.d(TAG, "GPS permission error");
            }
        }
    }

    public void stopLocationUpdates() {
        if (appPermissionsManager.checkLocationPermissions()) {
            try {
                mLocationManager.removeUpdates(locationListener);
            } catch (SecurityException ex) {
                Log.d(TAG, "GPS permission error");
            }
        }
    }

    public Address getCurrentAddress() {
        if (places != null && places.size() > 0) {
            return places.get(0);
        }

        return null;
    }

}