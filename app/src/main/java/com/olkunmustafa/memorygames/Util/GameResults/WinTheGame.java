package com.olkunmustafa.memorygames.Util.GameResults;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;

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
     * @param mFindResultViews To catch views in Dialog
     * @since 0.1.0
     */
    public WinTheGame( MainActivity mFindResultViews ) {
        super( mFindResultViews );

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

}
