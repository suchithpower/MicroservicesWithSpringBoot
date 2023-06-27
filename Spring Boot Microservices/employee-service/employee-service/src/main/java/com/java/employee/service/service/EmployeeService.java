package com.java.employee.service.service;

import com.java.employee.service.EmployeeServiceApplication;
import com.java.employee.service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
