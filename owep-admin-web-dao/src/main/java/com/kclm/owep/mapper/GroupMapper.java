/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Group;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/4 10:36
 * @description:用户组接口
 **/
@Mapper
public interface GroupMapper extends BaseMapper<Group> {
    /**
     * 统计表中数据
     */
    int count();

    /**
     * 根据组名称进行模糊查询
     */
    List<Group> selectByGroupName(String groupName);

    /**
     * 为用户组添加角色，向中间表添加数据
     */
    int assignRoleToGroup(@Param("groupId") Serializable groupId, @Param("roleId") Serializable roleId);

    /**
     * 删除中间表中的某个组已分配的角色
     */
    int deleteByGroupIdInGR(List<Serializable> groupIds);

    /**
     * 删除某个组下的某个角色
     */
    int deleteByGroupIdAndRoleId(@Param("groupId") Serializable groupId, @Param("roleId") Serializable roleId);

    /**
     * 查询某个用户组已经分配好的角色
     * 如若传入0则查询所有
     */
    List<Group> selectRolesByGroupId(@Param("groupId") Serializable groupId);

    /**
     * 查询该组所关联的所有用户
     */
    List<Group> selectUserInGroup(Serializable groupId);

    /**
     * 统计用户组中已经分配的角色 传入0则查询统计所有
     */
    int countRolesByGroupId(Serializable groupId);


}