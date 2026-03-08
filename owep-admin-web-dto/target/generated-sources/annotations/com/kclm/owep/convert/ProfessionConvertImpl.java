package com.kclm.owep.convert;

import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.Profession;
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
public class ProfessionConvertImpl implements ProfessionConvert {

    @Override
    public List<ProfessionDTO> toProfessionDTO(List<Profession> profession) {
        if ( profession == null ) {
            return null;
        }

        List<ProfessionDTO> list = new ArrayList<ProfessionDTO>( profession.size() );
        for ( Profession profession1 : profession ) {
            list.add( professionToProfessionDTO( profession1 ) );
        }

        return list;
    }

    protected ProfessionDTO professionToProfessionDTO(Profession profession) {
        if ( profession == null ) {
            return null;
        }

        ProfessionDTO professionDTO = new ProfessionDTO();

        professionDTO.setId( profession.getId() );
        professionDTO.setProfName( profession.getProfName() );
        professionDTO.setInstituteName( profession.getInstituteName() );
        professionDTO.setInstituteBranchName( profession.getInstituteBranchName() );
        if ( profession.getProfStatus() != null ) {
            professionDTO.setProfStatus( profession.getProfStatus() );
        }
        professionDTO.setProfDesc( profession.getProfDesc() );

        return professionDTO;
    }
}
