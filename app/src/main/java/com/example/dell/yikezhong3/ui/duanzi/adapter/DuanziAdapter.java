package com.example.dell.yikezhong3.ui.duanzi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.JokesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DuanziAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<JokesBean.DataBean> list;
    private LayoutInflater inflater;

    public DuanziAdapter(Context context, List<JokesBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.duanzi_item, parent, false);
        DViewHolder dViewHolder = new DViewHolder(view);
        return dViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        JokesBean.DataBean dataBean = list.get(position);
        JokesBean.DataBean.UserBean user = dataBean.getUser();
        DViewHolder dViewHolder = (DViewHolder) holder;
        dViewHolder.image.setImageURI(user.getIcon());
        dViewHolder.t1.setText(dataBean.getContent());
        dViewHolder.t2.setText(dataBean.getCreateTime());
        dViewHolder.t3.setText(user.getPraiseNum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView image;
        private final TextView t1,t2,t3;

        public DViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.sdv);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            t3 = itemView.findViewById(R.id.text3);

        }
    }
}
