package com.olkunmustafa.memorygames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.olkunmustafa.memorygames.Database.GameDatabaseQuery;
import com.olkunmustafa.memorygames.Holders.GameDatas;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Provides Activities for end the game.
 *
 * @since 0.1.0
 */
public class EndActivity extends BaseActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_end );

        List<GameDatas> datas = GameDatabaseQuery.newInstance( this ).getAllPeriodData();

        for ( GameDatas gameData : datas ) {

            System.out.println( gameData.getGameId() );
            System.out.println( gameData.getLevel() );
            System.out.println( gameData.getTotalScore() );
            System.out.println( "============" );


        }

    }
}
