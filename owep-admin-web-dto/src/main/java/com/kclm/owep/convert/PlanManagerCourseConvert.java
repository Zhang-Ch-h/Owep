package com.kclm.owep.convert;

import com.kclm.owep.dto.PlanManagerCourseDTO;
import com.kclm.owep.entity.PlanManagerCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanManagerCourseConvert {
    PlanManagerCourseConvert INSTANCE = Mappers.getMapper(PlanManagerCourseConvert.class);
    //yao
    @Mapping(target = "planNumber",source = "planManager.planNumber")
    @Mapping(target = "courseName",source = "course.courseName")
    @Mapping(target = "stageNum",source = "stageNum")
    @Mapping(target = "stageName",source = "stageName")
    @Mapping(target = "courseOrder",source = "courseOrder")
    PlanManagerCourseDTO entityToDTO_yjj(PlanManagerCourse planManagerCourse);

    //tian
    @Mapping(target = "courseDTO.id",source = "course.id")
    @Mapping(target = "courseDTO.courseNumber",source = "course.courseNumber")
    @Mapping(target = "courseDTO.courseName",source = "course.courseName")
    @Mapping(target = "courseDTO.startTime",source = "course.startTime")
    @Mapping(target = "courseDTO.endTime",source = "course.endTime")
    @Mapping(target = "courseDTO.coursePeriod",source = "course.coursePeriod")
    @Mapping(target = "courseDTO.courseStatus",source = "course.courseStatus")
    @Mapping(target = "courseDTO.courseImage",source = "course.courseImage")
    @Mapping(target = "courseDTO.courseDesc",source = "course.courseDesc")
        //@Mapping(target = "courseDTO",source = "course")
    PlanManagerCourseDTO entityToDTO(PlanManagerCourse entity);


    @Mapping(target = "planManager.planNumber",source = "planNumber")
    @Mapping(target = "course.courseName",source = "courseName")
    @Mapping(target = "stageNum",source = "stageNum")
    @Mapping(target = "stageName",source = "stageName")
    @Mapping(target = "courseOrder",source = "courseOrder")
    PlanManagerCourse updateEntityFromDto(PlanManagerCourseDTO peopleDTO);

    @Mapping(target = "course.id",source = "courseDTO.id")
    @Mapping(target = "course.courseNumber",source = "courseDTO.courseNumber")
    @Mapping(target = "course.courseName",source = "courseDTO.courseName")
    @Mapping(target = "course.startTime",source = "courseDTO.startTime")
    @Mapping(target = "course.endTime",source = "courseDTO.endTime")
    @Mapping(target = "course.coursePeriod",source = "courseDTO.coursePeriod")
    @Mapping(target = "course.courseStatus",source = "courseDTO.courseStatus")
    @Mapping(target = "course.courseImage",source = "courseDTO.courseImage")
    @Mapping(target = "course.courseDesc",source = "courseDTO.courseDesc")
    //@Mapping(target = "course",source = "courseDTO")
    void updateEntityFromDto(PlanManagerCourseDTO planManagerCourseDTO, @MappingTarget PlanManagerCourse planManagerCourse);
}
