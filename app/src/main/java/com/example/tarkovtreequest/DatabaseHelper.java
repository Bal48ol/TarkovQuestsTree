package com.example.tarkovtreequest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tarkov_tree.db";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "childs";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BACKGROUND_STATE = "background_state";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME + " TEXT PRIMARY KEY, " +
                COLUMN_BACKGROUND_STATE + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertChildName(String name, int backgroundState) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_BACKGROUND_STATE, backgroundState);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int getBackgroundState(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        int backgroundState = 0;

        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_BACKGROUND_STATE},
                COLUMN_NAME + "=?", new String[]{name}, null, null, null);

        if (cursor.moveToFirst()) {
            backgroundState = cursor.getInt(cursor.getColumnIndex(COLUMN_BACKGROUND_STATE));
        }

        cursor.close();
        db.close();

        return backgroundState;
    }

    public void updateBackgroundState(String name, int newBackgroundState) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BACKGROUND_STATE, newBackgroundState);
        db.update(TABLE_NAME, values, COLUMN_NAME + "=?", new String[]{name});
        db.close();
    }

}
