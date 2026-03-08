package com.kclm.owep.service.impl;

import cn.hutool.core.lang.Assert;
import com.kclm.owep.convert.AdministratorConvert;
import com.kclm.owep.convert.GroupConvert;
import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.AdministratorDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.UserGroupDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.GroupMapper;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdministratorConvert administratorConvert;

    @Autowired
    private GroupConvert groupConvert;

    @Autowired
    private UserConvert userConvert;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<AdministratorDTO> selectAdministrator() {
        try{
            List<User> users = userMapper.selectByType(1);
            List<AdministratorDTO> administratorDTOS = administratorConvert.toAdministratorDTO(users);
            return administratorDTOS;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<AdministratorDTO> selectAdministratorByuserNameAndrealName(String userName, String realName) {
        try {
            List<User> user = userMapper.selectUserByuserNameAndrealName(userName, realName, 1); //1:管理员
            List<AdministratorDTO> administratorDTOS = administratorConvert.toAdministratorDTO(user);
            return administratorDTOS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteAdministrator(Integer id) {
        try {
            /*List deleteList = new ArrayList<>();
            deleteList.add(id);
            userMapper.deleteByUserIdInUG(deleteList);*/
            userMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public NodeDTO selectAllGroups() {
        //
        List<Group> groups = groupMapper.selectAll();
        //
        List<NodeDTO> nodeDTOS = groupConvert.toNodeDtoList(groups);
        //
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setText("用户组");
        nodeDTO.setNodes(nodeDTOS);
        nodeDTO.setTags(0);
        //
        log.debug("nodeDTO:" + nodeDTO);
        //
        return nodeDTO;
    }

    @Override
    public UserGroupDTO selectGroupsByUserId(Serializable userId) {
        if (userId != null) {
            System.out.println("==========>"+userMapper);
            List<User> users = userMapper.selectGroupsByUserId(userId);
            User user = users.get(0);
            //
            UserGroupDTO userGroupDTO = userConvert.toUserGroupDto(user);
            //
            log.debug("userGroupDTO:" + userGroupDTO);
            //
            return userGroupDTO;
        } else {
            throw new IllegalArgumentException("userId值不合法");
        }
    }

    @Override
    public int attachGroupToUser(Map<Integer, List<Integer>> map) {
        Assert.notNull(map, "map对象不能为空");
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        try {
            for (Map.Entry<Integer,List<Integer>> next : entries) {
                Integer key = next.getKey();
                List<Integer> value = next.getValue();
                userMapper.deleteByUserIdInUG(Arrays.asList(key));
                log.debug("key:" + key + "_value:" + value);
                value.forEach(e -> userMapper.attachGroupToUser(key, e));
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        }
    }

    @Override
    public void save(User user) {
        user.setUserType(1); //1:管理员
        userMapper.save(user);
    }

    @Override
    public boolean isUserNameUnique(String userName) {
        User user = userMapper.getUserByUserName(userName);
        return user == null;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void switchStatus(Integer id, Integer status) {
        userMapper.switchStatus(id, status);
    }

    @Override
    public void deleteSelect(List<Serializable> ids) {
        try {
            /*userMapper.deleteByUserIdInUG(ids);*/
            userMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
