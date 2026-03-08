package com.kclm.owep.convert;

import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.entity.Course;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class CourseConvertImpl implements CourseConvert {

    @Override
    public CourseDTO PO2DTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setId( course.getId() );
        courseDTO.setCourseNumber( course.getCourseNumber() );
        courseDTO.setCourseName( course.getCourseName() );
        courseDTO.setStartTime( course.getStartTime() );
        courseDTO.setEndTime( course.getEndTime() );
        courseDTO.setCoursePeriod( course.getCoursePeriod() );
        courseDTO.setCourseStatus( course.getCourseStatus() );
        courseDTO.setCourseImage( course.getCourseImage() );
        courseDTO.setCourseDesc( course.getCourseDesc() );

        return courseDTO;
    }

    @Override
    public List<CourseDTO> POs2DTOs(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseDTO> list = new ArrayList<CourseDTO>( courses.size() );
        for ( Course course : courses ) {
            list.add( PO2DTO( course ) );
        }

        return list;
    }

    @Override
    public Course updatePOFromDTO(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDTO.getId() );
        course.setCourseNumber( courseDTO.getCourseNumber() );
        course.setCourseName( courseDTO.getCourseName() );
        course.setStartTime( courseDTO.getStartTime() );
        course.setEndTime( courseDTO.getEndTime() );
        course.setCoursePeriod( courseDTO.getCoursePeriod() );
        course.setCourseStatus( courseDTO.getCourseStatus() );
        course.setCourseImage( courseDTO.getCourseImage() );
        course.setCourseDesc( courseDTO.getCourseDesc() );

        return course;
    }

    @Override
    public List<Course> updatePOsFromDTOs(List<CourseDTO> courseDTOS) {
        if ( courseDTOS == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( courseDTOS.size() );
        for ( CourseDTO courseDTO : courseDTOS ) {
            list.add( updatePOFromDTO( courseDTO ) );
        }

        return list;
    }
}
