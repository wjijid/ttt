package com.example.dell.yikezhong3.ui.tuijian.guanzhu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.ui.tuijian.remen.adapter.ReMenAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.AttentionViewHolder>{


    private Context context;
    private List<AttentionBean.DataBean>  list;
    private OnItemClickListener onItemClickListener;

    public AttentionAdapter(Context context, List<AttentionBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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
        View view = View.inflate(context, R.layout.item_atten, null);
        return new AttentionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttentionViewHolder holder, final int position) {

        holder.rc_img.setImageURI(list.get(position).getIcon());
        holder.rc_name.setText(list.get(position).getUsername());
        holder.rc_time.setText(list.get(position).getCreatetime());

        holder.videoView.TOOL_BAR_EXIST = false;
        holder.videoView.setUp(list.get(position).getIcon(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"  ");
        Glide.with(context).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into(holder.videoView.thumbImageView);
        holder.videoView.widthRatio = 4;//播放比例
        holder.videoView.heightRatio = 3;
        holder.videoView.startVideo();
        //给条目设置点击事件
        holder.ll.setOnClickListener(new View.OnClickListener() {
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

    class AttentionViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView rc_img;
        private final TextView rc_name,rc_time;
        private final JCVideoPlayerStandard videoView;
        private final LinearLayout ll;
        public AttentionViewHolder(View itemView) {
            super(itemView);

            rc_img = itemView.findViewById(R.id.rc_img);
            rc_name = itemView.findViewById(R.id.rc_name);
            rc_time = itemView.findViewById(R.id.rc_time);
            videoView = itemView.findViewById(R.id.video);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
