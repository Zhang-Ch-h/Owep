package com.kclm.owep.service.impl;

import com.kclm.owep.entity.Resource;
import com.kclm.owep.mapper.ResourceMapper;
import com.kclm.owep.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> findResourceByClassId(Integer classId) {
        try {
            return resourceMapper.selectResourceByClassId(classId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteResourceFromClass(Integer cid, Integer rid) {
        try {
            resourceMapper.deleteResourceFromClass(cid, rid);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteSelectResourceFromClass(Integer cid, List<Integer> ridList) {
        try {
            resourceMapper.deleteResourcesFromClass(cid, ridList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Resource> findResourceByKeyword(Integer classId, String resourceName, String resourceTypeName) {
        try {
            return resourceMapper.selectResourceByKeyword(classId, resourceName, resourceTypeName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public Resource findResourceById(Long id) {
        try {
            return resourceMapper.selectById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<Resource> findAll() {
        try {
            return resourceMapper.selectAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void addResourceToClass(Integer cid, Integer rid) {
        try {
            resourceMapper.insertResourceToClass(cid, rid);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Resource> findAllResourceByKeyWord(String resourceName, String resourceType, LocalDateTime startTime, LocalDateTime endTime) {
        try {
            return resourceMapper.selectAllResourceByKeyWord(resourceName, resourceType, startTime, endTime);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void saveSelectedResourceToClass(Integer cid, List<Integer> ridList) {
        try {
            resourceMapper.insertSelectedResourceToClass(cid, ridList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
