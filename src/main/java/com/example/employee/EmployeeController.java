/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.employee;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.*;
import com.example.employee.EmployeeService;

@RestController
class EmployeeController {
    EmployeeService service = new EmployeeService();

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployee() {
        return service.getEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee GetEmployee(@PathVariable("employeeId") int employeeId) {
        return service.GetEmployee(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emps) {
        return service.addEmployee(emps);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee emps) {
        return service.updateEmployee(employeeId, emps);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmp(@PathVariable("employeeId") int employeeId) {
        service.deleteEmp(employeeId);
    }
}