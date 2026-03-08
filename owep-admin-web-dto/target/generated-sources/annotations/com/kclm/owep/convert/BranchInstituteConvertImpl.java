package com.kclm.owep.convert;

import com.kclm.owep.dto.BranchInstituteDTO;
import com.kclm.owep.entity.BranchInstitute;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class BranchInstituteConvertImpl implements BranchInstituteConvert {

    @Override
    public BranchInstituteDTO entityToDTO(BranchInstitute entity) {
        if ( entity == null ) {
            return null;
        }

        BranchInstituteDTO branchInstituteDTO = new BranchInstituteDTO();

        branchInstituteDTO.setBranchId( entity.getId() );
        branchInstituteDTO.setBranchName( entity.getBranchName() );
        branchInstituteDTO.setOrgInstitute( entity.getOrgInstitute() );
        branchInstituteDTO.setCreateTime( entity.getCreateTime() );

        return branchInstituteDTO;
    }

    @Override
    public void updateEntityFromDto(BranchInstituteDTO branchInstituteDTO, BranchInstitute entity) {
        if ( branchInstituteDTO == null ) {
            return;
        }

        entity.setId( branchInstituteDTO.getBranchId() );
        entity.setBranchName( branchInstituteDTO.getBranchName() );
        entity.setOrgInstitute( branchInstituteDTO.getOrgInstitute() );
        entity.setCreateTime( branchInstituteDTO.getCreateTime() );
    }
}
