package com.qingshangzuo.dbhelperapplication;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CursorAdapter extends BaseAdapter {

    private static final String TAG = "CursorAdapter";
    private Context context;
    private Cursor cursor;
    private LayoutInflater inflater;
    private LinearLayout pageLayout;

    public CursorAdapter(Context context, Cursor cursor) {
        super();
        this.context = context;
        this.cursor = cursor;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        Log.d(TAG, "Count :" + cursor.getCount());
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        Log.d(TAG, "Item :" + position);
        return position;
    }

    @Override
    public long getItemId(int position) {
        Log.d(TAG, "ItemId :" + position);
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        cursor.moveToPosition(position);
        // TODO Auto-generated method stub
        pageLayout = (LinearLayout) inflater.inflate(R.layout.page, null);
        TextView textAddr = pageLayout.findViewById(R.id.TextView01);
        TextView textEmail = pageLayout
                .findViewById(R.id.TextView02);

        textAddr.setText(cursor.getString(2));
        Log.d(TAG, "Addr :" + cursor.getString(2));
        textEmail.setText(cursor.getString(3));
        ImageView image = (ImageView) pageLayout.findViewById(R.id.ImageView01);
        image.setImageDrawable(context.getResources().getDrawable(
                R.drawable.icon0));

        return pageLayout;
    }
}
