package com.example.happli_welcomeexercice.View;

import static com.example.happli_welcomeexercice.View.ActivityList.BUNDLE_EMPLOYEE_NAME;

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
    private TextView tvCheck;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(RESULT_OK == resultCode){
            String name = intent.getStringExtra(BUNDLE_EMPLOYEE_NAME);
            if(requestCode == 0)
                tvCheck.setText(name+" Check-in");
            if(requestCode == 1)
                tvCheck.setText(name+" Check-out");
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
                startActivityForResult(ListIntent, 0);

            }
        });

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ListIntent = new Intent(MainActivity.this, ActivityList.class);
                startActivityForResult(ListIntent, 1);
            }
        });

    }
}