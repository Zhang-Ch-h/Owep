package com.kclm.owep.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
//注：因为业务层需要用到持久层，故这里激活的配置文件还是持久层模块的application-dao.properties 文件
@ActiveProfiles("dao")
public class BaseServiceTests {

    //在业务层中的测试类，只需要继承此类即可
}
