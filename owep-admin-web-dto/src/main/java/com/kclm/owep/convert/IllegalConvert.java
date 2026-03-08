package com.kclm.owep.convert;

import com.kclm.owep.dto.IllegalDTO;
import com.kclm.owep.entity.Illegal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IllegalConvert {
    IllegalConvert INSTENCE= Mappers.getMapper(IllegalConvert.class);
    @Mapping(target ="stuNumber",source = "student.stuNumber")
    @Mapping(target ="studentName",source = "student.stuName")
    @Mapping(target ="disciplineTime",source = "disciplineTime")
    @Mapping(target ="presentationCondition",source = "presentationCondition")
    IllegalDTO entityIllegal(Illegal illegal);
}
