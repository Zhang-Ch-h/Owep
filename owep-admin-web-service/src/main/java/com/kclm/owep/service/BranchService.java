package com.kclm.owep.service;

import com.kclm.owep.entity.BranchInstitute;
import java.io.Serializable;
import java.util.List;

public interface BranchService {

    List<BranchInstitute> findAllBranch();

    List<BranchInstitute> findAllBranchByKeyWords(String branchName, Integer id);

    void deleteBranch(Integer id);

    void deleteByGroups(List<Serializable> ids);

    void save(BranchInstitute branchInstitute);

    BranchInstitute getBranchById(Integer id);

    void update(Integer id, String name, Integer orgId);
}
