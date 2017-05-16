package com.example.guowei.mybasetabview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Guowei on 2017/5/15.
 */

public class TabItemView extends LinearLayout {

    /**
     * 两个状态 选中、未选中
     */
    public final static int PRESS = 1;
    public final static int DEFAULT = 2;
    /**
     * Item 的标题
     */
    public String title;
    /**
     * 标题的两个状态的颜色 选中、未选中
     */
    public int colorDef;
    public int colorPress;
    /**
     * 两个图标的 资源 id ，选中、未选中
     */
    public int iconResDef;
    public int iconResPress;
    /**图标标题*/
    public TextView tvTitle;
    /**图标*/
    public ImageView ivIcon;

    public TabItemView(Context context, String title, int colorDef, int colorPress,
                       int iconResDef, int iconResPress) {
        super(context);
        this.title = title;
        this.colorDef = colorDef;
        this.colorPress = colorPress;
        this.iconResDef = iconResDef;
        this.iconResPress = iconResPress;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(super.getContext()).inflate(R.layout.tabitem_view,this);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
        LayoutParams params = new LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight =1;
        view.setLayoutParams(params);
        tvTitle.setText(title);
    }
    /**
     * 设置状态
     */
    public void setStatus(int status){
        tvTitle.setTextColor(ContextCompat.getColor(super.getContext(), status == PRESS ? colorPress : colorDef));
        ivIcon.setImageResource(status == PRESS ? iconResPress : iconResDef);
    }
}
