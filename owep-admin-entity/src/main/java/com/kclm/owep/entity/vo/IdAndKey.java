package com.kclm.owep.entity.vo;

public class IdAndKey {
    private int id;
    private String key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "IdAndKey{" +
                "id=" + id +
                ", key='" + key + '\'' +
                '}';
    }
}
