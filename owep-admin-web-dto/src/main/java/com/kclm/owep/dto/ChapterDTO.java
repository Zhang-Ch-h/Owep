/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import com.kclm.owep.entity.Course;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 15:27
 *@Description 章DTO
 *
 */
public class ChapterDTO implements Serializable {

    /**
     *章id
     */
    private Integer id;

    /**
     *章编号
     */
    private String chapterNumber;

    /**
     *章名称
     */
    private String chapterName;

    /**
     *章描述
     */
    private String chapterDesc;

    /**
     * 一个章包含多个节
     */
    private List<SectionDTO> sectionDTOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }


    public List<SectionDTO> getSectionDTOList() {
        return sectionDTOList;
    }

    public void setSectionDTOList(List<SectionDTO> sectionDTOList) {
        this.sectionDTOList = sectionDTOList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChapterDTO{");
        sb.append("id=").append(id);
        sb.append(", chapterNumber='").append(chapterNumber).append('\'');
        sb.append(", chapterName='").append(chapterName).append('\'');
        sb.append(", chapterDesc='").append(chapterDesc).append('\'');
        sb.append(", sectionDTOList=").append(sectionDTOList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterDTO that = (ChapterDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(chapterNumber, that.chapterNumber) &&
                Objects.equals(chapterName, that.chapterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chapterNumber, chapterName);
    }
}
