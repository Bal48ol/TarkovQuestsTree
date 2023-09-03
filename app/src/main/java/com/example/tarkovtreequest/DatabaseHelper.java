package com.example.tarkovtreequest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tarkov_tree.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "quests";
    private static final String COLUMN_NAME = "quest";
    private static final String COLUMN_BACKGROUND_STATE = "done";

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

    public void insertChildName(Child child) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, child.getName());
        values.put(COLUMN_BACKGROUND_STATE, child.getBackgroundState());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Child getChildByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Child child = null;

        Cursor cursor = db.query(TABLE_NAME, null,
                COLUMN_NAME + "=?", new String[]{name}, null, null, null);

        if (cursor.moveToFirst()) {
            String childName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            int backgroundState = cursor.getInt(cursor.getColumnIndex(COLUMN_BACKGROUND_STATE));
            child = new Child(childName, backgroundState);
        }

        cursor.close();
        db.close();

        return child;
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

    public void updateBackgroundState(Child child) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BACKGROUND_STATE, child.getBackgroundState());
        db.update(TABLE_NAME, values, COLUMN_NAME + "=?", new String[]{child.getName()});
        db.close();
    }

}
