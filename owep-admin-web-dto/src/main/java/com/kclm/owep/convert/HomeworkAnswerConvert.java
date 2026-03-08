package com.kclm.owep.convert;

import com.kclm.owep.dto.HomeworkAnswerDTO;
import com.kclm.owep.entity.HomeworkAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HomeworkAnswerConvert {

    HomeworkAnswerConvert INSTENCE= Mappers.getMapper(HomeworkAnswerConvert.class);

    @Mapping(target ="workTitle",source = "homework.workTitle")
    @Mapping(target ="workContent",source = "homework.workContent")
    @Mapping(target ="answerContent",source = "answerContent")
    @Mapping(target ="studentName",source = "student.stuName")
    @Mapping(target ="createTime",source = "createTime")
    @Mapping(target ="startTime",source = "homework.createTime")
    @Mapping(target ="auditContent",source = "auditContent")
    @Mapping(target ="id",source = "id")
    HomeworkAnswerDTO entityToDto(HomeworkAnswer homeworkAnswer);
}
