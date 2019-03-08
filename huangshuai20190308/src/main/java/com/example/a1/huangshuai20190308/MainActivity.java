package com.example.a1.huangshuai20190308;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private Button but;
    private TagFlowLayout Flow;
    private List<String> list;
    private LayoutInflater Inflater;
    private Button qing;
    List<String> history=new ArrayList<>();
    TextView tv;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Flow.setAdapter(new TagAdapter<String>(list) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    tv = (TextView) Inflater.inflate(R.layout.tv, Flow, false);
                    tv.setText(s);
                    return tv;
                }
            });
        }
    };
    private Button qu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        list = new ArrayList<>();
        Inflater = LayoutInflater.from(this);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = edit.getText().toString();
                list.add(trim);
                handler.sendEmptyMessageDelayed(1, 0);
            }
        });
        //清除数据
        qing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(tv);
                finish();
            }
        });
        qu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });

    }

    private void initView() {
        edit = (EditText) findViewById(R.id.edit);
        but = (Button) findViewById(R.id.but);
        Flow = (TagFlowLayout) findViewById(R.id.Flow);
        qing = (Button) findViewById(R.id.qing);
        qu = (Button) findViewById(R.id.qu);
    }
}
