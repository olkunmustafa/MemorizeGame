package com.olkunmustafa.memorygames;

import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.olkunmustafa.memorygames.Adapters.MainGameAreaAdapter;
import com.olkunmustafa.memorygames.Holders.GradeRowColumn;
import com.olkunmustafa.memorygames.Holders.GridviewGrades;
import com.olkunmustafa.memorygames.Holders.SquaresInformations;
import com.olkunmustafa.memorygames.Util.CalculateHelper;
import com.olkunmustafa.memorygames.Util.GameResults.FindResultViews;
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
    private GridView mainGameArea;

    /**
     * Prvides an adapter for listing the values
     * in {@link MainActivity#mainGameArea}
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
     * Game areas {@link MainActivity#mainGameArea}
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

    /**
     * Wrapper for showing scores
     *
     * @since 0.1.0
     */
    private RelativeLayout scoreWrapper;

    /**
     * The life for user
     *
     * @since 0.1.0
     */
    private int life;

    /**
     * Indicates the levelView object
     *
     * @since 0.1.0
     */
    private TextView levelView;

    /**
     * Indicates the lifeView object.
     *
     * @since 0.1.0
     */
    private TextView lifeView;

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
        this.mainGameArea = ( GridView ) findViewById( R.id.mainGameArea );
        this.scoreWrapper = ( RelativeLayout ) findViewById( R.id.scoreWrapper );
        this.levelView = ( TextView ) findViewById( R.id.levelView );
        this.lifeView = ( TextView ) findViewById( R.id.lifeView );

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
        this.life = 3;

        this.gradeRowColumn = this.listGRD.get( this.level - 1 );
        this.informations.addAll( CalculateHelper.getGradedList( gradeRowColumn ) );

        this.gameAreaAdapter = new MainGameAreaAdapter( this, this.informations );
        this.mainGameArea.setAdapter( this.gameAreaAdapter );
        this.mainGameArea.setOnItemClickListener( this.gameAreaListener );

        this.setLevelViewText();
        this.setLifeViewText();

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
     * Defines features for {@link MainActivity#mainGameArea}
     *
     * @since 0.1.0
     */
    public void defineMainGameAreaAttr() {

        if ( this.mainGameArea != null ) {
            this.mainGameArea.setNumColumns( this.getGradeRowColumn().column );

            int width = getResources().getDimensionPixelSize( R.dimen.columnSize );
            int spacing = getResources().getDimensionPixelSize( R.dimen.gridviewMargin );

            int totalWidth = width * ( this.getGradeRowColumn().column );
            int totalSpacing = spacing * ( this.getGradeRowColumn().column );

            int gradeBorder = this.getResources().getDimensionPixelSize( R.dimen.dialog_wrapper_border );
            int totalHeight = ( ( ( width * 6 ) + ( spacing * 6 ) ) + gradeBorder );

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams( totalWidth + totalSpacing, totalHeight );
            lp.addRule( RelativeLayout.CENTER_VERTICAL );
            lp.addRule( RelativeLayout.CENTER_HORIZONTAL );

            this.gameAreaWrapper.setLayoutParams( lp );

        }
    }

    /**
     * Decreases the life count.
     *
     * @since 0.1.0
     */
    public void decreaseTheHeart() {
        this.life--;

    }

    /**
     * Changes the level value
     *
     * @since 0.1.0
     */
    public void setLevelViewText() {
        this.levelView.setText( String.format( this.mResources.getString( R.string.level_view ), level ) );

    }

    /**
     * Changes the life value
     *
     * @since 0.1.0
     */
    public void setLifeViewText() {
        this.lifeView.setText( String.format( this.mResources.getString( R.string.life_view ), life ) );

    }

    public RelativeLayout getScoreWrapper() {
        return scoreWrapper;
    }

    public GridView getMainGameArea1() {
        return mainGameArea;
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

    public TextView getLevelView() {
        return levelView;
    }

    public TextView getLifeView() {
        return lifeView;
    }
}
