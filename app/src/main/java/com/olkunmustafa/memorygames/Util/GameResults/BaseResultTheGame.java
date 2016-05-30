package com.olkunmustafa.memorygames.Util.GameResults;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;

import com.olkunmustafa.memorygames.MainActivity;

/**
 * Created by olkunmustafa on 30/05/16
 */
public class BaseResultTheGame implements ITheGameResult {

    /**
     * Provides a class in order to catch
     * views to show dialog button.
     *
     * @since 0.1.0
     */
    private MainActivity mContext;

    /**
     * Public constructor
     *
     * @param mFindResultViews To catch views in Dialog
     * @since 0.1.0
     */
    public BaseResultTheGame( MainActivity mFindResultViews ) {
        this.mContext = mFindResultViews;

    }

    @Override
    public void showResultWithDialog() {

        this.getmContext()
                .getFindResultViews()
                .getGameResultDialog()
                .animate()
                .setDuration( 500 )
                .alpha( 1 );

        // [LinearLayout START]
        LinearLayout wrapper = this.getmContext()
                .getFindResultViews()
                .getGameResultDialogGroup();

        PropertyValuesHolder scaleXHolder
                = PropertyValuesHolder.ofFloat( View.SCALE_X, 1f );
        PropertyValuesHolder scaleYHolder
                = PropertyValuesHolder.ofFloat( View.SCALE_Y, 1f );

        ObjectAnimator animator
                = ObjectAnimator.ofPropertyValuesHolder( wrapper, scaleXHolder, scaleYHolder );

        animator.setInterpolator( new BounceInterpolator() );
        animator.start();
        // [LinearLayout END]

    }

    public MainActivity getmContext() {
        return mContext;
    }
}
