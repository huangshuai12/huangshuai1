package com.example.a1.huangshuai20190308.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a1.huangshuai20190308.R;
import com.example.a1.huangshuai20190308.entity.UserShow;

import java.util.ArrayList;
import java.util.List;

public class NeiAdapter extends RecyclerView.Adapter<NeiAdapter.ViewHolder> {
    private Context context;
    private List<UserShow.DataBean> list;
    private int a;
    public NeiAdapter(Context context,int i) {
        this.context = context;
        list=new ArrayList<>();
        this.a=i;
    }

    public void setList(List<UserShow.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NeiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view=LayoutInflater.from(context).inflate(R.layout.linear2,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NeiAdapter.ViewHolder viewHolder, int i) {
        List<UserShow.DataBean.ListBean> list = this.list.get(a).getList();
        viewHolder.checkbox2.setChecked(list.get(i).productcheckbox);
        viewHolder.name2.setText(this.list.get(a).getList().get(i).getTitle());
       viewHolder.price.setText(this.list.get(a).getList().get(i).getPrice()+"");
        Glide.with(context).load(this.list.get(a).getList().get(i).getImages()).into(viewHolder.image);
}

    @Override
    public int getItemCount() {
            return list.get(a).getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkbox2;
        private TextView name2;
        private TextView price;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             name2=itemView.findViewById(R.id.name2);
            checkbox2=itemView.findViewById(R.id.checkbox2);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.image);
        }
    }
}
