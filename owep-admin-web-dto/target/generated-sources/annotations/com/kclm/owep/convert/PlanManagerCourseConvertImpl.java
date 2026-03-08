package com.kclm.owep.convert;

import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.PlanManagerCourseDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.PlanManagerCourse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class PlanManagerCourseConvertImpl implements PlanManagerCourseConvert {

    @Override
    public PlanManagerCourseDTO entityToDTO_yjj(PlanManagerCourse planManagerCourse) {
        if ( planManagerCourse == null ) {
            return null;
        }

        PlanManagerCourseDTO planManagerCourseDTO = new PlanManagerCourseDTO();

        planManagerCourseDTO.setPlanNumber( planManagerCoursePlanManagerPlanNumber( planManagerCourse ) );
        planManagerCourseDTO.setCourseName( planManagerCourseCourseCourseName( planManagerCourse ) );
        planManagerCourseDTO.setStageNum( planManagerCourse.getStageNum() );
        planManagerCourseDTO.setStageName( planManagerCourse.getStageName() );
        planManagerCourseDTO.setCourseOrder( planManagerCourse.getCourseOrder() );
        planManagerCourseDTO.setId( planManagerCourse.getId() );

        return planManagerCourseDTO;
    }

    @Override
    public PlanManagerCourseDTO entityToDTO(PlanManagerCourse entity) {
        if ( entity == null ) {
            return null;
        }

        PlanManagerCourseDTO planManagerCourseDTO = new PlanManagerCourseDTO();

        planManagerCourseDTO.setCourseDTO( courseToCourseDTO( entity.getCourse() ) );
        planManagerCourseDTO.setId( entity.getId() );
        planManagerCourseDTO.setStageNum( entity.getStageNum() );
        planManagerCourseDTO.setStageName( entity.getStageName() );
        planManagerCourseDTO.setCourseOrder( entity.getCourseOrder() );

        return planManagerCourseDTO;
    }

    @Override
    public PlanManagerCourse updateEntityFromDto(PlanManagerCourseDTO peopleDTO) {
        if ( peopleDTO == null ) {
            return null;
        }

        PlanManagerCourse planManagerCourse = new PlanManagerCourse();

        planManagerCourse.setPlanManager( planManagerCourseDTOToPlanManager( peopleDTO ) );
        planManagerCourse.setCourse( planManagerCourseDTOToCourse( peopleDTO ) );
        planManagerCourse.setStageNum( peopleDTO.getStageNum() );
        planManagerCourse.setStageName( peopleDTO.getStageName() );
        planManagerCourse.setCourseOrder( peopleDTO.getCourseOrder() );
        planManagerCourse.setId( peopleDTO.getId() );

        return planManagerCourse;
    }

    @Override
    public void updateEntityFromDto(PlanManagerCourseDTO planManagerCourseDTO, PlanManagerCourse planManagerCourse) {
        if ( planManagerCourseDTO == null ) {
            return;
        }

        if ( planManagerCourseDTO.getCourseDTO() != null ) {
            if ( planManagerCourse.getCourse() == null ) {
                planManagerCourse.setCourse( new Course() );
            }
            courseDTOToCourse( planManagerCourseDTO.getCourseDTO(), planManagerCourse.getCourse() );
        }
        else {
            planManagerCourse.setCourse( null );
        }
        planManagerCourse.setStageNum( planManagerCourseDTO.getStageNum() );
        planManagerCourse.setStageName( planManagerCourseDTO.getStageName() );
        planManagerCourse.setCourseOrder( planManagerCourseDTO.getCourseOrder() );
        planManagerCourse.setId( planManagerCourseDTO.getId() );
    }

    private String planManagerCoursePlanManagerPlanNumber(PlanManagerCourse planManagerCourse) {
        if ( planManagerCourse == null ) {
            return null;
        }
        PlanManager planManager = planManagerCourse.getPlanManager();
        if ( planManager == null ) {
            return null;
        }
        String planNumber = planManager.getPlanNumber();
        if ( planNumber == null ) {
            return null;
        }
        return planNumber;
    }

    private String planManagerCourseCourseCourseName(PlanManagerCourse planManagerCourse) {
        if ( planManagerCourse == null ) {
            return null;
        }
        Course course = planManagerCourse.getCourse();
        if ( course == null ) {
            return null;
        }
        String courseName = course.getCourseName();
        if ( courseName == null ) {
            return null;
        }
        return courseName;
    }

    protected CourseDTO courseToCourseDTO(Course course) {
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

    protected PlanManager planManagerCourseDTOToPlanManager(PlanManagerCourseDTO planManagerCourseDTO) {
        if ( planManagerCourseDTO == null ) {
            return null;
        }

        PlanManager planManager = new PlanManager();

        planManager.setPlanNumber( planManagerCourseDTO.getPlanNumber() );

        return planManager;
    }

    protected Course planManagerCourseDTOToCourse(PlanManagerCourseDTO planManagerCourseDTO) {
        if ( planManagerCourseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setCourseName( planManagerCourseDTO.getCourseName() );

        return course;
    }

    protected void courseDTOToCourse(CourseDTO courseDTO, Course mappingTarget) {
        if ( courseDTO == null ) {
            return;
        }

        mappingTarget.setId( courseDTO.getId() );
        mappingTarget.setCourseNumber( courseDTO.getCourseNumber() );
        mappingTarget.setCourseName( courseDTO.getCourseName() );
        mappingTarget.setStartTime( courseDTO.getStartTime() );
        mappingTarget.setEndTime( courseDTO.getEndTime() );
        mappingTarget.setCoursePeriod( courseDTO.getCoursePeriod() );
        mappingTarget.setCourseStatus( courseDTO.getCourseStatus() );
        mappingTarget.setCourseImage( courseDTO.getCourseImage() );
        mappingTarget.setCourseDesc( courseDTO.getCourseDesc() );
    }
}
