package com.kclm.owep.convert;

import com.kclm.owep.dto.ResourceTypeDTO;
import com.kclm.owep.entity.ResourceType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-25 14:20
 * @description  此类用于 ResourceType 转 ResourceTypeDTO 的转换
 */
@Mapper
public interface ResourceTypeConvert {
    ResourceTypeConvert INSTANCE = Mappers.getMapper(ResourceTypeConvert.class);

    /**
     *     PO               DTO
     * ResourceType 转 ResourceTypeDTO
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeName", source = "typeName")
    @Mapping(target = "typeDesc", source = "typeDesc")
    @Mapping(target = "createTime", source = "createTime")
    @Mapping(target = "isDelete", source = "isDelete")
    ResourceTypeDTO PO2DTO(ResourceType resourceType);
    List<ResourceTypeDTO> POs2DTOs(List<ResourceType> resourceTypes);


    /**
     *
     *     DTO               PO
     * ResourceTypeDTO 转 ResourceType
     *
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeName", source = "typeName")
    @Mapping(target = "typeDesc", source = "typeDesc")
    @Mapping(target = "createTime", source = "createTime")
    @Mapping(target = "isDelete", source = "isDelete")
    ResourceType updatePOFromDTO(ResourceTypeDTO resourceTypeDTO, @MappingTarget ResourceType resourceType);
    List<ResourceType> updatePOsFromDTOs(List<ResourceTypeDTO> resourceTypeDTOS );

} 