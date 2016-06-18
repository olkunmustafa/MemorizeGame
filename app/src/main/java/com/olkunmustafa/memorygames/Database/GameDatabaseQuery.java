package com.olkunmustafa.memorygames.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.olkunmustafa.memorygames.Holders.GameDatas;

import java.util.ArrayList;

/**
 * Created by olkunmustafa on 18/06/16
 */
public class GameDatabaseQuery {

    /**
     * Provides Context object for game
     *
     * @since 0.1.0
     */
    private Context mContext;

    /**
     * Creates object to allow
     * {@link GameDatabase} class
     *
     * @since 0.1.0
     */
    private GameDatabase mGameDatabase;

    /**
     * Crates singleton helper for GameDatabaseQuery
     */
    public static GameDatabaseQuery singleton;

    public GameDatabaseQuery( Context mContext ) {
        this.mGameDatabase = new GameDatabase( mContext );

    }

    /**
     * Singleton helper.
     *
     * @since 0.1.0
     */
    public static GameDatabaseQuery newInstance( Context context ) {

        if ( singleton == null )
            singleton = new GameDatabaseQuery( context );

        return singleton;

    }

    /**
     * @param totalScore Defines total score
     * @param level      Defines level of the final round
     * @return ID of the row
     * @since 0.1.0
     */
    public long insertGameData( int totalScore, int level ) {
        long insert_id = 0;
        final SQLiteDatabase db = this.mGameDatabase.getWritableDatabase();
        db.beginTransaction();

        try {
            ContentValues values = new ContentValues();
            values.put( GameDatabase.TOTAL_SCORE, totalScore );
            values.put( GameDatabase.LEVEL, level );

            insert_id = db.insert( GameDatabase.GAME_TABLE, null, values );

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();

        }
        return insert_id;
    }

    /**
     * LocalDate tipinde
     * Girilmiş tüm periodları çeker.
     *
     * @since 0.3.0
     */
    public ArrayList< GameDatas > getAllPeriodData() {
        final SQLiteDatabase db = this.mGameDatabase.getReadableDatabase();

        ArrayList< GameDatas > list = new ArrayList< GameDatas >();
        String selectQuery =
                "SELECT * FROM "
                        + GameDatabase.GAME_TABLE;

        Cursor c = db.rawQuery( selectQuery, null );

        if ( c != null && c.moveToFirst() ) {
            do {

                GameDatas gameDatas = new GameDatas();
                gameDatas.setGameId( c.getInt( c.getColumnIndex( GameDatabase.GAME_ID ) ) );
                gameDatas.setLevel( c.getInt( c.getColumnIndex( GameDatabase.LEVEL ) ) );
                gameDatas.setTotalScore( c.getInt( c.getColumnIndex( GameDatabase.TOTAL_SCORE ) ) );

                list.add( gameDatas );

            } while ( c.moveToNext() );
            c.close();
        }

        return list;
    }

}
