package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamQuesHard implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * 困难难度
    * */
    private String hardLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHardLevel() {
        return hardLevel;
    }

    public void setHardLevel(String hardLevel) {
        this.hardLevel = hardLevel;
    }

    @Override
    public String toString() {
        return "ExamQuesHard{" +
                "id=" + id +
                ", hardLevel='" + hardLevel + '\'' +
                '}';
    }

    public ExamQuesHard() {
    }

}
