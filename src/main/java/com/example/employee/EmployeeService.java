/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.employee;

import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();
    int unique = 7;

    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    // Write your code here

    @Override
    public ArrayList<Employee> getEmployee() {
        Collection<Employee> employeeCollection = employeeList.values();
        ArrayList<Employee> employees = new ArrayList<>(employeeCollection);
        return employees;
    }

    @Override
    public Employee GetEmployee(int employeeId) {
        Employee EMP = employeeList.get(employeeId);
        if (EMP == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return EMP;
    }

    @Override
    public Employee addEmployee(Employee emps) {
        emps.setEmployeeId(unique);
        employeeList.put(unique, emps);
        unique += 1;
        return emps;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee emps) {
        Employee existing = employeeList.get(employeeId);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (emps.getEmployeeName() != null) {
            existing.setEmployeeName(emps.getEmployeeName());
        }
        if (emps.getEmail() != null) {
            existing.setEmail(emps.getEmail());
        }
        if (emps.getDepartment() != null) {
            existing.setDepartment(emps.getDepartment());
        }
        return existing;
    }

    @Override
    public void deleteEmp(int employeeId) {
        Employee delete = employeeList.get(employeeId);
        if (delete == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            employeeList.remove(employeeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
