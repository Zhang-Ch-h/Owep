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
public class StuManagementDTO {

    private Integer id;

    private String stuNumber;

    private String stuPwd;

    private String stuName;

    private String stuRealName;

    private String gender;

    private String stuPhone;

    private String stuEmail;

    private Integer status;

    private String stuSchool;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;
}
