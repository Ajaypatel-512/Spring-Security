package com.practise.SpringSecurity.Service;

import com.practise.SpringSecurity.CustomemException.BusinessException;
import com.practise.SpringSecurity.CustomemException.EmptyInputException;
import com.practise.SpringSecurity.Entity.Employee;
import com.practise.SpringSecurity.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> all = null;
        try {
            all = employeeRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException("605", "Something went wrong while fetching employees: " + e.getMessage());
        }
        if (all.isEmpty()) {
            throw new BusinessException("604", "No employees found");
        }
        return all;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getName().isEmpty() || employee.getName().length() == 0) {
                throw new EmptyInputException("601", "Name is not present");
            }
        try {
            Employee result = employeeRepository.save(employee);
            return result;
        } catch (IllegalArgumentException e) {
            throw new BusinessException("602", "Employee is empty " + e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("603", "Something went wrong while saving employee: " + e.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
            return employeeRepository.findById(id).get();
//        } catch (IllegalArgumentException e) {
//            throw new BusinessException("607", "Given employee id is not present " + e.getMessage());
//        } catch (NoSuchElementException e) {
//            throw new NoSuchElementException("608", e);
//        } catch (Exception e) {
//            throw new BusinessException("609", "Something went wrong while fetching employee by id: " + e.getMessage());
//        }
    }

    @Override
    public void deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new BusinessException("610", "Given employee id is not present " + e.getMessage());
        } catch (NoSuchElementException e) {
            throw new BusinessException("611", "No employee found with id: " + id);
        } catch (Exception e) {
            throw new BusinessException("612", "Something went wrong while deleting employee: " + e.getMessage());
        }
    }
}
