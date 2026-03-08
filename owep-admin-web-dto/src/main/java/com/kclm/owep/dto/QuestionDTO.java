/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Profession;

import java.time.LocalDateTime;
import java.util.Objects;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 11:48
 * @version v1.0
 * @description 班级问题
 *
 */
public class QuestionDTO {
    private Integer id;

    /**
     * 专业方向
     */
    private Clazz clazz;

    /**
     * 相关课程
     */
    private String courseName;
    /**
     * 提问时间
     */
    private LocalDateTime createTime;
    /**
     * 提问人
     */
    private String stuName;

    /**
     * 提问内容
     */
    private String questionContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(stuName, that.stuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, stuName);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionDTO{");
        sb.append("id=").append(id);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", stuName='").append(stuName).append('\'');
        sb.append(", questionContent='").append(questionContent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
