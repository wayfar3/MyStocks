package com.standalone.mystocks.handlers.generic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OpenDB extends SQLiteOpenHelper {
    private final Context context;

    public OpenDB(Context context, String dbName, int version) {
        super(context, dbName, null, version);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropAllTables(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @NonNull
    public SQLiteDatabase getDatabase() {
        return getWritableDatabase();
    }

    @SuppressLint("Range")
    private void dropAllTables(SQLiteDatabase db) {
        Cursor curs = null;
        db.beginTransaction();
        try {
            curs = db.rawQuery("SELECT name FROM sqlite_master WHERE type IS 'table'", null);
            if (curs != null) {
                if (curs.moveToFirst()) {
                    do {
                        db.execSQL("DROP TABLE IF EXISTS " + curs.getString(curs.getColumnIndex("name")));
                    } while (curs.moveToNext());
                }
            }
        } finally {
            db.endTransaction();
            assert curs != null;
            curs.close();
        }
    }
}
