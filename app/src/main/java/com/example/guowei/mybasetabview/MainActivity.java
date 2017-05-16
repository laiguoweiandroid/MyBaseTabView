package com.example.guowei.mybasetabview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BottomTabBaseActivity {

    @Override
    protected List<TabItemView> getTabViews() {
        List<TabItemView> mTabList = new ArrayList<>();
        mTabList.add(new TabItemView(this,"标题1", R.color.colorPrimary,
                R.color.colorAccent, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));
        mTabList.add(new TabItemView(this,"标题2", R.color.colorPrimary,
                R.color.colorAccent, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));
        mTabList.add(new TabItemView(this,"标题3", R.color.colorPrimary,
                R.color.colorAccent, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));
        mTabList.add(new TabItemView(this,"标题4", R.color.colorPrimary,
                R.color.colorAccent, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round));

        return mTabList;
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> mList = new ArrayList<>();
        mList.add(new TabFragment1());
        mList.add(new TabFragment2());
        mList.add(new TabFragment3());
        mList.add(new TabFragment4());
        return mList;
    }

    @Override
    protected View getCenterView() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher_round);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100,100);
        params.leftMargin = 40;
        params.rightMargin = 40;
        params.bottomMargin =0;
        imageView.setLayoutParams(params);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"centerView 点击了",Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }
}
