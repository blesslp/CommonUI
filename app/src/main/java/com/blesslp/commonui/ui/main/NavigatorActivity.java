package com.blesslp.commonui.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.blesslp.commonui.ui.base.TranslucentActivity;
import com.blesslp.commonui.widget.navigator.NavTabView;
import com.cnsunrun.commonui.R;

public class NavigatorActivity extends TranslucentActivity {

    @Override
    protected boolean isTranslucent() {
        return true;
    }

    @Override
    protected boolean isStatusContentDark() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);
        initNavTabView();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContainer,UserMineFragment.newInstance())
                .commitNowAllowingStateLoss();
    }

    private final BottomNavigationItem[] navbars = new BottomNavigationItem[4];
    private final BadgeItem[] badgeItems = new BadgeItem[4];

    private void initNavTabView() {
        final BottomNavigationBar navTabView = (BottomNavigationBar) findViewById(R.id.navTabView);

        //不设置InactiveIcon的情况下,会启用着色器自动着色,设置了则忽略,
        //Navbar 可以动态设置Badge的数字和显示以及隐藏,
        //但是一经创建,不可修改文字和图片,若非要改,需要调用initialise()重新布局
        navTabView.addItem(navbars[0] = new BottomNavigationItem(R.mipmap.ic_launcher_round, "首页").setInactiveIconResource(R.mipmap.ic_launcher_round).setBadgeItem(badgeItems[0] = new BadgeItem().hide(false)));
        navTabView.addItem(navbars[1] = new BottomNavigationItem(R.mipmap.ic_launcher, "发现").setBadgeItem(badgeItems[1] = new BadgeItem().hide(false)));
        navTabView.addItem(navbars[2] = new BottomNavigationItem(R.mipmap.ic_launcher, "联系").setBadgeItem(badgeItems[2] = new BadgeItem().hide(false)));
        navTabView.addItem(navbars[3] = new BottomNavigationItem(R.mipmap.ic_launcher, "我的").setBadgeItem(badgeItems[3] = new BadgeItem().hide(false)));

        navTabView.initialise();

        navTabView.setTabSelectedListener(new BottomNavigationBar.SimpleOnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                super.onTabSelected(position);
                badgeItems[position].setText("1").show(true);

            }

            @Override
            public void onTabReselected(int position) {
                super.onTabReselected(position);
                badgeItems[position].setText("2").show();
            }

            @Override
            public void onTabUnselected(int position) {
                super.onTabUnselected(position);
                badgeItems[position].setText("0").hide(true);

            }
        });

    }
}
