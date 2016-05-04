package com.ravi.ezio.personeltodolist.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ravi.ezio.personeltodolist.Backend.CustomToDoType;
import com.ravi.ezio.personeltodolist.Backend.MyRecyclerView;
import com.ravi.ezio.personeltodolist.R;

public class Show extends Activity {

    CustomToDoType custom;
    TextView title,detail;
    Button time,date,location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();
        Bundle bundle=getIntent().getBundleExtra(MyRecyclerView.CUSTOM_OBJECT_KEY);
        custom= (CustomToDoType) bundle.getSerializable(MyRecyclerView.CUSTOM_OBJECT_KEY);
        //Setting details of the todo
        setData();
    }
    //method to set details of a todo
    private void setData() {
        time.setText(custom.time);
        date.setText(custom.date);
        location.setText(custom.location);
        title.setText(custom.title);
        detail.setText(custom.detail);
    }

    private void init() {
        title= (TextView) findViewById(R.id.tittle_show);
        detail= (TextView) findViewById(R.id.detail_show);
        time= (Button) findViewById(R.id.time_show);
        date= (Button) findViewById(R.id.date_show);
        location= (Button) findViewById(R.id.selectLocation_show);
    }
}
