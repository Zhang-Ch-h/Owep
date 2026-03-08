package com.kclm.owep.convert;

import com.kclm.owep.dto.BranchInstituteDTO;
import com.kclm.owep.entity.BranchInstitute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchInstituteConvert {

    BranchInstituteConvert INSTSNCE = Mappers.getMapper(BranchInstituteConvert.class);

    @Mapping(target = "branchId",source = "id")
    BranchInstituteDTO entityToDTO(BranchInstitute entity);

    @Mapping(target = "id",source = "branchId")
    void updateEntityFromDto(BranchInstituteDTO branchInstituteDTO,@MappingTarget BranchInstitute entity);
}
