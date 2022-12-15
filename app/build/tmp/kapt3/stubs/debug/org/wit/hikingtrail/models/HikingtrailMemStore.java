package org.wit.hikingtrail.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0019\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lorg/wit/hikingtrail/models/HikingtrailMemStore;", "Lorg/wit/hikingtrail/models/HikingtrailStore;", "()V", "hikingtrails", "Ljava/util/ArrayList;", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "getHikingtrails", "()Ljava/util/ArrayList;", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "hikingtrail", "(Lorg/wit/hikingtrail/models/HikingtrailModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "findAll", "", "findById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logAll", "update", "app_debug"})
public final class HikingtrailMemStore implements org.wit.hikingtrail.models.HikingtrailStore {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<org.wit.hikingtrail.models.HikingtrailModel> hikingtrails = null;
    
    public HikingtrailMemStore() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<org.wit.hikingtrail.models.HikingtrailModel> getHikingtrails() {
        return null;
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
    
    private final void logAll() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object findById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.wit.hikingtrail.models.HikingtrailModel> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object clear(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}