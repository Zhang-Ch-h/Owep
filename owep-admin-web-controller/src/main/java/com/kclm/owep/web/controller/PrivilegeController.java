/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.web.controller;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.*;
import com.kclm.owep.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;

/**
 * @author Artherine
 * @version v1.0
 * @date 2020/6/28 21:15
 * @description 描述权限模块跳转到指定页面
 */

@Controller
@RequestMapping("/privilege")
@Slf4j
//@PreAuthorize("hasAuthority('权限管理')")//只有拥有 【权限管理】权限的用户可以浏览和访问此controller下的服务
public class PrivilegeController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ActionService actionService;

    @Autowired
    private MenuService menuService;

    /***
     * 跳转到用户组管理页面
     * @return
     */
    @GetMapping("/userGroup")
    @PreAuthorize("hasAuthority('16-21')")
    public String toPrivilegeUserGroup(){
        log.debug("跳转视图，权限管理 -> 用户组管理 ");
        return "privilege/userGroup";
    }

    /***
     * 回应用户管理页面的table刷新请求 反馈json对象
     * @return
     */
    @GetMapping(value = "/userGroup_table", produces = "application/json")
    @ResponseBody()
    @PreAuthorize("hasAuthority('16-21')")
    public Object getGroupTable(@RequestParam("offset") int offset){
        //
        List<GroupDTO> groupDTOS = groupService.selectAllGroups(offset);
        //
        log.info("根据offset:{}, 查询所有的用户组： {}", offset, groupDTOS);
        // 返回
        return groupDTOS;
//
    }

    @GetMapping(value = "/userGroup/treeView", produces = "application/json")
    @ResponseBody()
    @PreAuthorize("hasAuthority('16-21')")
    public NodeDTO[] getGroupTreeView(@RequestParam("id") int groupId){//只是个字符串，没有相对应的数据库
        System.out.println("priv userGroup treeView json sent");
        NodeDTO nodeDTO = groupService.selectAllRoles();//获得完整树表
        List<NodeDTO> nodeList = nodeDTO.getNodes();
        List<Integer> roleIds = groupService.selectRolesByGroupId(groupId).getRoleIds();//获得已激活选择支id
        if(roleIds!=null){
            for ( Integer id:roleIds) {
                for ( NodeDTO node : nodeList) {// 预先勾选从数据库中得到的选择支
                    if(id.equals(node.getTags()))//nodeDto的tags就是group的id
                    node.nodeChecked();
                }
            }
        }else{
            System.out.println("新建组，无角色队列");
        }
        NodeDTO[] result = new NodeDTO[1];//新建一个数组
        result[0] = nodeDTO;//把结果包装进数组
        //
        return result;
    }

    @PostMapping(value = "/userGroup/editTreeView", produces = "application/json")
    @ResponseBody()
    @PreAuthorize("hasAuthority('16-23')")
    public String postGroupTreeViewEditAction(@RequestBody GroupRoleDTO groupRoleDTO){
        System.out.println("priv userGroup treeView edit action");
        Integer groupId = groupRoleDTO.getGroupId();
        List<Integer> roleIds = groupRoleDTO.getRoleIds();
        Map<Integer,List<Integer>> groupRoleMap = new HashMap<Integer,List<Integer>>();
        groupRoleMap.put(groupId,roleIds);
        groupService.assignRoleToGroup(groupRoleMap);
        int feedback = groupService.assignRoleToGroup(groupRoleMap);
        if(feedback==-2) {
            return "同步失败，意料之外的错误";
        }
        return "success";
    }

    @GetMapping(value = "/userGroup/toEdit", produces = "application/json")
    @ResponseBody()
    @PreAuthorize("hasAuthority('16-21')")
    public Object getGroupEditInfo(@RequestParam("id") int id){//前端按下编辑键时向前端传对应id的组信息
        System.out.println("priv userGroup Edit info trance  id:"+id);
         return groupService.selectById(id);
    }

    @PostMapping(value = "/userGroup/editGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('16-23')")
    public String postGroupEditAction(Group group){//前端按下编辑键时向前端传对应id的组信息
        System.out.println("priv userGroup Edit action:"+group);
        groupService.saveOrUpdate(group);
        return "privilege/userGroup";
    }

    @PostMapping(value = "/userGroup/addGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('16-22')")
    public String postGroupAddAction(Group group){//前端按下编辑键时向前端传对应id的组信息
        System.out.println("priv userGroup add action");
        System.out.println(group+"object adding");
        if(groupService.saveOrUpdate(group)!=-1){
            System.out.println("add new:"+group);
        }
        return "privilege/userGroup";
    }


    @GetMapping(value = "/userGroup/delete", produces = "application/json")
    @ResponseBody()
    @PreAuthorize("hasAuthority('16-24')")
    public String postGroupDeleteAction(@RequestParam("id") Integer id){
        System.out.println("priv userGroup delete id:"+id);
        List deleteList = new ArrayList<>();
        deleteList.add(id);
        if(groupService.deleteGroup(deleteList)!= -1){//返回值为-1说明删除过程中出错
        System.out.println("Group id<"+id+"> deleted");
        return "success";
        }
        else{
            return "failed";
        }
    }

    @PostMapping(value = "/userGroup/deleteByGroups", produces = "application/json")
    @PreAuthorize("hasAuthority('16-24')")
    @ResponseBody()
    public String postGroupDeleteByGroupsAction(@RequestBody List<Serializable>  idList){
        System.out.println("priv userGroup delete by groups ids:" + idList);
        if(groupService.deleteGroup(idList)!= -1){//返回值为-1说明删除过程中出错
            System.out.println("Group id<"+idList+"> deleted");
            return "success";
        }
        else{
            return "failed";
        }
    }

    /***
     * 跳转到角色管理页面
     * @return
     */
    @GetMapping("/roleList")
    @PreAuthorize("hasAuthority('19-21')")
    public String toPrivilegeRoleList(){
        return "privilege/roleList";
    }

    @GetMapping("/roleList/getTable")
    @PreAuthorize("hasAuthority('19-21')")
    @ResponseBody
    public Object getRoleListTable(@RequestParam("offset") int offset){
        System.out.println("priv roleList getTable");
        List<RoleDTO> roleDTOS = roleService.selectAllRoles(offset);
        System.out.println(roleDTOS);
        return roleDTOS;
    }

    @GetMapping("/roleList/toEditRole")
    @PreAuthorize("hasAuthority('19-21')")
    @ResponseBody
    public Object getRoleEditInfo(@RequestParam("id") int id){
        System.out.println("priv roleList toEdit Info trance");
        RoleDTO roleDTO = roleService.selectById(id);
        System.out.println(roleDTO);
        return roleDTO;
    }

    @PostMapping("/roleList/editRole")
    @PreAuthorize("hasAuthority('19-23')")
    public Object postRoleEditAction(Role role){
        System.out.println("priv roleList role edit action");
        roleService.saveOrUpdate(role);
        return "privilege/roleList";
    }

    @PostMapping("/roleList/addRole")
    @PreAuthorize("hasAuthority('19-22')")
    public Object postRoleAddAction(Role role){
        System.out.println("priv roleList role add action");
        roleService.saveOrUpdate(role);
        return "privilege/roleList";
    }

    @PostMapping("/roleList/deleteRole")
    @PreAuthorize("hasAuthority('19-24')")
    @ResponseBody
    public Object postRoleDeleteAction(@RequestBody Integer id){
        System.out.println("priv roleList role delete action");
        List idList = new ArrayList();
        idList.add(id);
        if(roleService.deleteRole(idList)!=-1){
            System.out.println("Role id<"+id+"> deleted");
            return "success";
        }
        else{
            return "failed";
        }
    }


    @GetMapping("roleList/treeCheck")
    @PreAuthorize("hasAuthority('19-21')")
    @ResponseBody
    public Object getTreeCheckMap(@RequestParam("id") int id){
        NodeDTO nodeDTO = roleService.selectAllDTO();//获取全节点
        //设置预先勾选
        List<NodeDTO> nodes = nodeDTO.getNodes();
        RolePermissionDTO rolePermissionDTO = roleService.selectPermissionByRoleId(id);
        List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
        if (permissionIds!=null){
            for( Integer per_id: permissionIds) {
                for(NodeDTO node:nodes){
                    if (node.getTags().equals(per_id))
                        node.nodeChecked();
                }
            }
        }else{
            System.out.println("empty list, new setting");
        }
        NodeDTO[] data = new NodeDTO[1];
        data[0] = nodeDTO;
        return data;
    }

    @PostMapping(value = "roleList/treeCheck_edit", produces = "application/json")
    @PreAuthorize("hasAuthority('19-23')")
    @ResponseBody
    public String postRoleTreeCheckEditAction(@RequestBody RolePermissionDTO rolePermissionDTO){
        Integer roleId = rolePermissionDTO.getRoleId();
        List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        map.put(roleId,permissionIds);
        roleService.assignPermissionToRole(map);
        return "success";

    }

    @PostMapping(value = "/roleList/deleteByGroups", produces = "application/json")
    @PreAuthorize("hasAuthority('19-24')")
    @ResponseBody()
    public String postRoleDeleteByGroupsAction(@RequestBody List<Serializable>  idList){
        System.out.println("priv userGroup delete by groups ids:" + idList);
        if(roleService.deleteRole(idList)!= -1){//返回值为-1说明删除过程中出错
            System.out.println("Group id<"+idList+"> deleted");
            return "success";
        }
        else{
            return "failed";
        }
    }


       /***
     * 跳转到角色权限页面
     * @return
     */
    @GetMapping("/rolePriv")
    @PreAuthorize("hasAuthority('35-21')")
    public String toPrivilegeRolePriv(){
        return "privilege/rolePriv";
    }


    @GetMapping(value = "/rolePriv/getTable", produces = "application/json")
    @PreAuthorize("hasAuthority('35-21')")
    @ResponseBody
    public Object getPrivTable(@RequestParam("offset") int offset){
        System.out.println("priv rolePriv get table: "+offset);
        List<PermissionDTO> permissionDTOS = permissionService.selectAllPermission(offset);
        System.out.println("rolePriv permiList:"+permissionDTOS);
        return permissionDTOS;
    }

    @PostMapping("/rolePriv/addPerm")
    @PreAuthorize("hasAuthority('35-22')")
    public String postAddPermAction(Permission permission){
        System.out.println("priv rolePriv add perm");
        permissionService.saveOrUpdate(permission);
        return "privilege/rolePriv";
    }

    @GetMapping(value = "/rolePriv/toEditPerm", produces = "application/json")
    @PreAuthorize("hasAuthority('35-21')")
    @ResponseBody
    public Object getEditPermInfo(@RequestParam("id") Integer id){
        System.out.println("priv rolePriv get perm Info trance");
        PermissionDTO permissionDTO = permissionService.selectById(id);
        return permissionDTO;
    }

    @PostMapping("/rolePriv/editPerm")
    @PreAuthorize("hasAuthority('35-23')")
    public String postEditPermAction(Permission permission){
        System.out.println("priv rolePriv edit perm");
        permissionService.saveOrUpdate(permission);
        return "privilege/rolePriv";
    }

    @PostMapping("/rolePriv/deletePerm")
    @PreAuthorize("hasAuthority('35-24')")
    @ResponseBody
    public String postDeletePermAction(@RequestBody Integer id){
        System.out.println("priv rolePriv delete perm id:"+id);
        List idList = new ArrayList();
        idList.add(id);
        if(permissionService.deletePermission(idList)!=-1) {
            return "success";
        }else{
            return "failed";
        }
    }

    @PostMapping(value = "/rolePriv/deleteByGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('35-24')")
    @ResponseBody()
    public Object postDeletePermByGroupsAction(@RequestBody List<Serializable>  idList){
        System.out.println("priv perm delete by groups ids:" + idList);
        if(permissionService.deletePermission(idList)!= -1){//返回值为-1说明删除过程中出错
            System.out.println("Group id<"+idList+"> deleted");
            return "success";
        }else{
            return "failed";
        }
    }

    @GetMapping("rolePriv/treeCheck")
    @PreAuthorize("hasAuthority('35-21')")
    @ResponseBody
    public Object getPermTreeCheckMap(@RequestParam("id") int id){//
        List<NodeDTO> nodeDTOS = permissionService.selectAllMenus();//获取全节点
        List<NodeDTO> nodeList = new ArrayList<NodeDTO>();
        nodeList.addAll(nodeDTOS);
        for(NodeDTO upperNode: nodeDTOS){//取出所有子node集合展开为一维列
            List<NodeDTO> nodes = upperNode.getNodes();
            if(nodes!=null){  nodeList.addAll(nodes);  }
        }
        //设置预先勾选
        PermissionMenuDTO permissionMenuDTO = permissionService.selectMenuByPermissionId(id);
        List<Integer> menuList = permissionMenuDTO.getMenuIds();
        if (menuList!=null){//不为空
            for( Integer menu_id: menuList) {
               for(NodeDTO node : nodeList){
                   if(node.getTags().equals(menu_id)){//遍历id和节点，把id一致的节点激活
                       node.nodeChecked();
                   }
               }
            }
        }else{
            System.out.println("empty list, new setting");
        }
        return nodeDTOS;
    }

    @PostMapping(value = "rolePriv/treeCheck_edit", produces = "application/json")
    @PreAuthorize("hasAuthority('35-23')")
    @ResponseBody
    public String postPermTreeCheckEditAction(@RequestBody PermissionMenuDTO permissionMenuDTO){
        Integer permissionId = permissionMenuDTO.getPermissionId();
        List<Integer> menuIds = permissionMenuDTO.getMenuIds();
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        map.put(permissionId,menuIds);
        permissionService.assignMenuToPermission(map);
        return "success";
    }


    /***
     * 跳转到菜单行为页面
     * @return
     */
    @GetMapping("/menuAction")
    @PreAuthorize("hasAuthority('37-21')")
    public String toPrivilegeMenuAction(){
        return "privilege/menuAction";
    }


    @GetMapping("/menuAction/getTable")
    @PreAuthorize("hasAuthority('37-21')")
    @ResponseBody
    public Object getMenuActionTable(){
        List<MenuDTO> menuDTOS = menuService.selectAllMenu();
        return menuDTOS;
    }

    @GetMapping("/menuAction/treeCheck")
    @PreAuthorize("hasAuthority('37-21')")
    @ResponseBody
    public Object getMenuActionTreeCheckMap(@RequestParam(value = "id",required = false) Integer id){//

        NodeDTO nodeDTO = menuService.selectAllAction();//获取行为全节点
        if(id!=null){
            List<NodeDTO> nodeList = new ArrayList<NodeDTO>();
            nodeList = nodeDTO.getNodes();
            //设置预先勾选
            ActionMenuPermissionDTO actionMenuPermissionDTO = menuService.selectActionAndPermissionByMenuId(id);
            List<Integer> actionIds = actionMenuPermissionDTO.getActionIds();
            if (actionIds!=null){//不为空
                for( Integer action_id: actionIds) {
                    for(NodeDTO node : nodeList){
                        if(node.getTags().equals(action_id)){//遍历id和节点，把id一致的节点激活
                            node.nodeChecked();
                        }
                    }
                }
            }else{System.out.println("empty list, new setting");}//空表提示
        }else{System.out.println("id = null , node only.");}
        List actionNodeList = new ArrayList();
        actionNodeList.add(nodeDTO);

        Object[] dataPack = new Object[3];//包装容器
        dataPack[0]="PermissonName";//第一位置为 string
        dataPack[1]= 14;//第二位置为 int
        dataPack[2]=actionNodeList;//第三位置为行为树状节点链

        return dataPack;
    }

    @PostMapping(value = "/menuAction/treeCheck_edit", produces = "application/json")
    @PreAuthorize("hasAuthority('37-23')")
    @ResponseBody
    public String postMenuActionTreeCheckEditAction(@RequestBody ActionMenuPermissionDTO actionMenuPermissionDTO){
        System.out.println("privilege menuAction treeCheck edit receive:"+actionMenuPermissionDTO);
        Integer menuId = actionMenuPermissionDTO.getMenuId();
        List<Integer> actionIds = actionMenuPermissionDTO.getActionIds();
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        map.put(menuId,actionIds);
        menuService.assignActionToMenu(map);
        return "success";
    }


    /***
     * 跳转到菜单管理页面
     * @return
     */
    @GetMapping("/menuList")
    @PreAuthorize("hasAuthority('38-21')")
    public String toPrivilegeMenuList(){
        return "privilege/menuList";
    }

    @GetMapping("/menuList/getTable")
    @PreAuthorize("hasAuthority('38-21')")
    @ResponseBody
    public Object getMenuListTable(){
        System.out.println("menuList getTable");
        List<MenuDTO> menuDTOS = menuService.selectAllMenu();
        return menuDTOS;
    }

    @GetMapping("/menuList/treeSelect")
    @PreAuthorize("hasAuthority('38-21')")
    @ResponseBody
    public Object getMenuListTreeSelect(){
        List<NodeDTO> nodeDTOS = permissionService.selectAllMenus();
        return nodeDTOS;
    }

    @PostMapping("/menuList/addMenu")
    @PreAuthorize("hasAuthority('38-22')")
    public Object postMenuAddAction(Menu menu ,String parentMenu,Integer parentMenuId){
        System.out.println("priv menuList role add action");
        System.out.println("menu object from web:"+menu);
        System.out.println("parent:"+parentMenu+"." + parentMenuId);

        Menu parent = new Menu();//做个空壳对象
        parent.setId(parentMenuId);//只存id
        parent.setMenuName(parentMenu);
        menu.setParent(parent);//作为parent保存进数据库
        menuService.saveOrUpdate(menu);
        return "privilege/menuList";
    }


    @GetMapping(value = "/menuList/suggest", produces = "application/json")
    @PreAuthorize("hasAuthority('38-21')")
    @ResponseBody
    public Map<String,List<PermissionDTO>> getMenuListSuggest(){
        System.out.println("Priv menuList suggest permissionList");
//        List<PermissionDTO> permissionDTOS = new  List<PermissionDTO>();

        List<PermissionDTO> permissionDTOS = permissionService.selectAllPermission(0);
        System.out.println("permissions we got:"+ permissionDTOS);
        Map<String,List<PermissionDTO>> result = new HashMap();
        result.put("value", permissionDTOS);
        //
        return result;
    }

    @GetMapping("/menuList/treeCheck")
    @PreAuthorize("hasAuthority('38-21')")
    @ResponseBody
    public Object getMenuListTreeCheckMap(@RequestParam(value = "id",required = false) Integer id){//

//        List<PermissionDTO> permissionDTOS = permissionService.selectAllPermission(0);
        NodeDTO nodeDTO = menuService.selectAllAction();//获取行为全节点
        if(id!=null){
            List<NodeDTO> nodeList = new ArrayList<NodeDTO>();
            nodeList = nodeDTO.getNodes();
            //设置预先勾选
            ActionMenuPermissionDTO actionMenuPermissionDTO = menuService.selectActionAndPermissionByMenuId(id);
            List<Integer> actionIds = actionMenuPermissionDTO.getActionIds();
            if (actionIds!=null){//不为空
                for( Integer action_id: actionIds) {
                    for(NodeDTO node : nodeList){
                        if(node.getTags().equals(action_id)){//遍历id和节点，把id一致的节点激活
                            node.nodeChecked();
                        }
                    }
                }
            }else{System.out.println("empty list, new setting");}//空表提示
        }else{System.out.println("id = null , node only.");}
        List actionNodeList = new ArrayList();
        actionNodeList.add(nodeDTO);

        Object[] dataPack = new Object[3];//包装容器
        dataPack[0]="PermissonName";//第一位置为 string
        dataPack[1]= 14;//第二位置为 int
        dataPack[2]=actionNodeList;//第三位置为行为树状节点链

        return dataPack;
    }

    @PostMapping(value = "menuList/treeCheck_edit", produces = "application/json")
    @PreAuthorize("hasAuthority('38-23')")
    @ResponseBody
    public String postMenuListTreeCheckEditAction(@RequestBody ActionMenuPermissionDTO actionMenuPermissionDTO){
        Integer menuId = actionMenuPermissionDTO.getMenuId();
        List<Integer> actionIds = actionMenuPermissionDTO.getActionIds();
        Integer permId = actionMenuPermissionDTO.getPermissionId();
        System.out.println("menuList treeCheck_edit menuId:"+menuId+",actionList:"+actionIds+",permId:"+permId);
//        Integer permId = permissionService.selectByName(permName).get(0).getId();
        System.out.println(actionMenuPermissionDTO);//todo
        menuService.assignActionToMenuAndPermission(actionMenuPermissionDTO);
        return "success";
    }

    @GetMapping("/menuList/toEdit")
    @PreAuthorize("hasAuthority('38-21')")
    @ResponseBody
    public Object getMenuEditInfo(@RequestParam("id") int id){
        System.out.println("priv menuList toEdit Info trance id:"+id);
        MenuDTO menuDTO = menuService.selectById(id);
        return menuDTO;
    }

    @PostMapping("/menuList/editMenu")
    @PreAuthorize("hasAuthority('38-23')")
    public Object postMenuEditAction(Menu menu, String parentMenu, Integer parentMenuId){
        System.out.println("priv menuList role edit action");
        System.out.println("menu object from web:"+menu);
        System.out.println("new parent:"+parentMenu+".[" + parentMenuId+"]");

        Menu parent = new Menu();//做个空壳对象
        parent.setId(parentMenuId);//只存id
        parent.setMenuName(parentMenu);
        menu.setParent(parent);//作为parent保存进数据库
        menuService.saveOrUpdate(menu);
        return "privilege/menuList";
    }


    @PostMapping("/menuList/deleteMenu")
    @PreAuthorize("hasAuthority('38-24')")
    @ResponseBody
    public Object postMenuDeleteAction(@RequestBody Integer id){
        System.out.println("priv menuList menu delete action");
        List idList = new ArrayList();
        idList.add(id);
        if(menuService.deleteMenu(idList)!=-1){
            System.out.println("Role id<"+id+"> deleted");
            return "success";
        }
        else{
            return "failed";
        }
    }


    /***
     * 跳转到行为管理页面
     * @return
     */
    @GetMapping("/actionList")
    @PreAuthorize("hasAuthority('39-21')")
    public String toPrivilegeActionList(){
        return "privilege/actionList";
    }

    @GetMapping("/actionList/getTable")
    @PreAuthorize("hasAuthority('39-21')")
    @ResponseBody
    public Object getActionListTable(@RequestParam("offset") int offset){
        List<ActionDTO> actionDTOS = actionService.selectAllAction(offset);
        return actionDTOS;
    }

    @GetMapping(value = "/actionList/toEdit", produces = "application/json")
    @PreAuthorize("hasAuthority('39-21')")
    @ResponseBody()
    public Object getActionEditInfo(@RequestParam("id") int id){//前端按下编辑键时向前端传对应id的组信息
        System.out.println("priv action Edit info trance  id:"+id);
        return actionService.selectById(id);
    }

    @PostMapping(value = "/actionList/edit", produces = "application/json")
    @PreAuthorize("hasAuthority('39-23')")
    public String postActionEditAction(Action action){//前端按下编辑键时向前端传对应id的组信息
        System.out.println("priv actionList Edit action:"+action);
        actionService.saveOrUpdate(action);
        return "privilege/actionList";
    }

    @PostMapping(value = "/actionList/add", produces = "application/json")
    @PreAuthorize("hasAuthority('39-22')")
    public String postActionAddAction(Action action){//前端按下编辑键时向前端传对应id的组信息
        System.out.println("priv action add action");
        System.out.println(action+"object adding");
        if(actionService.saveOrUpdate(action)!=-1){
            System.out.println("add new:"+action);
        }
        return "privilege/actionList";
    }

    @PostMapping(value = "/actionList/delete", produces = "application/json")
    @PreAuthorize("hasAuthority('39-24')")
    @ResponseBody()
    public String postActionDeleteAction(@RequestBody Integer id){
        System.out.println("priv action delete id:"+id);
        List deleteList = new ArrayList<>();
        deleteList.add(id);
        if(actionService.deleteAction(deleteList)!= -1){//返回值为-1说明删除过程中出错
            System.out.println("Group id<"+id+"> deleted");
            return "success";
        }
        else{
            return "failed";
        }
    }

    @PostMapping(value = "/actionList/deleteByGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('39-24')")
    @ResponseBody()
    public String postActionDeleteByGroupsAction(@RequestBody List<Serializable>  idList){
        System.out.println("priv actionList delete by groups ids:" + idList);
        if(actionService.deleteAction(idList)!= -1){//返回值为-1说明删除过程中出错
            System.out.println("Group id<"+idList+"> deleted");
            return "success";
        }
        else{
            return "failed";
        }
    }

}
