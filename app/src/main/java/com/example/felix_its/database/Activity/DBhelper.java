package com.example.felix_its.database.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    private static final  String DB_NAME = "employee.sqlite";
    private static final int DB_VERSION = 1;


    private static final String EMP_TABLE = "employee";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String SALARY = "salary";



    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table "+EMP_TABLE + "( "+ID+" integer primary key autoincrement, "
                +NAME + " text, "+ADDRESS + " text, "+ PHONE + " text, "+SALARY + " integer )";

        Log.e("DBQuery","========"+query);
        sqLiteDatabase.execSQL(query);
    }




    //Add Employee
    public boolean addEmployee(Employee employee)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,employee.getName());
        values.put(ADDRESS,employee.getAddress());
        values.put(PHONE,employee.getPhone());
        values.put(SALARY,employee.getSalary());

        long no = db.insert(EMP_TABLE,null,values);
        db.close();
        if (no==0)
        {
            return false;
        }
        else
        {
            return  true;
        }
    }
    //update employee method (update and add are same just copy and paste ... in long copy from delete clause and paste)
    public boolean updateEmployee(Employee employee,int id)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,employee.getName());
        values.put(ADDRESS,employee.getAddress());
        values.put(PHONE,employee.getPhone());
        values.put(SALARY,employee.getSalary());

        long no = db.update(EMP_TABLE,values,ID + " = "+ id, null);
        db.close();
        if (no==0)
        {
            return false;
        }
        else
        {
            return  true;
        }
    }

    //view method
    public List<Employee>getAllEmployee()
    {

        List<Employee>employees=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String query = "Select * from "+EMP_TABLE;

        Cursor cursor =db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do {
                String name =cursor.getString(cursor.getColumnIndex(NAME));
                String address =cursor.getString(cursor.getColumnIndex(ADDRESS));
                String phone =cursor.getString(cursor.getColumnIndex(PHONE));
                int id =cursor.getInt(cursor.getColumnIndex(ID));
                int salary =cursor.getInt(cursor.getColumnIndex(SALARY));
                Employee employee=new Employee(name, address, phone, salary);
                employee.setId(id);
                employees.add(employee);

            }while ((cursor.moveToNext()));

        }
            if (cursor!=null && !cursor.isClosed()){
            cursor.close();
    }
             db.close();
        return employees;
        }

        //Delete Data method
        public boolean deleteEmployee(int id)
        {
            SQLiteDatabase database=getWritableDatabase();
            long deletedRow=database.delete(EMP_TABLE, ID + " = "+ id, null);
            if(deletedRow >0)
            {
                return true;
            }
            else {
                return false;
            }
        }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Method for Search
    public Employee getEmployee(String name)
    {
        Employee employee=null;
        SQLiteDatabase db=getReadableDatabase();
        String query = "select * from "+EMP_TABLE+ " where "+NAME+ " = '"+name+ "'";
        //check in logcat{e means ckeck in error}
        Log.e("check Query","#############"+query);

        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            int id=cursor.getInt(cursor.getColumnIndex(ID));
            String address =cursor.getString(cursor.getColumnIndex(ADDRESS));
            String phone =cursor.getString(cursor.getColumnIndex(PHONE));
            int salary =cursor.getInt(cursor.getColumnIndex(SALARY));
            employee=new Employee(name, address, phone, salary);
            employee.setId(id);
        }
        return employee;
    }
}
