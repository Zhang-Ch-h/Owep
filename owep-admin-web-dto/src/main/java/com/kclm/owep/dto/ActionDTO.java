/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.Action;

import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 15:52
 * @description: 行为DTO
 **/
public class ActionDTO extends Action {
    private Integer id;
    /**
     * 行为名
     */
    private String actionName;
    /**
     * 行为描述
     */
    private String actionDescription;
    /**
     * 行为url
     */
    private String actionUrl;

    public ActionDTO() {
    }

    public ActionDTO(String actionName, String actionDescription, String actionUrl) {
        this.actionName = actionName;
        this.actionDescription = actionDescription;
        this.actionUrl = actionUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ActionDTO{");
        sb.append("id=").append(id);
        sb.append(", actionName='").append(actionName).append('\'');
        sb.append(", actionDescription='").append(actionDescription).append('\'');
        sb.append(", actionUrl='").append(actionUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ActionDTO actionDTO = (ActionDTO) o;
        return Objects.equals(id, actionDTO.id) &&
                Objects.equals(actionName, actionDTO.actionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, actionName);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getActionName() {
        return actionName;
    }

    @Override
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public String getActionDescription() {
        return actionDescription;
    }

    @Override
    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    @Override
    public String getActionUrl() {
        return actionUrl;
    }

    @Override
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
}
