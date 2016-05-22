package com.olkunmustafa.memorygames.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.olkunmustafa.memorygames.CustomViews.CustomSquare;
import com.olkunmustafa.memorygames.Holders.SquaresInformations;
import com.olkunmustafa.memorygames.R;

import java.util.ArrayList;

/**
 * Created by olkunmustafa on 21/05/16
 */
public class MainGameAreaAdapter extends BaseAdapter {

    /**
     * Ekranda nesneler hakkında bilgileri taşır.
     *
     * @since 0.1.0
     */
    private ArrayList< SquaresInformations > informationList;

    /**
     * Context değeridir.
     *
     * @since 0.1.0
     */
    private Context mContext;

    public MainGameAreaAdapter( Context mContext, ArrayList< SquaresInformations > informationList ) {
        this.informationList = informationList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return informationList.size();
    }

    @Override
    public SquaresInformations getItem( int position ) {
        return informationList.get( position );
    }

    @Override
    public long getItemId( int position ) {
        return 0;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        ViewHolder holder = null;
        SquaresInformations squaresInformations = getItem( position );

        if ( convertView == null ) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from( mContext ).inflate( R.layout.game_area_layout_inflate, parent, false );

            holder.customSquare = ( CustomSquare ) convertView.findViewById( R.id.gameSquare );
            convertView.setTag( holder );
        } else {
            holder = ( ViewHolder ) convertView.getTag();
        }

        if ( squaresInformations.isActive() )
            holder.customSquare.setBackgroundColor( this.mContext.getResources().getColor( R.color.colorPrimary ) );
        else
            holder.customSquare.setBackgroundColor( this.mContext.getResources().getColor( R.color.colorAccent ) );

        return convertView;
    }

    /*private view holder class*/
    private class ViewHolder {
        CustomSquare customSquare;
    }
}
