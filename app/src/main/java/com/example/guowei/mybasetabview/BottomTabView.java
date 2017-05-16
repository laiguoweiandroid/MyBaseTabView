package com.example.guowei.mybasetabview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Guowei on 2017/5/15.
 */

public class BottomTabView extends LinearLayout {
    /**
     * 记录最新的选择位置
     */
    private int lastPosition = -1;
    /**
     * 所有 TabItem 的集合
     */
    private List<TabItemView> tabItemViews;

    public BottomTabView(Context context) {
        super(context);
    }

    public BottomTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 设置 Tab Item View
     */
    public void setTabItemViews(List<TabItemView> tabItemViews){
        setTabItemViews(tabItemViews, null);
    }

    /**
     * 设置 Tab Item View
     */
    public void setTabItemViews(List<TabItemView> tabItemViews, View centerView){

        if (this.tabItemViews != null){
            throw new RuntimeException("不能重复设置！");
        }

        if (tabItemViews == null || tabItemViews.size() < 2){
            throw new RuntimeException("TabItemView 的数量必须大于2！");
        }

        this.tabItemViews = tabItemViews;
        for (int i=0; i<tabItemViews.size(); i++) {

            if (centerView != null && i == tabItemViews.size() / 2){
                this.addView(centerView);
            }

            final TabItemView tabItemView = tabItemViews.get(i);

            this.addView(tabItemView);

            final int finalI = i;

            tabItemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finalI == lastPosition){
                        // 第二次点击
                        if (onSecondSelectListener != null){
                            onSecondSelectListener.onSecondSelect(finalI);
                        }
                        return ;
                    }

                    updatePosition(finalI);

                    if (onTabItemSelectListener != null){
                        onTabItemSelectListener.onTabItemSelect(finalI);
                    }
                }
            });
        }
        /**
         * 将所有的 TabItem 设置为 初始化状态
         */
        for (TabItemView tab : tabItemViews) {
            tab.setStatus(TabItemView.DEFAULT);
        }

        /**
         * 默认状态选择第一个
         */
        updatePosition(0);
    }

    /**
     * 更新被选中 Tab Item 的状态
     * 恢复上一个 Tab Item 的状态
     */
    public void updatePosition(int position){
        if (lastPosition != position){
            tabItemViews.get(position).setStatus(TabItemView.PRESS);
            if (lastPosition != -1) {
                tabItemViews.get(lastPosition).setStatus(TabItemView.DEFAULT);
            }
            lastPosition = position;
        }
    }

    OnTabItemSelectListener onTabItemSelectListener;
    OnSecondSelectListener onSecondSelectListener;

    public void setOnTabItemSelectListener(OnTabItemSelectListener onTabItemSelectListener){
        this.onTabItemSelectListener = onTabItemSelectListener;
    }

    public void setOnSecondSelectListener(OnSecondSelectListener onSecondSelectListener){
        this.onSecondSelectListener = onSecondSelectListener;
    }

    /**
     * 第二次被选择的监听器
     */
    public interface OnSecondSelectListener{
        void onSecondSelect(int position);
    }

    /**
     * 第一次被选择的监听器
     */
    public interface OnTabItemSelectListener{
        void onTabItemSelect(int position);
    }

}
