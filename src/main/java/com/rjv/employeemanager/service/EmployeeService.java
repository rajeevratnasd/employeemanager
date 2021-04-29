package com.rjv.employeemanager.service;

import java.util.List;
import java.util.UUID;

import com.rjv.employeemanager.exception.UserNotFoundException;
import com.rjv.employeemanager.model.Employee;
import com.rjv.employeemanager.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee emp){
        emp.setEmployeeNumber(UUID.randomUUID().toString());
        return employeeRepo.save(emp);
    }   

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee emp){
        return employeeRepo.save(emp);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found" ));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
