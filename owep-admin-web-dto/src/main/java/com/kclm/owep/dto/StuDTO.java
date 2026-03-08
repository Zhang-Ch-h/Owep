package com.kclm.owep.dto;

public class StuDTO {
    private Integer id;
    private  String stuName;
    private  String stuPassword;

    public StuDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StuDTO{");
        sb.append("id=").append(id);
        sb.append(", stuName='").append(stuName).append('\'');
        sb.append(", stuPassword='").append(stuPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
