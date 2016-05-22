package com.olkunmustafa.memorygames.CustomViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.olkunmustafa.memorygames.R;

/**
 * Created by olkunmustafa on 22/05/16
 *
 * @since 0.1.0
 */
public class CustomSquare extends View {

    /**
     * Sistem kaynaklarına erişim sağlar.
     *
     * @since 0.1.0
     */
    private Resources mResources;

    public CustomSquare( Context context ) {
        this( context, null, 0 );
    }

    public CustomSquare( Context context, AttributeSet attrs ) {
        this( context, attrs, 0 );
    }

    public CustomSquare( Context context, AttributeSet attrs, int defStyleAttr ) {
        super( context, attrs, defStyleAttr );

        this.init();
    }

    @TargetApi( Build.VERSION_CODES.LOLLIPOP )
    public CustomSquare( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes ) {
        super( context, attrs, defStyleAttr, defStyleRes );
    }

    @Override
    protected void onDraw( Canvas canvas ) {
        super.onDraw( canvas );


    }

    /**
    * It defines init operations for that class.
    *
    * @since 0.1.0
    */
    private void init(){
        this.mResources = getResources();

    }
}
