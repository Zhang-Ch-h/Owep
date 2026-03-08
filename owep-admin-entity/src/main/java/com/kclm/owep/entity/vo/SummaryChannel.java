package com.kclm.owep.entity.vo;

public class SummaryChannel {
    private String value;    //该渠道的客户数量
    private String name;   //客户渠道

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SummeryChannel{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
