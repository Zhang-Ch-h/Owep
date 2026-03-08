/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.GroupDTO;
import com.kclm.owep.dto.GroupRoleDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.RoleDTO;
import com.kclm.owep.entity.Group;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 9:19
 * @description: 用户组接口
 **/

public interface GroupService {
    int PAGE_SIZE=10;
    /**
     * 添加或更新用户组;若group中的id有值则执行更新 id为空则执行添加。
     * @param group
     * @return 大于0则执行成功  等于或小于0执行失败
     */
    int saveOrUpdate(Group group);

    /**
     * 删除用户组,需要删除中间表数据
     * @param ids
     * @return  大于0则执行成功  等于或小于0执行失败
     */
    int deleteGroup(List<Serializable> ids);

    /**
     * 根据传入的name进行模糊查询
     * @param name
     * @return 用户组DTO
     */
    List<GroupDTO> selectByName(String name);

    /**
     * 根据id查询用户组
     * @param id
     * @return 用户组DTO
     */
    GroupDTO selectById(Serializable id);

    /**
     * 根据传入的pageNum，查询出相应数量用户组
     * @param pageNum
     * @return 返回当前页的10条数据
     */
    List<GroupDTO>  selectAllGroups(int pageNum);

    /**
     * 根据用户组的ID查询出已分配好的角色
     * @param groupId
     * @return
     */
    GroupRoleDTO selectRolesByGroupId(Serializable groupId);
    /**
     * 给用户组分配角色；
     * 往中间表插入数据，在插入之前需要先把某组分配的好角色的全部删除
     * 需要检查分配角色的数量是否大于最大分配量即Group中的属性maxCount。
     * @param map 第一个参数是组ID 第二个参数是所分配的角色ID集合
     * @return 大于0则执行成功  等于或小于0执行失败 其中-2
     */
    int assignRoleToGroup(Map<Integer,List<Integer>> map);
    /**
     * 查询所有的角色，需要构建Node对象进行值的映射(前端treeview框架中需要指定的数据类型)
     * 写死一个text为角色的对象，在其子（list）集中写入数据库中所拥有的角色。
     * @return 返回角色组DTO的集合
     */
    NodeDTO selectAllRoles();
}
