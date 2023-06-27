package com.java.departmentservice.service;

import com.java.departmentservice.dto.DepartmentDto;
import com.java.departmentservice.entity.Department;
import com.java.departmentservice.mapper.AutoDepartmentMapper;
import com.java.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department dto to department jpa entity
       /* Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );*/
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);


        Department savedDepartment = departmentRepository.save(department);
        /*DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );*/
        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        /*DepartmentDto dto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
                );*/
        DepartmentDto dto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);


        return dto;
    }
}
