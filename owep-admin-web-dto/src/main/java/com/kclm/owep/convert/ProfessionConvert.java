package com.kclm.owep.convert;

import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessionConvert {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "profName", target = "profName")
    @Mapping(source = "instituteName", target = "instituteName")
    @Mapping(source = "instituteBranchName", target = "instituteBranchName")
    @Mapping(source = "profStatus", target = "profStatus")
    @Mapping(source = "profDesc", target = "profDesc")
    List<ProfessionDTO> toProfessionDTO(List<Profession> profession);

    /* 可能是多余的，但也不一定，先放这*/
    /*ProfessionDTO toProfessionDTO(Profession profession);*/
}
