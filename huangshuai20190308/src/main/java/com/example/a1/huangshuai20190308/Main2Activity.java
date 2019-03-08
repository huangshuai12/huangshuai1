package com.example.a1.huangshuai20190308;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.a1.huangshuai20190308.Adapter.WaiAdapter;
import com.example.a1.huangshuai20190308.contract.LoadContract;
import com.example.a1.huangshuai20190308.entity.UserShow;
import com.example.a1.huangshuai20190308.presenter.Loadpresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements LoadContract.LloadView {

    private RecyclerView xrec;
    private CheckBox checkboxquan;
     public List<UserShow.DataBean> list;
    private  WaiAdapter waiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Loadpresenter loadpresenter = new Loadpresenter(this);
        xrec.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
        loadpresenter.ppresenter(new HashMap<String, String>());


        checkboxquan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list=waiAdapter.setList();
                if (isChecked){
                    for(UserShow.DataBean dataBean:list){
                        dataBean.ischecked=true;
                        for (UserShow.DataBean.ListBean listBean:dataBean.getList()){
                            listBean.productcheckbox=true;
                        }
                    }
                }else{
                    for(UserShow.DataBean dataBean:list) {
                        dataBean.ischecked = false;
                        for (UserShow.DataBean.ListBean listBean : dataBean.getList()) {
                            listBean.productcheckbox = false;
                        }
                    }
                }
                waiAdapter.notifyDataSetChanged();
                getTimeprice();
            }

            private void getTimeprice() {
                double timeout=0;
                for (UserShow.DataBean dataBean:list){
                    for (UserShow.DataBean.ListBean listBean:dataBean.getList()){
                        if (listBean.productcheckbox){
                            timeout+=listBean.getPrice();
                        }
                    }
                }
                checkboxquan.setText("总价"+timeout);
            }
        });
    }

    @Override
    public void Success(String result) {
        UserShow userShow = new Gson().fromJson(result, UserShow.class);

        waiAdapter = new WaiAdapter(this);
        xrec.setAdapter(waiAdapter);
        waiAdapter.setList(userShow.getData());
    }

    @Override
    public void Failure(String msg) {

    }

    private void initView() {
        xrec = (RecyclerView) findViewById(R.id.xrec);
        checkboxquan = (CheckBox) findViewById(R.id.checkboxquan);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Loadpresenter.ondestory();
    }
}
