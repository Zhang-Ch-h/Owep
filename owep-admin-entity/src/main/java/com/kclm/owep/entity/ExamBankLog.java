package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExamBankLog implements Serializable {

    /*
    * 主键
    * */
    private Integer id;

    /*
    * bank_id （fk）
    * */
    private ExamBank examBank;

    /*
    * 操作人
    * */
    private String userName;

    /*
    * 操作时间
    * */
    private LocalDateTime userTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExamBank getExamBank() {
        return examBank;
    }

    public void setExamBank(ExamBank examBank) {
        this.examBank = examBank;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getUserTime() {
        return userTime;
    }

    public void setUserTime(LocalDateTime userTime) {
        this.userTime = userTime;
    }

    @Override
    public String toString() {
        return "ExamBankLog{" +
                "id=" + id +
                ", examBank=" + examBank +
                ", userName='" + userName + '\'' +
                ", userTime=" + userTime +
                '}';
    }

    public ExamBankLog() {
    }

}
