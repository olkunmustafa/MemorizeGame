package com.olkunmustafa.memorygames.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by olkunmustafa on 11/06/16
 * <p/>
 * Creates database object
 *
 * @since 0.1.0
 */
public class GameDatabase extends SQLiteOpenHelper {

    /**
     * Context object
     *
     * @since 0.1.0
     */
    private Context mContext;

    /**
     * Database name constant.
     *
     * @since 0.1.0
     */
    public static final String DATABASE_NAME = "gameDatabase";

    /**
     * Database version
     *
     * @since 0.1.0
     */
    public static final int DATABASE_VERSION = 1;

    /**
     * Default constructor
     *
     * @param context Context object to create Database
     * @since 0.1.0
     */
    public GameDatabase( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
        this.mContext = context;

    }

    public static final String GAME_TABLE = "game_table"; // Gelen push bildirimler için tablo adı.
    public static final String GAME_ID = "game_id";
    public static final String TOTAL_SCORE = "total_score";
    public static final String LEVEL = "game_level";
    public static final String TIME = "game_time";
    public static final String CREATE_GAME_TABLE =
            "CREATE TABLE IF NOT EXISTS "
                    + GAME_TABLE
                    + "("
                    + GAME_ID
                    + " INTEGER PRIMARY KEY,"
                    + TOTAL_SCORE
                    + " INTEGER,"
                    + LEVEL
                    + " INTEGER,"
                    + TIME
                    + " TEXT "
                    + ")";

    @Override
    public void onCreate( SQLiteDatabase db ) {
        db.execSQL( CREATE_GAME_TABLE );

    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        onCreate( db );

    }
}
