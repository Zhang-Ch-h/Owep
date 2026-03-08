package com.kclm.owep.convert;

import com.kclm.owep.dto.QuestionDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Question;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class QuestionConvertImpl implements QuestionConvert {

    @Override
    public QuestionDTO entityToDTO(Question entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setStuName( entity.getQuestionAuthor() );
        questionDTO.setCourseName( entityCourseCourseName( entity ) );
        questionDTO.setId( entity.getId() );
        questionDTO.setClazz( entity.getClazz() );
        questionDTO.setCreateTime( entity.getCreateTime() );
        questionDTO.setQuestionContent( entity.getQuestionContent() );

        return questionDTO;
    }

    @Override
    public void updateEntityFromDto(QuestionDTO questionDTO, Question entity) {
        if ( questionDTO == null ) {
            return;
        }

        if ( entity.getCourse() == null ) {
            entity.setCourse( new Course() );
        }
        questionDTOToCourse( questionDTO, entity.getCourse() );
        entity.setQuestionAuthor( questionDTO.getStuName() );
        entity.setId( questionDTO.getId() );
        entity.setQuestionContent( questionDTO.getQuestionContent() );
        entity.setClazz( questionDTO.getClazz() );
    }

    private String entityCourseCourseName(Question question) {
        if ( question == null ) {
            return null;
        }
        Course course = question.getCourse();
        if ( course == null ) {
            return null;
        }
        String courseName = course.getCourseName();
        if ( courseName == null ) {
            return null;
        }
        return courseName;
    }

    protected void questionDTOToCourse(QuestionDTO questionDTO, Course mappingTarget) {
        if ( questionDTO == null ) {
            return;
        }

        mappingTarget.setCourseName( questionDTO.getCourseName() );
    }
}
