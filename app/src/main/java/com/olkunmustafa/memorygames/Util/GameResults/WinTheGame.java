package com.olkunmustafa.memorygames.Util.GameResults;

import android.view.View;

import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;

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

        // Increase the level
        this.getmContext().level
                = this.getmContext().level + 1;

        super.startNewGame();
    }

}
