package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    RadioGroup radiogrp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        radiogrp = findViewById(R.id.radiogrp1);
        Button btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectid = radiogrp.getCheckedRadioButtonId ();
                if(selectid==R.id.Radiob1)
                {
                    int gender = 1; // id =1 for male
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    i.putExtra("gender",1);
                    startActivity(i);
                    finish();
                }
                else if(selectid==R.id.Radiob2)
                {
                    int gender = 2;
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    i.putExtra("gender",2);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please select an option to proceed", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
