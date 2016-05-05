package com.ravi.ezio.personeltodolist.Activities;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.ravi.ezio.personeltodolist.Backend.AlertReceiver;
import com.ravi.ezio.personeltodolist.Backend.CustomToDoType;
import com.ravi.ezio.personeltodolist.R;

import java.util.Calendar;

public class Start extends Activity {

    CustomToDoType customToDoType;
    int rowno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        rowno=getIntent().getIntExtra("ROWNO",-1);

    }
    private void setNotificationService() {

        long miliTime=1800000;  //30 minutes prior
        Intent intent=new Intent(this, AlertReceiver.class);
        intent.putExtra("ROWNO",rowno);
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,miliTime, PendingIntent.getBroadcast(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
