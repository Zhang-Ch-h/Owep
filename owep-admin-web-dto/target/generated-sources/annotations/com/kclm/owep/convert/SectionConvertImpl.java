package com.kclm.owep.convert;

import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.Section;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class SectionConvertImpl implements SectionConvert {

    @Override
    public SectionDTO PO2DTO(Section section) {
        if ( section == null ) {
            return null;
        }

        SectionDTO sectionDTO = new SectionDTO();

        sectionDTO.setId( section.getId() );
        sectionDTO.setSectionName( section.getSectionName() );
        sectionDTO.setSectionNumber( section.getSectionNumber() );
        sectionDTO.setSectionDesc( section.getSectionDesc() );
        sectionDTO.setLookVideoStatus( section.getLookVideoStatus() );
        sectionDTO.setExperimentDucumentFile( section.getExperimentDucumentFile() );
        sectionDTO.setExperimentEnvironmentAddr( section.getExperimentEnvironmentAddr() );
        sectionDTO.setExperiment( section.getExperiment() );
        sectionDTO.setExperimentInstrusction( section.getExperimentInstrusction() );

        return sectionDTO;
    }

    @Override
    public List<SectionDTO> POs2DTOs(List<Section> sections) {
        if ( sections == null ) {
            return null;
        }

        List<SectionDTO> list = new ArrayList<SectionDTO>( sections.size() );
        for ( Section section : sections ) {
            list.add( PO2DTO( section ) );
        }

        return list;
    }

    @Override
    public Section updatePOFromDTO(SectionDTO sectionDTO) {
        if ( sectionDTO == null ) {
            return null;
        }

        Section section = new Section();

        section.setId( sectionDTO.getId() );
        section.setSectionName( sectionDTO.getSectionName() );
        section.setSectionNumber( sectionDTO.getSectionNumber() );
        section.setSectionDesc( sectionDTO.getSectionDesc() );
        section.setLookVideoStatus( sectionDTO.getLookVideoStatus() );
        section.setExperimentDucumentFile( sectionDTO.getExperimentDucumentFile() );
        section.setExperimentEnvironmentAddr( sectionDTO.getExperimentEnvironmentAddr() );
        section.setExperiment( sectionDTO.getExperiment() );
        section.setExperimentInstrusction( sectionDTO.getExperimentInstrusction() );

        return section;
    }

    @Override
    public List<Section> updatePOsFromDTOs(List<SectionDTO> sectionDTOS) {
        if ( sectionDTOS == null ) {
            return null;
        }

        List<Section> list = new ArrayList<Section>( sectionDTOS.size() );
        for ( SectionDTO sectionDTO : sectionDTOS ) {
            list.add( updatePOFromDTO( sectionDTO ) );
        }

        return list;
    }
}
