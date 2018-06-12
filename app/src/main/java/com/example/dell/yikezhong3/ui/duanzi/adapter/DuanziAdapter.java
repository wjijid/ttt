package com.example.dell.yikezhong3.ui.duanzi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.JokesBean;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DuanziAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<JokesBean.DataBean> list;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public DuanziAdapter(Context context, List<JokesBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.duanzi_item, parent, false);
        DViewHolder dViewHolder = new DViewHolder(view);
        return dViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        JokesBean.DataBean dataBean = list.get(position);
        JokesBean.DataBean.UserBean user = dataBean.getUser();
        DViewHolder dViewHolder = (DViewHolder) holder;
        dViewHolder.image.setImageURI(user.getIcon());
        dViewHolder.t1.setText(dataBean.getContent());
        dViewHolder.t2.setText(dataBean.getCreateTime());
        //给条目设置点击事件
        dViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView image;
        private final TextView t1,t2;
        private final LinearLayout ll;
        public DViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.sdv);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
