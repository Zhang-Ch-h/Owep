/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/14 9:06
 * @description: 节点
 **/
public class NodeDTO {
    /**
     * 文本信息
     */
    private String text;
    /**
     * 附加信息 放ID
     */
    private Integer tags;
    /**
     * 子节点
     */
    private List<NodeDTO> nodes;


    private State state;
    private class State {
        private Boolean checked = false;
        private Boolean expanded = true;
        State(){}
        public void checkedNode() {
            this.checked = true;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            if (checked != null ? !checked.equals(state.checked) : state.checked != null) return false;
            return expanded != null ? expanded.equals(state.expanded) : state.expanded == null;
        }
        @Override
        public int hashCode() {
            int result = checked != null ? checked.hashCode() : 0;
            result = 31 * result + (expanded != null ? expanded.hashCode() : 0);
            return result;
        }
        @Override
        public String toString() {
            return "State{" +
                    "checked=" + checked +
                    ", expanded=" + expanded +
                    '}';
        }
        public Boolean getChecked() {
            return checked;
        }
        public void setChecked(Boolean checked) {
            this.checked = checked;
        }
        public Boolean getExpanded() {
            return expanded;
        }
        public void setExpanded(Boolean expanded) {
            this.expanded = expanded;
        }
    }

    public NodeDTO() {
        this.state = new State();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeDTO nodeDTO = (NodeDTO) o;
        return Objects.equals(tags, nodeDTO.tags);

    }

    @Override
    public String toString() {
        return "NodeDTO{" +
                "text='" + text + '\'' +
                ", tags=" + tags +
                ", state=" + state +
                ", nodes=" + nodes +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTags() {
        return tags;
    }

    public void setTags(Integer tags) {
        this.tags = tags;
    }

    public List<NodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeDTO> nodes) {
        this.nodes = nodes;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void nodeChecked() {
        this.state.checkedNode();
    }
}
