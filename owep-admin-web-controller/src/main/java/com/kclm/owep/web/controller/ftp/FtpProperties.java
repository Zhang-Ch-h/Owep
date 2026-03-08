package com.kclm.owep.web.controller.ftp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ftp")
@PropertySource("classpath:ftp.properties")
public class FtpProperties {
    private String  ip="127.0.0.1";
    private String  port="21";
    private String  username="zch";
    private String  password="123456";
    private Integer initialSize = 0;
    private String  encoding = "UTF-8";
    private Integer bufferSize = 4096;
    private Integer retryCount = 3;

}
