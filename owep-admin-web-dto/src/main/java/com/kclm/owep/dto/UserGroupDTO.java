package com.kclm.owep.dto;


import java.util.List;

/***
 * By:Artherine
 */
public class UserGroupDTO {

    Integer userId;
    List<Integer> userIds;
    Integer groupId;
    List<Integer> groupIds;

    public UserGroupDTO() {}

    @Override
    public String toString() {
        return "UserGroupDTO{" +
                "userId=" + userId +
                ", userIds=" + userIds +
                ", groupId=" + groupId +
                ", groupIds=" + groupIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroupDTO)) return false;

        UserGroupDTO that = (UserGroupDTO) o;

        if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
        if (getUserIds() != null ? !getUserIds().equals(that.getUserIds()) : that.getUserIds() != null) return false;
        if (getGroupId() != null ? !getGroupId().equals(that.getGroupId()) : that.getGroupId() != null) return false;
        return getGroupIds() != null ? getGroupIds().equals(that.getGroupIds()) : that.getGroupIds() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getUserIds() != null ? getUserIds().hashCode() : 0);
        result = 31 * result + (getGroupId() != null ? getGroupId().hashCode() : 0);
        result = 31 * result + (getGroupIds() != null ? getGroupIds().hashCode() : 0);
        return result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public List<Integer> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<Integer> groupIds) {
        this.groupIds = groupIds;
    }
}
