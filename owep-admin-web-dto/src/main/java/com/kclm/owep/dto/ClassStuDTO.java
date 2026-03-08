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
public class ClassStuDTO {

    private Integer id;

    private String stuNumber;

    private String stuRealName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

    private String status;
}
