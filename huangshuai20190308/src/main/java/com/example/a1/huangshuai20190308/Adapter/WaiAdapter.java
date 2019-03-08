package com.example.a1.huangshuai20190308.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.a1.huangshuai20190308.R;
import com.example.a1.huangshuai20190308.entity.UserShow;

import java.util.ArrayList;
import java.util.List;

public class WaiAdapter extends RecyclerView.Adapter<WaiAdapter.ViewHolder> {
    private Context context;
    private List<UserShow.DataBean> list;

    public WaiAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<UserShow.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WaiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view=LayoutInflater.from(context).inflate(R.layout.linear1,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WaiAdapter.ViewHolder viewHolder, int i) {
        UserShow.DataBean dataBean = list.get(i);
        viewHolder.name1.setText(list.get(i).getSellerName());
        viewHolder.checkbox1.setChecked(list.get(i).ischecked);
        viewHolder.xrec1.setLayoutManager(new LinearLayoutManager(context));
        NeiAdapter neiAdapter = new NeiAdapter(context, i);
        viewHolder.xrec1.setAdapter(neiAdapter);
        neiAdapter.setList(list);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkbox1;
        private TextView name1;
        private RecyclerView xrec1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             name1=itemView.findViewById(R.id.name1);
            checkbox1=itemView.findViewById(R.id.checkbox1);
            xrec1=itemView.findViewById(R.id.xrec1);
        }
    }
    public List<UserShow.DataBean> setList(){
        return list;
    }
}
