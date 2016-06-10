package com.olkunmustafa.memorygames.Util.GameResults;

/**
 * Created by olkunmustafa on 30/05/16
 */
public class GameResultOps {

    public BaseResultTheGame iTheGameResult;

    public GameResultOps( BaseResultTheGame iTheGameResult ) {
        this.iTheGameResult = iTheGameResult;

        this.init();
    }

    /**
    * It defines init operations for that class.
    *
    * @since 0.1.0
    */
    private void init(){
        this.iTheGameResult.endTheGame();

    }
}
