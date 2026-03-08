package com.kclm.owep.convert;

import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.entity.Chapter;
import com.kclm.owep.entity.Course;
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
public interface ChapterConvert {

    ChapterConvert INSTANCE = Mappers.getMapper(ChapterConvert.class);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "chapterNumber", source = "chapterNumber")
    @Mapping(target = "chapterName", source = "chapterName")
    @Mapping(target = "chapterDesc", source = "chapterDesc")
    @Mapping(target = "sectionDTOList", source = "sectionList")
    ChapterDTO PO2DTO(Chapter chapter);

    List<ChapterDTO> POs2DTOs(List<Chapter> chapters);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "chapterNumber", source = "chapterNumber")
    @Mapping(target = "chapterName", source = "chapterName")
    @Mapping(target = "chapterDesc", source = "chapterDesc")
    @Mapping(target = "sectionList", source = "sectionDTOList")
    Chapter updatePOFromDTO(ChapterDTO chapterDTO);
    List<Chapter> updatePOsFromDTOs(List<ChapterDTO> chapterDTOS);


}
