package com.almahdi.jdbcours;


import com.almahdi.jdbcours.dao.Employee;
import com.almahdi.jdbcours.dao.EmployeeDao;
import com.almahdi.jdbcours.dao.EmployeeDaoImp;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        EmployeeDao  emp=new EmployeeDaoImp();
        Employee employee=new Employee(0,"alaa",true, new Date(),3000.0);
       emp.save(employee);

    }
}
