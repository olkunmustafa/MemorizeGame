package com.olkunmustafa.memorygames.Util.GameResults;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;

import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.Util.CalculateHelper;
import com.orhanobut.logger.Logger;

/**
 * Created by olkunmustafa on 30/05/16
 */
public abstract class BaseResultTheGame {

    /**
     * Defines to define duration for
     * translationX animations.
     *
     * @since 0.1.0
     */
    public static final int TRANSLATION_X_DURATION = 500;

    /**
     * Provides a class in order to catch
     * views to show dialog button.
     *
     * @since 0.1.0
     */
    private MainActivity mContext;

    /**
     * Used to find views
     * that is used when the game result
     *
     * @since 0.1.0
     */
    protected FindResultViews mFindViewResultViews;

    /**
     * Public constructor
     *
     * @param context To catch views in Dialog
     * @since 0.1.0
     */
    public BaseResultTheGame( MainActivity context ) {
        this.mContext = context;

        this.init();
    }

    /**
    * It defines init operations for that class.
    *
    * @since 0.1.0
    */
    private void init(){

        this.mFindViewResultViews = this.getmContext()
                .getFindResultViews();

    }

    /**
     * Ends the game
     *
     * @since 0.1.0
     */
    public abstract void endTheGame();

    /**
     * Shows a dialog to show
     * the game result.
     *
     * @since 0.1.0
     */
    public void showResultWithDialog() {

        this.mFindViewResultViews
                .getGameResultDialog()
                .setVisibility( View.VISIBLE );

        this.mFindViewResultViews
                .getGameResultDialog()
                .animate()
                .setDuration( 500 )
                .alpha( 1 );

        // [LinearLayout START]
        LinearLayout wrapper = this.mFindViewResultViews
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

    /**
     * Starts a operation when
     * usere to click on button.
     *
     * @since 0.1.0
     */
    public void clickForOperation() {
        // Silent is golden

    }

    /**
     * Starts a new game
     *
     * @since 0.1.0
     */
    public void startNewGame() {

        // Get squares information
        this.getmContext().gradeRowColumn
                = this.getmContext().listGRD.get( this.getmContext().level - 1 );

        // Clear the list
        this.getmContext().informations
                .clear();

        // Refresh the list
        this.getmContext().informations
                .addAll( CalculateHelper.getGradedList( this.getmContext().gradeRowColumn ) );

        // Clear the informations in Clicked list.
        this.getmContext().getGameAreaListener()
                .getSquaresInformationses().clear();

        // Prepare the layout to game.
        this.getmContext().defineMainGameAreaAttr();

        // Prepare new adapter to game
        this.getmContext().getGameAreaAdapter()
                .setAllPassive( false );

        // Refresh the adapter.
        this.getmContext().getGameAreaAdapter()
                .notifyDataSetChanged();

        // Opens to click the game.
        this.getmContext().openClickOperation();

    }

    /**
     * Hides the resut dialog
     *
     * @since 0.1.0
     */
    public void closeResultDialog() {

        this.mFindViewResultViews
                .getGameResultDialog()
                .animate()
                .setDuration( 500 )
                .alpha( 0 ).setListener( new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart( Animator animation ) {

            }

            @Override
            public void onAnimationEnd( Animator animation ) {
                mFindViewResultViews
                        .getGameResultDialog()
                        .setVisibility( View.GONE );

                mFindViewResultViews
                        .getGameResultDialogGroup()
                        .setScaleX( 0 );

                mFindViewResultViews
                        .getGameResultDialogGroup()
                        .setScaleY( 0 );

                mFindViewResultViews
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
