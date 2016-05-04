package com.ravi.ezio.personeltodolist.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ravi.ezio.personeltodolist.Backend.CustomToDoType;
import com.ravi.ezio.personeltodolist.Backend.DatabaseHelper;
import com.ravi.ezio.personeltodolist.Backend.MyRecyclerView;
import com.ravi.ezio.personeltodolist.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView emptyDatabaseNotice;
    RecyclerView recyclerView;
    MyRecyclerView recyclerAdapter;
    List<CustomToDoType> list;
    DatabaseHelper databaseHelper;
    private FloatingActionButton addToDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //searching for data in database
        MyAsync async=new MyAsync(this,databaseHelper);
        async.execute();



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
        databaseHelper=new DatabaseHelper(this);
        list=new ArrayList<CustomToDoType>();
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emptyDatabaseNotice= (TextView) findViewById(R.id.emptyDatabase);
    }

    private class MyAsync extends AsyncTask<Void,Void,Void>
    {
        DatabaseHelper databaseHelper;
        Context context;
        ProgressDialog progressDialog;
        public MyAsync(Context context, DatabaseHelper databaseHelper)
        {
            this.context=context;
            progressDialog=new ProgressDialog(context);
            this.databaseHelper=databaseHelper;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            list= databaseHelper.getAllToDo();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            if(list.isEmpty())
            {
                recyclerView.setVisibility(View.GONE);
                emptyDatabaseNotice.setVisibility(View.VISIBLE);
            }
            else
            {
                recyclerView.setVisibility(View.VISIBLE);
                emptyDatabaseNotice.setVisibility(View.GONE);
                recyclerAdapter=new MyRecyclerView(context,list);
                recyclerView.setAdapter(recyclerAdapter);
            }
        }
    }
}
