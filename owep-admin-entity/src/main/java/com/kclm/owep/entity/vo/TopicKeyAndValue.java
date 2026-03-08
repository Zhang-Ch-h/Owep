package com.kclm.owep.entity.vo;

import java.util.List;

public class TopicKeyAndValue {
    private Integer key;
    private List<QuesAneswerSet> value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public List<QuesAneswerSet> getValue() {
        return value;
    }

    public void setValue(List<QuesAneswerSet> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TopicKeyAndValue{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
