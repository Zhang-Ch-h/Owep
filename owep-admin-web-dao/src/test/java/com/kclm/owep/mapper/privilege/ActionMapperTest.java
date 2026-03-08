package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Action;
import com.kclm.owep.mapper.ActionMapper;
import com.kclm.owep.mapper.BaseMapperTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @program: owep
 * @package: com.kclm.owep.mapper.privilege
 * @description:
 * @author: qi_kran
 * @create: 2020-07-08 15:32
 **/
class ActionMapperTest extends BaseMapperTest {
    @Autowired
     private  ActionMapper actionMapper;
    @Test
    void save() {
        Action action = new Action("行为7", "测试行为7", "/action7", "b17", 111);
        action.setLastAccessTime(LocalDateTime.now());
        actionMapper.save(action);


    }

    @Test
    void update() {
        Action action = actionMapper.selectById(7);
        actionMapper.update(action);
    }

    @Test
    void findAll() {
        List<Action> actions = actionMapper.selectAll();
        actions.forEach(System.out::println);
    }

    @Test
    void findById() {
        Action action = actionMapper.selectById(2);
        System.out.println(action);
    }

    @Test
    void delete() {
        List<Serializable> integers = Arrays.asList(14, 15, 16, 17, 18, 19);
        actionMapper.deleteSelect(integers);

    }

    @Test
    void count() {
        int count = actionMapper.count();
        System.out.println(count);
    }

    @Test
    void findByActionName() {
        actionMapper.selectByActionName("1");
    }
}