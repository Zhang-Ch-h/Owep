/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/6 16:32
 * @Description 文档管理实体类
 */
@Data
public class Resource {

    /***
     * 主键ID
     */
    private Integer id;

    /***
     * 资源名称
     */
    private String resourceName;

    /***
     * 资源类型，0.表示课程资源，1.表示公共资源
     */
    private Integer type;

    /***
     * 资源扩展名（类型），如pdf、docx、ppt、md等
     */
    private String resourceSuffix;

    /***
     * 资源大小
     */
    private Integer resourceSize;

    /***
     * 资源标题（空）
     */
    private String resourceTitle;

    /***
     * 文件路径
     */
    private String resourcePath;

    /***
     * 资源标签
     */
    private String resourceLabel;

    /***
     * 资源描述
     */
    private String resourceDesc;

    /***
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();

    /***
     * 逻辑删除，1.表示未删除，0表示已删除
     */
    private Integer isDelete;

    /***
    * 节
    */
    private Section section;

    /***
     * 章
     */
    private Chapter chapter;

    /***
     * 课程
     */
    private Course course;

    /***
     * 资源类型
     */
    private ResourceType resourceType;

    /***
     * 旧资源名称
     */
    private Integer oldResourcename;

    /***
     * 版本号
     */
    private Integer version=1;

    /***
     * 最后一次访问时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getResourceSuffix() {
        return resourceSuffix;
    }

    public void setResourceSuffix(String resourceSuffix) {
        this.resourceSuffix = resourceSuffix;
    }

    public Integer getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourceLabel() {
        return resourceLabel;
    }

    public void setResourceLabel(String resourceLabel) {
        this.resourceLabel = resourceLabel;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getOldResourcename() {
        return oldResourcename;
    }

    public void setOldResourcename(Integer oldResourcename) {
        this.oldResourcename = oldResourcename;
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

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id) &&
                Objects.equals(resourceName, resource.resourceName) &&
                Objects.equals(type, resource.type) &&
                Objects.equals(resourceSuffix, resource.resourceSuffix) &&
                Objects.equals(resourceSize, resource.resourceSize) &&
                Objects.equals(resourceTitle, resource.resourceTitle) &&
                Objects.equals(resourcePath, resource.resourcePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceName, type, resourceSuffix, resourceSize, resourceTitle, resourcePath);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Resource{");
        sb.append("id=").append(id);
        sb.append(", resourceName='").append(resourceName).append('\'');
        sb.append(", type=").append(type);
        sb.append(", resourceSuffix='").append(resourceSuffix).append('\'');
        sb.append(", resourceSize=").append(resourceSize);
        sb.append(", resourceTitle='").append(resourceTitle).append('\'');
        sb.append(", resourcePath='").append(resourcePath).append('\'');
        sb.append(", resourceLabel='").append(resourceLabel).append('\'');
        sb.append(", resourceDesc='").append(resourceDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", oldResourcename=").append(oldResourcename);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }

}
