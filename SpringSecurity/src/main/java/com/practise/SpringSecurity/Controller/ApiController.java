package com.practise.SpringSecurity.Controller;

import com.practise.SpringSecurity.CustomemException.BusinessException;
import com.practise.SpringSecurity.CustomemException.ControllerException;
import com.practise.SpringSecurity.Entity.Employee;
import com.practise.SpringSecurity.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private EmployeeService employeeService;

//    @PostMapping("/save")
//    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
//        try {
//            Employee response = employeeService.saveEmployee(employee);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } catch (BusinessException e) {
//            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/employees")
//    public ResponseEntity<?> getAllEmployees() {
//        try {
//            List<Employee> allEmployees = employeeService.getAllEmployees();
//            return new ResponseEntity<>(allEmployees, HttpStatus.OK);
//        } catch (BusinessException e) {
//            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/employee/{id}")
//    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id){
//        try {
//        Employee employee = employeeService.getEmployeeById(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//        } catch (BusinessException e) {
//            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/employee/{id}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
//        try {
//           employeeService.deleteEmployee(id);
//           return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        } catch (BusinessException e) {
//            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
//        try {
//            Employee response = employeeService.saveEmployee(employee);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } catch (BusinessException e) {
//            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
//            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
//        }
//    }


    // Global Exception Handling

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        Employee response = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees() {
        try {
            List<Employee> allEmployees = employeeService.getAllEmployees();
            return new ResponseEntity<>(allEmployees, HttpStatus.OK);
        } catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            Employee response = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ControllerException ce = new ControllerException("611", "Something went wrong while saving employee: " + e.getMessage());
            return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
        }
    }



}
