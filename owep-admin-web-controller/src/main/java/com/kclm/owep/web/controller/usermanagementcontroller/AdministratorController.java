package com.kclm.owep.web.controller.usermanagementcontroller;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Result;
import com.kclm.owep.entity.User;
import com.kclm.owep.entity.UserRepository;
import com.kclm.owep.service.AdminService;
import com.kclm.owep.service.UserService;
import com.kclm.owep.utils.util.ExportExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class AdministratorController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/adminList")
    public ModelAndView administratorManagement() {
        return new ModelAndView("/user/adminList");
    }

    @GetMapping("/adminList/getTable")
    public List<AdministratorDTO> getAdminTable() {
        return adminService.selectAdministrator();
    }

    @GetMapping("/adminList/search")
    public Object searchAdmin(@RequestParam(name = "userName", required = false) String userName,
                               @RequestParam(name = "realName", required = false) String realName) {
        try {
            List<AdministratorDTO> administratorDTOS = adminService.selectAdministratorByuserNameAndrealName(userName, realName);
            Result result = new Result("200", "查询成功", administratorDTOS);
            log.debug(result.toString());
            return result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result("701", "查询失败", null);
        }

        /*if (administratorDTOS != null) {
            Result result1 = new Result("200", "查询成功", administratorDTO);
            log.debug(result1.toString());
            return result1;
        } else {
            Result result2 = new Result("701", "查询成功", null);
            log.debug(result2.toString());
            return result2;
        }*/
    }

    @GetMapping("/adminList/delete")
    public String deleteAdmin(@RequestParam("id") Integer id) {
        try {
            adminService.deleteAdministrator(id);
            return "删除成功";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "删除失败";
        }
    }

    @GetMapping("/adminList/treeCheck")
    public NodeDTO[] getGroupTreeView(@RequestParam("id") int userId) {//只是个字符串，没有相对应的数据库
        //log.debug("userId:"+userId);
        System.out.println("priv userGroup treeView json sent");
        NodeDTO nodeDTO = adminService.selectAllGroups();//获得完整树表
        List<NodeDTO> nodeList = nodeDTO.getNodes();
        List<Integer> groupIds = adminService.selectGroupsByUserId(userId).getGroupIds();//获得已激活选择支id
        if (groupIds != null) {
            for (Integer id : groupIds) {
                for (NodeDTO node : nodeList) {// 预先勾选从数据库中得到的选择支
                    if (id.equals(node.getTags()))//nodeDto的tags就是user的id
                        node.nodeChecked();
                }
            }
        } else {
            System.out.println("新建用户，无用户组队列");
        }
        NodeDTO[] result = new NodeDTO[1];//新建一个数组
        result[0] = nodeDTO;//把结果包装进数组
        //
        return result;
    }

    @PostMapping(value = "/adminList/treeCheck_edit", produces = "application/json;charset=UTF-8")
    public String postGroupTreeViewEditAction(@RequestBody UserGroupDTO userGroupDTO) {
        System.out.println("priv userGroup treeView edit action");
        Integer userId = userGroupDTO.getUserId();
        List<Integer> groupsIds = userGroupDTO.getGroupIds();
        Map<Integer, List<Integer>> userGroupMap = new HashMap<Integer, List<Integer>>();
        userGroupMap.put(userId, groupsIds);
        adminService.attachGroupToUser(userGroupMap);
        int feedback = adminService.attachGroupToUser(userGroupMap);
        if (feedback == -2) {
            return "同步失败，意料之外的错误";
        }
        return "success";
    }

    @PostMapping("/adminList/addAdmin")
    public ModelAndView addAdmin(@RequestBody User user) {
        adminService.save(user);
        return new ModelAndView("redirect:/user/adminList");
    }

    @PostMapping(value = "/adminList/checkUserName")
    public String checkUserName(HttpServletRequest req) {
        //1. 获取请求参数
        String userName = req.getParameter("userName");
        System.out.println("用户请求的用户名: " + userName);
        //2. 判断
        if (adminService.isUserNameUnique(userName)) {
            return "true";
        } else {
            return "false";
        }
    }

    @PostMapping(value = "/adminList/edit", consumes = "application/json;charset=UTF-8")
    public ModelAndView editAdmin(@RequestBody User user) {
        log.debug("userPwd: " + user.getUserPwd());
        adminService.update(user);
        return new ModelAndView("redirect:/user/adminList");
    }

    @GetMapping("/adminList/switch")
    public String switchAdmin(@RequestParam("userId") int id, @RequestParam("status") int status) {
        try {
            adminService.switchStatus(id, status);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error";
        }
    }

    @PostMapping("/adminList/deleteByGroup")
    public String deleteAdminByGroup(@RequestBody List<Serializable> ids) {
        try {
            adminService.deleteSelect(ids);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "failure";
        }
    }

    @GetMapping("/adminList/export")
    public ResponseEntity<String> export(HttpServletResponse response) {
        try {
            List<Map<String, Object>> userList = new ArrayList<>();

            // 获取所有用户信息
            log.debug("开始导出用户信息");
            List<User> users = userRepository.findByUserTypeAndIsDelete(1, 1);
            log.debug("用户信息获取成功，共" + users.size() + "条");

            // 转换用户信息到可以导出的格式
            log.debug("开始转换用户信息");
            for (User user : users) {
                Map<String, Object> userMap = new HashMap<>();
                userMap.put("sheetName", "管理员信息表");
                userMap.put("id", user.getId() != null ? user.getId() : "N/A");
                userMap.put("username", user.getUserName() != null ? user.getUserName() : "N/A");
                userMap.put("pwd", user.getUserPwd() != null ? user.getUserPwd() : "N/A");
                userMap.put("phone", user.getUserPhone() != null ? user.getUserPhone() : "N/A");
                userMap.put("realname", user.getRealName() != null ? user.getRealName() : "N/A");
                userMap.put("email", user.getUserEmail() != null ? user.getUserEmail() : "N/A");
                userMap.put("emailcode", user.getEmailCode() != null ? user.getEmailCode() : "N/A");
                userMap.put("gender", user.getGender() != null ? user.getGender() : "N/A");
                userMap.put("cardnum", user.getCardNum() != null ? user.getCardNum() : "N/A");
                userMap.put("status", user.getStatus() != null ? user.getStatus() : "N/A");
                userMap.put("effectdate", user.getEffectiveDate() != null ? user.getEffectiveDate() : "N/A");
                userMap.put("usertype", user.getUserType() != null ? user.getUserType() : "N/A");
                userMap.put("birth", user.getBirth() != null ? user.getBirth() : "N/A");
                userMap.put("imgurl", user.getImageUrl() != null ? user.getImageUrl() : "N/A");
                userMap.put("description", user.getDescription() != null ? user.getDescription() : "N/A");
                userMap.put("title", user.getTitle() != null ? user.getTitle() : "N/A");
                userMap.put("perfectstatus", user.getPerfectStatus() != null ? user.getPerfectStatus() : "N/A");
                userMap.put("isdelete", user.getIsDelete() != null ? user.getIsDelete() : "N/A");
                userMap.put("createtime", user.getCreateTime() != null ? user.getCreateTime() : "N/A");
                userMap.put("lastaccesstime", user.getLastAccessTime() != null ? user.getLastAccessTime() : "N/A");
                userMap.put("version", user.getVersion() != null ? user.getVersion() : "N/A");
                // 添加更多字段...
                userList.add(userMap);
            }
            log.debug("用户信息转换成功");

            // 列名和列键
            String[] columnNames = {"编号", "用户名", "密码", "手机号", "真实姓名", "邮箱", "邮箱密码", "性别", "身份证",
                                    "状态", "有效日期", "用户类型", "出生日期", "头像", "描述", "标题", "完美状态", "是否逻辑删除",
                                    "创建时间", "最后访问时间", "版本" /*, 其他列名...*/};
            String[] keys = {"id", "username", "pwd", "phone", "realname", "email", "emailcode", "gender", "cardnum",
                                "status", "effectdate", "usertype", "birth", "imgurl", "description", "title", "perfectstatus",
                                "isdelete", "createtime", "lastaccesstime", "version" /*, 其他键...*/};

            // 创建工作簿
            log.debug("开始创建工作簿");
            Workbook workbook = ExportExcelUtils.createWorkBook(userList, keys, columnNames);
            log.debug("工作簿创建成功");

            // 设置响应头
            log.debug("开始设置响应头");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=AdminInfo.xlsx");
            log.debug("响应头设置成功");

            // 写入到响应输出流
            log.debug("开始写入到响应输出流");
            workbook.write(response.getOutputStream());
            log.debug("写入到响应输出流成功，导出成功");

            return ResponseEntity.ok("导出成功");
        } catch (Exception e) {
            log.debug("导出过程中出现错误：", e);
            return ResponseEntity.status(500).body("服务器内部错误");
        }
    }
}
