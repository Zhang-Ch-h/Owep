package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamMemberSet implements Serializable {

    /*
    * 主键
    * */
    private Integer id;

    /*
    * exam_id (fk)
    * */
    private Exam exam;

    /*
    * user_id(fk)
    * */
    private User user;

    /*
    * class_id(fk)
    * */
    private Clazz clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "ExamMemberSet{" +
                "id=" + id +
                ", exam=" + exam +
                ", user=" + user +
                ", clazz=" + clazz +
                '}';
    }

    public ExamMemberSet() {
    }

}
