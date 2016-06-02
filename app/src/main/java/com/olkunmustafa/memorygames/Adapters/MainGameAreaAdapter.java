package com.olkunmustafa.memorygames.Adapters;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
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

    /**
     * Whether defines all squares are passive
     *
     * @since 0.1.0
     */
    private boolean allPassive;

    /**
     * @since 0.1.0
     */
    private Resources mResources;

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

        // Triggered when the game starts.
        if ( !this.isAllPassive() ) {

            if ( squaresInformations.isActive() )
                holder.customSquare.setBackgroundColor( this.mContext.getResources().getColor( R.color.colorPrimary ) );

            else
                holder.customSquare.setBackgroundColor( this.mContext.getResources().getColor( R.color.colorAccent ) );

        }
        // Triggered when all squares are convert to passive color.
        else {

            if ( squaresInformations.isActive() ) {

                int colorFrom = ContextCompat.getColor( this.mContext, R.color.colorPrimary );
                int colorTo = ContextCompat.getColor( this.mContext, R.color.colorAccent );

                ValueAnimator colorAnimation = ValueAnimator.ofObject( new ArgbEvaluator(), colorFrom, colorTo );
                colorAnimation.setDuration( 300 ); // milliseconds

                final ViewHolder finalHolder = holder;
                colorAnimation.addUpdateListener( new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate( ValueAnimator animator ) {
                        finalHolder.customSquare.setBackgroundColor( ( int ) animator.getAnimatedValue() );

                    }

                } );
                colorAnimation.start();

            }

        }

        return convertView;
    }

    public boolean isAllPassive() {
        return allPassive;
    }

    public MainGameAreaAdapter setAllPassive( boolean allPassive ) {
        this.allPassive = allPassive;
        return this;
    }

    private Resources getSystemResources() {

        if ( this.mResources == null )
            this.mResources = this.mContext.getResources();

        return this.mResources;

    }

    /*private view holder class*/
    public class ViewHolder {
        public CustomSquare customSquare;

        public CustomSquare getCustomSquare() {
            return customSquare;
        }
    }
}
