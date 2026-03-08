package com.kclm.owep.service;

import com.kclm.owep.entity.SystLog;

import java.time.LocalDateTime;
import java.util.List;

public interface SysLogService {

    List<SystLog> getAll();

    void save(SystLog systLog);

    List<SystLog> getByKeyWords(String userName, LocalDateTime start, LocalDateTime end);
}
