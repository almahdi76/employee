package com.almahdi.jdbcours.dao;
import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private boolean gendre;
    private Date birthDay;
    private double salary;

    public Employee() {
    }

    public Employee(int i, String nom, boolean b, Date date, double v) {
        this.id=i;
        this.name=nom;
        this.gendre=b;
        this.birthDay=date;this.salary=v;
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

    public boolean isGendre() {
        return gendre;
    }

    public void setGendre(boolean gendre) {
        this.gendre = gendre;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gendre=" + gendre +
                ", birthDay=" + birthDay +
                ", salary=" + salary +
                '}';
    }
}
