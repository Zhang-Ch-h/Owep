package com.kclm.owep.service;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;

import java.io.Serializable;
import java.util.List;

public interface OrganizationService {
    List<OrgInstituteDTO> findAllOrg();

    List<OrgInstituteDTO> findAllOrgByKeyWords(String orgName, Integer orgTypeInt);

    void deleteOrganization(Integer id);

    void deleteByGroups(List<Serializable> ids);

    void save(OrgInstitute orgInstitute);

    OrgInstitute getOrgById(Integer id);

    void update(Integer id, String name, Integer type);
}
