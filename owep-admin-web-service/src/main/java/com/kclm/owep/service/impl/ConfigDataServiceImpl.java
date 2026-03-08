package com.kclm.owep.service.impl;

import com.kclm.owep.entity.SystemConfig;
import com.kclm.owep.mapper.ConfigDataMapper;
import com.kclm.owep.service.ConfigDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class ConfigDataServiceImpl implements ConfigDataService {

    @Autowired
    private ConfigDataMapper configDataMapper;

    @Override
    public void insertNameAndInfo(String name, String info) {
        try {
            configDataMapper.updateNameAndInfo(name, info);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void insertLoginImage(String fileName) {
        try {
            configDataMapper.insertLoginImage(fileName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void insertSystemImage(String fileName) {
        try {
            configDataMapper.insertSystemImage(fileName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public SystemConfig selectPage() {
        try {
            return configDataMapper.selectPage();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
