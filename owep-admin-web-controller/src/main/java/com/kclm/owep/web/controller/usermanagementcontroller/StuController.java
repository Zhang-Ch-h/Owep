package com.kclm.owep.web.controller.usermanagementcontroller;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Result;
import com.kclm.owep.entity.Student;
import com.kclm.owep.entity.User;
import com.kclm.owep.service.StuService;
import com.kclm.owep.utils.util.ExportExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class StuController {

    @Autowired
    private StuService stuService;

    @GetMapping("/stuList")
    public ModelAndView stuManagement() {
        return new ModelAndView("/user/stuList");
    }

    @GetMapping("/stuList/getTable")
    public List<StuManagementDTO> getStuTable() {
        return stuService.selectStudent();
    }

    @RequestMapping("/stuList/stuSuggest")
    public Map<String, Object> searchByStuSuggest() {
        List<StuSuggestDTO> stuSuggestDTOS = stuService.searchByStuSuggest();

        List<Map<String, Object>> values = new ArrayList<>();
        Set<Map.Entry<String, Object>> seenEntries = new HashSet<>(); // 用于跟踪已见过的键值对

        for (StuSuggestDTO dto : stuSuggestDTOS) {
            if (dto == null) {
                continue;
            }

            Map<String, Object> studentData = new HashMap<>();
            Map<String, Object> tempData = new HashMap<>(); // 临时存储数据
            tempData.put("stuRealName", dto.getStuRealName());
            tempData.put("stuSchool", dto.getStuSchool());
            tempData.put("stuCollege", dto.getStuCollege());

            for (Map.Entry<String, Object> entry : tempData.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().toString().isEmpty() && seenEntries.add(entry)) {
                    studentData.put(entry.getKey(), entry.getValue());
                }
            }

            if (!studentData.isEmpty()) {
                values.add(studentData);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "");
        result.put("value", values);
        result.put("code", 200);
        result.put("redirect", "");

        return result;
    }

    @RequestMapping("/stuList/classSuggest")
    public Map<String, Object> searchByClassSuggest() {
        List<ClazzSuggestDTO> clazzSuggestDTOS = stuService.searchByClassSuggest();

        List<Map<String, Object>> values = new ArrayList<>();
        for (ClazzSuggestDTO dto : clazzSuggestDTOS) {
            Map<String, Object> classData = new HashMap<>();
            if (dto.getClassName() != null && !dto.getClassName().isEmpty()) {
                classData.put("className", dto.getClassName());
            }

            if (!classData.isEmpty()) {
                values.add(classData);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "");
        result.put("value", values);
        result.put("code", 200);
        result.put("redirect", "");

        return result;
    }

    @GetMapping("/stuList/treeCheck")
    public NodeDTO[] getClassTreeView(@RequestParam("id") int stuId) {//只是个字符串，没有相对应的数据库
        log.debug("stuId:"+stuId);
        System.out.println("priv userGroup treeView json sent");
        NodeDTO nodeDTO = stuService.selectClass();//获得完整树表
        List<NodeDTO> nodeList = nodeDTO.getNodes();
        Integer classId;
        if (stuService.selectClassByStuId(stuId) != null) {
            classId = stuService.selectClassByStuId(stuId).getClassId(); //获得已激活选择支id
        } else {
            classId = null;
        }
        if (classId != null) {
                for (NodeDTO node : nodeList) {// 预先勾选从数据库中得到的选择支
                    if (classId.equals(node.getTags()))//nodeDto的tags就是user的id
                        node.nodeChecked();
                }
        } else {
            System.out.println("新建学生，无班级队列");
        }
        NodeDTO[] result = new NodeDTO[1];//新建一个数组
        result[0] = nodeDTO;//把结果包装进数组
        //
        return result;
    }

    @PostMapping(value = "/stuList/allocation")
    public String postClassTreeViewEditAction(@RequestParam("stuId") Integer stuId, @RequestParam("classId") Integer classId) {
        log.debug("stuId:"+stuId);
        log.debug("classId:"+classId);
        int result = stuService.classAllocation(stuId, classId);
        if (result == 0) {
            return "success";
        } else {
            return "failure";
        }
    }

    @GetMapping("/stuList/delete")
    public String deleteStu(@RequestParam("id") Integer id) {
        try {
            stuService.deleteStudent(id);
            return "删除成功";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "删除失败";
        }
    }

    @PostMapping("/stuList/deleteByGroup")
    public String deleteStuByGroup(@RequestBody List<Serializable> ids) {
        try {
            stuService.deleteSelect(ids);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "failure";
        }
    }

    @PostMapping(value = "/adminList/checkStuNameAndStuNum")
    public String checkStuNameAndStuNum(HttpServletRequest req) {
        //1. 获取请求参数
        String stuName = req.getParameter("stuName");
        String stuNum = req.getParameter("stuNumber");
        System.out.println("用户请求的用户名: " + stuName);
        System.out.println("用户请求的学号: " + stuNum);
        //2. 判断
        if (!stuService.isStuNameUnique(stuName)) {
            return "nameFalse";
        } else if (!stuService.isStuNumUnique(stuNum)){
            return "numFalse";
        }
        return "true";
    }

    @PostMapping("/stuList/addStudent")
    public ModelAndView addStu(@RequestBody Student student) {
        stuService.save(student);
        return new ModelAndView("redirect:/user/stuList");
    }

    @GetMapping("/stuList/search")
    public Object searchStu(@RequestParam(name = "class", required = false) String className,
                            @RequestParam(name = "name", required = false) String stuRealName,
                            @RequestParam(name = "school", required = false) String school,
                            @RequestParam(name = "college", required = false) String college,
                            @RequestParam(name = "start", required = false) String start,
                            @RequestParam(name = "end", required = false) String end) {
        try {
            List<StuManagementDTO> stuManagementDTOS = stuService.searchByStuAndClass(className, stuRealName, school,
                    college, start, end);
            Result result = new Result("200", "查询成功", stuManagementDTOS);
            log.debug(result.toString());
            return result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result("701", "查询失败", null);
        }
    }

    @PostMapping(value = "/stuList/edit", consumes = "application/json;charset=UTF-8")
    public ModelAndView editStu(@RequestBody Student student) {
        log.debug("stuPwd: " + student.getStuPwd());
        stuService.update(student);
        return new ModelAndView("redirect:/user/stuList");
    }

    // 获取特定学生的班级
    @GetMapping("/stuList/inClass")
    public ResponseEntity<String> getStudentClass(@RequestParam Serializable studentId) {
        String className;
        if (stuService.selectClassByStuId(studentId) != null) {
            className = stuService.selectClassByStuId(studentId).getClassName();
        } else {
            className = null;
        }
        return ResponseEntity.ok(className);
    }

    @RequestMapping("/stuList/otherClassSuggest")
    public Map<String, Object> searchByOtherClassSuggest(@RequestParam Integer studentId) {
        List<ClazzSuggestDTO> clazzSuggestDTOS = stuService.getOtherClassNames(studentId);

        List<Map<String, Object>> values = new ArrayList<>();
        for (ClazzSuggestDTO dto : clazzSuggestDTOS) {
            Map<String, Object> classData = new HashMap<>();
            if (dto.getClassName() != null && !dto.getClassName().isEmpty()) {
                classData.put("className", dto.getClassName());
            }

            if (!classData.isEmpty()) {
                values.add(classData);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "");
        result.put("value", values);
        result.put("code", 200);
        result.put("redirect", "");
        //
        System.out.println("Result: " + result);
        return result;
    }

    @PostMapping("/stuList/transfer")
    public String transferStu(@RequestParam Integer stuId, @RequestParam String className) {
        try {
            if (stuService.isClassNameExist(className)) {
                stuService.transferStu(stuId, className);
                return "success";
            } else {
                return "existFalse";
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "failure";
    }

    @GetMapping("/stuList/switch")
    public String switchStu(@RequestParam("stuId") int stuId, @RequestParam("status") int status) {
        try {
            stuService.switchStatus(stuId, status);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "failure";
    }

    @GetMapping("/stuList/export")
    public ResponseEntity<String> export(HttpServletResponse response) {
        try {
            List<Map<String, Object>> stuList = new ArrayList<>();

            // 获取所有用户信息
            log.debug("开始导出学生信息");
            List<Student> students = stuService.findAll();
            log.debug("用户信息获取成功，共" + students.size() + "条");

            // 转换用户信息到可以导出的格式
            log.debug("开始转换学生信息");
            for (Student stu : students) {
                Map<String, Object> stuMap = new HashMap<>();
                stuMap.put("sheetName", "学生信息表");
                stuMap.put("id", stu.getId() != null ? stu.getId() : "N/A");
                stuMap.put("stuName", stu.getStuName() != null ? stu.getStuName() : "N/A");
                stuMap.put("pwd", stu.getStuPwd() != null ? stu.getStuPwd() : "N/A");
                stuMap.put("stuNum", stu.getStuNumber() != null ? stu.getStuNumber() : "N/A");
                stuMap.put("phone", stu.getStuPhone() != null ? stu.getStuPhone() : "N/A");
                stuMap.put("email", stu.getStuEmail() != null ? stu.getStuEmail() : "N/A");
                stuMap.put("realName", stu.getStuRealName() != null ? stu.getStuRealName() : "N/A");
                stuMap.put("emailCode", stu.getEmailCode() != null ? stu.getEmailCode() : "N/A");
                stuMap.put("gender", stu.getGender() != null ? stu.getGender() : "N/A");
                stuMap.put("cardNum", stu.getCardNum() != null ? stu.getCardNum() : "N/A");
                stuMap.put("status", stu.getStatus() != null ? stu.getStatus() : "N/A");
                stuMap.put("effectDate", stu.getEffectiveDate() != null ? stu.getEffectiveDate() : "N/A");
                stuMap.put("birth", stu.getBirth() != null ? stu.getBirth() : "N/A");
                stuMap.put("imgUrl", stu.getImageUrl() != null ? stu.getImageUrl() : "N/A");
                stuMap.put("description", stu.getDescription() != null ? stu.getDescription() : "N/A");
                stuMap.put("type", stu.getStuType() != null ? stu.getStuType() : "N/A");
                stuMap.put("school", stu.getStuSchool() != null ? stu.getStuSchool() : "N/A");
                stuMap.put("college", stu.getStuCollege() != null ? stu.getStuCollege() : "N/A");
                stuMap.put("stuMajor", stu.getStuMajor() != null ? stu.getStuMajor() : "N/A");
                stuMap.put("education", stu.getStuEducation() != null ? stu.getStuEducation() : "N/A");
                stuMap.put("englishLevel", stu.getEnglishLevel() != null ? stu.getEnglishLevel() : "N/A");
                stuMap.put("perfectStatus", stu.getPerfectStatus() != null ? stu.getPerfectStatus() : "N/A");
                stuMap.put("isDelete", stu.getIsDelete() != null ? stu.getIsDelete() : "N/A");
                stuMap.put("createTime", stu.getCreateTime() != null ? stu.getCreateTime() : "N/A");
                stuMap.put("lastAccessTime", stu.getLastAccessTime() != null ? stu.getLastAccessTime() : "N/A");
                stuMap.put("version", stu.getVersion() != null ? stu.getVersion() : "N/A");
                //
                log.debug("createTime: " + stu.getCreateTime());
                // 添加更多字段...
                stuList.add(stuMap);
            }
            log.debug("学生信息转换成功");

            // 列名和列键
            String[] columnNames = {"编号", "用户名", "密码", "学号", "手机号", "邮箱", "真实姓名", "邮箱密码", "性别",
                    "身份证号码", "状态", "有效期", "出生日期", "头像", "描述", "学生类型", "学校", "学院", "专业", "学历",
                    "英语水平", "完善状态", "是否逻辑删除", "创建时间", "最后访问时间", "版本" /*, 其他列名...*/};
            String[] keys = {"id", "stuName", "pwd", "stuNum", "phone", "email", "realName", "emailCode", "gender",
                    "cardNum", "status", "effectDate", "birth", "imgUrl", "description", "type", "school",
                    "college", "stuMajor", "education", "englishLevel", "perfectStatus", "isDelete", "createTime",
                    "lastAccessTime", "version" /*, 其他键...*/};

            // 创建工作簿
            log.debug("开始创建工作簿");
            Workbook workbook = ExportExcelUtils.createWorkBook(stuList, keys, columnNames);
            log.debug("工作簿创建成功");

            // 设置响应头
            log.debug("开始设置响应头");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=AdminInfo.xlsx");
            log.debug("响应头设置成功");

            // 写入到响应输出流
            log.debug("开始写入到响应输出流");
            workbook.write(response.getOutputStream());
            log.debug("写入到响应输出流成功，导出成功");

            return ResponseEntity.ok("导出成功");
        } catch (Exception e) {
            log.debug("导出过程中出现错误：", e);
            return ResponseEntity.status(500).body("服务器内部错误");
        }
    }

    @GetMapping("/stuList/download-template")
    public ResponseEntity<Resource> downloadTemplate() {
            Resource resource = new ClassPathResource("templates/download/studentInfoTemplate.xlsx");

            if (!resource.exists()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Template not found");
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=StudentInfoTemplate.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
    }

    @PostMapping("/stuList/import")
    public ResponseEntity<String> importExcel(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
            }

            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            List<Student> studentList = new ArrayList<>();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (currentRow.getRowNum() == 0) { // skip header
                    continue;
                }

                // 如果关键列（例如stuName或stuNum）为空，则认为此行及其后面的行都是空行，跳出循环
                if (isCellEmpty(currentRow.getCell(0)) && isCellEmpty(currentRow.getCell(2))) {
                    break;
                }

                Student stu = new Student(
                        getStringValueOrDefault(currentRow.getCell(0), null),
                        getStringValueOrDefault(currentRow.getCell(1), null),
                        getStringValueOrDefault(currentRow.getCell(2), null),
                        getStringValueOrDefault(currentRow.getCell(3), null),
                        getStringValueOrDefault(currentRow.getCell(4), null),
                        getStringValueOrDefault(currentRow.getCell(5), null),
                        getStringValueOrDefault(currentRow.getCell(6), null),
                        getIntegerValueOrDefault(currentRow.getCell(7), null),
                        getStringValueOrDefault(currentRow.getCell(8), null),
                        getIntegerValueOrDefault(currentRow.getCell(9), null),
                        getLocalDateTimeValueOrDefault(currentRow.getCell(10), dateFormatter, null),
                        getLocalDateTimeValueOrDefault(currentRow.getCell(11), dateFormatter, null),
                        getStringValueOrDefault(currentRow.getCell(12), null),
                        getStringValueOrDefault(currentRow.getCell(13), null),
                        getStringValueOrDefault(currentRow.getCell(14), null),
                        getStringValueOrDefault(currentRow.getCell(15), null),
                        getStringValueOrDefault(currentRow.getCell(16), null),
                        getStringValueOrDefault(currentRow.getCell(17), null),
                        getIntegerValueOrDefault(currentRow.getCell(18), null),
                        getIntegerValueOrDefault(currentRow.getCell(19), null),
                        getIntegerValueOrDefault(currentRow.getCell(20), null),
                        getIntegerValueOrDefault(currentRow.getCell(21), null),
                        getDateTimeValueOrDefault(currentRow.getCell(22), dateTimeFormatter, null),
                        getDateTimeValueOrDefault(currentRow.getCell(23), dateTimeFormatter, null),
                        getIntegerValueOrDefault(currentRow.getCell(24), null)
                );

                studentList.add(stu);
            }

            stuService.saveAll(studentList);

            workbook.close();
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded and data saved successfully.");
        } catch (Exception e) {
            log.error("Error while uploading file: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while uploading the file.");
        }
    }

    private String getStringValueOrDefault(Cell cell, String defaultValue) {
        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return defaultValue;
        }

        int cellType = cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_STRING:
                String cellValue = cell.getStringCellValue().trim();
                return cellValue.isEmpty() ? defaultValue : cellValue;
            case Cell.CELL_TYPE_NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            default:
                return defaultValue;
        }
    }

    private Integer getIntegerValueOrDefault(Cell cell, Integer defaultValue) {
        if (cell == null) {
            return defaultValue;
        }

        int cellType = cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_STRING:
                try {
                    return Integer.parseInt(cell.getStringCellValue().trim());
                } catch (NumberFormatException e) {
                    log.error("Error parsing integer value: " + e);
                    return defaultValue;
                }
            case Cell.CELL_TYPE_NUMERIC:
                return (int) cell.getNumericCellValue();
            default:
                return defaultValue;
        }
    }

    private LocalDateTime getLocalDateTimeValueOrDefault(Cell cell, DateTimeFormatter formatter, LocalDateTime defaultValue) {
        try {
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                LocalDate date = convertExcelDateNumberToLocalDate(cell.getNumericCellValue());
                return LocalDateTime.of(date, LocalTime.MIDNIGHT);
            }

            String cellValue = getStringValueOrDefault(cell, "");
            if (cellValue.isEmpty()) {
                return defaultValue;
            }
            LocalDate date = LocalDate.parse(cellValue, formatter);
            return LocalDateTime.of(date, LocalTime.MIDNIGHT); // Set time part to midnight
        } catch (DateTimeParseException e) {
            log.error("Error parsing date value: " + e);
            return defaultValue;
        }
    }

    private LocalDateTime getDateTimeValueOrDefault(Cell cell, DateTimeFormatter formatter, LocalDateTime defaultValue) {
        try {
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                return convertExcelDateNumberToLocalDateTime(cell.getNumericCellValue());
            }

            String cellValue = getStringValueOrDefault(cell, "");
            return cellValue.isEmpty() ? defaultValue : LocalDateTime.parse(cellValue, formatter);
        } catch (Exception e) {
            log.error("Error parsing date-time value: " + e);
            return defaultValue;
        }
    }

    private LocalDate convertExcelDateNumberToLocalDate(double excelDateNumber) {
        LocalDate baseDate = LocalDate.of(1900, 1, 1);
        return baseDate.plusDays((long) excelDateNumber - 2); // minus 2 because Excel thinks 1900 is a leap year, but it's not
    }

    private LocalDateTime convertExcelDateNumberToLocalDateTime(double excelDateNumber) {
        LocalDate baseDate = LocalDate.of(1900, 1, 1);
        long wholeDays = (long) excelDateNumber;
        double fractionalDay = excelDateNumber - wholeDays;

        // Convert Excel date format to LocalDate
        LocalDate date = baseDate.plusDays(wholeDays - 2); // minus 2 because of Excel's leap year bug

        // Convert the fractional day to a LocalTime
        int totalSecondsInDay = 24 * 60 * 60;
        int secondsOfDay = (int) (fractionalDay * totalSecondsInDay);
        LocalTime time = LocalTime.ofSecondOfDay(secondsOfDay);

        return LocalDateTime.of(date, time);
    }

    private boolean isCellEmpty(Cell cell) {
        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return true;
        }
        if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
