package com.kclm.owep.convert;

import com.kclm.owep.dto.NewsDTO;
import com.kclm.owep.entity.News;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class NewsConvertImpl implements NewsConvert {

    @Override
    public NewsDTO toNewsDTO(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDTO newsDTO = new NewsDTO();

        newsDTO.setId( news.getId() );
        newsDTO.setNewsTitle( news.getNewsTitle() );
        newsDTO.setNewsContent( news.getNewsContent() );
        newsDTO.setCreateTime( news.getCreateTime() );
        newsDTO.setNewsPublisher( news.getNewsPublisher() );

        newsDTO.setNewsType( convertType(news.getNewsType()) );

        return newsDTO;
    }

    @Override
    public List<NewsDTO> toNewsDTO(List<News> news) {
        if ( news == null ) {
            return null;
        }

        List<NewsDTO> list = new ArrayList<NewsDTO>( news.size() );
        for ( News news1 : news ) {
            list.add( toNewsDTO( news1 ) );
        }

        return list;
    }

    @Override
    public News toNews(NewsDTO newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        News news = new News();

        news.setId( newsDTO.getId() );
        news.setNewsTitle( newsDTO.getNewsTitle() );
        news.setNewsContent( newsDTO.getNewsContent() );
        news.setCreateTime( newsDTO.getCreateTime() );
        news.setNewsPublisher( newsDTO.getNewsPublisher() );

        news.setNewsType( convertToType(newsDTO.getNewsType()) );

        return news;
    }
}
