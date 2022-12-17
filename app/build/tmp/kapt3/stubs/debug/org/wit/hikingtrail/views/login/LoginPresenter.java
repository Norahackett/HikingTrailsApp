package org.wit.hikingtrail.views.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\b\u0010\"\u001a\u00020\u001dH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lorg/wit/hikingtrail/views/login/LoginPresenter;", "", "view", "Lorg/wit/hikingtrail/views/login/LoginView;", "(Lorg/wit/hikingtrail/views/login/LoginView;)V", "app", "Lorg/wit/hikingtrail/main/MainApp;", "getApp", "()Lorg/wit/hikingtrail/main/MainApp;", "setApp", "(Lorg/wit/hikingtrail/main/MainApp;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "fireStore", "Lorg/wit/hikingtrail/models/HikingtrailFireStore;", "getFireStore", "()Lorg/wit/hikingtrail/models/HikingtrailFireStore;", "setFireStore", "(Lorg/wit/hikingtrail/models/HikingtrailFireStore;)V", "loginIntentLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getView", "()Lorg/wit/hikingtrail/views/login/LoginView;", "doLogin", "", "email", "", "password", "doSignUp", "registerLoginCallback", "app_debug"})
public final class LoginPresenter {
    @org.jetbrains.annotations.NotNull()
    private final org.wit.hikingtrail.views.login.LoginView view = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> loginIntentLauncher;
    @org.jetbrains.annotations.NotNull()
    private org.wit.hikingtrail.main.MainApp app;
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.auth.FirebaseAuth auth;
    @org.jetbrains.annotations.Nullable()
    private org.wit.hikingtrail.models.HikingtrailFireStore fireStore;
    
    public LoginPresenter(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.login.LoginView view) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.views.login.LoginView getView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.wit.hikingtrail.main.MainApp getApp() {
        return null;
    }
    
    public final void setApp(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.main.MainApp p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.wit.hikingtrail.models.HikingtrailFireStore getFireStore() {
        return null;
    }
    
    public final void setFireStore(@org.jetbrains.annotations.Nullable()
    org.wit.hikingtrail.models.HikingtrailFireStore p0) {
    }
    
    public final void doLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void doSignUp(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final void registerLoginCallback() {
    }
}