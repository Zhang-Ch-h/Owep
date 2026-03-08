package com.kclm.owep.mapper;

import com.kclm.owep.entity.Profession;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProfessionMapper extends BaseMapper<Profession> {

    List<Profession> selectByProNameAndInstituteNameAndInstituteBranchName(@Param("proName") String proName,
                                                                     @Param("instituteName") String instituteName,
                                                                     @Param("instituteBranchName") String instituteBranchName);


    void switchStatus(@Param("id") Integer id, @Param("status") Integer status);

    List<Profession> selectByInstituteNameAndInstituteBranchName(@Param("instituteName") String instituteName,
                                                                 @Param("instituteBranchName") String instituteBranchName);

    Profession selectByProfNameAndInstituteNameAndInstituteBranchName(@Param("profName") String profName, @Param("instituteName") String instituteName,
                                                                      @Param("InstituteBranchName") String instituteBranchName);

    Profession selectByInstituteNameAndInstituteBranchNameAndIsDelete(@Param("instituteName") String instituteName,
                                                                 @Param("instituteBranchName") String instituteBranchName);
}
