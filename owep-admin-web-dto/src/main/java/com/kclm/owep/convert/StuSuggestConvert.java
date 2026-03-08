package com.kclm.owep.convert;

import com.kclm.owep.dto.StuSuggestDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Mapper(componentModel = "spring")
public interface StuSuggestConvert {

    @Mapping(source = "stuRealName", target = "stuRealName")
    @Mapping(source = "stuSchool", target = "stuSchool")
    @Mapping(source = "stuCollege", target = "stuCollege")
    List<StuSuggestDTO> toStuSuggestDTO(List<Student> students);
}
