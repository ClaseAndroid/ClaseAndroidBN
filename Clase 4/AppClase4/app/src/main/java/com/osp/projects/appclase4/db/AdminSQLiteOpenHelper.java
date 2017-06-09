package com.osp.projects.appclase4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by OSP on 6/06/17.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private String sql = "create table user(id int primary key, name text, lastName text, dni int, email text)";

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(sql);
    }
}
