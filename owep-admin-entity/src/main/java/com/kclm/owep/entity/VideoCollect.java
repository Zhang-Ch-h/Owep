/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月08日
 * @Description 视频观看历史
 */


public class VideoCollect implements Serializable {

    /***
     * id(主键)
     */
    private Integer id;

    /***
     * 收藏的学员id（外键）
     */
    private Integer fkStudentId;

    /***
     * 节id（外键）
     */
    private Integer fkSectionId;

    /***
     * 收藏的视频id（外键）
     */
    private Integer fkVideoId;

    /***
     * 课程名称
     */
    private String courseName;

    /***
     * 章名称
     */
    private String chapterName;

    /***
     * 节名称
     */
    private String sectionName;

    /***
     * 创建时间
     */
    private Date createTime;

    /***
     * 最后一次访问时间
     */
    private Date lastAccessTime;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 空参构造
     */
    public VideoCollect() {
    }


    public VideoCollect(Integer id) {
        this.id = id;
    }

    /***
     * 带参构造
     * @param id
     * @param fkStudentId
     * @param fkSectionId
     * @param fkVideoId
     * @param courseName
     * @param chapterName
     * @param sectionName
     * @param createTime
     * @param lastAccessTime
     * @param version
     */
    public VideoCollect(Integer id, Integer fkStudentId, Integer fkSectionId, Integer fkVideoId, String courseName, String chapterName, String sectionName, Date createTime, Date lastAccessTime, Integer version) {
        this.id = id;
        this.fkStudentId = fkStudentId;
        this.fkSectionId = fkSectionId;
        this.fkVideoId = fkVideoId;
        this.courseName = courseName;
        this.chapterName = chapterName;
        this.sectionName = sectionName;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkStudentId() {
        return fkStudentId;
    }

    public void setFkStudentId(Integer fkStudentId) {
        this.fkStudentId = fkStudentId;
    }

    public Integer getFkSectionId() {
        return fkSectionId;
    }

    public void setFkSectionId(Integer fkSectionId) {
        this.fkSectionId = fkSectionId;
    }

    public Integer getFkVideoId() {
        return fkVideoId;
    }

    public void setFkVideoId(Integer fkVideoId) {
        this.fkVideoId = fkVideoId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoCollect)) return false;
        VideoCollect that = (VideoCollect) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCourseName(), that.getCourseName()) &&
                Objects.equals(getChapterName(), that.getChapterName()) &&
                Objects.equals(getSectionName(), that.getSectionName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourseName(), getChapterName(), getSectionName());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VideoCollect{");
        sb.append("id=").append(id);
        sb.append(", fkStudentId=").append(fkStudentId);
        sb.append(", fkSectionId=").append(fkSectionId);
        sb.append(", fkVideoId=").append(fkVideoId);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", chapterName='").append(chapterName).append('\'');
        sb.append(", sectionName='").append(sectionName).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}