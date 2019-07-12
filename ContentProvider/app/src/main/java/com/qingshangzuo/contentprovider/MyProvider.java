package com.qingshangzuo.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

public class MyProvider extends ContentProvider {
    private MyOpenHelper mHelper;
    private static final String AUTHORITIES = "com.gdcp.student";
    private static final  int CODE_STU = 1;
    private static final  int CODE_SCO = 2;
    public  static final Uri URI_STU = Uri.parse("content://"+AUTHORITIES+"/"+StudentTable.TABLE_NAME);
    public  static final Uri URI_SCO = Uri.parse("content://"+AUTHORITIES+"/"+ScoreTable.TABLE_NAME);
    static UriMatcher sMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sMatcher.addURI(AUTHORITIES,StudentTable.TABLE_NAME,CODE_STU );
        sMatcher.addURI(AUTHORITIES,ScoreTable.TABLE_NAME, CODE_SCO);
    }
    @Override
    public boolean onCreate() {
        mHelper = new MyOpenHelper(getContext(),"stu.db",null, 1);
        return true;
    }
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (sMatcher.match(uri)){
            case  CODE_STU:
                SQLiteDatabase db1 = mHelper.getReadableDatabase();
                Cursor cur = db1.query(StudentTable.TABLE_NAME,projection,selection,selectionArgs,null,null, sortOrder);
//                db1.close();
                return  cur;
            case  CODE_SCO:
                SQLiteDatabase  db2 = mHelper.getReadableDatabase();
                return  db2.query(ScoreTable.TABLE_NAME,projection,selection,selectionArgs,null,null, sortOrder);
        }
        return null;
    }



    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch (sMatcher.match(uri)){
            case  CODE_STU:
                SQLiteDatabase  db1 = mHelper.getReadableDatabase();
                db1.insert(StudentTable.TABLE_NAME, null, values);
                db1.close();
                break;


            case  CODE_SCO:
                SQLiteDatabase  db2 = mHelper.getReadableDatabase();
                db2.insert(ScoreTable.TABLE_NAME, null, values);
                db2.close();
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch (sMatcher.match(uri)){
            case  CODE_STU:
                SQLiteDatabase  db1 = mHelper.getReadableDatabase();
                int i = db1.delete(StudentTable.TABLE_NAME, selection, selectionArgs);
                db1.close();
                return i;

            case  CODE_SCO:
                SQLiteDatabase  db2 = mHelper.getReadableDatabase();
                int a= db2.delete(ScoreTable.TABLE_NAME, selection, selectionArgs);
                db2.close();
                return a;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        switch (sMatcher.match(uri)){
            case  CODE_STU:
                SQLiteDatabase  db1 = mHelper.getReadableDatabase();
                db1.update(StudentTable.TABLE_NAME, values, selection, selectionArgs);
                db1.close();
                break;

            case  CODE_SCO:
                SQLiteDatabase  db2 = mHelper.getReadableDatabase();
                db2.update(ScoreTable.TABLE_NAME, values, selection, selectionArgs);
                db2.close();
                break;
        }
        return 0;
    }


    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }
}

