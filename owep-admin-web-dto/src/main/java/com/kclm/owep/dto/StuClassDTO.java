package com.kclm.owep.dto;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/*******************
 * @Author zch
 * @Description
 */
@Data
public class StuClassDTO {

    Integer stuId;

    List<Integer> stuIds;

    Integer classId;

    List<Integer> classIds;

    String className;

}
