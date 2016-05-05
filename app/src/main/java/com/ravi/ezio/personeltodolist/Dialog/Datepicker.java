package com.ravi.ezio.personeltodolist.Dialog;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.widget.DatePicker;

import com.ravi.ezio.personeltodolist.Activities.EnterInfo;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Datepicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {




    public Datepicker() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar=Calendar.getInstance();

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);


        return new DatePickerDialog(getActivity(),this ,year,month,date);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        EnterInfo.datePicker.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
        EnterInfo.selectDate=1;
        EnterInfo.date=dayOfMonth;
        EnterInfo.month=monthOfYear;
        EnterInfo.year=year;
    }
}
