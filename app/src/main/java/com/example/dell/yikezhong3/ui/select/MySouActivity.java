package com.example.dell.yikezhong3.ui.select;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.base.BaseActivity;
import com.example.dell.yikezhong3.bean.CollectionBean;
import com.example.dell.yikezhong3.bean.SelectBean;
import com.example.dell.yikezhong3.component.DaggerHttpComponent;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.collect.adapter.CollectAdapter;
import com.example.dell.yikezhong3.ui.collect.contract.CollectContract;
import com.example.dell.yikezhong3.ui.collect.presenter.CollectPresenter;
import com.example.dell.yikezhong3.ui.select.adapter.SelectAdapter;
import com.example.dell.yikezhong3.ui.select.contract.SelectContract;
import com.example.dell.yikezhong3.ui.select.presenter.SelectPresenter;

import java.util.ArrayList;
import java.util.List;

public class MySouActivity extends BaseActivity<SelectPresenter> implements SelectContract.View {


    private RecyclerView recv;
    private Button bt_select;
    private EditText  ed;
    private SelectAdapter adapter;
    private TextView foll_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }



    private void initview() {
        recv=findViewById(R.id.select_recyclerview);
        bt_select=findViewById(R.id.select_but);
        foll_text=findViewById(R.id.foll_text);
        foll_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySouActivity.this.finish();
            }
        });
        ed=findViewById(R.id.ed);

        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = ed.getText().toString();
                if(s!=null){
                    initData();

                }
               else{
                    Toast.makeText(MySouActivity.this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }


            }
        });

        List<SelectBean.DataBean> list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recv.setLayoutManager(manager);
        recv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new SelectAdapter(this,list);
        recv.setAdapter(adapter);


    }


    private void initData() {
        String s = ed.getText().toString();
        if(s==null){
            Toast.makeText(MySouActivity.this,"输入内容不能为空",Toast.LENGTH_SHORT).show();;
        }else {
            mPresenter.getSelect(s);
        }
    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_my_sou;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpMoudle(new HttpMoudle())
                .build()
                .inject(this);
    }

    @Override
    public void getSelectSuccess(SelectBean selectBean) {
        if (adapter != null){
            adapter.addData(selectBean.getData());

        }
    }
}
