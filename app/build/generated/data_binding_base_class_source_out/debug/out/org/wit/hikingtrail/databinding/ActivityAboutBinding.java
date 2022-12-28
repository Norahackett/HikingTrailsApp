// Generated by view binder compiler. Do not edit!
package org.wit.hikingtrail.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.wit.hikingtrail.R;

public final class ActivityAboutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView aboutText;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final Toolbar toolbarAdd;

  private ActivityAboutBinding(@NonNull ConstraintLayout rootView, @NonNull TextView aboutText,
      @NonNull AppBarLayout appBarLayout, @NonNull ImageView imageView3,
      @NonNull Toolbar toolbarAdd) {
    this.rootView = rootView;
    this.aboutText = aboutText;
    this.appBarLayout = appBarLayout;
    this.imageView3 = imageView3;
    this.toolbarAdd = toolbarAdd;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAboutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAboutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_about, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAboutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aboutText;
      TextView aboutText = ViewBindings.findChildViewById(rootView, id);
      if (aboutText == null) {
        break missingId;
      }

      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.toolbarAdd;
      Toolbar toolbarAdd = ViewBindings.findChildViewById(rootView, id);
      if (toolbarAdd == null) {
        break missingId;
      }

      return new ActivityAboutBinding((ConstraintLayout) rootView, aboutText, appBarLayout,
          imageView3, toolbarAdd);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
