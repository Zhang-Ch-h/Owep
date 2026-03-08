package com.kclm.owep.convert;

import com.kclm.owep.dto.QuestionDTO;
import com.kclm.owep.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionConvert {

    QuestionConvert INSTANCE = Mappers.getMapper(QuestionConvert.class);

    @Mapping(target ="stuName" ,source = "questionAuthor")
    @Mapping(target = "courseName",source = "course.courseName")
    QuestionDTO entityToDTO(Question entity);

    @Mapping(target = "questionAuthor",source = "stuName")
    @Mapping(target = "course.courseName",source = "courseName")
    void updateEntityFromDto(QuestionDTO questionDTO, @MappingTarget Question entity);
}
