package com.kclm.owep.service.impl;

import antlr.collections.impl.LList;
import com.kclm.owep.convert.ProfessionConvert;
import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.mapper.BranchInstituteMapper;
import com.kclm.owep.mapper.OrgInstituteMapper;
import com.kclm.owep.mapper.ProfessionMapper;
import com.kclm.owep.service.ProfessionService;
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
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionConvert professionConvert;

    @Autowired
    private ProfessionMapper professionMapper;

    @Autowired
    private OrgInstituteMapper orgInstituteMapper;

    @Autowired
    private BranchInstituteMapper branchInstituteMapper;

    @Override
    public List<ProfessionDTO> selectProfessionList() {
        try {
            List<Profession> professions = professionMapper.selectAll();
            List<ProfessionDTO> professionDTOS = professionConvert.toProfessionDTO(professions);
            return professionDTOS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<OrgInstitute> searchByOrgSuggest() {
        List<OrgInstitute> orgInstitutes = orgInstituteMapper.selectAll();
        return orgInstitutes;
    }

    @Override
    public List<BranchInstitute> searchByBranchSuggest(Integer orgId) {
        List<BranchInstitute> branchInstitutes = branchInstituteMapper.getBranchByOrgId(orgId);
        return branchInstitutes;
    }

    @Override
    public List<ProfessionDTO> searchBySuggestion(String proName, String instituteName, String instituteBranchName) {
        try {
            List<Profession> professions = professionMapper.selectByProNameAndInstituteNameAndInstituteBranchName(proName, instituteName,
                                                                                                            instituteBranchName);
                    List<ProfessionDTO> professionDTOS = professionConvert.toProfessionDTO(professions);
                    return professionDTOS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void save(Profession profession) {
        professionMapper.save(profession);
    }

    @Override
    public void deleteMajor(Integer id) {
        try {
            professionMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteSelect(List<Serializable> ids) {
        try {
            professionMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public Profession findById(Integer id) {
        try {
            return professionMapper.selectById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void update(Profession profession) {
        professionMapper.update(profession);
    }

    @Override
    public void switchProfession(Integer id, Integer status) {
        professionMapper.switchStatus(id, status);
    }
}
