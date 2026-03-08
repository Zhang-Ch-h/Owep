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
 * @Create 2020/7/6 16:18
 * @Description 学生评价
 */
public class Evaluate implements Serializable {
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
    private LocalDateTime createTime = LocalDateTime.now();
    /**
     *最后修改时间
     */
    private LocalDateTime lastAccessTime;
    /**
     *老师ID外键
     */
    private User user;
    /**
     *学员外键
     */
    private Student student;
    /**
     *fk_class_id
     */
    private Clazz clazz;
    /**
     *学生姓名
     */
    private String studentName;
    /**
     *状态,1 表示有效，0表示无效
     */
    private Integer evaluateStatus;
    /**
     *评价内容
     */
    private String evaluate;

    public Evaluate() {
    }

    public Evaluate(Integer id, String studentName, Integer evaluateStatus) {
        this.id = id;
        this.studentName = studentName;
        this.evaluateStatus = evaluateStatus;
    }

    public Evaluate(Integer id, User user, Student student,  Clazz clazz, String studentName, Integer evaluateStatus) {
        this.id = id;
        this.user = user;
        this.student = student;
        this.clazz = clazz;
        this.studentName = studentName;
        this.evaluateStatus = evaluateStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluate evaluate = (Evaluate) o;
        return Objects.equals(id, evaluate.id) &&
                Objects.equals(studentName, evaluate.studentName) &&
                Objects.equals(evaluateStatus, evaluate.evaluateStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, evaluateStatus);
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", user=" + user +
                ", student=" + student +
                ", clazz=" + clazz +
                ", studentName='" + studentName + '\'' +
                ", evaluateStatus=" + evaluateStatus +
                ", evaluate='" + evaluate + '\'' +
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

    public Integer getEvaluateStatus() {
        return evaluateStatus;
    }

    public void setEvaluateStatus(Integer evaluateStatus) {
        this.evaluateStatus = evaluateStatus;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }
}