package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/616:22
 *@Description 数据库备份实体类
 */
public class DbCopy implements Serializable {
    /**
     * 序列化接口
     */
    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 备份的sql文件名
     */
    private String fileName;

    /**
     * 备份的sql文件路径
     */
    private String filePath;

    /**
     * 备份的状态，1表示成功，0表示失败
     */
    private Integer status;

    /**
     *备份的时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime=LocalDateTime.now();

    /**
     *版本号
     */
    private Integer version=1;

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 构造方法
     */
    public DbCopy() {
    }

    public DbCopy(String fileName, String filePath, Integer status) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }


    public String getFilePath() {
        return filePath;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public String toString() {
        return "DbCopy{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", version=" + version +
                ", lastAccessTime=" + lastAccessTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DbCopy dbCopy = (DbCopy) o;
        return Objects.equals(id, dbCopy.id) &&
                Objects.equals(fileName, dbCopy.fileName) &&
                Objects.equals(filePath, dbCopy.filePath) &&
                Objects.equals(status, dbCopy.status) &&
                Objects.equals(createTime, dbCopy.createTime) &&
                Objects.equals(version, dbCopy.version) &&
                Objects.equals(lastAccessTime, dbCopy.lastAccessTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, filePath, status, createTime, version, lastAccessTime);
    }
}