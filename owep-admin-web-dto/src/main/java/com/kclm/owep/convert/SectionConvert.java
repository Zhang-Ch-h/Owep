package com.kclm.owep.convert;

import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-26 16:32
 * @description  此类用于 Resource 转 ResourceDTO 的转换
 */

@Mapper
public interface SectionConvert {

    SectionConvert INSTANCE = Mappers.getMapper(SectionConvert.class);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "sectionName", source = "sectionName")
    @Mapping(target = "sectionNumber", source = "sectionNumber")
    @Mapping(target = "sectionDesc", source = "sectionDesc")
    @Mapping(target = "lookVideoStatus", source = "lookVideoStatus")
    @Mapping(target = "experimentDucumentFile", source = "experimentDucumentFile")
    @Mapping(target = "experimentEnvironmentAddr", source = "experimentEnvironmentAddr")
    @Mapping(target = "experiment", source = "experiment")
    @Mapping(target = "experimentInstrusction", source = "experimentInstrusction")
    SectionDTO PO2DTO(Section section);
    List<SectionDTO> POs2DTOs(List<Section> sections);




    @Mapping(target = "id", source = "id")
    @Mapping(target = "sectionName", source = "sectionName")
    @Mapping(target = "sectionNumber", source = "sectionNumber")
    @Mapping(target = "sectionDesc", source = "sectionDesc")
    @Mapping(target = "lookVideoStatus", source = "lookVideoStatus")
    @Mapping(target = "experimentDucumentFile", source = "experimentDucumentFile")
    @Mapping(target = "experimentEnvironmentAddr", source = "experimentEnvironmentAddr")
    @Mapping(target = "experiment", source = "experiment")
    @Mapping(target = "experimentInstrusction", source = "experimentInstrusction")
    Section updatePOFromDTO(SectionDTO sectionDTO);
    List<Section> updatePOsFromDTOs(List<SectionDTO> sectionDTOS);


}
