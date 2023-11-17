package me.t3sl4.galaxyguide.Permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

public class PermissionControl {
    private Context context;

    public PermissionControl(Context context) {
        this.context = context;
    }

    public boolean checkPermission(String permission) {
        if (Permissions.contains(permission)) {
            if (checkManifestPermission(permission)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkManifestPermission(String permission) {
        try {
            int result = context.getPackageManager().checkPermission(permission, context.getPackageName());
            return result == PackageManager.PERMISSION_GRANTED;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void requestPermission(String permission, @Nullable Integer requestCode) {
        if(requestCode == null) {
            requestCode = 123;
        }
        ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, requestCode);
    }

    private void checkAndRequestPermission(String permission, @Nullable Integer requestCode) {
        if(checkPermission(permission)) {
            requestPermission(permission, requestCode);
        }
    }
}
