package com.example.felix_its.database.Activity.adapter;

import android.app.VoiceInteractor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.felix_its.database.Activity.DBhelper;
import com.example.felix_its.database.Activity.Employee;
import com.example.felix_its.database.R;

import java.util.List;
import java.util.zip.Inflater;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    List<Employee>employees;
    DBhelper dBhelper;
    public EmployeeListAdapter(List<Employee> employees, DBhelper dBhelper) {
        this.employees=employees;
        this.dBhelper = dBhelper;

    }

    @NonNull
    @Override
    //view banane ke liye
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee_list,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    //view pe data set karane ke liye
    public void onBindViewHolder(@NonNull EmployeeViewHolder  holder, int position) {
        final Employee employee=employees.get(position);
        holder.txtName.setText("Name :"+employee.getName());
        holder.txtAddress.setText("Address :"+employee.getAddress());
        holder.txtPhone.setText("Phone :"+employee.getPhone());
        holder.txtSalary.setText("Salary :"+employee.getSalary());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDeleted=dBhelper.deleteEmployee(employee.getId());
                if(isDeleted)
                {
                    employees.remove(employee);
                    notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    public int getItemCount() {

        return employees.size();
    }
}
