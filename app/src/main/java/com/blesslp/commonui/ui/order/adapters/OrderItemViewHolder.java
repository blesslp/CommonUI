package com.blesslp.commonui.ui.order.adapters;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blesslp.commonui.widget.recyclerview.RecyclerViewDivider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.commonui.R;

class OrderItemViewHolder extends BaseViewHolder {

    private RecyclerView recyclerView;
    private OrderProductItemAdapter mAdapter;

    public OrderProductItemAdapter getAdapter() {
        return mAdapter;
    }


    public OrderItemViewHolder(View view) {
        super(view);
        initRecyclerView();
        initRecyclerViewEvent();
    }

    private OrderItemAdapter.OnGroupItemClickListener mGroupItemClickListener;

    public void setGroupItemClickListener(OrderItemAdapter.OnGroupItemClickListener onGroupItemClickListener) {
        this.mGroupItemClickListener = onGroupItemClickListener;
    }

    private void initRecyclerViewEvent() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (mGroupItemClickListener != null) {
                    mGroupItemClickListener.onGroupItemClick(getAdapterPosition(), position);
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = getView(R.id.recvProductItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        recyclerView.addItemDecoration(new RecyclerViewDivider(itemView.getContext(), DividerItemDecoration.VERTICAL, R.drawable.divider_inner_drawable));
        mAdapter = new OrderProductItemAdapter();
        mAdapter.bindToRecyclerView(recyclerView);
    }
}