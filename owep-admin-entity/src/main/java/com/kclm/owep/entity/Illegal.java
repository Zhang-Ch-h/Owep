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
 * @Create 2020/7/6 16:17
 * @Description 违纪处理
 */
public class Illegal implements Serializable {
    /**
     *主键
     */
    private Integer id;
    /**
     *版本
     */
    private Integer version = 1;
    /**
     *创建时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();
    /**
     *最后修改时间
     */
    private LocalDateTime lastAccessTime;
    /**
     *老师外键
     */
    private User user;
    //学生id
    /**
     *学生外键
     */
    private Student student;
    /**
     *fk_class_id
     */
    private Clazz clazz;
    /**
     *违纪学生姓名
     */
    private String studentName;
    /**
     *违规时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime disciplineTime;
    /**
     *情况说明
     */
    private String presentationCondition;
    /**
     *证据文件，以学员名#id.扩展名 命名
     */
    private String attachment;

    public Illegal() {
    }

    public Illegal(Integer id, String studentName, LocalDateTime disciplineTime) {
        this.id = id;
        this.studentName = studentName;
        this.disciplineTime = disciplineTime;
    }

    public Illegal(Integer id, User user, Student student, Clazz clazz, String studentName, LocalDateTime disciplineTime) {
        this.id = id;
        this.user = user;
        this.student = student;
        this.clazz = clazz;
        this.studentName = studentName;
        this.disciplineTime = disciplineTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Illegal illegal = (Illegal) o;
        return Objects.equals(id, illegal.id) &&
                Objects.equals(studentName, illegal.studentName) &&
                Objects.equals(disciplineTime, illegal.disciplineTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, disciplineTime);
    }

    @Override
    public String toString() {
        return "Illegal{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", user=" + user +
                ", student=" + student +
                ", clazz=" + clazz +
                ", studentName='" + studentName + '\'' +
                ", disciplineTime=" + disciplineTime +
                ", presentationCondition='" + presentationCondition + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }

    public Clazz getClazz() { return clazz; }

    public void setClazz(Clazz clazz) { this.clazz = clazz; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public LocalDateTime getDisciplineTime() {
        return disciplineTime;
    }

    public void setDisciplineTime(LocalDateTime disciplineTime) {
        this.disciplineTime = disciplineTime;
    }

    public String getPresentationCondition() {
        return presentationCondition;
    }

    public void setPresentationCondition(String presentationCondition) {
        this.presentationCondition = presentationCondition == null ? null : presentationCondition.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}