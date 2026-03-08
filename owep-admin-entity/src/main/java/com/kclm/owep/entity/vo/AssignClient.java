package com.kclm.owep.entity.vo;

import java.io.Serializable;
import java.util.List;

public class AssignClient {
    private int teacherId;
    private String teacherName;
    private List<Serializable> clientIds;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Serializable> getClientIds() {
        return clientIds;
    }

    public void setClientIds(List<Serializable> clientIds) {
        this.clientIds = clientIds;
    }

    @Override
    public String toString() {
        return "AssignClient{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", clientIds=" + clientIds +
                '}';
    }
}
