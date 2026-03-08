package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExamLog implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * exam_id(fk)
    * */
    private Exam exam;

    /*
    * user_id(fk)
    * */
    private User user;

    /*
    * 该用户的开考时间
    * */
    private LocalDateTime userStart;

    /*
    * 该用户的结束时间
    * */
    private LocalDateTime userEnd;

    /*
    * 该用户的ip地址
    * */
    private String userIp;

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

    public LocalDateTime getUserStart() {
        return userStart;
    }

    public void setUserStart(LocalDateTime userStart) {
        this.userStart = userStart;
    }

    public LocalDateTime getUserEnd() {
        return userEnd;
    }

    public void setUserEnd(LocalDateTime userEnd) {
        this.userEnd = userEnd;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Override
    public String toString() {
        return "ExamLog{" +
                "id=" + id +
                ", exam=" + exam +
                ", user=" + user +
                ", userStart=" + userStart +
                ", userEnd=" + userEnd +
                ", userIp='" + userIp + '\'' +
                '}';
    }

    public ExamLog() {
    }

}
