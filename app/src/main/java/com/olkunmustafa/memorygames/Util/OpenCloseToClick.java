package com.olkunmustafa.memorygames.Util;

import android.os.Handler;
import android.os.Message;

import com.olkunmustafa.memorygames.Util.OnClickListeners.MainGameAreaListener;

/**
 * Created by olkunmustafa on 23/05/16
 * <p/>
 * Opens or Closeds the Main game area to click
 *
 * @since 1.1.0
 */
public class OpenCloseToClick extends Handler {

    /**
     * @since 1.1.0
     */
    private MainGameAreaListener mainGameAreaListener;

    public OpenCloseToClick( MainGameAreaListener mainGameAreaListener ) {
        this.mainGameAreaListener = mainGameAreaListener;

    }

    @Override
    public void handleMessage( Message msg ) {
        super.handleMessage( msg );

        switch ( msg.what ){

            case 1:
                this.mainGameAreaListener.setCloseToClick( true );
                break;
            case 0:
                this.mainGameAreaListener.setCloseToClick( false );
                break;

        }

    }
}
