package com.kclm.owep.convert;

import com.kclm.owep.dto.ClazzSuggestDTO;
import com.kclm.owep.entity.Clazz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClazzSuggestConvert {

    @Mapping(source = "className", target = "className")
    List<ClazzSuggestDTO> toClazzSuggestDTO(List<Clazz> clazzs);
}
