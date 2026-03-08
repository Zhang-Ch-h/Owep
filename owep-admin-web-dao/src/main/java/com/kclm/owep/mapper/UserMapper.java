package com.kclm.owep.mapper;

import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /*************
     *
     * @param userName
     * @return
     */
    User selectByName(@Param("userName")String userName );

    List<User> selectByType(@Param("type") Integer type);

    List<Integer> getGroupId(Serializable id);

    /**
     * 为用户分配用户组，向中间表添加数据
     */
    int attachGroupToUser(@Param("uid") Serializable uid , @Param("gid") Serializable gid);

    User getUserByUserName(String userName);

    List<User> getUserByTeacherRealName(String realName);
    //

    List<User> selectUserByuserNameAndrealName(@Param("userName") String userName, @Param("realName") String realName, @Param("userType") Integer userType);

    List<User> selectGroupsByUserId(@Param("userId") Serializable userId);

    /********
     * 删除中间表中的某个用户已分配的用户组
     */
    int deleteByUserIdInUG(List<Serializable> userIds);

    void switchStatus(@Param("id") Integer id, @Param("status") Integer status);
}
