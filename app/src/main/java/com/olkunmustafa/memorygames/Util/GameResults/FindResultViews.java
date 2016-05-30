package com.olkunmustafa.memorygames.Util.GameResults;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;

/**
 * Created by olkunmustafa on 29/05/16
 * <p/>
 * Used to find views that is used when the game result
 */
public class FindResultViews {

    /**
     * Prvides a context object in order to
     * find views from MainActivity.
     *
     * @since 0.1.0
     */
    private MainActivity mContext;

    /**
     * Creates a dialog in order to show
     * the result of the game
     *
     * @since @since 0.1.0
     */
    private ViewGroup gameResultDialog;

    /**
     * Creates textView object
     * in order to show warnings about
     * the game result.
     *
     * @since 0.1.0
     */
    private TextView dialogTitle;

    /**
     * Creates ViewGroup object
     *
     * @since 0.1.0
     */
    private LinearLayout gameResultDialogGroup;

    /**
     * @since 0.1.0
     */
    private Button dialogButton;

    public FindResultViews( MainActivity mContext ) {
        this.mContext = mContext;

        this.init();
    }

    /**
     * It defines init operations for that class.
     *
     * @since 0.1.0
     */
    private void init() {

        this.gameResultDialog = ( ViewGroup ) this.mContext.findViewById( R.id.gameResultDialog );
        this.dialogTitle = ( TextView ) this.mContext.findViewById( R.id.dialogTitle );
        this.dialogButton = ( Button ) this.mContext.findViewById( R.id.dialogButton );
        this.gameResultDialogGroup = ( LinearLayout ) this.mContext.findViewById( R.id.gameResultDialogGroup );

    }

    public Button getDialogButton() {
        return dialogButton;
    }

    public TextView getDialogTitle() {
        return dialogTitle;
    }

    public ViewGroup getGameResultDialog() {
        return gameResultDialog;
    }

    public LinearLayout getGameResultDialogGroup() {
        return gameResultDialogGroup;
    }
}
