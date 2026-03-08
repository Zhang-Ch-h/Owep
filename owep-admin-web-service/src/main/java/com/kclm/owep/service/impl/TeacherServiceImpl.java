package com.kclm.owep.service.impl;

import cn.hutool.core.lang.Assert;
import com.kclm.owep.convert.GroupConvert;
import com.kclm.owep.convert.TeacherConvert;
import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.AdministratorDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.TeacherDTO;
import com.kclm.owep.dto.UserGroupDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.GroupMapper;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherConvert teacherConvert;

    @Autowired
    private GroupConvert groupConvert;

    @Autowired
    private UserConvert userConvert;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<TeacherDTO> selectTeacher() {
        try{
            List<User> users = userMapper.selectByType(3);
            List<TeacherDTO> TeacherDTOS = teacherConvert.toTeacherDTO(users);
            return TeacherDTOS;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<TeacherDTO> selectTeacherByuserNameAndrealName(String userName, String realName) {
        try {
            List<User> user = userMapper.selectUserByuserNameAndrealName(userName, realName, 3); //3:教师
            List<TeacherDTO> TeacherDTOS = teacherConvert.toTeacherDTO(user);
            return TeacherDTOS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteTeacher(Integer id) {
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
        user.setUserType(3); //3:教师
        /********
         * 获取到userName、realName、effectiveTime为后面插入教师数据
         * 到t_teacher_poll表做准备
         */
        //String userName = user.getUserName();
        //String realName = user.getRealName();
        //LocalDateTime effectiveDate = user.getEffectiveDate();
        userMapper.save(user);
        // 等待教师数据插入到t_user总表后再根据总表的唯一性的userName拿到userId
        //Integer id = userMapper.getUserByUserName(userName).getId();
        // 插入数据到t_teacher_poll表
        //teacherPollMapper.insertByUser(realName, id, effectiveDate);
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
