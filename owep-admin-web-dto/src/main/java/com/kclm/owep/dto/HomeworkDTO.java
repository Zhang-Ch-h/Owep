/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 11:49
 * @version v1.0
 * @description 班级作业
 *
 */
public class HomeworkDTO {
    private Integer id;
    /***
     * 标题
     */
    private String workTitle;
    /**
     * 内容
     */
    private String workContent;
    /**
     * 文件路径
     */
    private String workFileName;
    /**
     * 所属课程
     */
    private String courseName;
    /**
     * 所属班级
     */
    private String className;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getWorkFileName() {
        return workFileName;
    }

    public void setWorkFileName(String workFileName) {
        this.workFileName = workFileName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkDTO that = (HomeworkDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(workTitle, that.workTitle) &&
                Objects.equals(workContent, that.workContent) &&
                Objects.equals(workFileName, that.workFileName) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(className, that.className) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workTitle, workContent, workFileName, courseName, className, createTime);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HomeworkDTO{");
        sb.append("id=").append(id);
        sb.append(", workTitle='").append(workTitle).append('\'');
        sb.append(", workContent='").append(workContent).append('\'');
        sb.append(", workFileName='").append(workFileName).append('\'');
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
