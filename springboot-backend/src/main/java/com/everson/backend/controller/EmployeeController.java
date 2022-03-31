package com.everson.backend.controller;

import com.everson.backend.exception.ResourceNotFoundException;
import com.everson.backend.model.Employee;
import com.everson.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Get All employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //Create employee - REST API
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


    //GET employee By Id - REST API
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        return ResponseEntity.ok(employee);
    }

    //UPDATE employee - REST API
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    //DELETE employee - REST API
    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }



}
