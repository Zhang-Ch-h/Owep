package com.kclm.owep.convert;


import com.kclm.owep.dto.ExamBankDTO;
import com.kclm.owep.entity.ExamBank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamBankConvert {
    ExamBankConvert INSTANCE = Mappers.getMapper(ExamBankConvert.class);
    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "userName",source = "user.userName")
    ExamBankDTO entityToDTO(ExamBank entity);
}
