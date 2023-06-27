package com.java.employee.service.service;

import com.java.employee.service.dto.EmployeeDto;
import com.java.employee.service.entity.Employee;
import com.java.employee.service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

       /* Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );*/

        Employee employee = modelMapper.map(employeeDto,Employee.class);


        Employee savedEmployee = employeeRepository.save(employee);

        //Employee JPA entity to Employee dto
        /*EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );*/

        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
         Employee employee = employeeRepository.findById(employeeId).get();
        /* EmployeeDto employeeDto = new EmployeeDto(
                 employee.getId(),
                 employee.getFirstName(),
                 employee.getLastName(),
                 employee.getEmail()
         );*/
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);
        return employeeDto;
    }
}
