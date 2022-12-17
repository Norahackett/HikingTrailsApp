package org.wit.hikingtrail.views.hikingtraillist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailAdapter$MainHolder;", "hikingtrails", "", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "listener", "Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListener;", "(Ljava/util/List;Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MainHolder", "app_debug"})
public final class HikingtrailAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<org.wit.hikingtrail.views.hikingtraillist.HikingtrailAdapter.MainHolder> {
    private java.util.List<org.wit.hikingtrail.models.HikingtrailModel> hikingtrails;
    private final org.wit.hikingtrail.views.hikingtraillist.HikingtrailListener listener = null;
    
    public HikingtrailAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<org.wit.hikingtrail.models.HikingtrailModel> hikingtrails, @org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.hikingtraillist.HikingtrailListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.wit.hikingtrail.views.hikingtraillist.HikingtrailAdapter.MainHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.wit.hikingtrail.views.hikingtraillist.HikingtrailAdapter.MainHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailAdapter$MainHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lorg/wit/hikingtrail/databinding/CardHikingtrailBinding;", "(Lorg/wit/hikingtrail/databinding/CardHikingtrailBinding;)V", "bind", "", "hikingtrail", "Lorg/wit/hikingtrail/models/HikingtrailModel;", "listener", "Lorg/wit/hikingtrail/views/hikingtraillist/HikingtrailListener;", "app_debug"})
    public static final class MainHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final org.wit.hikingtrail.databinding.CardHikingtrailBinding binding = null;
        
        public MainHolder(@org.jetbrains.annotations.NotNull()
        org.wit.hikingtrail.databinding.CardHikingtrailBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        org.wit.hikingtrail.models.HikingtrailModel hikingtrail, @org.jetbrains.annotations.NotNull()
        org.wit.hikingtrail.views.hikingtraillist.HikingtrailListener listener) {
        }
    }
}