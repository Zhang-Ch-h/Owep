/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.ActionDTO;
import com.kclm.owep.entity.Action;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 16:14
 * @description: 行为
 **/

public interface ActionService {
    int PAGE_SIZE=10;

    /**
     * 添加或更新行为，根据id是否为空来选择执行哪种方法。
     * @param action
     * @return 大于0执行成功；等于或小于0执行失败。
     */
    int saveOrUpdate(Action action);

    /**
     * 删除单个或批量删除行为记录。
     * @param ids
     * @return 大于0执行成功；等于或小于0执行失败。
     */
    int deleteAction(List<Serializable> ids);

    /**
     * 根据id来查询。
     * @param id
     * @return
     */
    ActionDTO selectById(Serializable id);

    /**
     * 分页查询行为记录。
     * @param pageNum
     * @return 返回当前页的10条记录。
     */
    List<ActionDTO> selectAllAction(int pageNum);

}
