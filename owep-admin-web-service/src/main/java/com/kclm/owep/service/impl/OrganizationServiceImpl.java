package com.kclm.owep.service.impl;

import com.kclm.owep.convert.OrgInstituteConvert;
import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.mapper.OrgInstituteMapper;
import com.kclm.owep.service.OrganizationService;
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
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrgInstituteMapper orgInstituteMapper;

    @Autowired
    private OrgInstituteConvert orgInstituteConvert;

    @Override
    public List<OrgInstituteDTO> findAllOrg() {
        try {
            List<OrgInstitute> orgInstitutes = orgInstituteMapper.selectAll();
            return orgInstituteConvert.toOrgInstituteDTO(orgInstitutes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<OrgInstituteDTO> findAllOrgByKeyWords(String orgName, Integer orgTypeInt) {
        try {
            List<OrgInstitute> orgInstitutes = orgInstituteMapper.selectAllByKeyWords(orgName, orgTypeInt);
            return orgInstituteConvert.toOrgInstituteDTO(orgInstitutes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteOrganization(Integer id) {
        try {
            orgInstituteMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteByGroups(List<Serializable> ids) {
        try {
            orgInstituteMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void save(OrgInstitute orgInstitute) {
        try {
            orgInstituteMapper.save(orgInstitute);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public OrgInstitute getOrgById(Integer id) {
        try {
            return orgInstituteMapper.selectById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void update(Integer id, String name, Integer type) {
        try {
            orgInstituteMapper.updateOrg(id, name, type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
