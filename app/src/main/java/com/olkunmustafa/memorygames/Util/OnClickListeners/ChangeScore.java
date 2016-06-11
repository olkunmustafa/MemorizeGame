package com.olkunmustafa.memorygames.Util.OnClickListeners;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;
import com.olkunmustafa.memorygames.Util.CalculateHelper;

import org.w3c.dom.Text;

/**
 * Created by olkunmustafa on 05/06/16
 */
public class ChangeScore {

    /**
     * Hands the total textview
     *
     * @since 0.1.0
     */
    private TextView totalTextView;

    /**
     * Context object
     *
     * @since 0.1.0
     */
    private MainActivity mContext;

    /**
     * Holds the total score of the game
     *
     * @since 0.1.0
     */
    private int totalScore;

    /**
     * Holds the total score for each level
     *
     * @since 0.1.0
     */
    private int levelScore;

    public ChangeScore( MainActivity mContext ) {
        this.mContext = mContext;

        this.init();
    }

    /**
     * It defines init operations for that class.
     *
     * @since 0.1.0
     */
    private void init() {
        this.totalScore = 0;
        this.levelScore = 0;

        this.totalTextView = ( TextView ) this.getmContext().findViewById( R.id.totalScore );
        this.totalTextView.setText( "0" );

    }

    /**
     * Increases the main point when the user
     * clicked the true squares.
     *
     * @since 0.1.0
     */
    public void increase() {

        // The point that will be increased at each click
        int point = CalculateHelper.getPoint( this.getmContext().level );
        this.increaseTheLevelScore( point );

        // Increases the total score of the game.
        this.increaseTheTotalScore( point );
        this.animateSquareScore( "+" + point, false );

    }

    /**
     * Increases the main point when the user
     * clicked the true squares.
     *
     * @since 0.1.0
     */
    public void decrease() {

        this.animateSquareScore( "Oh noooo!", true );

    }

    /**
     * Animates the score on the page
     * when the user clicked the squares.
     *
     * @since 0.1.0
     */
    public void animateSquareScore( String point, boolean negative ) {

        // Fetch the view from point layout
        final ViewGroup scoreLayout = ( ViewGroup ) LayoutInflater.from( mContext ).inflate( R.layout.point_layout, null );
        scoreLayout.setAlpha( 0f );

        TextView scoreView = ( TextView ) scoreLayout.findViewById( R.id.theSquareScore );
        scoreView.setText( point );
        if ( negative )
            scoreView.setTextColor( getmContext().getResources().getColor( R.color.red ) );

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

    /**
     * Increases the total score of the game
     *
     * @since 0.1.0
     */
    public void increaseTheTotalScore( int score ) {
        this.totalScore += score;
        this.totalTextView.setText( String.valueOf( this.totalScore ) );
    }

    /**
     * Decreases the total score of the game
     *
     * @since 0.1.0
     */
    public void decreaseTheTotalScore() {
        this.totalScore -= levelScore;
        this.totalTextView.setText( String.valueOf( this.totalScore ) );

    }

    /**
     * Increases the total level score
     * Every user clicked the right answer
     *
     * @param score Increase score
     * @since 0.1.0
     */
    public void increaseTheLevelScore( int score ) {
        this.levelScore += score;

    }

    /**
     * Resets the level score
     * after every level
     *
     * @since 0.1.0
     */
    public void resetLevelScore() {
        this.levelScore = 0;

    }

    public int getLevelScore() {
        return levelScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public MainActivity getmContext() {
        return mContext;
    }
}
