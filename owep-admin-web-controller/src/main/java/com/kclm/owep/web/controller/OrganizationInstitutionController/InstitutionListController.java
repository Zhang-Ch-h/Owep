package com.kclm.owep.web.controller.OrganizationInstitutionController;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.entity.Question;
import com.kclm.owep.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class InstitutionListController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/orgList")
    public ModelAndView orgList() {
        return new ModelAndView("/organization/orgList");
    }

    @GetMapping("/allOrganization")
    public List<OrgInstituteDTO> allQuestion() {
        return organizationService.findAllOrg();
    }

    @GetMapping("/getAllOrganizationByKeyWords")
    public List<OrgInstituteDTO> getAllOrganizationByKeyWords(@RequestParam("name") String orgName,
                                                              @RequestParam("type") String orgType) {
        //
        Integer orgTypeInt = null;
        if (orgType.equals("学校机构")) {
            orgTypeInt = 1;
        } else if (orgType.equals("培训机构")) {
            orgTypeInt = 2;
        }
        return organizationService.findAllOrgByKeyWords(orgName, orgTypeInt);
    }

    @GetMapping("/deleteOrganization")
    public String deleteOrganization(@RequestParam("id") Integer id) {
        try {
            organizationService.deleteOrganization(id);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error";
        }
    }

    @PostMapping("/deleteSelectOrg")
    public String deleteSelectOrg(@RequestBody List<Serializable> ids) {
        organizationService.deleteByGroups(ids);
        return "success";
    }

    @PostMapping("/addOrganization")
    public String addOrganization(@RequestBody OrgInstitute orgInstitute) {
        organizationService.save(orgInstitute);
        return "success";
    }

    @GetMapping("/getOrganizationById")
    public OrgInstitute getOrganizationById(@RequestParam("id") Integer id) {
        return organizationService.getOrgById(id);
    }

    @PostMapping("/updateOrganization")
    public String updateOrganization(@RequestParam("id") Integer id, @RequestParam("name") String name,
                                     @RequestParam("type") Integer type) {
        organizationService.update(id, name, type);
        return "success";
    }
}
