package org.wit.hikingtrail.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"REQUEST_PERMISSIONS_REQUEST_CODE", "", "checkLocationPermissions", "", "activity", "Landroid/app/Activity;", "createDefaultLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "app_debug"})
public final class LocationHelperKt {
    public static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    
    public static final boolean checkLocationPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    public static final com.google.android.gms.location.LocationRequest createDefaultLocationRequest() {
        return null;
    }
}