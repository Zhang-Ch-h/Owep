package com.kclm.owep.web.controller.OrganizationInstitutionController;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.entity.ResponseWrapper;
import com.kclm.owep.entity.Section;
import com.kclm.owep.service.BranchService;
import com.kclm.owep.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/organization")
@Slf4j
public class BranchInstitutionController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/branchList")
    public ModelAndView branchList() {
        return new ModelAndView("/organization/branchList");
    }

    @GetMapping("/allBranch")
    public List<BranchInstitute> allBranch() {
        return branchService.findAllBranch();
    }

    @GetMapping("/getAllBranchByKeyWords")
    public List<BranchInstitute> getAllBranchByKeyWords(@RequestParam("name") String branchName,
                                                              @RequestParam("id") Integer id) {
        //
        return branchService.findAllBranchByKeyWords(branchName, id);
    }

    @GetMapping("/deleteBranch")
    public String deleteBranch(@RequestParam("id") Integer id) {
        try {
            branchService.deleteBranch(id);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error";
        }
    }

    @PostMapping("/deleteSelectBranch")
    public String deleteSelectBranch(@RequestBody List<Serializable> ids) {
        branchService.deleteByGroups(ids);
        return "success";
    }

    @PostMapping("/addBranch")
    public String addBranch(@RequestBody BranchInstitute branchInstitute) {
            branchService.save(branchInstitute);
            return "success";
    }

    @GetMapping("/getBranchById")
    public BranchInstitute getBranchById(@RequestParam("id") Integer id) {
        return branchService.getBranchById(id);
    }

    @PostMapping("/updateBranch")
    public String updateBranch(@RequestParam("id") Integer id, @RequestParam("name") String name,
                                     @RequestParam("orgId") Integer orgId) {
        branchService.update(id, name, orgId);
        return "success";
    }

    @GetMapping("/getAllOrg")
    public ResponseEntity<ResponseWrapper<OrgInstituteDTO>> getAllOrg() {
        List<OrgInstituteDTO> orgs = organizationService.findAllOrg();
        ResponseWrapper<OrgInstituteDTO> wrapper = new ResponseWrapper<>(orgs);
        return ResponseEntity.ok(wrapper);
    }
}
