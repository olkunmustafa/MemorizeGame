package com.olkunmustafa.memorygames.Util.GameResults;

/**
 * Created by olkunmustafa on 30/05/16
 */
public interface ITheGameResult {

    /**
     * Shows a dialog to show
     * the game result.
     *
     * @since 0.1.0
     */
    void showResultWithDialog();

    /**
     * Starts a operation when
     * usere to click on button.
     *
     * @since 0.1.0
     */
    void clickForOperation();

    /**
     * Hides the resut dialog
     *
     * @since 0.1.0
     */
    void closeResultDialog();

}
