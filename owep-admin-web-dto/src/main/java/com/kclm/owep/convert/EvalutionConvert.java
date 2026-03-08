package com.kclm.owep.convert;

import com.kclm.owep.dto.EvaluateDTO;
import com.kclm.owep.entity.Evaluate;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface EvalutionConvert {

    EvalutionConvert INSTANCE= Mappers.getMapper(EvalutionConvert.class);

    @Mapping(target = "stuName",source = "student.stuName")
    EvaluateDTO entityToDTO(Evaluate entity);

}
