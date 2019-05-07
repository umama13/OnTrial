package com.example.ontrial;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Profile extends AppCompatActivity {
    EditText dob;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        dob=(EditText) findViewById(R.id.dob);
        dob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                c= Calendar.getInstance();
                final int date=c.get(Calendar.DAY_OF_MONTH);
                final int month=c.get(Calendar.MONTH);
                final int year=c.get(Calendar.YEAR);

                dpd=new DatePickerDialog(Profile.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dob.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    } }, date, month, year);
                dpd.show();

            }
        });
    }
}
