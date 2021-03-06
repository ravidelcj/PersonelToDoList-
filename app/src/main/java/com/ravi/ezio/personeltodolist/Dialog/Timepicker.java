package com.ravi.ezio.personeltodolist.Dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import android.widget.TimePicker;

import com.ravi.ezio.personeltodolist.Activities.EnterInfo;

import android.text.format.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Timepicker extends DialogFragment implements android.app.TimePickerDialog.OnTimeSetListener{


    public Timepicker() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Adding Default Time
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minutes=calendar.get(Calendar.MINUTE);


        return new android.app.TimePickerDialog(getActivity(), this, hour, minutes,
                DateFormat.is24HourFormat(getActivity()));

    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        EnterInfo.timePicker.setText(hourOfDay+" : "+minute);
        EnterInfo.selectTime=1;
        EnterInfo.hour=hourOfDay;
        EnterInfo.minute=minute;
    }
}
