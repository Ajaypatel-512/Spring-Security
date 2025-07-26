package com.practise.SpringSecurity.Service;

import com.practise.SpringSecurity.Entity.Employee;
import java.util.List;

public interface EmployeeService{
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);
}
