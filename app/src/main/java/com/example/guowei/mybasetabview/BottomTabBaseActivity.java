package com.example.guowei.mybasetabview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public abstract class BottomTabBaseActivity extends AppCompatActivity {
    ViewPager mViewPager;
    BottomTabView bottomTabView;
    FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_base);
        initView();
        setListeners();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        bottomTabView = (BottomTabView) findViewById(R.id.bottomTabView);
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return getFragments().get(position);
            }

            @Override
            public int getCount() {
                return getFragments().size();
            }
        };
        mViewPager.setAdapter(fragmentPagerAdapter);

        if (getCenterView() == null){
            bottomTabView.setTabItemViews(getTabViews());
        }else {
            bottomTabView.setTabItemViews(getTabViews(), getCenterView());
        }
    }

    /**
     * 设置控件监听
     */
    private void setListeners() {
        bottomTabView.setOnTabItemSelectListener(new BottomTabView.OnTabItemSelectListener() {
            @Override
            public void onTabItemSelect(int position) {
                mViewPager.setCurrentItem(position,true);

            }
        });
        bottomTabView.setOnSecondSelectListener(new BottomTabView.OnSecondSelectListener() {
            @Override
            public void onSecondSelect(int position) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomTabView.updatePosition(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    protected abstract List<TabItemView> getTabViews();
    protected abstract List<Fragment> getFragments();

    protected View getCenterView(){
        return null;
    }
}
