package com.kclm.owep.service;

import com.kclm.owep.dto.AdministratorDTO;
import com.kclm.owep.dto.AdvisorDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.UserGroupDTO;
import com.kclm.owep.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface AdvisorService {

    List<AdvisorDTO> selectAdvisor();

    List<AdvisorDTO> selectAdvisorByuserNameAndrealName(String userName, String realName);

    void deleteAdvisor(Integer id);

    NodeDTO selectAllGroups();

    UserGroupDTO selectGroupsByUserId(Serializable userId);

    /**
     * 给用户分配用户组；
     * 需要检查分配角色的数量是否大于最大分配量即Group中的属性maxCount。
     * @param map 第一个参数是用户ID 第二个参数是所分配的用户组ID集合
     * @return
     */
    int attachGroupToUser(Map<Integer,List<Integer>> map);

    void save(User user);

    boolean isUserNameUnique(String userName);

    void update(User user);

    void switchStatus(Integer id, Integer status);

    void deleteSelect(List<Serializable> ids);
}
