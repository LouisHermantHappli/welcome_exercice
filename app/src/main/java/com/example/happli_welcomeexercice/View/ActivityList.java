package com.example.happli_welcomeexercice.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.happli_welcomeexercice.Model.Employee;
import com.example.happli_welcomeexercice.R;
import com.example.happli_welcomeexercice.ViewModel.RecyclerAdapter;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    private ArrayList<Employee> employeesList;
    private RecyclerView recyclerView;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    public static final String BUNDLE_EMPLOYEE_NAME = "EMPLOYEE_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        employeesList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.rvEmployee);

        setEmployeeName();
        setAdapter();

    }

    private void setAdapter() {
        setOnClickListner();
        RecyclerAdapter adapter = new RecyclerAdapter(employeesList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListner() {
        listener = new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent();
                intent.putExtra(BUNDLE_EMPLOYEE_NAME, employeesList.get(position).getName());
                setResult(RESULT_OK, intent);
            }
        };
    }

    private void setEmployeeName() {
        employeesList.add(new Employee("John"));
        employeesList.add(new Employee("Lucas"));
        employeesList.add(new Employee("Joe"));
        employeesList.add(new Employee("Bob"));

    }

}