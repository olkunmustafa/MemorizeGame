package com.olkunmustafa.memorygames.Holders;

/**
 * Created by olkunmustafa on 22/05/16
 *
 * @since 0.1.0
 */
public class GradeRowColumn {

    /**
     * Defines grade of the game
     *
     * @since 0.1.0
     */
    public int grade;

    /**
     * Defines row count of Gridview
     *
     * @since 0.1.0
     */
    public int row;

    /**
     * Defines column count of Gridview
     *
     * @since 0.1.0
     */
    public int column;

    /**
     * Defines how many mark will be square active
     *
     * @since 0.1.0
     */
    public int activeCount;

    public GradeRowColumn( int grade, int row, int column, int activeCount ) {
        this.column = column;
        this.grade = grade;
        this.row = row;
        this.activeCount = activeCount;
    }

    public int getColumn() {
        return column;
    }

    public GradeRowColumn setColumn( int column ) {
        this.column = column;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public GradeRowColumn setGrade( int grade ) {
        this.grade = grade;
        return this;
    }

    public int getRow() {
        return row;
    }

    public GradeRowColumn setRow( int row ) {
        this.row = row;
        return this;
    }

    public int getActiveCount() {
        return activeCount;
    }

    public GradeRowColumn setActiveCount( int activeCount ) {
        this.activeCount = activeCount;
        return this;
    }
}
