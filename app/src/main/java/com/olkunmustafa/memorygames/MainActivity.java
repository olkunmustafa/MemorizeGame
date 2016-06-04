package com.olkunmustafa.memorygames;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.olkunmustafa.memorygames.Adapters.MainGameAreaAdapter;
import com.olkunmustafa.memorygames.Holders.GradeRowColumn;
import com.olkunmustafa.memorygames.Holders.GridviewGrades;
import com.olkunmustafa.memorygames.Holders.SquaresInformations;
import com.olkunmustafa.memorygames.Util.CalculateHelper;
import com.olkunmustafa.memorygames.Util.GameResults.FindResultViews;
import com.olkunmustafa.memorygames.Util.GameResults.WinTheGame;
import com.olkunmustafa.memorygames.Util.OnClickListeners.MainGameAreaListener;
import com.olkunmustafa.memorygames.Util.OpenCloseToClick;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    /**
     * Defines the level of the game
     *
     * @since 1.1.0
     */
    public int level;

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
    public GridView mainGameArea2;

    /**
     * Prvides an adapter for listing the values
     * in {@link MainActivity#mainGameArea1}
     *
     * @since 0.1.0
     */
    public MainGameAreaAdapter gameAreaAdapter;

    /**
     * Provides a list that is contains
     * informations about game informations.
     * Each element carries informations about a level.
     *
     * @since 0.1.0
     */
    public List< GradeRowColumn > listGRD;

    /**
     * Provides a list that is contains
     * information each square
     *
     * @since 0.1.0
     */
    public ArrayList< SquaresInformations > informations;

    /**
     * It is a wrapper that wraps
     * Game areas {@link MainActivity#mainGameArea1}
     *
     * @since 1.1.0
     */
    public RelativeLayout gameAreaWrapper;

    /**
     * @since 1.1.0
     */
    public RelativeLayout mainWrapper;

    /**
     * Fetchs square informations in Current game
     *
     * @since 1.1.0
     */
    public GradeRowColumn gradeRowColumn;

    /**
     * Provides listener for gameArea
     *
     * @since 1.1.0
     */
    public MainGameAreaListener gameAreaListener;

    /**
     * Provides a handler for providing new
     * delayed operations.
     *
     * @since 1.1.0
     */
    public Handler mOpenCloseToClick;

    /**
     * Used to find views
     * that is used when the game result
     *
     * @since 0.1.0
     */
    public FindResultViews mFindResultViews;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        this.defineViews();
        this.init();
        this.defineMainGameAreaAttr();

    }

    /**
     * Defines all Views and Viewgroups
     * in Application.
     *
     * @since 1.1.0
     */
    private void defineViews() {

        this.gameAreaWrapper = ( RelativeLayout ) findViewById( R.id.gameAreaWrapper );
        this.mainWrapper = ( RelativeLayout ) findViewById( R.id.mainWrapper );
        this.mainGameArea1 = ( GridView ) findViewById( R.id.mainGameArea );

    }

    /**
     * It defines init operations for that class.
     *
     * @since 0.1.0
     */
    private void init() {

        Logger.init();

        this.mFindResultViews = new FindResultViews( this );

        this.gameAreaListener = new MainGameAreaListener( this );
        this.mOpenCloseToClick = new OpenCloseToClick( this );
        this.informations = new ArrayList< SquaresInformations >();

        this.listGRD = GridviewGrades.newInstance().getGradeRowColumn();

        this.startNewGame();
        this.openClickOperation();
    }

    private void startNewGame() {

        this.level = this.level + 1;
        this.gradeRowColumn = this.listGRD.get( this.level - 1 );
        this.informations.addAll( CalculateHelper.getGradedList( gradeRowColumn ) );

        this.gameAreaAdapter = new MainGameAreaAdapter( this, this.informations );
        this.mainGameArea1.setAdapter( this.gameAreaAdapter );
        this.mainGameArea1.setOnItemClickListener( this.gameAreaListener );

    }

    /**
     * Opens to click the main game area.
     *
     * @since 0.1.0
     */
    public void openClickOperation() {
        mOpenCloseToClick.sendEmptyMessageDelayed( 1, 1000 );

    }

    /**
     * Defines features for {@link MainActivity#mainGameArea1}
     *
     * @since 0.1.0
     */
    public void defineMainGameAreaAttr() {

        if ( this.mainGameArea1 != null ) {
            this.mainGameArea1.setNumColumns( this.getGradeRowColumn().column );

            int width = getResources().getDimensionPixelSize( R.dimen.columnSize );

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams( ( width * this.getGradeRowColumn().column ), ViewGroup.LayoutParams.WRAP_CONTENT );
            lp.addRule( RelativeLayout.CENTER_VERTICAL );
            lp.addRule( RelativeLayout.CENTER_HORIZONTAL );

            this.gameAreaWrapper.setLayoutParams( lp );

        }
    }

    public GridView getMainGameArea1() {
        return mainGameArea1;
    }

    public RelativeLayout getGameAreaWrapper() {
        return gameAreaWrapper;
    }

    public RelativeLayout getMainWrapper() {
        return mainWrapper;
    }

    public MainGameAreaListener getGameAreaListener() {
        return gameAreaListener;
    }

    public MainGameAreaAdapter getGameAreaAdapter() {
        return gameAreaAdapter;
    }

    public GradeRowColumn getGradeRowColumn() {
        return gradeRowColumn;
    }

    public ArrayList< SquaresInformations > getInformations() {
        return informations;
    }

    public FindResultViews getFindResultViews() {
        return mFindResultViews;
    }
}
