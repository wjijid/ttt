package com.example.dell.yikezhong3.ui.follow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.bean.FllowBean;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.adapter.AttentionAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.AttentionViewHolder> {


    private Context context;
    private List<AttentionBean.DataBean>  list;

    public FollowAdapter(Context context, List<AttentionBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void  addData(List<AttentionBean.DataBean> data){

        if(this.list==null){
            this.list = new ArrayList<>();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AttentionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_followrecv, null);
        return new FollowAdapter.AttentionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttentionViewHolder holder, int position) {

        holder.rc_img.setImageURI(list.get(position).getIcon());
        holder.rc_name.setText(list.get(position).getUsername());
        holder.rc_time.setText(list.get(position).getCreatetime());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class AttentionViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView rc_img;
        private final TextView rc_name,rc_time;
        public AttentionViewHolder(View itemView) {
            super(itemView);

            rc_img = itemView.findViewById(R.id.rc_img);
            rc_name = itemView.findViewById(R.id.rc_name);
            rc_time = itemView.findViewById(R.id.rc_time);
        }
    }
}
