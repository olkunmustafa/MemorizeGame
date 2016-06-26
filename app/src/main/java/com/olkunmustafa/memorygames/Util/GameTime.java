package com.olkunmustafa.memorygames.Util;

import android.animation.Animator;
import android.widget.FrameLayout;

import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.Util.GameResults.GameResultOps;
import com.olkunmustafa.memorygames.Util.GameResults.LoseTheGame;
import com.olkunmustafa.memorygames.Util.OnClickListeners.ChangeScore;
import com.orhanobut.logger.Logger;

/**
 * Created by olkunmustafa on 24/06/16
 */
public class GameTime {

    /**
     * Context object
     *
     * @since 0.1.0
     */
    private MainActivity mContext;

    /**
     * Given time for the each level
     *
     * @since 0.1.0
     */
    private int gameTime = 5000;

    /**
     * @since 0.1.0
     */
    private GameResultOps mGameResultOps;

    /**
     * Changes score when the user
     * end the game
     *
     * @since 0.1.0
     */
    protected ChangeScore mChangeScore;

    /**
     * Provides a ViewGroup object
     * that is used for showing the time
     *
     * @since 0.1.0
     */
    public FrameLayout gameTimeBackground;

    /**
     * @since 0.1.0
     */
    public boolean isWin;

    public GameTime( MainActivity mContext ) {
        this.mContext = mContext;

        this.mChangeScore = new ChangeScore( getmContext() );
        this.gameTimeBackground = this.getmContext().getGameTimeBackground();
    }

    /**
     * Starts the game time
     * when the user ready.
     *
     * @since 0.1.0
     */
    public void startGameTime() {

        this.isWin = false;
        this.gameTimeBackground
                .animate()
                .translationY( this.gameTimeBackground.getHeight() )
                .setDuration( this.gameTime )
                .setListener( new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart( Animator animation ) {

                    }

                    @Override
                    public void onAnimationEnd( Animator animation ) {

                        if( !isWin ){
                            mGameResultOps = new GameResultOps(
                                    new LoseTheGame( getmContext() )
                                            .setChangeScore( getmContext().mChangeScore )
                            );
                        }

                        gameTimeBackground
                                .animate()
                                .setListener( null );
                    }

                    @Override
                    public void onAnimationCancel( Animator animation ) {
                        isWin = true;

                    }

                    @Override
                    public void onAnimationRepeat( Animator animation ) {

                    }
                } );

    }

    /**
     * Cancels the animate
     *
     * @since 0.1.0
     */
    public void cancelGameTime(){

        this.gameTimeBackground
                .animate()
                .cancel();

    }

    public void resetGame(){

        this.gameTimeBackground
                .setTranslationY( 0 );

    }

    public MainActivity getmContext() {
        return mContext;
    }
}
