package com.kclm.owep.service;


import com.kclm.owep.entity.Resource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ResourceService {

    List<Resource> findResourceByClassId(Integer classId);

    void deleteResourceFromClass(Integer cid, Integer rid);

    void deleteSelectResourceFromClass(Integer cid, List<Integer> ridList);

    List<Resource> findResourceByKeyword(Integer classId, String resourceName, String resourceTypeName);

    Resource findResourceById(Long id);

    List<Resource> findAll();

    void addResourceToClass(Integer cid, Integer rid);

    List<Resource> findAllResourceByKeyWord(String resourceName, String resourceType, LocalDateTime startTime, LocalDateTime endTime);

    void saveSelectedResourceToClass(Integer cid, List<Integer> ridList);
}
