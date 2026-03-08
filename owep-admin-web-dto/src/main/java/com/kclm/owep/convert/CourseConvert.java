package com.kclm.owep.convert;

import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-26 16:32
 * @description  此类用于 Resource 转 ResourceDTO 的转换
 */

@Mapper
public interface CourseConvert {

    CourseConvert INSTANCE = Mappers.getMapper(CourseConvert.class);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "courseNumber", source = "courseNumber")
    @Mapping(target = "courseName", source = "courseName")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    @Mapping(target = "coursePeriod", source = "coursePeriod")
    @Mapping(target = "courseStatus", source = "courseStatus")
    @Mapping(target = "courseImage", source = "courseImage")
    @Mapping(target = "courseDesc", source = "courseDesc")
    CourseDTO PO2DTO(Course course);

    List<CourseDTO> POs2DTOs(List<Course> courses);




    @Mapping(target = "id", source = "id")
    @Mapping(target = "courseNumber", source = "courseNumber")
    @Mapping(target = "courseName", source = "courseName")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    @Mapping(target = "coursePeriod", source = "coursePeriod")
    @Mapping(target = "courseStatus", source = "courseStatus")
    @Mapping(target = "courseImage", source = "courseImage")
    @Mapping(target = "courseDesc", source = "courseDesc")
    Course updatePOFromDTO(CourseDTO courseDTO);
    List<Course> updatePOsFromDTOs(List<CourseDTO> courseDTOS);


}
