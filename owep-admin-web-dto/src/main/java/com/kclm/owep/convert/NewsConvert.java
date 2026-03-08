package com.kclm.owep.convert;

import com.kclm.owep.dto.NewsDTO;
import com.kclm.owep.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsConvert {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "newsTitle",target = "newsTitle")
    @Mapping(source = "newsContent",target = "newsContent")
    @Mapping(target = "newsType", expression = "java(convertType(news.getNewsType()))")
    @Mapping(source = "createTime",target = "createTime")
    NewsDTO toNewsDTO(News news);

    List<NewsDTO> toNewsDTO(List<News> news);

    default String convertType(Integer type) {
        if (type == null) {
            return null;
        }
        return type == 1 ? "国际新闻" : "国内新闻";
    }

    @Mapping(source = "id",target = "id")
    @Mapping(source = "newsTitle",target = "newsTitle")
    @Mapping(source = "newsContent",target = "newsContent")
    @Mapping(target = "newsType", expression = "java(convertToType(newsDTO.getNewsType()))")
    @Mapping(source = "createTime",target = "createTime")
    News toNews(NewsDTO newsDTO);

    default Integer convertToType(String type) {
        if (type == null) {
            return null;
        }
        return type.equals("国际新闻") ? 1 : 2;
    }
}
