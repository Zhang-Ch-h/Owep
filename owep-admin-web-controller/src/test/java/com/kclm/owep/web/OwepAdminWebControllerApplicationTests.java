package com.kclm.owep.web;

import com.kclm.owep.OwepAdminWebControllerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/***************************
 * 控制层的测试类
 * 在这里指定了classes
 */
@SpringBootTest(classes = OwepAdminWebControllerApplication.class)
public class OwepAdminWebControllerApplicationTests {


    @Test
    public void beginControllerTests() {
        //
        System.out.println("controller tests");
    }

}
