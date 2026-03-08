package com.kclm.owep.convert;

import com.kclm.owep.dto.StuClassDTO;
import com.kclm.owep.dto.StuManagementDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

/*******************
 * @Author zch
 * @Description
 */
@Mapper(componentModel = "spring")
public interface StuConvert {

    @Mapping(target = "gender", expression = "java(convertGender(student.getGender()))")
    @Mapping(source = "stuNumber", target = "stuNumber")
    @Mapping(source = "stuPwd", target = "stuPwd")
    @Mapping(source = "stuName", target = "stuName")
    @Mapping(source = "stuRealName", target = "stuRealName")
    @Mapping(source = "stuPhone", target = "stuPhone")
    @Mapping(source = "stuEmail", target = "stuEmail")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "lastAccessTime", target = "lastAccessTime")
    @Mapping(source = "stuSchool", target = "stuSchool")
    StuManagementDTO toStuManagementDTO(Student student);

    List<StuManagementDTO> toStuManagementDTO(List<Student> students);

    @Mapping(source = "id", target = "stuId")
    @Mapping(target = "classId", expression = "java(mapClassToId(stu.getClazz()))")
    @Mapping(target = "className", expression = "java(mapClassToName(stu.getClazz()))")
    StuClassDTO toStuClassDto(Student stu);

    default Integer mapClassToId(Clazz clazz) {
        //
        if(clazz != null) {
            //
            return clazz.getId();
        }
        return null;
    }

    default String mapClassToName(Clazz clazz) {
        //
        if(clazz != null) {
            //
            return clazz.getClassName();
        }
        return null;
    }

    default String convertGender(Integer gender) {
        if (gender == null) {
            return null;
        }
        return gender == 1 ? "男" : "女";
    }
}
