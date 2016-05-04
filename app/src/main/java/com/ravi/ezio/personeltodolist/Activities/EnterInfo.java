package com.ravi.ezio.personeltodolist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.ravi.ezio.personeltodolist.Dialog.Datepicker;
import com.ravi.ezio.personeltodolist.Dialog.Timepicker;
import com.ravi.ezio.personeltodolist.R;


public class EnterInfo extends AppCompatActivity{

    private final int PLACE_PICKER=1;
    public static Button location,datePicker,timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);
        init();
        clickListeners();

    }

    private void clickListeners() {

        //FOR SELECTING LOCATION
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EnterInfo.this,"Select From NEARBY PLACES",Toast.LENGTH_SHORT).show();
                PlacePicker.IntentBuilder builder=new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(EnterInfo.this),PLACE_PICKER);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        //FOR SELECTING TIME
        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=new Timepicker();
                dialogFragment.show(getSupportFragmentManager(),"timepicker");
            }
        });

        //FOR SELECTING DATE
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=new Datepicker();
                dialogFragment.show(getSupportFragmentManager(),"datepicker");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==PLACE_PICKER)
        {

            if(resultCode==RESULT_OK)
            {
                Place place=PlacePicker.getPlace(this,data);
                location.setText(place.getName());
            }

        }

    }

    private void init() {
        location= (Button) findViewById(R.id.selectLocation);
        datePicker= (Button) findViewById(R.id.date);
        timePicker= (Button) findViewById(R.id.time);
    }


}
