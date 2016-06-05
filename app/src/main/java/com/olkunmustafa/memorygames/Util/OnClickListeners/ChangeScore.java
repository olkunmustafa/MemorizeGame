package com.olkunmustafa.memorygames.Util.OnClickListeners;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;

/**
 * Created by olkunmustafa on 05/06/16
 */
public class ChangeScore {

    private ViewGroup scoreLayout;

    /**
     * Context object
     *
     * @since 0.1.0
     */
    private MainActivity mContext;

    public ChangeScore( MainActivity mContext ) {
        this.mContext = mContext;

    }

    /**
     * Increases the main point when the user
     * clicked the true squares.
     *
     * @since 0.1.0
     */
    public void increase() {

        // Fetch the view from point layout
        final ViewGroup scoreLayout = ( ViewGroup ) LayoutInflater.from( mContext ).inflate( R.layout.point_layout, null );
        scoreLayout.setAlpha( 0f );

        // Add view that is fetched
        this.getmContext().getScoreWrapper()
                .addView( scoreLayout );

        // Add START animations Alpha and TranslationY
        PropertyValuesHolder startAlpha
                = PropertyValuesHolder.ofFloat( View.ALPHA, 1f );
        PropertyValuesHolder startTranslation
                = PropertyValuesHolder.ofFloat( View.TRANSLATION_Y, -100f );

        ObjectAnimator animatorStart
                = ObjectAnimator.ofPropertyValuesHolder( scoreLayout, startAlpha, startTranslation );

        animatorStart.setDuration( 700 );
        animatorStart.start();

        // When START animations endsi define the END animations.
        PropertyValuesHolder endAlpha
                = PropertyValuesHolder.ofFloat( View.ALPHA, 0f );

        ObjectAnimator animatorEnd
                = ObjectAnimator.ofPropertyValuesHolder( scoreLayout, endAlpha );

        animatorEnd.setDuration( 700 );
        animatorEnd.setStartDelay( 700 );
        animatorEnd.start();

        // Remove added view after defined time.
        new Handler() {

            @Override
            public void handleMessage( Message msg ) {
                super.handleMessage( msg );

                getmContext().getScoreWrapper().removeView( scoreLayout );
            }
        }.sendEmptyMessageDelayed( 0, 1600 );
    }

    public MainActivity getmContext() {
        return mContext;
    }
}
