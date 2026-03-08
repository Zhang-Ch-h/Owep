package com.kclm.owep.service;

import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface DBCopyService {

    List<DbCopyDTO> findAll();

    List<DbCopyDTO> findByTime(LocalDateTime start, LocalDateTime end);

    boolean backupDatabase();

    DbCopy getById(Serializable id);

    boolean deleteDbCopy(Serializable id);

    Map<String, Object> deleteSelectedDbCopies(List<Serializable> ids);
}
