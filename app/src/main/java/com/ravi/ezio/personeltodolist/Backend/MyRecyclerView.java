package com.ravi.ezio.personeltodolist.Backend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ravi.ezio.personeltodolist.Activities.Show;
import com.ravi.ezio.personeltodolist.R;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

/**
 * Created by ezio on 4/5/16.
 */
public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {

    public static final String CUSTOM_OBJECT_KEY="OBJECT";
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
        final CustomToDoType customToDoType=list.get(position);
        holder.title.setText(customToDoType.title);
        holder.time.setText(customToDoType.time);
        holder.date.setText(customToDoType.date);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Show.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable(CUSTOM_OBJECT_KEY,customToDoType);
                intent.putExtra(CUSTOM_OBJECT_KEY,bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView time,date,title;
        LinearLayout layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            time= (TextView) itemView.findViewById(R.id.card_time);
            time.setTypeface(EasyFonts.walkwayBold(context));
            date= (TextView) itemView.findViewById(R.id.card_date);
            date.setTypeface(EasyFonts.walkwayBold(context));
            title= (TextView) itemView.findViewById(R.id.card_title);
            title.setTypeface(EasyFonts.walkwayBold(context));
            layout= (LinearLayout) itemView.findViewById(R.id.card);
        }
    }
}
