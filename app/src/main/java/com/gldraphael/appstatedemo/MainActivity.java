package com.gldraphael.appstatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtDescription;
    private CheckBox cbxMilk;
    private CheckBox cbxLaundry;
    private CheckBox cbxBed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDescription = (EditText) findViewById(R.id.txtDescription);
        cbxMilk = (CheckBox) findViewById(R.id.cbxMilk);
        cbxLaundry = (CheckBox) findViewById(R.id.cbxLaundry);
        cbxBed = (CheckBox) findViewById(R.id.cbxBed);
    }
}
