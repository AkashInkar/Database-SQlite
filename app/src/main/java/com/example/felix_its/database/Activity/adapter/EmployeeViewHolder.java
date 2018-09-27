package com.example.felix_its.database.Activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felix_its.database.R;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    TextView txtName,txtAddress,txtPhone,txtSalary ;
    ImageView imgDelete;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);

        txtName=itemView.findViewById(R.id.txtName);
        txtAddress=itemView.findViewById(R.id.txtAddress);
        txtPhone=itemView.findViewById(R.id.txtPhone);
        txtSalary=itemView.findViewById(R.id.txtSalary);
        imgDelete=itemView.findViewById(R.id.imgDelete);
    }
}
