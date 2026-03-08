package com.kclm.owep.web.controller.classcontroller;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.service.ProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.*;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/clazz")
@Slf4j
public class MajorController {

    @Autowired
    private ProfessionService professionService;

    @GetMapping("/major")
    public ModelAndView major() {
        return new ModelAndView("clazz/major");
    }

    @GetMapping("/majorList")
    public List<ProfessionDTO> getMajorTable() {
        return professionService.selectProfessionList();
    }

    @GetMapping("/getAllInstitute")
    public Map<String, Object> searchByOrgInstituteName() {
        List<OrgInstitute> orgInstitutes = professionService.searchByOrgSuggest();

        List<Map<String, Object>> values = new ArrayList<>();
        Set<Map.Entry<String, Object>> seenEntries = new HashSet<>(); // 用于跟踪已见过的键值对

        for (OrgInstitute orgInstitute : orgInstitutes) {
            if (orgInstitute == null) {
                continue;
            }

            Map<String, Object> orgData = new HashMap<>();
            Map<String, Object> tempData = new HashMap<>(); // 临时存储数据
            tempData.put("instituteName", orgInstitute.getInstituteName());
            tempData.put("instituteId", orgInstitute.getId());

            for (Map.Entry<String, Object> entry : tempData.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().toString().isEmpty() && seenEntries.add(entry)) {
                    orgData.put(entry.getKey(), entry.getValue());
                }
            }

            if (!orgData.isEmpty()) {
                values.add(orgData);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "");
        result.put("value", values);
        result.put("code", 200);
        result.put("redirect", "");

        return result;
    }

    @GetMapping("/getBranchByInstitute")
    public Map<String, Object> searchByBranchInstituteName(@RequestParam("id") Integer instituteId) {
        List<BranchInstitute> branchInstitutes = professionService.searchByBranchSuggest(instituteId);

        List<Map<String, Object>> values = new ArrayList<>();
        Set<Map.Entry<String, Object>> seenEntries = new HashSet<>(); // 用于跟踪已见过的键值对

        for (BranchInstitute branchInstitute : branchInstitutes) {
            if (branchInstitute == null) {
                continue;
            }

            Map<String, Object> branchData = new HashMap<>();
            Map<String, Object> tempData = new HashMap<>(); // 临时存储数据
            tempData.put("branchName", branchInstitute.getBranchName());

            for (Map.Entry<String, Object> entry : tempData.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().toString().isEmpty() && seenEntries.add(entry)) {
                    branchData.put(entry.getKey(), entry.getValue());
                }
            }

            if (!branchData.isEmpty()) {
                values.add(branchData);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "");
        result.put("value", values);
        result.put("code", 200);
        result.put("redirect", "");

        return result;
    }

    @GetMapping("/selectByKeyword")
    public List<ProfessionDTO> selectByKeyword(@RequestParam("profName") String proName,
                                         @RequestParam("instituteName") String instituteName,
                                         @RequestParam("instituteBranchName") String instituteBranchName) {
        try {
            return professionService.searchBySuggestion(proName, instituteName, instituteBranchName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @PostMapping("/saveMajor")
    public ModelAndView addMajor(@ModelAttribute Profession profession) {
        professionService.save(profession);
        return new ModelAndView("redirect:/clazz/major");
    }

    @GetMapping("/deleteMajor")
    public String deleteMajor(@RequestParam("id") Integer id) {
        try {
            professionService.deleteMajor(id);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error";
        }
    }

    @PostMapping("/deleteSelectMajor")
    public String deleteSelectMajor(@RequestBody List<Serializable> ids) {
        try {
            professionService.deleteSelect(ids);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error";
        }
    }

    @GetMapping("/toUpdateMajor")
    public Profession toUpdateMajor(@RequestParam("id") Integer id) {
        return professionService.findById(id);
    }

    @PostMapping("/updateMajor")
    public String updateMajor(@ModelAttribute Profession profession) {
        try {
            professionService.update(profession);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error";
        }
    }

    @GetMapping("/professionTrigger")
    public String switchProfession(@RequestParam("id") Integer id, @RequestParam("check") String check) {
        int status;
        if (check.equals("true")) {
            status = 1;
        } else {
            status = 0;
        }
        try {
            professionService.switchProfession(id, status);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error";
        }
    }
}
