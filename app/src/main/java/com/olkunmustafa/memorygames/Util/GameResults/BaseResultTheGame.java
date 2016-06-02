package com.olkunmustafa.memorygames.Util.GameResults;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;

import com.olkunmustafa.memorygames.MainActivity;
import com.orhanobut.logger.Logger;

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
     * @param context To catch views in Dialog
     * @since 0.1.0
     */
    public BaseResultTheGame( MainActivity context ) {
        this.mContext = context;

    }

    @Override
    public void showResultWithDialog() {

        this.getmContext()
                .getFindResultViews()
                .getGameResultDialog()
                .setVisibility( View.VISIBLE );

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

        this.clickForOperation();
    }

    @Override
    public void clickForOperation() {
        // Silent is golden

    }

    @Override
    public void closeResultDialog() {

        this.getmContext()
                .getFindResultViews()
                .getGameResultDialog()
                .animate()
                .setDuration( 500 )
                .alpha( 0 ).setListener( new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart( Animator animation ) {

            }

            @Override
            public void onAnimationEnd( Animator animation ) {
                getmContext()
                        .getFindResultViews()
                        .getGameResultDialog()
                        .setVisibility( View.GONE );

                getmContext()
                        .getFindResultViews()
                        .getGameResultDialogGroup()
                        .setScaleX( 0 );

                getmContext()
                        .getFindResultViews()
                        .getGameResultDialogGroup()
                        .setScaleY( 0 );

                getmContext()
                        .getFindResultViews()
                        .getGameResultDialog()
                        .animate()
                        .setListener( null );

            }

            @Override
            public void onAnimationCancel( Animator animation ) {

            }

            @Override
            public void onAnimationRepeat( Animator animation ) {

            }
        } );

    }

    public MainActivity getmContext() {
        return mContext;
    }
}
