package com.olkunmustafa.memorygames.Util.GameResults;

import android.animation.Animator;
import android.view.View;

import com.olkunmustafa.memorygames.Holders.GridviewGrades;
import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;
import com.olkunmustafa.memorygames.Util.OnClickListeners.ChangeScore;

/**
 * Created by olkunmustafa on 30/05/16
 * <p/>
 * It is triggered when the user wins to game
 *
 * @since 0.1.0
 */
public class WinTheGame extends BaseResultTheGame {

    /**
     * Public constructor
     *
     * @param context To catch views in Dialog
     * @since 0.1.0
     */
    public WinTheGame( MainActivity context ) {
        super( context );

    }

    @Override
    public void endTheGame() {

        this.getmContext()
                .getGameAreaWrapper()
                .animate()
                .translationX( - this.getmContext()
                        .getMainWrapper().getWidth() )
                .setDuration( TRANSLATION_X_DURATION )
                .setListener( new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart( Animator animation ) {

                    }

                    @Override
                    public void onAnimationEnd( Animator animation ) {
                        showResultWithDialog();

                        getmContext()
                                .getGameAreaWrapper()
                                .setTranslationX( getmContext()
                                        .getMainWrapper().getWidth() );

                        getmContext()
                                .getGameAreaWrapper()
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

    @Override
    public void showResultWithDialog() {
        super.showResultWithDialog();

        this.mFindViewResultViews
                .getDialogTitle()
                .setText( getmContext().getResources().getString( R.string.win_the_game ) );

        this.mFindViewResultViews
                .getDialogButton()
                .setText( getmContext().getResources().getString( R.string.continue_to_play ) );

    }

    @Override
    public void clickForOperation() {

        this.mFindViewResultViews
                .getDialogButton().setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                closeResultDialog();
                startNewGame();
            }
        } );

    }

    @Override
    public void startNewGame() {

        if( GridviewGrades.newInstance().getGradeRowColumn().size() > this.getmContext().level ){

            // Increase the level
            this.getmContext().level
                    = this.getmContext().level + 1;

        }
        super.startNewGame();

        this.getmContext()
                .getGameAreaWrapper()
                .animate()
                .translationX( 0 )
                .setDuration( TRANSLATION_X_DURATION );

    }

}
