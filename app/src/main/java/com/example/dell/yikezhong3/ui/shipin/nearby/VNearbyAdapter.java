package com.example.dell.yikezhong3.ui.shipin.nearby;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.AdBean;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class VNearbyAdapter extends RecyclerView.Adapter<VNearbyAdapter.AttentionViewHolder>{
    private Context context;
    private List<AdBean.DataBean> list;
    private List<Integer> heightList=new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public VNearbyAdapter(Context context, List<AdBean.DataBean> list) {
        this.context = context;
        this.list = list;
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
        View view = View.inflate(context, R.layout.nearfragment, null);
        return new VNearbyAdapter.AttentionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttentionViewHolder holder, final int position) {
        holder.rc_img.setImageURI(list.get(position).getUser().getIcon());
        ViewGroup.LayoutParams params = holder.rc_img.getLayoutParams();

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

    class   AttentionViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView rc_img;
        public AttentionViewHolder(View itemView) {
            super(itemView);

            rc_img = itemView.findViewById(R.id.vfollow_sdv);
        }
    }

}
