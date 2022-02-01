package com.example.happli_welcomeexercice.Repository;

import com.example.happli_welcomeexercice.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeInterface {

    @GET("/users")
    Call<List<Employee>> getAllUsers();
    // préférable d'utiliser un DTO
}
