package com.blesslp.commonui.ui.order.adapters;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cnsunrun.commonui.R;

import java.util.Arrays;

public class OrderItemAdapter extends BaseQuickAdapter<String, OrderItemViewHolder> {

    public OrderItemAdapter() {
        super(R.layout.item_order);
    }

    @Override
    protected void convert(OrderItemViewHolder helper, String item) {
        helper.setGroupItemClickListener(mGroupItemClickListener);
        helper.getAdapter().setNewData(Arrays.asList(new String[(int) (Math.random() * 5 + 1)]));
    }

    public interface OnGroupItemClickListener {
        public void onGroupItemClick(int parentPosition, int childrenPosition);
    }

    private OnGroupItemClickListener mGroupItemClickListener;

    public void setGroupItemClickListener(OnGroupItemClickListener mGroupItemClickListener) {
        this.mGroupItemClickListener = mGroupItemClickListener;
    }


}