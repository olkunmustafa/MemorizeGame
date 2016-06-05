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
    private void init() {

        int row = 2;
        int column = 3;

        this.gradeRowColumn = new ArrayList< GradeRowColumn >();

        for ( int i = 1; i < 15; i++ ) {

            if ( i > 1 && row < 6 ) {
                if ( ( i % 2 ) == 0 )
                    row++;
                else
                    column++;

            }

            this.gradeRowColumn.add( new GradeRowColumn( i, row, column, i + 1 ) );

        }

    }

    public List< GradeRowColumn > getGradeRowColumn() {
        return gradeRowColumn;

    }
}
