package com.kclm.owep.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
//指定激活的 application-dao.properties 文件
@ActiveProfiles("dao")
public class BaseMapperTest {

    @Test
    public void beginTest() {
        System.out.println("begin to test...");
    }
}