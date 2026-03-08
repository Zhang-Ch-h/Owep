package com.kclm.owep.convert;

import com.kclm.owep.dto.ResourceTypeDTO;
import com.kclm.owep.entity.ResourceType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class ResourceTypeConvertImpl implements ResourceTypeConvert {

    @Override
    public ResourceTypeDTO PO2DTO(ResourceType resourceType) {
        if ( resourceType == null ) {
            return null;
        }

        ResourceTypeDTO resourceTypeDTO = new ResourceTypeDTO();

        resourceTypeDTO.setId( resourceType.getId() );
        resourceTypeDTO.setTypeName( resourceType.getTypeName() );
        resourceTypeDTO.setTypeDesc( resourceType.getTypeDesc() );
        resourceTypeDTO.setCreateTime( resourceType.getCreateTime() );
        resourceTypeDTO.setIsDelete( resourceType.getIsDelete() );

        return resourceTypeDTO;
    }

    @Override
    public List<ResourceTypeDTO> POs2DTOs(List<ResourceType> resourceTypes) {
        if ( resourceTypes == null ) {
            return null;
        }

        List<ResourceTypeDTO> list = new ArrayList<ResourceTypeDTO>( resourceTypes.size() );
        for ( ResourceType resourceType : resourceTypes ) {
            list.add( PO2DTO( resourceType ) );
        }

        return list;
    }

    @Override
    public ResourceType updatePOFromDTO(ResourceTypeDTO resourceTypeDTO, ResourceType resourceType) {
        if ( resourceTypeDTO == null ) {
            return null;
        }

        resourceType.setId( resourceTypeDTO.getId() );
        resourceType.setTypeName( resourceTypeDTO.getTypeName() );
        resourceType.setTypeDesc( resourceTypeDTO.getTypeDesc() );
        resourceType.setCreateTime( resourceTypeDTO.getCreateTime() );
        resourceType.setIsDelete( resourceTypeDTO.getIsDelete() );

        return resourceType;
    }

    @Override
    public List<ResourceType> updatePOsFromDTOs(List<ResourceTypeDTO> resourceTypeDTOS) {
        if ( resourceTypeDTOS == null ) {
            return null;
        }

        List<ResourceType> list = new ArrayList<ResourceType>( resourceTypeDTOS.size() );
        for ( ResourceTypeDTO resourceTypeDTO : resourceTypeDTOS ) {
            list.add( resourceTypeDTOToResourceType( resourceTypeDTO ) );
        }

        return list;
    }

    protected ResourceType resourceTypeDTOToResourceType(ResourceTypeDTO resourceTypeDTO) {
        if ( resourceTypeDTO == null ) {
            return null;
        }

        ResourceType resourceType = new ResourceType();

        resourceType.setId( resourceTypeDTO.getId() );
        resourceType.setTypeName( resourceTypeDTO.getTypeName() );
        resourceType.setTypeDesc( resourceTypeDTO.getTypeDesc() );
        resourceType.setCreateTime( resourceTypeDTO.getCreateTime() );
        resourceType.setIsDelete( resourceTypeDTO.getIsDelete() );

        return resourceType;
    }
}
