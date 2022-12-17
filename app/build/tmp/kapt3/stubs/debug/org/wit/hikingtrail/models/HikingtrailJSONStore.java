package org.wit.hikingtrail.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\u0019\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lorg/wit/hikingtrail/models/HikingtrailJSONStore;", "Lorg/wit/hikingtrail/models/HikingtrailStore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hikingtrails", "", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "getHikingtrails", "()Ljava/util/List;", "setHikingtrails", "(Ljava/util/List;)V", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "hikingtrail", "(Lorg/wit/hikingtrail/models/HikingtrailModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "deserialize", "findAll", "findById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logAll", "serialize", "update", "app_debug"})
public final class HikingtrailJSONStore implements org.wit.hikingtrail.models.HikingtrailStore {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<org.wit.hikingtrail.models.HikingtrailModel> hikingtrails;
    
    public HikingtrailJSONStore(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.wit.hikingtrail.models.HikingtrailModel> getHikingtrails() {
        return null;
    }
    
    public final void setHikingtrails(@org.jetbrains.annotations.NotNull()
    java.util.List<org.wit.hikingtrail.models.HikingtrailModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object findAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<org.wit.hikingtrail.models.HikingtrailModel>> continuation) {
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
    public java.lang.Object findById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.wit.hikingtrail.models.HikingtrailModel> continuation) {
        return null;
    }
    
    private final void serialize() {
    }
    
    private final void deserialize() {
    }
    
    private final void logAll() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object clear(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}