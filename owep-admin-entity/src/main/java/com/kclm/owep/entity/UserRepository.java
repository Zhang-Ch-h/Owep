package com.kclm.owep.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserType(Integer userType);

    // 新增的方法
    List<User> findByUserTypeAndIsDelete(Integer userType, Integer isDelete);
}
