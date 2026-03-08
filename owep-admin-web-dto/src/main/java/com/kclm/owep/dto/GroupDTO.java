/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.Group;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 9:56
 * @description: 用户组DTO
 **/
public class GroupDTO {
    private Integer id;
    /**
     * 组名
     */
    private String groupName;
    /**
     * 组描述
     */
    private String groupDescription;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 角色分配上限
     */
    private Integer maxCount;

    public GroupDTO() {
    }

    public GroupDTO(Integer id, String groupName, String groupDescription, LocalDateTime createTime) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.createTime = createTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDTO groupDto = (GroupDTO) o;
        return Objects.equals(id, groupDto.id) &&
                Objects.equals(groupName, groupDto.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupDTO{");
        sb.append("id=").append(id);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", groupDescription='").append(groupDescription).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", maxCount=").append(maxCount);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

}
