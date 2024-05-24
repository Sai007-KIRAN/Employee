// Write your code here

package com.example.employee;

import java.util.*;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployee();

    Employee GetEmployee(int employeeId);

    Employee addEmployee(Employee emps);

    Employee updateEmployee(int employeeId, Employee emps);

    void deleteEmp(int employeeId);
}