package com.kclm.owep.convert;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrgInstituteConvert {

    //OrgInstituteConvert INSTANCE = Mappers.getMapper(OrgInstituteConvert.class);

    /*@Mapping(target = "instituteId",source = "id")
    OrgInstituteDTO entityToDTO(OrgInstitute entity);*/

    @Mapping(target = "id",source = "instituteId")
    void updateEntityFromDto(OrgInstituteDTO orgInstituteDTO,@MappingTarget OrgInstitute entity);

    @Mapping(source = "id", target = "instituteId")
    @Mapping(source = "instituteName", target = "instituteName")
    @Mapping(target = "instituteType", expression = "java(convertType(orgInstitute.getInstituteType()))")
    @Mapping(source = "createTime", target = "createTime")
    OrgInstituteDTO toOrgInstituteDTO(OrgInstitute orgInstitute);

    List<OrgInstituteDTO> toOrgInstituteDTO(List<OrgInstitute> orgInstitutes);

    default String convertType(Integer type) {
        if (type == null) {
            return null;
        }
        return type == 1 ? "学校机构" : "培训机构";
    }
}
