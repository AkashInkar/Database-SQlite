package com.example.felix_its.database.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.felix_its.database.Activity.DBhelper;
import com.example.felix_its.database.Activity.Employee;
import com.example.felix_its.database.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
    EditText edtName,edtAddress,edtPhone,edtSalary;
    Button btnSearch,btnUpdate;
    int id=-1;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_update, container, false);
        btnSearch=view.findViewById(R.id.btnSearch);
        btnUpdate=view.findViewById(R.id.btnUpdate);


        edtName=view.findViewById(R.id.edtName);
        edtAddress=view.findViewById(R.id.edtAddress);
        edtPhone=view.findViewById(R.id.edtPhone);
        edtSalary=view.findViewById(R.id.edtSalary);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtName.getText().toString().trim();

                if (TextUtils.isEmpty(name))
                {
                    Toast.makeText(getActivity(),"Please Enter The name to Search",Toast.LENGTH_SHORT).show();
                    return;
                }

                //Create dbHelper Object
                DBhelper dBhelper=new DBhelper(getActivity());
                Employee employee=dBhelper.getEmployee(name);

                if (employee==null)
                {
                    Toast.makeText(getActivity(),"Employee Not Found",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    edtAddress.setText(employee.getAddress());
                    edtPhone.setText(employee.getPhone());
                    edtSalary.setText(String.valueOf(employee.getSalary()));
                    id=employee.getId();
                }

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtName.getText().toString().trim();
                String address=edtAddress.getText().toString().trim();
                String phone=edtPhone.getText().toString().trim();
                String salString=edtSalary.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(address)||TextUtils.isEmpty(phone)||TextUtils.isEmpty(salString)) {
                    Toast.makeText(getActivity(), "Enter All required Field", Toast.LENGTH_SHORT).show();

                }
                int salary=Integer.parseInt(salString);
                Employee employee=new Employee(name,address,phone,salary);
                DBhelper dBhelper=new DBhelper(getActivity());
                boolean isUpdated =dBhelper.updateEmployee(employee,id);
                if (isUpdated)
                {
                    Toast.makeText(getActivity(), "Updated Successfully", Toast.LENGTH_SHORT).show();

                }

            }
        });
        return view;
    }

}



