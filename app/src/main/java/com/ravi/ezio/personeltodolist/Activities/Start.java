package com.ravi.ezio.personeltodolist.Activities;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ravi.ezio.personeltodolist.Backend.AlertReceiver;
import com.ravi.ezio.personeltodolist.Backend.CustomToDoType;
import com.ravi.ezio.personeltodolist.R;

import java.util.Calendar;

public class Start extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
         long miliTime=1800000;  //30 minutes prior
        //long miliTime = 30000;
      //  Toast.makeText(context,"jgjgcxjgxj",Toast.LENGTH_LONG).show();
        Intent intent1=new Intent(context, AlertReceiver.class);
        intent1.putExtra("ROWNO",intent.getIntExtra("ROWNO",-1));
        intent1.putExtra("TITLE",intent.getStringExtra("TITLE"));
        AlarmManager alarmManager= (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,miliTime, PendingIntent.getBroadcast(context,1,intent1,PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
