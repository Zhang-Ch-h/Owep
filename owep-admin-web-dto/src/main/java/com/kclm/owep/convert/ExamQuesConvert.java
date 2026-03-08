package com.kclm.owep.convert;

import com.kclm.owep.dto.ExamQuesDTO;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamQues;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamQuesConvert {
    ExamQuesConvert INSTANCE = Mappers.getMapper(ExamQuesConvert.class);
    @Mapping(target = "examBankName",source = "examBank.bankName")
    ExamQuesDTO entityToDTO(ExamQues entity);
}
