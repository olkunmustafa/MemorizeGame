package com.olkunmustafa.memorygames.Util.OnClickListeners;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

import com.olkunmustafa.memorygames.Adapters.MainGameAreaAdapter;
import com.olkunmustafa.memorygames.MainActivity;
import com.olkunmustafa.memorygames.R;
import com.orhanobut.logger.Logger;


/**
 * Created by olkunmustafa on 23/05/16
 */
public class MainGameAreaListener implements
        AdapterView.OnItemClickListener {

    private Activity mContext;

    /**
     * Defines a boolea value
     * that close to click or open.
     *
     * @since 1.1.0
     */
    private boolean closeToClick;

    public MainGameAreaListener( Activity mContext ) {
        this.mContext = mContext;

        Logger.init();
    }

    @Override
    public void onItemClick( AdapterView< ? > parent, View view, int position, long id ) {

        if ( isCloseToClick() ) {

            int colorTo = ContextCompat.getColor( this.mContext, R.color.colorYellow );
            ( ( MainGameAreaAdapter.ViewHolder ) view.getTag() ).getCustomSquare().setBackgroundColor( colorTo );

        }

    }

    public boolean isCloseToClick() {
        return closeToClick;
    }

    public MainGameAreaListener setCloseToClick( boolean closeToClick ) {
        this.closeToClick = closeToClick;
        return this;
    }
}
