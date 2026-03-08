package com.kclm.owep.convert;

import com.kclm.owep.dto.ClassStuDTO;
import com.kclm.owep.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassStuConvert {

    @Mapping(target = "status", expression = "java(convertStatus(student.getStatus()))")
    ClassStuDTO toClassStuDTO(Student student);

    List<ClassStuDTO> toClassStuDTOS(List<Student> students);

    default String convertStatus(Integer status) {
        if (status == null) {
            return null;
        }
        return status == 1 ? "有效" : "无效";
    }
}
