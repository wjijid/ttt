package com.example.dell.yikezhong3.ui.gerenxq;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.GenBean;
import com.example.dell.yikezhong3.ui.follow.contract.FollowContract;
import com.example.dell.yikezhong3.ui.gerenxq.contract.Mycontract;
import com.example.dell.yikezhong3.ui.gerenxq.presenter.MyPresenter;
import com.example.dell.yikezhong3.ui.xiangqing.XiangQingActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class SPXQActivity extends BaseActivity<MyPresenter> implements Mycontract.View {

    private JCVideoPlayerStandard  videoView;
    private SimpleDraweeView draweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_spxq;
    }

    private void initview() {
        videoView = findViewById(R.id.xq_video);
        videoView.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "饺子闭眼睛");
        //videoView.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        Glide.with(this).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into(videoView.thumbImageView);
        //创建simpleDraweeView对象
        draweeView = (SimpleDraweeView) findViewById(R.id.xq_image);
        draweeView.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login))
                .build());
        draweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SPXQActivity.this, XiangQingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void inject() {

    }

    @Override
    public void getGeSuccess(GenBean genBean) {

        //List<GenBean.DataBean> list = genBean.getData();
//        for (int i = 0; i <list.size() ; i++) {
//           // String videoUrl = list.get(i).getVideoUrl();
//
//        }
        
    }
}
