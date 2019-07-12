package com.qingshangzuo.dbhelperapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";

    public DBHelper(Context context){
        super(context,CONST.JFTT_DATABASE_NAME, null,
                CONST.JFTT_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "create table "
                + CONST.JFTT_DATABASE_TABLE_USER
                + "(_id autoinc primary key , u_name varchar(20),u_pass varchar(20))";
        db.execSQL(createTableSql);
        Log.d(TAG, "Table  " + CONST.JFTT_DATABASE_TABLE_USER
                + " createad succesfully");
        createTableSql = "CREATE TABLE " + CONST.JFTT_DATABASE_TABLE_INFO + "("
                + "_id AUTOINC PRIMARY KEY,"
                + "u_age VARCHAR(20)NOT NULL ON CONFLICT FAIL,"
                + "u_addr VARCHAR(20)NOT NULL ON CONFLICT FAIL,"
                + "u_email VARCHAR(20)NOT NULL ON CONFLICT FAIL )";
        db.execSQL(createTableSql);
        Log.d(TAG, "Database " + CONST.JFTT_DATABASE_NAME
                + " createad succesfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableSQL = "DROP TABLE IF EXISTS "
                + CONST.JFTT_DATABASE_TABLE_INFO + " ";
        db.execSQL(dropTableSQL);
        dropTableSQL = "DROP TABLE IF EXISTS " + CONST.JFTT_DATABASE_TABLE_USER
                + " ";
        db.execSQL(dropTableSQL);
        onCreate(db);
    }

    public void execSQL(String sql,Object[] args){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql, args);
        Log.d(TAG, "Execute SQL " + sql + "  succesfully");
    }

    public Cursor query(String sql, String[] args) {

        SQLiteDatabase db = this.getWritableDatabase();
        Log.d(TAG, "Query SQL " + sql + "  being excuted....");
        Cursor cursor = db.rawQuery(sql, args);
        return cursor;
    }
}
