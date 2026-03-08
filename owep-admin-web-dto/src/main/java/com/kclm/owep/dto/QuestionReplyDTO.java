/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.Question;
import java.time.LocalDateTime;
import java.util.Objects;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 11:48
 * @version v1.0
 * @description 问题回答
 *
 */
public class QuestionReplyDTO {
    private Integer id;
    /**
     * 回复内容
     */
    private String replyContent;
    /**
     * 回复名字
     */
    private String replyAuthor;
    /**
     * 回复时间
     */
    private LocalDateTime createTime;
    /***
     * 班级问题
     */
    private Question question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyAuthor() {
        return replyAuthor;
    }

    public void setReplyAuthor(String replyAuthor) {
        this.replyAuthor = replyAuthor;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionReplyDTO that = (QuestionReplyDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(replyContent, that.replyContent) &&
                Objects.equals(replyAuthor, that.replyAuthor) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, replyContent, replyAuthor, createTime);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionReplyDTO{");
        sb.append("id=").append(id);
        sb.append(", replyContent='").append(replyContent).append('\'');
        sb.append(", replyAuthor='").append(replyAuthor).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
