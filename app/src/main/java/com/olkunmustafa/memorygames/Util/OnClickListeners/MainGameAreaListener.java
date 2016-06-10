package com.olkunmustafa.memorygames.Util.OnClickListeners;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

import com.olkunmustafa.memorygames.Adapters.MainGameAreaAdapter;
import com.olkunmustafa.memorygames.CustomViews.CustomSquare;
import com.olkunmustafa.memorygames.Holders.SquaresInformations;
import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;
import com.olkunmustafa.memorygames.Util.GameResults.GameResultOps;
import com.olkunmustafa.memorygames.Util.GameResults.LoseTheGame;
import com.olkunmustafa.memorygames.Util.GameResults.WinTheGame;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;


/**
 * Created by olkunmustafa on 23/05/16
 */
public class MainGameAreaListener implements
        AdapterView.OnItemClickListener {

    private MainActivity mContext;

    /**
     * Defines a boolea value
     * that close to click or open.
     *
     * @since 1.1.0
     */
    private boolean closeToClick;

    /**
     * Saves the square informations
     * when user the click square.
     *
     * @since 1.2.0
     */
    private ArrayList< SquaresInformations > squaresInformationses;

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
     * Public consturctor
     *
     * @param mContext
     * @since 1.2.0
     */
    public MainGameAreaListener( MainActivity mContext ) {
        this.mContext = mContext;

        this.init();
    }

    /**
     * It defines init operations for that class.
     *
     * @since 0.1.0
     */
    private void init() {

        Logger.init();

        this.squaresInformationses = new ArrayList< SquaresInformations >();

        this.mChangeScore
                = new ChangeScore( this.getmContext() );

    }

    @Override
    public void onItemClick( AdapterView< ? > parent, View view, int position, long id ) {

        if ( isCloseToClick() ) {

            // Defines that user  clicked th
            boolean theSameClick = false;
            int colorTrue = ContextCompat.getColor( this.mContext, R.color.colorPrimary );
            int colorFalse = ContextCompat.getColor( this.mContext, R.color.colorYellow );
            CustomSquare customSquare = ( ( MainGameAreaAdapter.ViewHolder ) view.getTag() ).getCustomSquare();

            SquaresInformations sInformation = this.mContext.getGameAreaAdapter().getItem( position );
            // Defines whether the user clicked the same square
            for ( SquaresInformations s : this.squaresInformationses ) {

                if ( s.getId() == sInformation.getId() )
                    theSameClick = true;

            }

            if ( !theSameClick ) {

                this.squaresInformationses.add( sInformation );

                if ( sInformation.isActive() ) {

                    this.mChangeScore.increase();
                    customSquare.setBackgroundColor( colorTrue );

                    // Close to click if the clicked square count size is equal to active square count.
                    // This means, all answers all correct
                    if ( this.squaresInformationses.size() == this.mContext.getGradeRowColumn().getActiveCount() ) {
                        this.setCloseToClick( false );
                        this.mGameResultOps = new GameResultOps(
                                new WinTheGame( this.mContext )
                                        .setChangeScore( this.mChangeScore )
                        );

                    }

                } else {
                    customSquare.setBackgroundColor( colorFalse );
                    this.setCloseToClick( false );
                    this.mGameResultOps = new GameResultOps(
                            new LoseTheGame( this.mContext )
                                    .setChangeScore( this.mChangeScore )
                    );

                }

            }
        }

    }

    public boolean isCloseToClick() {
        return closeToClick;
    }

    public MainGameAreaListener setCloseToClick( boolean closeToClick ) {
        this.closeToClick = closeToClick;
        return this;
    }

    public ArrayList< SquaresInformations > getSquaresInformationses() {
        return squaresInformationses;
    }

    public MainActivity getmContext() {
        return mContext;
    }
}
