package com.kclm.owep.convert;

import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.Chapter;
import com.kclm.owep.entity.Section;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class ChapterConvertImpl implements ChapterConvert {

    @Override
    public ChapterDTO PO2DTO(Chapter chapter) {
        if ( chapter == null ) {
            return null;
        }

        ChapterDTO chapterDTO = new ChapterDTO();

        chapterDTO.setId( chapter.getId() );
        chapterDTO.setChapterNumber( chapter.getChapterNumber() );
        chapterDTO.setChapterName( chapter.getChapterName() );
        chapterDTO.setChapterDesc( chapter.getChapterDesc() );
        chapterDTO.setSectionDTOList( sectionListToSectionDTOList( chapter.getSectionList() ) );

        return chapterDTO;
    }

    @Override
    public List<ChapterDTO> POs2DTOs(List<Chapter> chapters) {
        if ( chapters == null ) {
            return null;
        }

        List<ChapterDTO> list = new ArrayList<ChapterDTO>( chapters.size() );
        for ( Chapter chapter : chapters ) {
            list.add( PO2DTO( chapter ) );
        }

        return list;
    }

    @Override
    public Chapter updatePOFromDTO(ChapterDTO chapterDTO) {
        if ( chapterDTO == null ) {
            return null;
        }

        Chapter chapter = new Chapter();

        chapter.setId( chapterDTO.getId() );
        chapter.setChapterNumber( chapterDTO.getChapterNumber() );
        chapter.setChapterName( chapterDTO.getChapterName() );
        chapter.setChapterDesc( chapterDTO.getChapterDesc() );
        chapter.setSectionList( sectionDTOListToSectionList( chapterDTO.getSectionDTOList() ) );

        return chapter;
    }

    @Override
    public List<Chapter> updatePOsFromDTOs(List<ChapterDTO> chapterDTOS) {
        if ( chapterDTOS == null ) {
            return null;
        }

        List<Chapter> list = new ArrayList<Chapter>( chapterDTOS.size() );
        for ( ChapterDTO chapterDTO : chapterDTOS ) {
            list.add( updatePOFromDTO( chapterDTO ) );
        }

        return list;
    }

    protected SectionDTO sectionToSectionDTO(Section section) {
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

    protected List<SectionDTO> sectionListToSectionDTOList(List<Section> list) {
        if ( list == null ) {
            return null;
        }

        List<SectionDTO> list1 = new ArrayList<SectionDTO>( list.size() );
        for ( Section section : list ) {
            list1.add( sectionToSectionDTO( section ) );
        }

        return list1;
    }

    protected Section sectionDTOToSection(SectionDTO sectionDTO) {
        if ( sectionDTO == null ) {
            return null;
        }

        Section section = new Section();

        section.setId( sectionDTO.getId() );
        section.setSectionName( sectionDTO.getSectionName() );
        section.setSectionNumber( sectionDTO.getSectionNumber() );
        section.setSectionDesc( sectionDTO.getSectionDesc() );
        section.setExperimentDucumentFile( sectionDTO.getExperimentDucumentFile() );
        section.setExperimentEnvironmentAddr( sectionDTO.getExperimentEnvironmentAddr() );
        section.setExperiment( sectionDTO.getExperiment() );
        section.setLookVideoStatus( sectionDTO.getLookVideoStatus() );
        section.setExperimentInstrusction( sectionDTO.getExperimentInstrusction() );

        return section;
    }

    protected List<Section> sectionDTOListToSectionList(List<SectionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Section> list1 = new ArrayList<Section>( list.size() );
        for ( SectionDTO sectionDTO : list ) {
            list1.add( sectionDTOToSection( sectionDTO ) );
        }

        return list1;
    }
}
