/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.PollItem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/13 10:28
 *@Description:考评模板DTO层
 ***/
public class PollTemplateDTO implements Serializable {

    /***
     * 主键
     */
    private Integer id;

    /***
     * 模板内容
     */
    private String templateContent;

    /***
     * 模板名称
     */
    private String templateName;

    /***
     * 模板编号
     */
    private String templateNum;

    /***
     * 模板状态  1.启用 0.未启用
     */
    private Integer templateStatus;

    /***
     * 考评选项
     */
    private List<PollItem> pollItemList;

    /***
     * 空参构造
     */
    public PollTemplateDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateNum() {
        return templateNum;
    }

    public void setTemplateNum(String templateNum) {
        this.templateNum = templateNum;
    }

    public Integer getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(Integer templateStatus) {
        this.templateStatus = templateStatus;
    }

    public List<PollItem> getPollItemList() {
        return pollItemList;
    }

    public void setPollItemList(List<PollItem> pollItemList) {
        this.pollItemList = pollItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PollTemplateDTO)) return false;
        PollTemplateDTO that = (PollTemplateDTO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTemplateContent(), that.getTemplateContent()) &&
                Objects.equals(getTemplateName(), that.getTemplateName()) &&
                Objects.equals(getTemplateNum(), that.getTemplateNum()) &&
                Objects.equals(getTemplateStatus(), that.getTemplateStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTemplateContent(), getTemplateName(), getTemplateNum(), getTemplateStatus());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PollTemplateDTO{");
        sb.append("id=").append(id);
        sb.append(", templateContent='").append(templateContent).append('\'');
        sb.append(", templateName='").append(templateName).append('\'');
        sb.append(", templateNum='").append(templateNum).append('\'');
        sb.append(", templateStatus=").append(templateStatus);
        sb.append('}');
        return sb.toString();
    }
}
