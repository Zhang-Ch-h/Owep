package com.kclm.owep.dto;


import lombok.Data;

import java.util.Objects;

@Data
public class VideoDTO {

    private int id;
    //名称
    private String videoMsg;

    //父文件夹
    private int pid;

    //课时
    private  String times;

    //来源
    private String origin;
    //状态
    private String status;

    //
    private Boolean isDir;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoDTO videoDTO = (VideoDTO) o;
        return Objects.equals(id, videoDTO.id) &&
                Objects.equals(videoMsg, videoDTO.videoMsg) &&
                Objects.equals(pid, videoDTO.pid) &&
                Objects.equals(times, videoDTO.times) &&
                Objects.equals(origin, videoDTO.origin) &&
                Objects.equals(status, videoDTO.status) &&
                Objects.equals(isDir, videoDTO.isDir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, videoMsg, pid, times, origin, status, isDir);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VideoDTO{");
        sb.append("id=").append(id);
        sb.append(", videoMsg='").append(videoMsg).append('\'');
        sb.append(", pid=").append(pid);
        sb.append(", times='").append(times).append('\'');
        sb.append(", origin='").append(origin).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", isDir=").append(isDir);
        sb.append('}');
        return sb.toString();
    }
}
