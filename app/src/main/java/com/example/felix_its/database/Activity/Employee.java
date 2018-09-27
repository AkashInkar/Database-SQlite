package com.example.felix_its.database.Activity;

public class Employee {
    private int id;
    private  String name;
    private  String  address;
    private  String phone;
    private int salary;

    public Employee(String name, String address, String phone, int salary) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
