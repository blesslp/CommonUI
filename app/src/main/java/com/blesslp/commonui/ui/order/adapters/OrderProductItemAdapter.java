package com.blesslp.commonui.ui.order.adapters;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.commonui.R;

public class OrderProductItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public OrderProductItemAdapter() {
            super(R.layout.item_order_product);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }