package org.wit.hikingtrail.views.hikingtraillist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0014\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListPresenter;", "", "view", "Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListView;", "(Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListView;)V", "app", "Lorg/wit/hikingtrail/main/MainApp;", "getApp", "()Lorg/wit/hikingtrail/main/MainApp;", "setApp", "(Lorg/wit/hikingtrail/main/MainApp;)V", "editIntentLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "refreshIntentLauncher", "doAddHikingtrail", "", "doEditHikingtrail", "hikingtrail", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "doLogout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doShowAbout", "doShowHikingtrailsMap", "getHikingtrails", "", "registerEditCallback", "registerRefreshCallback", "app_debug"})
public final class HikingtrailListPresenter {
    private final org.wit.hikingtrail.views.hikingtraillist.HikingtrailListView view = null;
    @org.jetbrains.annotations.NotNull()
    private org.wit.hikingtrail.main.MainApp app;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> refreshIntentLauncher;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> editIntentLauncher;
    
    public HikingtrailListPresenter(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.hikingtraillist.HikingtrailListView view) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.main.MainApp getApp() {
        return null;
    }
    
    public final void setApp(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.main.MainApp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHikingtrails(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<org.wit.hikingtrail.models.HikingtrailModel>> continuation) {
        return null;
    }
    
    public final void doAddHikingtrail() {
    }
    
    public final void doShowAbout() {
    }
    
    public final void doEditHikingtrail(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail) {
    }
    
    public final void doShowHikingtrailsMap() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object doLogout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void registerRefreshCallback() {
    }
    
    private final void registerEditCallback() {
    }
}