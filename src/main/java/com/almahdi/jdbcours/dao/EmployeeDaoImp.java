package com.almahdi.jdbcours.dao;

import com.almahdi.jdbcours.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM employee;";
        List<Employee> ListEmployees = new LinkedList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("gendre"),
                        resultSet.getDate("birth_date"),
                        resultSet.getDouble("salary"));
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ListEmployees;
    }


    @Override
    public Employee findById(int id) {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return null;
        }
        String query = "SELECT * FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee empl = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("gendre"),
                        resultSet.getDate("birth_date"),
                        resultSet.getDouble("salary"));
                return empl;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public void save(Employee employee) { // isert || update
        Connection con = DBconnection.getConnection();
        if(con==null){
            return;
        }else{
            if(employee.getId()>0){ //update
                String query="UPDATE  employee SET name=?, gendre=?, birth_date=?, salary=? WHERE id=?;";
                // String query="INSERT INTO emps(id_e,nom,prenom) VALUES (?,?,?);";
                try(PreparedStatement preparedStatement=con.prepareStatement(query)) {
                    //  PreparedStatement preparedStatement=con.prepareStatement(query); pour bien closed
                    //preparedStatement.setInt(1,employ.getId());
                    preparedStatement.setString(1, employee.getName());
                    preparedStatement.setBoolean(2, employee.isGendre());
                    preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthDay()));
                    preparedStatement.setDouble(4, employee.getSalary());

                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }else{
                //String query="UPDATE  employee SET name=?, gendre=?, birth_date=?, salary=? WHERE id=?;";
                String query="INSERT INTO employee(name,gendre,birth_date,salary) VALUES (?,?,?,?);";
                // String query="INSERT INTO emps(id_e,nom,prenom) VALUES (?,?,?);";
                try(PreparedStatement preparedStatement=con.prepareStatement(query)) {
                    //  PreparedStatement preparedStatement=con.prepareStatement(query); pour bien closed
                    //preparedStatement.setInt(1,employ.getId());
                    preparedStatement.setString(1, employee.getName());
                    preparedStatement.setBoolean(2, employee.isGendre());
                    preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthDay()));
                    preparedStatement.setDouble(4, employee.getSalary());

                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
    @Override
    public void deleteById(int id) {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return;
        }
        String query = "DELETE  FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return;
    }
}
