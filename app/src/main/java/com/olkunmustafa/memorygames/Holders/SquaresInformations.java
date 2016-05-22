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
     * Defines the whether square is active or not.
     *
     * @since 0.1.0
     */
    private boolean active;

    public SquaresInformations( boolean active ) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public SquaresInformations setActive( boolean active ) {
        this.active = active;
        return this;
    }
}
