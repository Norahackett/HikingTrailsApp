package org.wit.hikingtrail.views.hikingtrail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0014J\b\u0010!\u001a\u00020\u0014H\u0014J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0016H\u0014J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\'H\u0002J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lorg/wit/hikingtrail/views/hikingtrail/HikingtrailView;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lorg/wit/hikingtrail/databinding/ActivityHikingtrailBinding;", "hikingtrail", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "getHikingtrail", "()Lorg/wit/hikingtrail/models/HikingtrailModel;", "setHikingtrail", "(Lorg/wit/hikingtrail/models/HikingtrailModel;)V", "map", "Lcom/google/android/gms/maps/GoogleMap;", "getMap", "()Lcom/google/android/gms/maps/GoogleMap;", "setMap", "(Lcom/google/android/gms/maps/GoogleMap;)V", "presenter", "Lorg/wit/hikingtrail/views/hikingtrail/HikingtrailPresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onLowMemory", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onResume", "onSaveInstanceState", "outState", "showHikingtrail", "showLocation", "loc", "Lorg/wit/hikingtrail/models/Location;", "updateImage", "image", "", "app_debug"})
public final class HikingtrailView extends androidx.appcompat.app.AppCompatActivity {
    private org.wit.hikingtrail.databinding.ActivityHikingtrailBinding binding;
    private org.wit.hikingtrail.views.hikingtrail.HikingtrailPresenter presenter;
    public com.google.android.gms.maps.GoogleMap map;
    @org.jetbrains.annotations.NotNull()
    private org.wit.hikingtrail.models.HikingtrailModel hikingtrail;
    
    public HikingtrailView() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.GoogleMap getMap() {
        return null;
    }
    
    public final void setMap(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.models.HikingtrailModel getHikingtrail() {
        return null;
    }
    
    public final void setHikingtrail(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel p0) {
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
    
    public final void showHikingtrail(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail) {
    }
    
    private final void showLocation(org.wit.hikingtrail.models.Location loc) {
    }
    
    public final void updateImage(@org.jetbrains.annotations.NotNull()
    java.lang.String image) {
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