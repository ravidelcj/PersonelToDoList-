package com.ravi.ezio.personeltodolist.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ravi.ezio.personeltodolist.R;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addToDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        addToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EnterInfo.class));
            }
        });


    }

    //Initialising various parameters
    private void init() {
        addToDo= (FloatingActionButton) findViewById(R.id.add);

    }
}