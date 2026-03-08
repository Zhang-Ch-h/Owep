/*********************
 * 2018-2021 版权所有 CopyRight（c） 快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/6 18:06
 * @Description 学员作业完成
 */
public class HomeworkAnswer implements Serializable {
    /**
     *主键
     */
    private Integer id;

    /**
     *代码作业提交的git地址
     */
    private String answerUrl;

    /**
     *答案内容
     */
    private String answerContent;

    /**
     *学员所上传的作业附件
     */
    private String answerAttachment;

    /**
     *作业状态，1表示已完成，0表示未完成
     */
    private Integer answerStatus;

    /**
     *审核内容
     */
    private String auditContent;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *最后一次修改时间
     */
    private LocalDateTime lastAccessTime;

    /**
     *版本号
     */
    private Integer version = 1;

    /**
     *外键，作业id
     */
    private Homework homework;

    /**
     *外键，学员id
     */
    private Student student;

    public HomeworkAnswer() {
    }

    public HomeworkAnswer(Integer id, String answerContent, Integer answerStatus) {
        this.id = id;
        this.answerContent = answerContent;
        this.answerStatus = answerStatus;
    }

    public HomeworkAnswer(Integer id, Integer answerStatus, Homework homework, Student student) {
        this.id = id;
        this.answerStatus = answerStatus;
        this.homework = homework;
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkAnswer that = (HomeworkAnswer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(answerStatus, that.answerStatus) &&
                Objects.equals(homework, that.homework) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerStatus, homework, student);
    }

    @Override
    public String toString() {
        return "HomeworkAnswer{" +
                "id=" + id +
                ", answerUrl='" + answerUrl + '\'' +
                ", answerContent='" + answerContent + '\'' +
                ", answerAttachment='" + answerAttachment + '\'' +
                ", answerStatus=" + answerStatus +
                ", auditContent='" + auditContent + '\'' +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", version=" + version +
                ", homework=" + homework +
                ", student=" + student +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerUrl() {
        return answerUrl;
    }

    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl == null ? null : answerUrl.trim();
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public String getAnswerAttachment() {
        return answerAttachment;
    }

    public void setAnswerAttachment(String answerAttachment) {
        this.answerAttachment = answerAttachment == null ? null : answerAttachment.trim();
    }

    public Integer getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(Integer answerStatus) {
        this.answerStatus = answerStatus;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}