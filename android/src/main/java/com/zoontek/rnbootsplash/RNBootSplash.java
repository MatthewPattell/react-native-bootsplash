package com.zoontek.rnbootsplash;

import android.app.Activity;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class RNBootSplash {

  public static void init(final @DrawableRes int drawableResId, @NonNull final Activity activity) {
    RNBootSplashModule.init(drawableResId, activity);
  }

  public static void showCustom(final int drawableResId, final int colorResId, @NonNull final Activity activity) {
      if (showHasRunOnce) return;

      activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          Context context = activity.getApplicationContext();
          LinearLayout layout = new LinearLayout(context);

          LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
          View view = new View(context);
          view.setBackgroundResource(drawableResId);

          layout.setId(R.id.bootsplash_layout_id);
          layout.setLayoutTransition(null);
          layout.setOrientation(LinearLayout.VERTICAL);
          layout.addView(view, params);

          layout.setBackgroundColor(activity.getResources().getColor(colorResId));

          activity.addContentView(layout, params);
          showHasRunOnce = true;
        }
      });
    }
}
