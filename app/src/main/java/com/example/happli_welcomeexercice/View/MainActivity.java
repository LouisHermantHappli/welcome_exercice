package com.example.happli_welcomeexercice.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.happli_welcomeexercice.R;

public class MainActivity extends AppCompatActivity {

    private Button btnCheckIn;
    private Button btnCheckOut;
    private String employeeName;
    private TextView tvCheck;
    private static final int LIST_ACTIVITY_REQUEST_CODE = 42;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(LIST_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode){

            String name = intent.getExtras().getString(ActivityList.BUNDLE_EMPLOYEE_NAME, "/");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheckIn = (Button) findViewById(R.id.btnCheckIn);
        btnCheckOut = (Button) findViewById(R.id.btnCheckOut);
        tvCheck = (TextView) findViewById(R.id.tvCheck);

        btnCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ListIntent = new Intent(MainActivity.this, ActivityList.class);
                startActivityForResult(ListIntent, LIST_ACTIVITY_REQUEST_CODE);
                employeeName = getIntent().getExtras().getString("employee");
                tvCheck.setText(employeeName+" Check-in");
            }
        });

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ListIntent = new Intent(MainActivity.this, ActivityList.class);
                startActivityForResult(ListIntent, LIST_ACTIVITY_REQUEST_CODE);
                employeeName = getIntent().getExtras().getString("employee");
                tvCheck.setText(employeeName+" Check-out");
            }
        });

    }
}