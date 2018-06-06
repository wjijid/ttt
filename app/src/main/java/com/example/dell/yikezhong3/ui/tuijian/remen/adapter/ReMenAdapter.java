package com.example.dell.yikezhong3.ui.tuijian.remen.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ReMenAdapter extends RecyclerView.Adapter<ReMenAdapter.RecommendViewHolder> {
    private Context context;
    private List<AdBean.DataBean> list;

    public ReMenAdapter(Context context, List<AdBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void addData(List<AdBean.DataBean> data) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //添加布局视图
        View view = View.inflate(context, R.layout.item_recv, null);
        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecommendViewHolder holder, int position) {
        holder.rc_img.setImageURI(list.get(position).getUser().getIcon());
        holder.rc_name.setText(list.get(position).getUser().getNickname());
        holder.rc_time.setText(list.get(position).getCreateTime());

        holder.videoView.TOOL_BAR_EXIST = false;
        holder.videoView.setUp(list.get(position).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"我最帅");
        Glide.with(context).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into(holder.videoView.thumbImageView);
        holder.videoView.widthRatio = 4;//播放比例
        holder.videoView.heightRatio = 3;
        holder.videoView.startVideo();
    }

/*    @Override
    public void onBindViewHolder(@NonNull final RecommendViewHolder holder, int position) {
      //  final RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
        holder.rc_img.setImageURI(list.get(position).getUser().getIcon());
        holder.rc_name.setText(list.get(position).getUser().getNickname());
        holder.rc_time.setText(list.get(position).getCreateTime());

        holder.videoView.setVideoURI(Uri.parse(list.get(position).getVideoUrl()));
        holder.videoView.setMediaController(new MediaController(context));//显示控制栏
        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                holder.videoView.start();
            }
        });
    }*/

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView rc_img;
        private final TextView rc_name,rc_time;
        private final JCVideoPlayerStandard videoView;
        public RecommendViewHolder(View itemView) {
            super(itemView);

            rc_img = itemView.findViewById(R.id.rc_img);
            rc_name = itemView.findViewById(R.id.rc_name);
            rc_time = itemView.findViewById(R.id.rc_time);
            videoView = itemView.findViewById(R.id.video);
        }
    }
}
