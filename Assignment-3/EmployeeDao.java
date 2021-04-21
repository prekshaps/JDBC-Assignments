package com.thepreksha;


import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee1(int id);
    Employee getEmployeeById(int empId);
    List<Employee> getEmployees();
	void deleteEmployee(int id);
}
