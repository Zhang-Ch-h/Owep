package com.kclm.owep.convert;

import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;
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
public interface ResourceConvert {

    ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);

    /**
     *     PO               DTO
     * Resource 转 ResourceDTO
     */

    @Mapping(target = "id", source = "id")
    @Mapping(target = "resourceName", source = "resourceName")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "resourceSuffix", source = "resourceSuffix")
    @Mapping(target = "resourceSize", source = "resourceSize")
    @Mapping(target = "resourceDesc", source = "resourceDesc")
    @Mapping(target = "createTime", source = "createTime")
    @Mapping(target = "isDelete", source = "isDelete")
    @Mapping(target = "resourceType", source = "resourceType")
//    @Mapping(target = "resourcePath", source = "resourcePath")
    @Mapping(target = "course", source = "course")
    ResourceDTO PO2DTO(Resource resource);
    //
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "resourceName", source = "resourceName")
//    @Mapping(target = "type", source = "type")
//    @Mapping(target = "resourceSuffix", source = "resourceSuffix")
//    @Mapping(target = "resourceSize", source = "resourceSize")
//    @Mapping(target = "resourceDesc", source = "resourceDesc")
//    @Mapping(target = "createTime", source = "createTime")
//    @Mapping(target = "isDelete", source = "isDelete")
//    @Mapping(target = "resourceType", source = "resourceType")
//    @Mapping(target = "resourcePath", source = "resourcePath")
//    @Mapping(target = "course", source = "course")
    List<ResourceDTO>POs2DTOs(List<Resource> resources);



    /**
     *
     *     DTO            PO
     * ResourceDTO 转 Resource
     *
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "resourceName", source = "resourceName")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "resourceSuffix", source = "resourceSuffix")
    @Mapping(target = "resourceSize", source = "resourceSize")
    @Mapping(target = "resourceDesc", source = "resourceDesc")
    @Mapping(target = "createTime", source = "createTime")
    @Mapping(target = "isDelete", source = "isDelete")
    @Mapping(target = "resourceType", source = "resourceType")
//    @Mapping(target = "resourcePath", source = "resourcePath")
    @Mapping(target = "course", source = "course")
    Resource updatePOFromDTO(ResourceDTO resourceDTO);

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "resourceName", source = "resourceName")
//    @Mapping(target = "type", source = "type")
//    @Mapping(target = "resourceSuffix", source = "resourceSuffix")
//    @Mapping(target = "resourceSize", source = "resourceSize")
//    @Mapping(target = "resourceDesc", source = "resourceDesc")
//    @Mapping(target = "createTime", source = "createTime")
//    @Mapping(target = "isDelete", source = "isDelete")
//    @Mapping(target = "resourceType", source = "resourceType")
//    @Mapping(target = "resourcePath", source = "resourcePath")
//    @Mapping(target = "course", source = "course")
    List<Resource> updatePOsFromDTOs(List<ResourceDTO> resourceDTOS);

}
