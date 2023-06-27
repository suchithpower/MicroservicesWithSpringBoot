package com.java.departmentservice.mapper;

import com.java.departmentservice.dto.DepartmentDto;
import com.java.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);
    @Mapping(source = "departmentCode", target = "departmentCode") //Consider departmentCode field name is different in both Department and DepartmentDto.
    DepartmentDto mapToDepartmentDto(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);
}
