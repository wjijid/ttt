package com.example.dell.yikezhong3.ui.select.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.bean.SelectBean;
import com.example.dell.yikezhong3.inter.OnItemClickListener;
import com.example.dell.yikezhong3.ui.collect.adapter.CollectAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class SelectAdapter  extends RecyclerView.Adapter<SelectAdapter.ViewHolder>{


    private Context context;
    private List<SelectBean.DataBean> list;
    private OnItemClickListener onItemClickListener;

    public SelectAdapter(Context context, List<SelectBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;


    }

    public void  addData(List<SelectBean.DataBean> data){
        if(this.list==null){
            list=new ArrayList<>();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.select_item, null);
        return new SelectAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.rc_img.setImageURI(list.get(position).getIcon());
        holder.rc_name.setText(list.get(position).getNickname());
        holder.rc_time.setText(list.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class  ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView rc_img;
        private final TextView rc_name,rc_time;
        public ViewHolder(View itemView) {
            super(itemView);

            rc_img = itemView.findViewById(R.id.rc_img);
            rc_name = itemView.findViewById(R.id.rc_name);
            rc_time = itemView.findViewById(R.id.rc_time);
        }
    }
}
