package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest extends BaseMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectByName() {
    }

    @Test
    void selectByType() {
        List<User> users = userMapper.selectByType(1);
        users.forEach(System.out::println);
    }

    @Test
    void getGroupId() {
    }

    @Test
    void attachGroupToUser() {
    }

    @Test
    void deleteUserGroupAllocation() {
    }
}