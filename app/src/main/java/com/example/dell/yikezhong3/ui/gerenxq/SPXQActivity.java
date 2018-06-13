package com.example.dell.yikezhong3.ui.gerenxq;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.GenBean;
import com.example.dell.yikezhong3.ui.MainActivity;
import com.example.dell.yikezhong3.ui.follow.contract.FollowContract;
import com.example.dell.yikezhong3.ui.gerenxq.contract.Mycontract;
import com.example.dell.yikezhong3.ui.gerenxq.presenter.MyPresenter;
import com.example.dell.yikezhong3.ui.xiangqing.XiangQingActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class SPXQActivity extends BaseActivity<MyPresenter> implements Mycontract.View {

    private JCVideoPlayerStandard  videoView;
    private SimpleDraweeView draweeView;
    private ImageView xq_back;
    private ImageView xq_fenxiang;
    private ImageView xq_xin;
    boolean isCheck = true;
    private ImageView xq_xinlie;

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
        xq_back = findViewById(R.id.xq_back);
        xq_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPXQActivity.this.finish();
            }
        });
        xq_fenxiang = findViewById(R.id.xq_fenxiang);
        xq_fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMWeb umWeb = new UMWeb("http://www.baidu.com");
                new ShareAction(SPXQActivity.this).withMedia(umWeb).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ,
                        SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener).open();
            }
        });
        xq_xin = findViewById(R.id.xq_xin);
        xq_xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheck){
                    xq_xin.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.raw_1500090533));
                    isCheck = false;
                }else{
                    xq_xin.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.raw_1499933216));
                    isCheck = true;
                }
            }
        });

        xq_xinlie = findViewById(R.id.xq_xinlie);
        xq_xinlie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheck){
                    xq_xinlie.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.raw_1499933217));
                    isCheck = false;
                }else{
                    xq_xinlie.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.raw_1500257333));
                    isCheck = true;
                }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, requestCode, data);
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(SPXQActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(SPXQActivity.this, "失败" + t.getMessage
                    (), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(SPXQActivity.this, "取消了", Toast
                    .LENGTH_LONG).show();
        }
    };

}
