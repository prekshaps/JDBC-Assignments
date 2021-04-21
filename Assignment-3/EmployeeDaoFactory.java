package com.thepreksha;


import java.sql.SQLException;

public class EmployeeDaoFactory {

    private static EmployeeDao dao;

    public static EmployeeDao getEmployeeDao() throws SQLException, ClassNotFoundException {
        if(dao==null){
            dao = new EmployeeDaoImpl();
        }
        return dao;
    }
}
