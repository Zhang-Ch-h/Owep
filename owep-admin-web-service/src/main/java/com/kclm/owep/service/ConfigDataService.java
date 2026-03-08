package com.kclm.owep.service;

import com.kclm.owep.entity.SystemConfig;

public interface ConfigDataService {

    void insertNameAndInfo(String name, String info);

    void insertLoginImage(String fileName);

    void insertSystemImage(String fileName);

    SystemConfig selectPage();
}
