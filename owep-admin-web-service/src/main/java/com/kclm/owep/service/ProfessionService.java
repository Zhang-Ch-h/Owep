package com.kclm.owep.service;

import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.entity.Profession;

import java.io.Serializable;
import java.util.List;

public interface ProfessionService {

    List<ProfessionDTO> selectProfessionList();

    List<OrgInstitute> searchByOrgSuggest();

    List<BranchInstitute> searchByBranchSuggest(Integer orgId);

    List<ProfessionDTO> searchBySuggestion(String proName, String instituteName, String instituteBranchName);

    void save(Profession profession);

    void deleteMajor(Integer id);

    void deleteSelect(List<Serializable> ids);

    Profession findById(Integer id);

    void update(Profession profession);

    void switchProfession(Integer id, Integer status);
}
