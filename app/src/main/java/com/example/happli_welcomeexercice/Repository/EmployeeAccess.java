package com.example.happli_welcomeexercice.Repository;

import android.content.Context;

import java.net.URI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeAccess {
    private static final String URL = "https://jsonplaceholder.typicode.com/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static EmployeeInterface api;

    public static EmployeeInterface employeeAccess(){
        if(api == null)
            api = retrofit.create(EmployeeInterface.class);
        return api;
    }
}
