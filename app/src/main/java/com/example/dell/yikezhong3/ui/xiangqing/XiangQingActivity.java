package com.example.dell.yikezhong3.ui.xiangqing;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.bean.GuanzhuBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.collect.adapter.CollectAdapter;
import com.example.dell.yikezhong3.ui.collect.contract.CollectContract;
import com.example.dell.yikezhong3.ui.collect.presenter.CollectPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import static com.example.dell.yikezhong3.R.drawable.dianzan1;

public class XiangQingActivity extends BaseActivity<CollectPresenter> implements CollectContract.View {

    private RecyclerView recyclerView;
    private CollectAdapter adapter;
    private TextView foll_text;
    private CheckBox btn;
    private ImageView dianzan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    private void initview() {
        recyclerView=findViewById(R.id.xMrv);
        btn = findViewById(R.id.guanzhu);
        //dianzan = findViewById(R.id.dianzan);
        //创建simpleDraweeView对象
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.simple);
        draweeView.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.touxiang))
                .build());
        List<CollectionBean.DataBean> list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CollectAdapter(this,list);
        recyclerView.setAdapter(adapter);



        initData();
    }

    private void initData() {
        mPresenter.getCollect("14445","DEEDFF540856EC880DC7EB2F8C16C7E5");
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_xiang_qing;
    }



    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
                .inject(this);
    }


    @Override
    public void getCollectSuccess(CollectionBean collectionBean) {
        if (adapter != null){
            adapter.addData(collectionBean.getData());

        }
    }
}
