package com.kclm.owep.dto;

import java.util.List;
import java.util.Objects;

public class TemplateItemDTO {
      Integer pollTemplateId;
      List<Integer> pollTemplateIds;
      Integer pollItemId;
      List<Integer> pollItemIds;

    public TemplateItemDTO() {
    }

    public Integer getPollTemplateId() {
        return pollTemplateId;
    }

    public void setPollTemplateId(Integer pollTemplateId) {
        this.pollTemplateId = pollTemplateId;
    }

    public List<Integer> getPollTemplateIds() {
        return pollTemplateIds;
    }

    public void setPollTemplateIds(List<Integer> pollTemplateIds) {
        this.pollTemplateIds = pollTemplateIds;
    }

    public Integer getPollItemId() {
        return pollItemId;
    }

    public void setPollItemId(Integer pollItemId) {
        this.pollItemId = pollItemId;
    }

    public List<Integer> getPollItemIds() {
        return pollItemIds;
    }

    public void setPollItemIds(List<Integer> pollItemIds) {
        this.pollItemIds = pollItemIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateItemDTO that = (TemplateItemDTO) o;
        return Objects.equals(pollTemplateId, that.pollTemplateId) &&
                Objects.equals(pollTemplateIds, that.pollTemplateIds) &&
                Objects.equals(pollItemId, that.pollItemId) &&
                Objects.equals(pollItemIds, that.pollItemIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pollTemplateId, pollTemplateIds, pollItemId, pollItemIds);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TemplateItemDTO{");
        sb.append("pollTemplateId=").append(pollTemplateId);
        sb.append(", pollTemplateIds=").append(pollTemplateIds);
        sb.append(", pollItemId=").append(pollItemId);
        sb.append(", pollItemIds=").append(pollItemIds);
        sb.append('}');
        return sb.toString();
    }
}
