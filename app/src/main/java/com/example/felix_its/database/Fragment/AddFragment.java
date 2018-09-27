package com.example.felix_its.database.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class AddFragment extends Fragment {
    EditText etdname,etdadd,etdphone,etdsal;
    Button btnsave;


    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add, container, false);
        etdname=view.findViewById(R.id.etdname);
        etdadd=view.findViewById(R.id.etdadd);
        etdphone=view.findViewById(R.id.etdphone);
        etdsal=view.findViewById(R.id.etdsal);
        btnsave=view.findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etdname.getText().toString().trim();
                String phone=etdphone.getText().toString().trim();
                String address=etdadd.getText().toString().trim();
                String salaryS=etdsal.getText().toString().trim();
               int salary=Integer.parseInt(salaryS);


                Employee employee=new Employee(name, address, phone, salary);
                DBhelper dBhelper= new DBhelper(getActivity());
                boolean isAdded=dBhelper.addEmployee(employee);
                if (isAdded)
                { Toast.makeText(getActivity(),"Record added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view ;
    }

}
