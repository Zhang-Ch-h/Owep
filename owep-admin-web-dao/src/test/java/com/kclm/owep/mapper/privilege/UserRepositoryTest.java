package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.User;
import com.kclm.owep.entity.UserRepository;
import com.kclm.owep.mapper.BaseMapperTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends BaseMapperTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserTypeAndIsDelete() {
        List<User> users = userRepository.findByUserTypeAndIsDelete(1, 1);
        System.out.println("user: " + users);
    }
}