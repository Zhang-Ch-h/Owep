package com.kclm.owep.convert;

import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class ResourceConvertImpl implements ResourceConvert {

    @Override
    public ResourceDTO PO2DTO(Resource resource) {
        if ( resource == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        resourceDTO.setId( resource.getId() );
        resourceDTO.setResourceName( resource.getResourceName() );
        resourceDTO.setType( resource.getType() );
        resourceDTO.setResourceSuffix( resource.getResourceSuffix() );
        resourceDTO.setResourceSize( resource.getResourceSize() );
        resourceDTO.setResourceDesc( resource.getResourceDesc() );
        resourceDTO.setCreateTime( resource.getCreateTime() );
        resourceDTO.setIsDelete( resource.getIsDelete() );
        resourceDTO.setResourceType( resource.getResourceType() );
        resourceDTO.setCourse( resource.getCourse() );

        return resourceDTO;
    }

    @Override
    public List<ResourceDTO> POs2DTOs(List<Resource> resources) {
        if ( resources == null ) {
            return null;
        }

        List<ResourceDTO> list = new ArrayList<ResourceDTO>( resources.size() );
        for ( Resource resource : resources ) {
            list.add( PO2DTO( resource ) );
        }

        return list;
    }

    @Override
    public Resource updatePOFromDTO(ResourceDTO resourceDTO) {
        if ( resourceDTO == null ) {
            return null;
        }

        Resource resource = new Resource();

        resource.setId( resourceDTO.getId() );
        resource.setResourceName( resourceDTO.getResourceName() );
        resource.setType( resourceDTO.getType() );
        resource.setResourceSuffix( resourceDTO.getResourceSuffix() );
        resource.setResourceSize( resourceDTO.getResourceSize() );
        resource.setResourceDesc( resourceDTO.getResourceDesc() );
        resource.setCreateTime( resourceDTO.getCreateTime() );
        resource.setIsDelete( resourceDTO.getIsDelete() );
        resource.setResourceType( resourceDTO.getResourceType() );
        resource.setCourse( resourceDTO.getCourse() );

        return resource;
    }

    @Override
    public List<Resource> updatePOsFromDTOs(List<ResourceDTO> resourceDTOS) {
        if ( resourceDTOS == null ) {
            return null;
        }

        List<Resource> list = new ArrayList<Resource>( resourceDTOS.size() );
        for ( ResourceDTO resourceDTO : resourceDTOS ) {
            list.add( updatePOFromDTO( resourceDTO ) );
        }

        return list;
    }
}
