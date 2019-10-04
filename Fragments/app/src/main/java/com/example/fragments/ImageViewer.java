package com.example.fragments;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class ImageViewer extends Fragment {
    final private int norway_id = 0;
    final private int sweden_id = 1;
    final private int denmark_id = 2;
    final private int finland_id = 3;

    public ImageViewer(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_viewer, container, false);
    }

    public void display(int i){
        Resources res = getResources();
        String[] details = res.getStringArray(R.array.description);
        TextView tv = (TextView) getView().findViewById(R.id.Description);
        ImageView iv = (ImageView) getView().findViewById(R.id.Image);

        if(i == norway_id){
            iv.setImageResource(R.drawable.norge);
            tv.setText(details[i]);
        } else if(i == sweden_id){
            iv.setImageResource(R.drawable.sverige);
            tv.setText(details[i]);
        } else if(i == denmark_id){
            iv.setImageResource(R.drawable.danmark);
            tv.setText(details[i]);
        } else if(i == finland_id){
            iv.setImageResource(R.drawable.finland);
            tv.setText(details[i]);
        } else {
            if(i < 0){
                iv.setImageResource(R.drawable.norge);
                tv.setText(details[0]);
            } else {
                iv.setImageResource(R.drawable.finland);
                tv.setText(details[3]);
            }
        }
    }
}
