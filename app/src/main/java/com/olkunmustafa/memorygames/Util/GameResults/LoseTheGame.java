package com.olkunmustafa.memorygames.Util.GameResults;

import android.animation.Animator;
import android.content.Intent;
import android.view.View;

import com.olkunmustafa.memorygames.Database.GameDatabaseQuery;
import com.olkunmustafa.memorygames.EndActivity;
import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;

/**
 * Created by olkunmustafa on 30/05/16
 * <p/>
 * It is triggered when the user wins to game
 *
 * @since 0.1.0
 */
public class LoseTheGame extends BaseResultTheGame {

    /**
     * Public constructor
     *
     * @param context To catch views in Dialog
     * @since 0.1.0
     */
    public LoseTheGame( MainActivity context ) {
        super( context );

    }

    @Override
    public void endTheGame() {

        this.getmContext()
                .getmGametime()
                .cancelGameTime();

        this.getmContext().decreaseTheHeart();

        if ( ( this.getmContext().getLife() + 1 ) > 1 ) {

            this.getmContext().setLifeViewText();

            this.getChangeScore().decrease();
            this.getChangeScore().decreaseTheTotalScore();
            this.getChangeScore().resetLevelScore();

            this.getmContext()
                    .getGameAreaWrapper()
                    .animate()
                    .translationX( this.getmContext()
                            .getMainWrapper().getWidth() )
                    .setDuration( TRANSLATION_X_DURATION )
                    .setListener( new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart( Animator animation ) {

                        }

                        @Override
                        public void onAnimationEnd( Animator animation ) {

                            // Shows the score to user
                            showResultWithDialog();

                            // Moves the game are to start point.
                            getmContext()
                                    .getGameAreaWrapper()
                                    .setTranslationX( -getmContext()
                                            .getMainWrapper().getWidth() );

                            // Trash the listener.
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

        } else {

            this.saveGameDataToDb();
            this.reversAlphaMainGameArea();

//            Intent intent = new Intent( this.getmContext(), EndActivity.class );
//            this.getmContext().startActivity( intent );
//            this.getmContext().finish();

        }

    }

    /**
     * Reverste the alpha value
     * when the user lost own all lifes.
     *
     * @since 0.1.0
     */
    public void reversAlphaMainGameArea() {

        getmContext()
                .getMainWrapper()
                .animate()
                .alpha( 0 )
                .setDuration( 1250 )
                .setListener( new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart( Animator animation ) {

                    }

                    @Override
                    public void onAnimationEnd( Animator animation ) {
                        getmContext()
                                .replaceNewFragment();

                    }

                    @Override
                    public void onAnimationCancel( Animator animation ) {

                    }

                    @Override
                    public void onAnimationRepeat( Animator animation ) {

                    }
                } );

    }

    /**
     *
     */
    public void saveGameDataToDb() {

        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                GameDatabaseQuery.newInstance( getmContext() ).insertGameData(
                        getChangeScore().getTotalScore(),
                        getmContext().level
                );

            }
        } );

        thread.start();

    }

    @Override
    public void showResultWithDialog() {
        super.showResultWithDialog();

        this.mFindViewResultViews
                .getLevelPoint()
                .setText(
                        String.format(
                                getMyResources().getString( R.string.level_score ),
                                getChangeScore().getLevelScore()
                        )
                );

        this.mFindViewResultViews
                .getDialogTitle()
                .setText( getmContext().getResources().getString( R.string.lose_the_game ) );

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

        if ( this.getmContext().level > 1 ) {

            // Decrease the level
            this.getmContext().level
                    = this.getmContext().level - 1;

        }

        super.startNewGame();

        this.getmContext()
                .getGameAreaWrapper()
                .animate()
                .translationX( 0 )
                .setDuration( TRANSLATION_X_DURATION );
    }

}
