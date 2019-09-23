package com.example.friends;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class FriendAdapter extends BaseAdapter {
    private Context context;
    private Friend[] friends;

    public FriendAdapter(Context context, Friend[] friends){
        this.context = context;
        this.friends = friends;
    }

    @Override
    public int getCount() {
        return this.friends.length;
    }

    @Override
    public Object getItem(int i) {
        return this.friends[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView tv;
        if(view == null){
            tv = new TextView(this.context);
            tv.setText(this.friends[i].getName() + " born " + this.friends[i].getBirthdate());
        } else {
            tv = (TextView) view;
        }

        return tv;
    }
}
