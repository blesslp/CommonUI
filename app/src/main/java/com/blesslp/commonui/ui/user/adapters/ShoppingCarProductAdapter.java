package com.blesslp.commonui.ui.user.adapters;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.commonui.R;

/**
 * @作者: Liufan
 * @时间: 2017/5/18
 * @功能描述:
 */


public class ShoppingCarProductAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public ShoppingCarProductAdapter() {
        super(R.layout.item_shoppingcar);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
