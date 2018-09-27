package com.example.felix_its.database.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.felix_its.database.Activity.DBhelper;
import com.example.felix_its.database.Activity.Employee;
import com.example.felix_its.database.Activity.adapter.EmployeeListAdapter;
import com.example.felix_its.database.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {
    RecyclerView rvUsers;


    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view, container, false);
        rvUsers=view.findViewById(R.id.rvUsers);

        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity()));

        DBhelper dBhelper=new DBhelper(getActivity());

        List<Employee>employees=dBhelper.getAllEmployee();

        EmployeeListAdapter adapter=new EmployeeListAdapter(employees, dBhelper);

        rvUsers.setAdapter(adapter);

        return view;
    }

}
