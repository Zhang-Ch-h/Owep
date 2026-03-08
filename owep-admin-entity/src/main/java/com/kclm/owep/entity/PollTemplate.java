/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 考评模板实体类
 */

public class PollTemplate implements Serializable {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 最后访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 考评选项
     */
    private List<PollItem> pollItemList;

    /***
     * 空参构造
     */
    public PollTemplate() {
    }

    /***
     * 有参构造
     * @param templateContent
     * @param templateName
     * @param templateNum
     * @param templateStatus
     */
    public PollTemplate(String templateContent, String templateName, String templateNum, Integer templateStatus) {
        this.templateContent = templateContent;
        this.templateName = templateName;
        this.templateNum = templateNum;
        this.templateStatus = templateStatus;
    }

    /***
     * 全参构造
     * @param id
     * @param templateContent
     * @param templateName
     * @param templateNum
     * @param templateStatus
     * @param createTime
     * @param version
     * @param lastAccessTime
     */
    public PollTemplate(Integer id, String templateContent, String templateName, String templateNum, Integer templateStatus, LocalDateTime createTime, Integer version, LocalDateTime lastAccessTime) {
        this.id = id;
        this.templateContent = templateContent;
        this.templateName = templateName;
        this.templateNum = templateNum;
        this.templateStatus = templateStatus;
        this.createTime = createTime;
        this.version = version;
        this.lastAccessTime = lastAccessTime;
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
        this.templateContent = templateContent == null ? null : templateContent.trim();
    }


    public String getTemplateName() {
        return templateName;
    }


    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }


    public String getTemplateNum() {
        return templateNum;
    }


    public void setTemplateNum(String templateNum) {
        this.templateNum = templateNum == null ? null : templateNum.trim();
    }


    public Integer getTemplateStatus() {
        return templateStatus;
    }


    public void setTemplateStatus(Integer templateStatus) {
        this.templateStatus = templateStatus;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }


    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }


    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
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
        if (!(o instanceof PollTemplate)) return false;
        PollTemplate that = (PollTemplate) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTemplateContent(), that.getTemplateContent()) &&
                Objects.equals(getTemplateName(), that.getTemplateName()) &&
                Objects.equals(getTemplateNum(), that.getTemplateNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTemplateContent(), getTemplateName(), getTemplateNum());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PollTemplate{");
        sb.append("id=").append(id);
        sb.append(", templateContent='").append(templateContent).append('\'');
        sb.append(", templateName='").append(templateName).append('\'');
        sb.append(", templateNum='").append(templateNum).append('\'');
        sb.append(", templateStatus=").append(templateStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}