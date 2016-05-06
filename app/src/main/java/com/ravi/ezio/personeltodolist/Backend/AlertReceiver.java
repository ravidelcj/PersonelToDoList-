package com.ravi.ezio.personeltodolist.Backend;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.ravi.ezio.personeltodolist.Activities.Start;
import com.ravi.ezio.personeltodolist.Activities.Stop;

/**
 * Created by ezio on 5/5/16.
 */
public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        int rowno=intent.getIntExtra("ROW",-1);
        String title=intent.getStringExtra("TITLE");
        NotificationCompat.Builder mBuilder;
        Intent stop=new Intent(context,Stop.class);
        stop.putExtra("ROWNO",rowno);

        PendingIntent stopIntent=PendingIntent.getBroadcast(context,0,stop,0);

        Intent snooze=new Intent(context,Start.class);
        snooze.putExtra("ROWNO",rowno);
        snooze.putExtra("TITLE",title);
        PendingIntent snoozeIntent=PendingIntent.getBroadcast(context,1,snooze,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder=new NotificationCompat.Builder(context).setContentTitle(title).setTicker("Reminder").addAction(android.R.drawable.alert_dark_frame,"STOP",stopIntent).addAction(android.R.drawable.ic_lock_idle_alarm,"SNOOZE",snoozeIntent);
        mBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        NotificationManager manager= (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.notify(1,mBuilder.build());
        //Toast.makeText(context,"Toast set",Toast.LENGTH_SHORT).show();
    }
}
