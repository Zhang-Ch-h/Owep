package com.kclm.owep.convert;

import com.kclm.owep.dto.ActionDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Action;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/******************
 * @author yejf
 * 此接口是基于mapstruct组件技术来完成实体类与DTO之前的映射，包含集合或集合属性都可以。
 */
@Mapper(componentModel = "spring")
public interface ActionConvert {

    /** 实例:用spring IOC管理时，此句可以不用写 */
    ActionConvert instance = Mappers.getMapper(ActionConvert.class);

    /*****
     * 属性名相同时，可以采用默认的映射
     * @param action
     * @return
     */
    ActionDTO toDto(Action action);

    /*******
     * 属性名相同时，可以采用默认的映射，集合也一样, 注意：此方法需要用到上面的 toDto方法
     * 因为集合映射时，会通过循环，来一个一个对象进行映射，也就是会在循环中调用上面的 toDto方法来把Action
     * 转换成 ActionDTO实例。
     * @param actions
     * @return
     */
    List<ActionDTO> toListDto(List<Action> actions);

    /**************
     * 把List<Action>转换成 List<NodeDTO>, 此方法的内部转换，需要使用 actionToNodeDTO
     * 所以， 我们要定义 actionToNodeDTO方法
     * @param actions
     * @return
     */
    List<NodeDTO> toNodeDtoList(List<Action> actions);

    /******
     * 此方法是把 Action映射成为NodeDTO,同时，也是为了上面的 toNodeDtoList方法提供转换功能，上面的
     * 集合转换是需要用到此方法的。
     * @param action
     * @return
     */
    @Mapping(source = "actionName", target = "text")
    @Mapping(source = "id", target = "tags")
    NodeDTO actionToNodeDTO(Action action);
}
