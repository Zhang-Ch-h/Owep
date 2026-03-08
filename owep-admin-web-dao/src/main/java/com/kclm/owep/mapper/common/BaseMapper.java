/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.mapper.common;

import java.io.Serializable;
import java.util.List;

/******************
 * @Author yejf
 * @Version v1.0
 * @Create 2020-07-07 13:48
 * @Description 定义通用的DAO方法，所有的Mapper接口都应该从此接口扩展, 泛型字母T 代表要操作的实体类型
 */
public interface BaseMapper<T> {

    /***********
     * 持久化一个实体对象
     * @param entity
     * @return
     */
    int save(T entity);

    /************
     * 更新实体对象
     * @param entity
     * @return
     */
    int update(T entity);

    /*******
     * 依主键值删除实体对象
     * @param id
     * @return
     */
    int deleteById(Serializable id);

    /*****
     * 依多个主键值，删除多行记录
     * @param idList
     * @return
     */
    int deleteSelect(List<Serializable> idList);

    /*******
     * 依主键查询单个对象
     * @param id
     * @return
     */
    T selectById(Serializable id);

    /************
     * 查询多个对象
     * @return
     */
    List<T> selectAll();

}
