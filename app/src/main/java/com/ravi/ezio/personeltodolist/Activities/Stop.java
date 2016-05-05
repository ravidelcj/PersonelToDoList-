package com.ravi.ezio.personeltodolist.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.ravi.ezio.personeltodolist.Backend.DatabaseHelper;
import com.ravi.ezio.personeltodolist.R;

public class Stop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);
        DatabaseHelper db=new DatabaseHelper(this);
        long row=getIntent().getIntExtra("ROWNO",-1);
        if(row==-1)
            Toast.makeText(this,"Error Occured!!",Toast.LENGTH_SHORT).show();
        else
        {
            db.deleteARecord(row);
            Toast.makeText(this,"To Do Deleted!",Toast.LENGTH_SHORT).show();
        }
    }
}
