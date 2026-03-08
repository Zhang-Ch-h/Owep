package com.kclm.owep.entity;

import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
public class ResponseWrapper<T> {
    private List<T> value; // 使用泛型T

    // 构造函数
    public ResponseWrapper(List<T> value) {
        this.value = value;
    }

    // getter 和 setter
    public List<T> getValue() {
        return value;
    }

    public void setValue(List<T> value) {
        this.value = value;
    }
}