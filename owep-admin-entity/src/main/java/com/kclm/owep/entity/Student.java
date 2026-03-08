/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/*********************
 * @Author: ZhangShaowei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 学生实体类
 */
public class Student {

    /**
     * id
     */
    private Integer id;

    /**
     * 学生用户名
     */
    private String stuName;

    /**
     * 学生密码
     */
    private String stuPwd;

    /**
     * 学号
     */
    private String stuNumber;

    /**
     * 学生手机号码
     */
    private String stuPhone;

    /**
     * 学生邮箱
     */
    private String stuEmail;

    /**
     * 学生真实姓名
     */
    private String stuRealName;

    /**
     * 学生email密文
     */
    private String emailCode;

    /**
     * 学生性别，1表示男，0表示女，-1 表示未知
     */
    private Integer gender;

    /**
     * 学生身份证号码
     */
    private String cardNum;

    /**
     * 学生状态，1表示启用，0表示禁用
     */
    private Integer status;

    /**
     * 学生截止有效期限
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

    /**
     * 学生生日
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birth;

    /**
     * 学生头像图片路径
     */
    private String imageUrl;

    /**
     * 学生描述信息
     */
    private String description;

    /**
     * 学员的类型，如：应届生，往届生
     */
    private String stuType;

    /**
     * 学生就读的大学
     */
    private String stuSchool;

    /**
     * 学生所在的院系
     */
    private String stuCollege;

    /**
     * 学生专业
     */
    private String stuMajor;

    /**
     * 学生学历，枚举，1.博士，2.硕士，3. 本科，4.专科，5.高中，6.中职，7.其它
     */
    private Integer stuEducation;

    /**
     * 英语水平，枚举，1.AB,2.4级，3. 6级，4.8级， 5. 雅思，6，托福
     */
    private Integer englishLevel;

    /**
     * 个人资料是否完善，1表示已完善，0表示未完善
     */
    private Integer perfectStatus;

    /**
     * 是否已经逻辑删除，1表示未删除，0表示已删除
     */
    private Integer isDelete;

    /**
     * 学生创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 学生最后一次访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 外键 ，班级ID
     */
    private Clazz clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getStuNumber() { return stuNumber; }

    public void setStuNumber(String stuNumber) { this.stuNumber = stuNumber; }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuRealName() {
        return stuRealName;
    }

    public void setStuRealName(String stuRealName) {
        this.stuRealName = stuRealName;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public Integer getStuEducation() {
        return stuEducation;
    }

    public void setStuEducation(Integer stuEducation) {
        this.stuEducation = stuEducation;
    }

    public Integer getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(Integer englishLevel) {
        this.englishLevel = englishLevel;
    }

    public Integer getPerfectStatus() {
        return perfectStatus;
    }

    public void setPerfectStatus(Integer perfectStatus) {
        this.perfectStatus = perfectStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", stuName='").append(stuName).append('\'');
        sb.append(", stuPwd='").append(stuPwd).append('\'');
        sb.append(", stuNumber='").append(stuNumber).append('\'');
        sb.append(", stuPhone='").append(stuPhone).append('\'');
        sb.append(", stuEmail='").append(stuEmail).append('\'');
        sb.append(", stuRealName='").append(stuRealName).append('\'');
        sb.append(", emailCode='").append(emailCode).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", cardNum='").append(cardNum).append('\'');
        sb.append(", status=").append(status);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", birth=").append(birth);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", stuType='").append(stuType).append('\'');
        sb.append(", stuSchool='").append(stuSchool).append('\'');
        sb.append(", stuCollege='").append(stuCollege).append('\'');
        sb.append(", stuMajor='").append(stuMajor).append('\'');
        sb.append(", stuEducation=").append(stuEducation);
        sb.append(", englishLevel=").append(englishLevel);
        sb.append(", perfectStatus=").append(perfectStatus);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Student student = (Student) o;
        return id.equals(student.id) &&
                stuName.equals(student.stuName) &&
                stuPwd.equals(student.stuPwd) &&
                stuPhone.equals(student.stuPhone) &&
                stuEmail.equals(student.stuEmail) &&
                stuRealName.equals(student.stuRealName) &&
                emailCode.equals(student.emailCode) &&
                gender.equals(student.gender) &&
                cardNum.equals(student.cardNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stuName, stuPwd, stuPhone, stuEmail, stuRealName, emailCode, gender, cardNum);
    }

    public Student() {
    }

    public Student(String stuName, String stuPwd, String stuNumber, String stuPhone, String stuEmail,
                   String stuRealName, String emailCode, Integer gender, String cardNum, Integer status,
                   LocalDateTime effectiveDate, LocalDateTime birth, String imageUrl, String description,
                   String stuType, String stuSchool, String stuCollege, String stuMajor, Integer stuEducation,
                   Integer englishLevel, Integer perfectStatus, Integer isDelete, LocalDateTime createTime,
                   LocalDateTime lastAccessTime, Integer version) {
        this.stuName = stuName;
        this.stuPwd = stuPwd;
        this.stuNumber = stuNumber;
        this.stuPhone = stuPhone;
        this.stuEmail = stuEmail;
        this.stuRealName = stuRealName;
        this.emailCode = emailCode;
        this.gender = gender;
        this.cardNum = cardNum;
        this.status = status;
        this.effectiveDate = effectiveDate;
        this.birth = birth;
        this.imageUrl = imageUrl;
        this.description = description;
        this.stuType = stuType;
        this.stuSchool = stuSchool;
        this.stuCollege = stuCollege;
        this.stuMajor = stuMajor;
        this.stuEducation = stuEducation;
        this.englishLevel = englishLevel;
        this.perfectStatus = perfectStatus;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
    }
}
