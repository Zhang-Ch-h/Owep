/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.Permission;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 13:59
 * @description: 角色权限DTO
 **/
public class PermissionDTO extends Permission {
    private Integer id;
    /**
     * 权限名
     */
    private String permissionName;
    /**
     * 权限描述
     */
    private String permissionDescription;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public PermissionDTO() {
    }

    public PermissionDTO(String permissionName, String permissionDescription) {
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PermissionDTO{");
        sb.append("id=").append(id);
        sb.append(", permissionName='").append(permissionName).append('\'');
        sb.append(", permissionDescription='").append(permissionDescription).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermissionDTO that = (PermissionDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(permissionName, that.permissionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, permissionName);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getPermissionName() {
        return permissionName;
    }

    @Override
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String getPermissionDescription() {
        return permissionDescription;
    }

    @Override
    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    @Override
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
