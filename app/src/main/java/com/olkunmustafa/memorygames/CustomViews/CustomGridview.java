package com.olkunmustafa.memorygames.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by olkunmustafa on 22/05/16
 */
public class CustomGridview extends GridView {

    public CustomGridview( Context context, AttributeSet attrs ) {
        super( context, attrs );
    }

    public CustomGridview( Context context ) {
        super( context );
    }

    public CustomGridview( Context context, AttributeSet attrs, int defStyle ) {
        super( context, attrs, defStyle );
    }

    @Override
    public void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
        int expandSpec = MeasureSpec.makeMeasureSpec( Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST );
        super.onMeasure( widthMeasureSpec, expandSpec );
    }
}
