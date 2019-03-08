package com.example.a1.huangshuai20190308;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyView extends LinearLayout {
     TextView ed_jia,ed_jian;
    EditText ed_num;
    private int num=1;
    public MyView(Context context) {
        super(context);
    }

    public MyView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=LayoutInflater.from(context).inflate(R.layout.linear3,this);
        ed_jia=view.findViewById(R.id.ed_jia);
        ed_jian=view.findViewById(R.id.ed_jian);
        ed_num=view.findViewById(R.id.ed_num);
        ed_num.setText("1");
        ed_jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                ed_num.setText(num+"");
            }
        });
        ed_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num--;
                if (num==0){
                    num=1;
                    Toast.makeText(context,"不能在减了",Toast.LENGTH_SHORT).show();
                }ed_num.setText(num+"");
            }
        });
    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
