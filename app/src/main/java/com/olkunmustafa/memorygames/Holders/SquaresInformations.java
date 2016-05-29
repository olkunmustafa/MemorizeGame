package com.olkunmustafa.memorygames.Holders;

/**
 * Created by olkunmustafa on 22/05/16
 * <p/>
 * Used for defining essential informations
 * about squares.
 *
 * @since 0.1.0
 */
public class SquaresInformations {

    /**
     * Defines the ids of active squares
     *
     * @since 1.2.0
     */
    private int id;

    /**
     * Defines the whether square is active or not.
     *
     * @since 0.1.0
     */
    private boolean active;

    public SquaresInformations( int id, boolean active ) {
        this.active = active;
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public SquaresInformations setActive( boolean active ) {
        this.active = active;
        return this;
    }

    public int getId() {
        return id;
    }

    public SquaresInformations setId( int id ) {
        this.id = id;
        return this;
    }
}
