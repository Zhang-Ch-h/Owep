package com.kclm.owep.service.impl;

import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Homework;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.mapper.BranchInstituteMapper;
import com.kclm.owep.mapper.OrgInstituteMapper;
import com.kclm.owep.service.BranchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchInstituteMapper branchInstituteMapper;

    @Override
    public List<BranchInstitute> findAllBranch() {
        try {
            List<BranchInstitute> branchInstitutes = branchInstituteMapper.selectAll();

            for (BranchInstitute branchInstitute : branchInstitutes) {
                // 检查并处理branchInstitute为空的情况
                if (branchInstitute.getOrgInstitute() == null) {
                    branchInstitute.setOrgInstitute(new OrgInstitute());
                }
            }

            return branchInstitutes;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<BranchInstitute> findAllBranchByKeyWords(String branchName, Integer id) {
        try {
            List<BranchInstitute> branchInstitutes = branchInstituteMapper.selectByKeyWords(branchName, id);

            for (BranchInstitute branchInstitute : branchInstitutes) {
                // 检查并处理branchInstitute为空的情况
                if (branchInstitute.getOrgInstitute() == null) {
                    branchInstitute.setOrgInstitute(new OrgInstitute());
                }
            }

            return branchInstitutes;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteBranch(Integer id) {
        try {
            branchInstituteMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteByGroups(List<Serializable> ids) {
        try {
            branchInstituteMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void save(BranchInstitute branchInstitute) {
        try {
            branchInstituteMapper.save(branchInstitute);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public BranchInstitute getBranchById(Integer id) {
        try {
            return branchInstituteMapper.selectById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void update(Integer id, String name, Integer orgId) {
        try {
            branchInstituteMapper.updateBranch(id, name, orgId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
