package com.thepreksha;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    private static Statement statement = null;
    private Connection conn;

    public EmployeeDaoImpl() throws SQLException, ClassNotFoundException {
        conn = ConnectionFactory.getConnection();
        statement = conn.createStatement();
    }

    @Override
    public void addEmployee(Employee employee) {
String sql = "insert into jdbcconn.employee values("+employee.getEmpId()+",'"+employee.getName()+"','"+employee.getEmail()+"')";
int count = 0;
try {
	count = statement.executeUpdate(sql);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if(count>0){
	System.out.println("Employee saved");
}else{
	System.out.println("Not completed");
}

    }
    @Override
    public void updateEmployee(Employee employee) {
    	String sql = "update jdbcconn.employee set name='"+employee.getName()+"',email='"+employee.getEmail()+"' where EmpId="+employee.getEmpId();
    	int count = 0;
    	try {
			count = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("employee data updated");
    	}else{
    		System.out.println("not completed");
    	}

    }

    @Override
    public void deleteEmployee(int id) {
    	String sql = "delete from jdbcconn.employee  where empId =" +id;
    	int count = 0;
    	try {
			count = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("employee data deleted");
    	}else{
    		System.out.println("not completed");
    	}
    }

    @Override
    public Employee getEmployeeById(int id) {
    	Employee employee = null;
        String sql = "select * from employee where id = "+id;
        ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			if(rs.next()){
			    int empId = rs.getInt("id");
			    String name = rs.getString("name");
			    String email = rs.getString("email");
			    employee = new Employee(empId, name, email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return employee;
    	
       
    }

    @Override
    public List<Employee> getEmployees() {
    	List<Employee> list = new ArrayList<>();
    	String sql = "select * from jdbcconn.employee";
    	ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			while(rs.next()){
				int id = rs.getInt("EmpId");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Employee employee = new Employee(id,name,email);
				list.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
    }

	@Override
	public void deleteEmployee1(int id) {
		// TODO Auto-generated method stub
		
	}
}
