package com.olkunmustafa.memorygames.Util.GameResults;

import android.view.View;

import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;
import com.olkunmustafa.memorygames.Util.CalculateHelper;

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
    public void showResultWithDialog() {
        super.showResultWithDialog();

        this.getmContext()
                .getFindResultViews()
                .getDialogTitle()
                .setText( getmContext().getResources().getString( R.string.win_the_game ) );

        this.getmContext()
                .getFindResultViews()
                .getDialogButton()
                .setText( getmContext().getResources().getString( R.string.continue_to_play ) );

    }

    @Override
    public void clickForOperation() {

        this.getmContext()
                .getFindResultViews()
                .getDialogButton().setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                closeResultDialog();
                startNewGame();
            }
        } );

    }

    private void startNewGame() {

        // Increase the level
        this.getmContext().level
                = this.getmContext().level + 1;

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

}
