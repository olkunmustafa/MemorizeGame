package com.olkunmustafa.memorygames.Holders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olkunmustafa on 22/05/16
 *
 * @since 0.1.0
 */
public class GridviewGrades {

    private List< GradeRowColumn > gradeRowColumn;

    /**
     * Crates singleton helper for GridviewGrades
     */
    public static GridviewGrades singleton;

    /**
     * Singleton helper.
     */
    public static GridviewGrades newInstance() {

        if ( singleton == null )
            singleton = new GridviewGrades();

        return singleton;

    }

    public GridviewGrades() {

        this.init();

    }

    /**
    * It defines init operations for that class.
    *
    * @since 0.1.0
    */
    private void init(){

        this.gradeRowColumn = new ArrayList< GradeRowColumn >();
        this.gradeRowColumn.add( new GradeRowColumn( 1, 2, 3, 2 ) );
        this.gradeRowColumn.add( new GradeRowColumn( 2, 3, 3, 3 ) );
        this.gradeRowColumn.add( new GradeRowColumn( 3, 3, 4, 4 ) );
        this.gradeRowColumn.add( new GradeRowColumn( 4, 4, 4, 5 ) );
        this.gradeRowColumn.add( new GradeRowColumn( 5, 4, 5, 6 ) );
        this.gradeRowColumn.add( new GradeRowColumn( 6, 5, 5, 7 ) );

    }

    public List< GradeRowColumn > getGradeRowColumn() {
        return gradeRowColumn;

    }
}
