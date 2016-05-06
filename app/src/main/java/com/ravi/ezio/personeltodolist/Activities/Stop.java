package com.ravi.ezio.personeltodolist.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;

import com.ravi.ezio.personeltodolist.Backend.DatabaseHelper;


public class Stop extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        DatabaseHelper db=new DatabaseHelper(context);
        long row=intent.getIntExtra("ROWNO",-1);
        if(row==-1)
            Toast.makeText(context,"Error Occured!!",Toast.LENGTH_SHORT).show();
        else
        {
            db.deleteARecord(row);
            Toast.makeText(context,"To Do Deleted!",Toast.LENGTH_SHORT).show();
        }
    }
}
