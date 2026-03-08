/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.io.Serializable;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 15:11
 *@Description 课程分类DTO
 *
 */
public class CourseCategoryDTO implements Serializable {
    /**
     *课程分类id
     */
    private Integer id;

    /**
     *分类名称
     */
    private String categoryName;

    /**
     *分类描述
     */
    private String categoryDesc;

    /**
     *自关联 上级id
     */
    private CourseCategoryDTO courseCategoryDTO;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public CourseCategoryDTO getCourseCategoryDTO() {
        return courseCategoryDTO;
    }

    public void setCourseCategoryDTO(CourseCategoryDTO courseCategoryDTO) {
        this.courseCategoryDTO = courseCategoryDTO;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CourseCategoryDTO{");
        sb.append("id=").append(id);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", categoryDesc='").append(categoryDesc).append('\'');
        sb.append(", courseCategoryDTO=").append(courseCategoryDTO);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCategoryDTO that = (CourseCategoryDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(categoryDesc, that.categoryDesc) &&
                Objects.equals(courseCategoryDTO, that.courseCategoryDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, categoryDesc, courseCategoryDTO);
    }
}
