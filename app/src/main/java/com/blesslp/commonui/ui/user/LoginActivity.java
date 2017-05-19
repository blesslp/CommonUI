package com.blesslp.commonui.ui.user;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.blesslp.commonui.ui.base.TranslucentActivity;
import com.blesslp.commonui.ui.main.NavigatorActivity;
import com.blesslp.commonui.ui.order.OrderListActivity;
import com.blesslp.commonui.ui.order.PaymentSuccessActivity;
import com.blesslp.commonui.ui.settings.AboutActivity;
import com.blesslp.commonui.ui.settings.FeedbackActivity;
import com.blesslp.commonui.widget.titlebar.TitleBar;
import com.cnsunrun.commonui.R;

public class LoginActivity extends TranslucentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initTitleBar();
        initLoginButton();
        initWxLoginButton();
    }

    private void initWxLoginButton() {
        findViewById(R.id.btnWXLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void initLoginButton() {
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheTestActivityListDialog();
            }
        });
    }

    private void openTheTestActivityListDialog() {
        new AlertDialog.Builder(LoginActivity.this)
                .setItems(new String[]{
                        "支付成功",
                        "支付失败",
                        "关于我们",
                        "反馈意见",
                        "首页",
                        "编辑信息",
                        "收货地址",
                        "订单列表",
                        "购物车"
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openTheTestActivityByListSelection(which);
                    }
                })
                .show();
    }

    private void openTheTestActivityByListSelection(int which) {
        Class<?>[] testActivities = new Class[]{
                PaymentSuccessActivity.class,
                PaymentSuccessActivity.class,
                AboutActivity.class,
                FeedbackActivity.class,
                NavigatorActivity.class,
                EditUserInfoActivity.class,
                ShippingAddressListActivity.class,
                OrderListActivity.class,
                ShoppingCarActivity.class
        };
        Class<?> clazz = testActivities[which];
        startActivity(new Intent(LoginActivity.this, clazz));
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        titleBar.setRightAction(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

}
