package com.ravi.ezio.personeltodolist.Backend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ravi.ezio.personeltodolist.R;

import java.util.List;

/**
 * Created by ezio on 4/5/16.
 */
public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {

    public LayoutInflater inflater;
    public Context context;
    List<CustomToDoType> list;
    public MyRecyclerView(Context context, List<CustomToDoType> list)
    {
        this.list=list;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.custom_card,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
