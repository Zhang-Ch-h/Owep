package com.kclm.owep.mapper;

import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BranchInstituteMapper extends BaseMapper<BranchInstitute> {

    List<BranchInstitute> getBranchByOrgId(Integer orgId);

    List<BranchInstitute> selectByKeyWords(@Param("name") String branchName, @Param("id") Integer id);

    void updateBranch(@Param("id") Integer id, @Param("name") String name, @Param("orgId") Integer orgId);
}
