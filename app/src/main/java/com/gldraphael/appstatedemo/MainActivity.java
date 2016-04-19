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

        AppState.getInstance().restore(this); // Make sure this is called when the app is started,
                                              // before you access the AppState fields

        txtDescription.setText(AppState.getInstance().description);
        cbxMilk.setChecked(AppState.getInstance().milk);
        cbxLaundry.setChecked(AppState.getInstance().laundry);
        cbxBed.setChecked(AppState.getInstance().bed);
    }

    @Override
    protected void onPause() {
        super.onPause();

        AppState.getInstance().description = txtDescription.getText().toString();
        AppState.getInstance().milk = cbxMilk.isChecked();
        AppState.getInstance().laundry = cbxLaundry.isChecked();
        AppState.getInstance().bed = cbxBed.isChecked();

        AppState.getInstance().commit(getApplicationContext());
    }
}
