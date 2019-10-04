package com.example.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.ListFragment;
import android.widget.ListView;

public class TitleViewer extends ListFragment {
    private ImageViewer iv;
    private int current = 0;

    public TitleViewer(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iv = (ImageViewer) getFragmentManager().findFragmentById(R.id.image_viewer);
        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, titles));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        current = position;
        iv.display(position);
    }

    public void show(int i){
        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        current += i;
        System.out.println(current);
        if(current > -1 && current < titles.length){
            iv.display(current);
        } else if(current == -1){
            iv.display(current = titles.length - 1);
        } else if(current == titles.length){
            iv.display(current = 0);
        }
    }
}
