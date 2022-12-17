// Generated by view binder compiler. Do not edit!
package org.wit.hikingtrail.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.wit.hikingtrail.R;

public final class FragmentAboutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout aboutFragment;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final TextView tvAboutUs;

  private FragmentAboutBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout aboutFragment, @NonNull ImageView imageView3,
      @NonNull TextView tvAboutUs) {
    this.rootView = rootView;
    this.aboutFragment = aboutFragment;
    this.imageView3 = imageView3;
    this.tvAboutUs = tvAboutUs;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_about, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAboutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout aboutFragment = (ConstraintLayout) rootView;

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.tvAboutUs;
      TextView tvAboutUs = ViewBindings.findChildViewById(rootView, id);
      if (tvAboutUs == null) {
        break missingId;
      }

      return new FragmentAboutBinding((ConstraintLayout) rootView, aboutFragment, imageView3,
          tvAboutUs);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}