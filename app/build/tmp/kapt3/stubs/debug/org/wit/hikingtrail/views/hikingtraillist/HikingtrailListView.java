package org.wit.hikingtrail.views.hikingtraillist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0017H\u0014J\b\u0010%\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006&"}, d2 = {"Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListView;", "Landroidx/appcompat/app/AppCompatActivity;", "Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListener;", "()V", "app", "Lorg/wit/hikingtrail/main/MainApp;", "getApp", "()Lorg/wit/hikingtrail/main/MainApp;", "setApp", "(Lorg/wit/hikingtrail/main/MainApp;)V", "binding", "Lorg/wit/hikingtrail/databinding/ActivityHikingtrailListBinding;", "getBinding", "()Lorg/wit/hikingtrail/databinding/ActivityHikingtrailListBinding;", "setBinding", "(Lorg/wit/hikingtrail/databinding/ActivityHikingtrailListBinding;)V", "presenter", "Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListPresenter;", "getPresenter", "()Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListPresenter;", "setPresenter", "(Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListPresenter;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onHikingtrailClick", "hikingtrail", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "updateRecyclerView", "app_debug"})
public final class HikingtrailListView extends androidx.appcompat.app.AppCompatActivity implements org.wit.hikingtrail.views.hikingtraillist.HikingtrailListener {
    public org.wit.hikingtrail.main.MainApp app;
    public org.wit.hikingtrail.databinding.ActivityHikingtrailListBinding binding;
    public org.wit.hikingtrail.views.hikingtraillist.HikingtrailListPresenter presenter;
    
    public HikingtrailListView() {
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
    public final org.wit.hikingtrail.databinding.ActivityHikingtrailListBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.databinding.ActivityHikingtrailListBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.views.hikingtraillist.HikingtrailListPresenter getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.hikingtraillist.HikingtrailListPresenter p0) {
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
    protected void onResume() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onHikingtrailClick(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail) {
    }
    
    private final void updateRecyclerView() {
    }
}