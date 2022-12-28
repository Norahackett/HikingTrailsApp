package org.wit.hikingtrail.views.location;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0016H\u0014J\b\u0010*\u001a\u00020\u0016H\u0014J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0019H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006-"}, d2 = {"Lorg/wit/hikingtrail/views/location/EditLocationView;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerDragListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "()V", "binding", "Lorg/wit/hikingtrail/databinding/ActivityMapBinding;", "location", "Lorg/wit/hikingtrail/models/Location;", "getLocation", "()Lorg/wit/hikingtrail/models/Location;", "setLocation", "(Lorg/wit/hikingtrail/models/Location;)V", "map", "Lcom/google/android/gms/maps/GoogleMap;", "presenter", "Lorg/wit/hikingtrail/views/location/EditLocationPresenter;", "getPresenter", "()Lorg/wit/hikingtrail/views/location/EditLocationPresenter;", "setPresenter", "(Lorg/wit/hikingtrail/views/location/EditLocationPresenter;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onLowMemory", "onMarkerClick", "marker", "Lcom/google/android/gms/maps/model/Marker;", "onMarkerDrag", "onMarkerDragEnd", "onMarkerDragStart", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onResume", "onSaveInstanceState", "outState", "app_debug"})
public final class EditLocationView extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.GoogleMap.OnMarkerDragListener, com.google.android.gms.maps.GoogleMap.OnMarkerClickListener {
    private org.wit.hikingtrail.databinding.ActivityMapBinding binding;
    private com.google.android.gms.maps.GoogleMap map;
    public org.wit.hikingtrail.views.location.EditLocationPresenter presenter;
    @org.jetbrains.annotations.NotNull()
    private org.wit.hikingtrail.models.Location location;
    
    public EditLocationView() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.views.location.EditLocationPresenter getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.location.EditLocationPresenter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.models.Location getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.Location p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onMarkerDragStart(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
    }
    
    @java.lang.Override()
    public void onMarkerDrag(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
    }
    
    @java.lang.Override()
    public void onMarkerDragEnd(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
    }
    
    @java.lang.Override()
    public boolean onMarkerClick(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onLowMemory() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
}