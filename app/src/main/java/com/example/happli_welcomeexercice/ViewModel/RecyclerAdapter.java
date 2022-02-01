package com.example.happli_welcomeexercice.ViewModel;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happli_welcomeexercice.Model.Employee;
import com.example.happli_welcomeexercice.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Employee> employeesList;
    private RecyclerViewClickListener listener;

    public RecyclerAdapter(ArrayList<Employee> employeesList, RecyclerViewClickListener listener){
        this.employeesList = employeesList;
        this.listener = listener;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTxt;

        public MyViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.tvName);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String name = employeesList.get(position).getName();
        holder.nameTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
