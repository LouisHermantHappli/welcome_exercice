package com.example.happli_welcomeexercice.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.happli_welcomeexercice.Model.Employee;
import com.example.happli_welcomeexercice.R;
import com.example.happli_welcomeexercice.Repository.EmployeeAccess;
import com.example.happli_welcomeexercice.Repository.EmployeeInterface;
import com.example.happli_welcomeexercice.ViewModel.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        Log.d("Tab", "Garni tableau");
        setEmployeeName();
        Log.d("Adapter", "dans l'adapter");
        setAdapter();

        Log.d("END", "Fini");
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
                finish();
            }
        };
    }

    private void setEmployeeName() {

        EmployeeInterface api = EmployeeAccess.employeeAccess();
        Log.d("test", "ok");
        api.getAllUsers().enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {

                for(int i = 0; i < response.body().size(); i++){
                    employeesList.add(new Employee(response.body().get(i).getName()));
                    Log.d("ADD", response.body().get(i).getName());
                }
                Log.i("Employe", "List created");
                for(int i =0; i<employeesList.size();i++)
                    Log.d("TAB", employeesList.get(i).getName());
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.i("No","Error");
            }
        });

//        employeesList.add(new Employee("John"));
//        employeesList.add(new Employee("Lucas"));
//        employeesList.add(new Employee("Joe"));
//        employeesList.add(new Employee("Bob"));

    }

}