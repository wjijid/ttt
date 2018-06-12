package com.example.dell.yikezhong3.ui.shipin.follow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.bean.AttentionBean;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.adapter.AttentionAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VFollowAdapter  extends RecyclerView.Adapter<VFollowAdapter.AttentionViewHolder>{

    private Context context;
    private List<AdBean.DataBean> list;
    private List<Integer> heightList=new ArrayList<>();
    private OnItemClickListener  onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public VFollowAdapter(Context context, List<AdBean.DataBean> list) {
        this.context = context;
        this.list = list;
        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int height = new Random().nextInt(500) + 100;//[100,300)的随机数
            heightList.add(height);
        }
    }

    public void  addData(List<AdBean.DataBean> data){

        if(this.list==null){
            this.list = new ArrayList<>();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AttentionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.vfollow_item, null);
        return new VFollowAdapter.AttentionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttentionViewHolder holder, final int position) {
        holder.rc_img.setImageURI(list.get(position).getUser().getIcon());
        ViewGroup.LayoutParams params = holder.rc_img.getLayoutParams();
        heightList.add(position,new Random().nextInt(350) + 100);
        params.height=heightList.get(position);
        holder.rc_img.setLayoutParams(params);

        holder.rc_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null){
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
        public AttentionViewHolder(View itemView) {
            super(itemView);

            rc_img = itemView.findViewById(R.id.vfollow_sdv);
        }
    }
}
