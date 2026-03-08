/******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权。不得复制转发
 *
 */
package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/********
 *@Author WangSP
 *@Version v1.0
 *@Create 2020/7/13 0013 15:03
 *@Description  资源类型数据传输层
 */
public class ResourceTypeDTO implements java.io.Serializable{

    /**
     * 资源ID
     */
    private Integer id;

    /**
     * 资源类型（名称）
     */
    private String typeName;

    /**
     * 资源描述
     */
    private String typeDesc;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /***
     * 逻辑删除，1表示未删除，0表示已删除
     */
    private Integer isDelete;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResourceTypeDTO{");
        sb.append("id=").append(id);
        sb.append(", typeName='").append(typeName).append('\'');
        sb.append(", typeDesc='").append(typeDesc).append('\'');
        sb.append(", createTime=").append(createTime).append('\'');
        sb.append(", isDelete=").append(isDelete);
        sb.append('}');
        return sb.toString();
    }
}
