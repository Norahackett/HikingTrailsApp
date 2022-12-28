package org.wit.hikingtrail.views.location;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lorg/wit/hikingtrail/views/location/EditLocationPresenter;", "", "view", "Lorg/wit/hikingtrail/views/location/EditLocationView;", "(Lorg/wit/hikingtrail/views/location/EditLocationView;)V", "location", "Lorg/wit/hikingtrail/models/Location;", "getLocation", "()Lorg/wit/hikingtrail/models/Location;", "setLocation", "(Lorg/wit/hikingtrail/models/Location;)V", "getView", "()Lorg/wit/hikingtrail/views/location/EditLocationView;", "doCancel", "", "doOnBackPressed", "doUpdateLocation", "lat", "", "lng", "doUpdateMarker", "marker", "Lcom/google/android/gms/maps/model/Marker;", "initMap", "map", "Lcom/google/android/gms/maps/GoogleMap;", "app_debug"})
public final class EditLocationPresenter {
    @org.jetbrains.annotations.NotNull()
    private final org.wit.hikingtrail.views.location.EditLocationView view = null;
    @org.jetbrains.annotations.NotNull()
    private org.wit.hikingtrail.models.Location location;
    
    public EditLocationPresenter(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.location.EditLocationView view) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.views.location.EditLocationView getView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.models.Location getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.Location p0) {
    }
    
    public final void initMap(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap map) {
    }
    
    public final void doUpdateLocation(double lat, double lng) {
    }
    
    public final void doOnBackPressed() {
    }
    
    public final void doUpdateMarker(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
    }
    
    public final void doCancel() {
    }
}