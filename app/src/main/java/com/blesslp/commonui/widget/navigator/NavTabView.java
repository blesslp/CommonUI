package com.blesslp.commonui.widget.navigator;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cnsunrun.commonui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者: Liufan
 * @时间: 2017/5/16
 * @功能描述:
 */


public class NavTabView extends LinearLayout {
    public NavTabView(Context context) {
        this(context,null);
    }

    public NavTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public NavTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initConfiguration();
    }

    private void initConfiguration() {
        //横向
        setOrientation(LinearLayout.HORIZONTAL);
    }

    private List<TabItem> tabs = new ArrayList<>();

    public void addTab(TabItem item) {
        View view = inflate(getContext(), R.layout.view_navtab_item, this);
        item.inflate(view);
        tabs.add(item);
    }


    public static class TabItem {
        private int res;
        private String title;
        private int notifyNumber;
        private ImageView imgNav;
        private TextView txtNav;

        private void inflate(View view) {
            this.imgNav = (ImageView) view.findViewById(R.id.img_nav);
            this.txtNav = (TextView) view.findViewById(R.id.txt_nav);
            this.txtNav.setText(title);
            this.imgNav.setImageResource(res);
        }

        public TabItem(@DrawableRes int res, String title, int notifyNumber) {
            this.res = res;
            this.title = title;
            this.notifyNumber = notifyNumber;
        }

        public int getNotifyNumber() {
            return notifyNumber;
        }

        public void setNotifyNumber(int notifyNumber) {
            this.notifyNumber = notifyNumber;
        }

        public int getRes() {
            return res;
        }

        public void setRes(int res) {
            this.res = res;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
