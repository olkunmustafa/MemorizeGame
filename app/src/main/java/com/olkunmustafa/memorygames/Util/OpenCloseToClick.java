package com.olkunmustafa.memorygames.Util;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.olkunmustafa.memorygames.MainActivity;
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
     * Provides a Context object
     *
     * @since 0.1.0
     */
    private Activity mContext;

    public OpenCloseToClick( Activity mContext ) {
        this.mContext = mContext;
    }

    @Override
    public void handleMessage( Message msg ) {
        super.handleMessage( msg );

        switch ( msg.what ){

            case 1:
                ((MainActivity)this.mContext)
                        .getGameAreaListener().setCloseToClick( true );
                ((MainActivity)this.mContext)
                        .getGameAreaAdapter().setAllPassive( true ).notifyDataSetChanged();

                break;
            case 0:
                ((MainActivity)this.mContext)
                        .getGameAreaListener().setCloseToClick( false );

                break;

        }

    }
}
