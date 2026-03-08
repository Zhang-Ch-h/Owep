/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Action;

import java.util.List;

import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/7 15:54
 * @description: 行为接口
 **/
@Mapper
public interface ActionMapper extends BaseMapper<Action> {
    /**
     * 统计表中数据
     */
    int count();

    /*
     * 根据行为名称进行模糊查询
     * */
    List<Action> selectByActionName(@Param("actionName") String actionName);


}