package com.kclm.owep.convert;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class OrgInstituteConvertImpl implements OrgInstituteConvert {

    @Override
    public void updateEntityFromDto(OrgInstituteDTO orgInstituteDTO, OrgInstitute entity) {
        if ( orgInstituteDTO == null ) {
            return;
        }

        entity.setId( orgInstituteDTO.getInstituteId() );
        entity.setInstituteName( orgInstituteDTO.getInstituteName() );
        if ( orgInstituteDTO.getInstituteType() != null ) {
            entity.setInstituteType( Integer.parseInt( orgInstituteDTO.getInstituteType() ) );
        }
        else {
            entity.setInstituteType( null );
        }
        entity.setDelete( orgInstituteDTO.getDelete() );
        entity.setCreateTime( orgInstituteDTO.getCreateTime() );
    }

    @Override
    public OrgInstituteDTO toOrgInstituteDTO(OrgInstitute orgInstitute) {
        if ( orgInstitute == null ) {
            return null;
        }

        OrgInstituteDTO orgInstituteDTO = new OrgInstituteDTO();

        orgInstituteDTO.setInstituteId( orgInstitute.getId() );
        orgInstituteDTO.setInstituteName( orgInstitute.getInstituteName() );
        orgInstituteDTO.setCreateTime( orgInstitute.getCreateTime() );
        orgInstituteDTO.setDelete( orgInstitute.getDelete() );

        orgInstituteDTO.setInstituteType( convertType(orgInstitute.getInstituteType()) );

        return orgInstituteDTO;
    }

    @Override
    public List<OrgInstituteDTO> toOrgInstituteDTO(List<OrgInstitute> orgInstitutes) {
        if ( orgInstitutes == null ) {
            return null;
        }

        List<OrgInstituteDTO> list = new ArrayList<OrgInstituteDTO>( orgInstitutes.size() );
        for ( OrgInstitute orgInstitute : orgInstitutes ) {
            list.add( toOrgInstituteDTO( orgInstitute ) );
        }

        return list;
    }
}
