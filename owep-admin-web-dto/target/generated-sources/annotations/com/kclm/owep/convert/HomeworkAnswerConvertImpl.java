package com.kclm.owep.convert;

import com.kclm.owep.dto.HomeworkAnswerDTO;
import com.kclm.owep.entity.Homework;
import com.kclm.owep.entity.HomeworkAnswer;
import com.kclm.owep.entity.Student;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class HomeworkAnswerConvertImpl implements HomeworkAnswerConvert {

    @Override
    public HomeworkAnswerDTO entityToDto(HomeworkAnswer homeworkAnswer) {
        if ( homeworkAnswer == null ) {
            return null;
        }

        HomeworkAnswerDTO homeworkAnswerDTO = new HomeworkAnswerDTO();

        homeworkAnswerDTO.setWorkTitle( homeworkAnswerHomeworkWorkTitle( homeworkAnswer ) );
        homeworkAnswerDTO.setWorkContent( homeworkAnswerHomeworkWorkContent( homeworkAnswer ) );
        homeworkAnswerDTO.setAnswerContent( homeworkAnswer.getAnswerContent() );
        homeworkAnswerDTO.setStudentName( homeworkAnswerStudentStuName( homeworkAnswer ) );
        homeworkAnswerDTO.setCreateTime( homeworkAnswer.getCreateTime() );
        homeworkAnswerDTO.setStartTime( homeworkAnswerHomeworkCreateTime( homeworkAnswer ) );
        homeworkAnswerDTO.setAuditContent( homeworkAnswer.getAuditContent() );
        homeworkAnswerDTO.setId( homeworkAnswer.getId() );

        return homeworkAnswerDTO;
    }

    private String homeworkAnswerHomeworkWorkTitle(HomeworkAnswer homeworkAnswer) {
        if ( homeworkAnswer == null ) {
            return null;
        }
        Homework homework = homeworkAnswer.getHomework();
        if ( homework == null ) {
            return null;
        }
        String workTitle = homework.getWorkTitle();
        if ( workTitle == null ) {
            return null;
        }
        return workTitle;
    }

    private String homeworkAnswerHomeworkWorkContent(HomeworkAnswer homeworkAnswer) {
        if ( homeworkAnswer == null ) {
            return null;
        }
        Homework homework = homeworkAnswer.getHomework();
        if ( homework == null ) {
            return null;
        }
        String workContent = homework.getWorkContent();
        if ( workContent == null ) {
            return null;
        }
        return workContent;
    }

    private String homeworkAnswerStudentStuName(HomeworkAnswer homeworkAnswer) {
        if ( homeworkAnswer == null ) {
            return null;
        }
        Student student = homeworkAnswer.getStudent();
        if ( student == null ) {
            return null;
        }
        String stuName = student.getStuName();
        if ( stuName == null ) {
            return null;
        }
        return stuName;
    }

    private LocalDateTime homeworkAnswerHomeworkCreateTime(HomeworkAnswer homeworkAnswer) {
        if ( homeworkAnswer == null ) {
            return null;
        }
        Homework homework = homeworkAnswer.getHomework();
        if ( homework == null ) {
            return null;
        }
        LocalDateTime createTime = homework.getCreateTime();
        if ( createTime == null ) {
            return null;
        }
        return createTime;
    }
}
