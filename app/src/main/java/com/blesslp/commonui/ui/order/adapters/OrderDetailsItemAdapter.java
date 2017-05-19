package com.blesslp.commonui.ui.order.adapters;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cnsunrun.commonui.R;

import java.util.Arrays;

/**
 * @作者: Liufan
 * @时间: 2017/5/18
 * @功能描述:
 */


public class OrderDetailsItemAdapter extends BaseQuickAdapter<String, OrderItemViewHolder> {

    public OrderDetailsItemAdapter() {
        super(R.layout.item_order_detail);

    }

    private OrderItemAdapter.OnGroupItemClickListener groupItemClickListener;

    public void setGroupItemClickListener(OrderItemAdapter.OnGroupItemClickListener groupItemClickListener) {
        this.groupItemClickListener = groupItemClickListener;
    }

    @Override
    protected void convert(OrderItemViewHolder helper, String item) {
        helper.setGroupItemClickListener(groupItemClickListener);
        helper.getAdapter().setNewData(Arrays.asList(new String[(int) (Math.random()*5+1)]));
    }
}
