package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/*******************
 * @Author zch
 * @Description
 */
@Data
public class NewsDTO {

    /**
     * 主键
     * @mbg.generated
     */
    private Integer id;

    /**
     * 新闻标题
     * @mbg.generated
     */
    private String newsTitle;

    /**
     * 新闻内容
     * @mbg.generated
     */
    private String newsContent;

    /**
     * 新闻类型
     * @mbg.generated
     */
    private String newsType;

    /**
     *新闻发布人
     * @mbg.generated
     */
    private String newsPublisher;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();
}
