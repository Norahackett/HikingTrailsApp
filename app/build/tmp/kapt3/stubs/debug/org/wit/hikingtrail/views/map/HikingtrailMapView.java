package org.wit.hikingtrail.views.map;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0014J\b\u0010%\u001a\u00020\u0015H\u0014J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\'\u001a\u00020\u0017H\u0014J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006+"}, d2 = {"Lorg/wit/hikingtrail/views/map/HikingtrailMapView;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "()V", "app", "Lorg/wit/hikingtrail/main/MainApp;", "getApp", "()Lorg/wit/hikingtrail/main/MainApp;", "setApp", "(Lorg/wit/hikingtrail/main/MainApp;)V", "binding", "Lorg/wit/hikingtrail/databinding/ActivityHikingtrailMapsBinding;", "contentBinding", "Lorg/wit/hikingtrail/databinding/ContentHikingtrailMapsBinding;", "presenter", "Lorg/wit/hikingtrail/views/map/HikingtrailMapPresenter;", "getPresenter", "()Lorg/wit/hikingtrail/views/map/HikingtrailMapPresenter;", "setPresenter", "(Lorg/wit/hikingtrail/views/map/HikingtrailMapPresenter;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onLowMemory", "onMarkerClick", "marker", "Lcom/google/android/gms/maps/model/Marker;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onResume", "onSaveInstanceState", "outState", "showHikingtrail", "hikingtrail", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "app_debug"})
public final class HikingtrailMapView extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.GoogleMap.OnMarkerClickListener {
    private org.wit.hikingtrail.databinding.ActivityHikingtrailMapsBinding binding;
    private org.wit.hikingtrail.databinding.ContentHikingtrailMapsBinding contentBinding;
    public org.wit.hikingtrail.main.MainApp app;
    public org.wit.hikingtrail.views.map.HikingtrailMapPresenter presenter;
    
    public HikingtrailMapView() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.main.MainApp getApp() {
        return null;
    }
    
    public final void setApp(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.main.MainApp p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.views.map.HikingtrailMapPresenter getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.map.HikingtrailMapPresenter p0) {
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
    public boolean onMarkerClick(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
        return false;
    }
    
    public final void showHikingtrail(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail) {
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