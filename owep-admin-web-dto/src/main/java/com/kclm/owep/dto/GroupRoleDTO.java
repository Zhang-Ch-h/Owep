/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 10:39
 * @description: 用户组和角色
 **/
public class GroupRoleDTO implements Serializable {
    /**
     * 组ID
     */
    private Integer groupId;
    /**
     * 角色ID
     */
    private Integer roleId;

    private List<Integer> roleIds;

    private List<Integer> groupIds;

    public GroupRoleDTO() {
    }

    public GroupRoleDTO(Integer groupId, Integer roleId) {
        this.groupId = groupId;
        this.roleId = roleId;
    }

    public GroupRoleDTO(Integer groupId, Integer roleId, List<Integer> roleIds, List<Integer> groupIds) {
        this.groupId = groupId;
        this.roleId = roleId;
        this.roleIds = roleIds;
        this.groupIds = groupIds;
    }

    @Override
    public String toString() {
        return "GroupRoleDTO{" +
                "groupId=" + groupId +
                ", roleId=" + roleId +
                ", roleIds=" + roleIds +
                ", groupIds=" + groupIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupRoleDTO that = (GroupRoleDTO) o;
        return Objects.equals(groupId, that.groupId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, roleId);
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Integer> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<Integer> groupIds) {
        this.groupIds = groupIds;
    }
}
