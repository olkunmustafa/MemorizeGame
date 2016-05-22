package com.olkunmustafa.memorygames;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.olkunmustafa.memorygames.Adapters.MainGameAreaAdapter;
import com.olkunmustafa.memorygames.Holders.GradeRowColumn;
import com.olkunmustafa.memorygames.Holders.GridviewGrades;
import com.olkunmustafa.memorygames.Holders.SquaresInformations;
import com.olkunmustafa.memorygames.Util.CalculateHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private int grade;

    /**
     * Provides an area for playing game
     *
     * @since 0.1.0
     */
    private GridView mainGameArea1;

    /**
     * Provides an area for playing game
     *
     * @since 0.1.0
     */
    private GridView mainGameArea2;

    /**
     * Prvides an adapter for listing the values
     * in {@link MainActivity#mainGameArea1}
     *
     * @since 0.1.0
     */
    private MainGameAreaAdapter gameAreaAdapter;

    /**
     * @since 0.1.0
     */
    private List< GradeRowColumn > listGRD;

    /**
     * @since 0.1.0
     */
    private ArrayList< SquaresInformations > informations;

    /**
     *
     */
    private RelativeLayout gameAreaWrapper;

    private GradeRowColumn gradeRowColumn;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        this.init();
        this.defineMainGameAreaAttr();

    }

    /**
     * It defines init operations for that class.
     *
     * @since 0.1.0
     */
    private void init() {

        this.grade = this.grade + 1;

        this.gameAreaWrapper = ( RelativeLayout ) findViewById( R.id.gameAreaWrapper );

        this.mainGameArea1 = ( GridView ) findViewById( R.id.mainGameArea );
        this.listGRD = GridviewGrades.newInstance().getGradeRowColumn();

        this.gradeRowColumn = this.listGRD.get( this.grade - 1 );

        this.informations = CalculateHelper.getGradedList( gradeRowColumn );
        this.gameAreaAdapter = new MainGameAreaAdapter( this, this.informations );
        this.mainGameArea1.setAdapter( this.gameAreaAdapter );

    }

    /**
     * Defines features for {@link MainActivity#mainGameArea1}
     *
     * @since 0.1.0
     */
    private void defineMainGameAreaAttr() {

        if ( this.mainGameArea1 != null ) {
            this.mainGameArea1.setNumColumns( this.gradeRowColumn.column );

            int width = getResources().getDimensionPixelSize( R.dimen.columnSize );

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams( ( width * this.gradeRowColumn.column ), ViewGroup.LayoutParams.WRAP_CONTENT );
            lp.addRule( RelativeLayout.CENTER_VERTICAL );
            lp.addRule( RelativeLayout.CENTER_HORIZONTAL );

            this.gameAreaWrapper.setLayoutParams( lp );

        }
    }


}
