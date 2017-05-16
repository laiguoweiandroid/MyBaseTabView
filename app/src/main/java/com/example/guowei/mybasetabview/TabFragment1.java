package com.example.guowei.mybasetabview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Guowei on 2017/5/16.
 */

public class TabFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablist_view,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText("这是第一页");
        textView.setBackgroundColor(Color.GREEN);
        return view;
    }
}
