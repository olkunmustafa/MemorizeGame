package com.olkunmustafa.memorygames.Holders;

/**
 * Created by olkunmustafa on 18/06/16
 * <p/>
 * Saves all datas about the game
 * The game datas are saved after eacht game ends.
 *
 * @since 0.1.0
 */
public class GameDatas {

    /**
     * ID number of the game
     *
     * @since 0.1.0
     */
    public int gameId;

    /**
     * Total score for the game
     *
     * @since 0.1.0
     */
    public int totalScore;

    /**
     * Level of the final round
     *
     * @since 0.1.0
     */
    public int level;

    public int getGameId() {
        return gameId;
    }

    public GameDatas setGameId( int gameId ) {
        this.gameId = gameId;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public GameDatas setLevel( int level ) {
        this.level = level;
        return this;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public GameDatas setTotalScore( int totalScore ) {
        this.totalScore = totalScore;
        return this;
    }
}
