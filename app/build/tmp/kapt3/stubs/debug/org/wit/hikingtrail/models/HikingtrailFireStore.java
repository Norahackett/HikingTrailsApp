package org.wit.hikingtrail.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u001e\u001a\u00020\u001fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0014\u0010%\u001a\u00020\u001f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\'J\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0)H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u001b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010+\u001a\u00020,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u000e\u0010/\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lorg/wit/hikingtrail/models/HikingtrailFireStore;", "Lorg/wit/hikingtrail/models/HikingtrailStore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "db", "Lcom/google/firebase/database/DatabaseReference;", "getDb", "()Lcom/google/firebase/database/DatabaseReference;", "setDb", "(Lcom/google/firebase/database/DatabaseReference;)V", "hikingtrails", "Ljava/util/ArrayList;", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "getHikingtrails", "()Ljava/util/ArrayList;", "st", "Lcom/google/firebase/storage/StorageReference;", "getSt", "()Lcom/google/firebase/storage/StorageReference;", "setSt", "(Lcom/google/firebase/storage/StorageReference;)V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "hikingtrail", "(Lorg/wit/hikingtrail/models/HikingtrailModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "fetchHikingtrails", "hikingtrailsReady", "Lkotlin/Function0;", "findAll", "", "findById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "updateImage", "app_debug"})
public final class HikingtrailFireStore implements org.wit.hikingtrail.models.HikingtrailStore {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<org.wit.hikingtrail.models.HikingtrailModel> hikingtrails = null;
    public java.lang.String userId;
    public com.google.firebase.database.DatabaseReference db;
    public com.google.firebase.storage.StorageReference st;
    
    public HikingtrailFireStore(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<org.wit.hikingtrail.models.HikingtrailModel> getHikingtrails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getSt() {
        return null;
    }
    
    public final void setSt(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.StorageReference p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object findAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<org.wit.hikingtrail.models.HikingtrailModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object findById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.wit.hikingtrail.models.HikingtrailModel> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object create(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object update(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object clear(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void fetchHikingtrails(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> hikingtrailsReady) {
    }
    
    public final void updateImage(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.models.HikingtrailModel hikingtrail) {
    }
}