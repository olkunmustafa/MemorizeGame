package com.olkunmustafa.memorygames.Util.OnClickListeners;

import android.view.View;
import android.widget.AdapterView;

import com.orhanobut.logger.Logger;


/**
 * Created by olkunmustafa on 23/05/16
 */
public class MainGameAreaListener implements
        AdapterView.OnItemClickListener {

    /**
     * Defines a boolea value
     * that close to click or open.
     *
     * @since 1.1.0
     */
    private boolean closeToClick;

    public MainGameAreaListener() {

        Logger.init();

    }

    @Override
    public void onItemClick( AdapterView< ? > parent, View view, int position, long id ) {

        if( isCloseToClick() )
            Logger.d( "pos : " + position );

    }

    public boolean isCloseToClick() {
        return closeToClick;
    }

    public MainGameAreaListener setCloseToClick( boolean closeToClick ) {
        this.closeToClick = closeToClick;
        return this;
    }
}
