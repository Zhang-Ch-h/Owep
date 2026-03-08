/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.convert.ActionConvert;
import com.kclm.owep.dto.ActionDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.mapper.ActionMapper;
import com.kclm.owep.mapper.MenuMapper;
import com.kclm.owep.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/15 10:45
 * @description:
 **/
@Service
@Slf4j
public class ActionServiceImpl implements ActionService {
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ActionConvert actionConvert;

    @Override
    public int saveOrUpdate(Action action) {
        Assert.notNull(action.getActionName(), "group对象不能为空");
        log.debug("action:" + action.toString());
        Integer id = action.getId();
        if (id == null) {
            return actionMapper.save(action);

        } else if (id > 0) {
            return actionMapper.update(action);
        }
        return -1;
    }

    @Override
    public int deleteAction(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");
        //todo 此方法存在bug
        menuMapper.deleteByActionIdInAPM(ids);
        //
        log.debug("ids:" + ids.size());
        if (ids.size() == 1) {
            return actionMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {
            return actionMapper.deleteSelect(ids);
        }
        return -1;
    }

    @Override
    public ActionDTO selectById(Serializable id) {
        if (id != null) {
            Action action = actionMapper.selectById(id);
            //
            return actionConvert.toDto(action);
        } else {
            throw new IllegalArgumentException("id值不合法");
        }
    }

    @Override
    public List<ActionDTO> selectAllAction(int pageNum) {
        if (pageNum >= 0) {
            //PageHelper.startPage(pageNum, PAGE_SIZE);
            List<Action> actions = actionMapper.selectAll();
            //
            return actionConvert.toListDto(actions);
        } else {
            throw new IllegalArgumentException("pageNum值不合法");
        }

    }
}
