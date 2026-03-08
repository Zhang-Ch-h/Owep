package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamQuesType implements Serializable {

    /*
    * 主键
    * */
    private int id;

    /*
    * 类型
    * */
    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "ExamQuesType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public ExamQuesType() {
    }

}
