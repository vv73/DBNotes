package com.vv.myapplication;

import java.io.File;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private Context context;
    private String DB_NAME = "game.db";

    private SQLiteDatabase db;

    private static DBManager dbManager;

    public static DBManager getInstance(Context context) {
        if (dbManager == null) {
            dbManager = new DBManager(context);
        }
        return dbManager;
    }

    private DBManager(Context context) {
        this.context = context;
        db = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        createTablesIfNeedBe();
    }

    void addNote(String note) {
        db.execSQL("INSERT INTO NOTES (NOTE) VALUES ('" + note + "');");
    }

    Cursor getAllNotes() {
        Cursor cursor = db.rawQuery("SELECT * FROM NOTES;", null);
        return cursor;
    }

    private void createTablesIfNeedBe() {
        db.execSQL("CREATE TABLE IF NOT EXISTS NOTES (_id integer PRIMARY KEY AUTOINCREMENT,  NOTE TEXT)");
    }

    private boolean dbExist() {
        File dbFile = context.getDatabasePath(DB_NAME);
        return dbFile.exists();
    }

}