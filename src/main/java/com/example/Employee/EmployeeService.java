package com.example.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    // Create operation
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    // Read operations
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    // Update operation
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setPosition(employeeDetails.getPosition());
            employee.setDepartment(employeeDetails.getDepartment());
            return employeeRepository.save(employee);
        }
        return null;
    }
    
    // Delete operation
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
