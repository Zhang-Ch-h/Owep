package com.kclm.owep.web.controller.classcontroller;

import com.kclm.owep.dto.ClassStuDTO;
import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.*;
import com.kclm.owep.service.ClassListService;
import com.kclm.owep.service.ProfessionService;
import com.kclm.owep.service.ResourceService;
import com.kclm.owep.service.StuService;
import com.kclm.owep.web.controller.ftp.FTPUtil;
import com.kclm.owep.web.controller.ftp.FtpProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/clazz")
@Slf4j
public class ClassListController {

    @Autowired
    private ClassListService classListService;

    @Autowired
    private StuService stuService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/clazzList")
    public ModelAndView clazzList() {
        return new ModelAndView("clazz/clazzList");
    }

    @GetMapping("/allClazz")
    public List<Clazz> getClazzTable() {
        return classListService.selectClassList();
    }

    @GetMapping("/getProfession")
    public Map<String, Object> getProfessionSuggest(@RequestParam("instituteName") String instituteName,
                                                    @RequestParam("instituteBranchName") String instituteBranchName) {
        List<Profession> professionDTOS = classListService.getProfessionSuggest(instituteName, instituteBranchName);

        List<Map<String, Object>> values = new ArrayList<>();
        Set<Map.Entry<String, Object>> seenEntries = new HashSet<>(); // 用于跟踪已见过的键值对

        for (Profession profession : professionDTOS) {
            if (profession == null) {
                continue;
            }

            Map<String, Object> proData = new HashMap<>();
            Map<String, Object> tempData = new HashMap<>(); // 临时存储数据
            tempData.put("profName", profession.getProfName());
            tempData.put("id", profession.getId());

            for (Map.Entry<String, Object> entry : tempData.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().toString().isEmpty() && seenEntries.add(entry)) {
                    proData.put(entry.getKey(), entry.getValue());
                }
            }

            if (!proData.isEmpty()) {
                values.add(proData);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "");
        result.put("value", values);
        result.put("code", 200);
        result.put("redirect", "");

        return result;
    }

    @GetMapping("/findAllPlanManager")
    public Map<String, Object> findAllPlanManager() {
        List<PlanManager> planManagers = classListService.getPlanManagerSuggest();

        List<Map<String, Object>> values = new ArrayList<>();
        Set<Map.Entry<String, Object>> seenEntries = new HashSet<>(); // 用于跟踪已见过的键值对

        for (PlanManager planManager : planManagers) {
            if (planManager == null) {
                continue;
            }

            Map<String, Object> planManagerData = new HashMap<>();
            Map<String, Object> tempData = new HashMap<>(); // 临时存储数据
            tempData.put("planName", planManager.getPlanName());
            tempData.put("id", planManager.getId());

            for (Map.Entry<String, Object> entry : tempData.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().toString().isEmpty() && seenEntries.add(entry)) {
                    planManagerData.put(entry.getKey(), entry.getValue());
                }
            }

            if (!planManagerData.isEmpty()) {
                values.add(planManagerData);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "");
        result.put("value", values);
        result.put("code", 200);
        result.put("redirect", "");

        return result;
    }

    @GetMapping("/findAllCourseByPlan")
    public List<Course> findAllCourseByPlan(@RequestParam("id") Integer planId) {
        return classListService.findAllCourseByPlan(planId);
    }

    @PostMapping("/saveClazz")
    public String saveClass(@RequestParam("classNumber") String classNumber, @RequestParam("className") String className,
                            @RequestParam("instituteName") String instituteName, @RequestParam("branchName") String branchName,
                            @RequestParam("professionName") String professionName, @RequestParam("planManagerName") String planManagerName,
                            @RequestParam("teacherName") String teacherName, @RequestParam("startTime") LocalDateTime startTime,
                            @RequestParam("endTime") LocalDateTime endTime, @RequestParam("classStatus") Integer classStatus,
                            @RequestParam("classDesc") String classDesc) {

        int i = classListService.saveClass(classNumber, className, instituteName, branchName, professionName, planManagerName,
                teacherName, startTime, endTime, classStatus, classDesc);
        if (i == 0) {
            return "success";
        } else if (i == -1) {
            return "teacherNotExist";
        } else {
            log.error("i: " + i);
            return "error";
        }
    }

    @GetMapping("/findClassByKeyword")
    public List<Clazz> findClassByKeyword(@RequestParam("classNumber") String classNumber, @RequestParam("className") String className,
                                          @RequestParam("instituteName") String instituteName, @RequestParam("instituteBranchName") String instituteBranchName,
                                          @RequestParam("profession") String profession) {
        return classListService.getClassByKeyWords(classNumber, className, instituteName, instituteBranchName, profession);
    }

    @GetMapping("/deleteClazz")
    public String deleteClazz(@RequestParam("id") Integer id) {
        try {
            classListService.deleteById(id);
            return "success";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "fail";
        }
    }

    @PostMapping("/deleteSelectClazz")
    public String deleteSelectClazz(@RequestBody List<Serializable> ids) {
        classListService.deleteByGroups(ids);
        return "success";
    }

    @GetMapping("/toUpdateClazz")
    public Clazz toUpdateClass(@RequestParam("id") Integer id) {
        return classListService.findClassById(id);
    }

    @PostMapping("/updateClazz")
    public String updateClazz(@RequestParam("id") Integer classId, @RequestParam("classNumber") String classNumber, @RequestParam("className") String className,
                              @RequestParam("instituteName") String instituteName, @RequestParam("branchName") String branchName,
                              @RequestParam("professionName") String professionName, @RequestParam("planManagerName") String planManagerName,
                              @RequestParam("teacherName") String teacherName, @RequestParam("startTime") LocalDateTime startTime,
                              @RequestParam("endTime") LocalDateTime endTime, @RequestParam("classDesc") String classDesc) {

        int i = classListService.updateClass(classId, classNumber, className, instituteName, branchName, professionName, planManagerName,
                teacherName, startTime, endTime, classDesc);
        if (i == 0) {
            return "success";
        } else if (i == -1) {
            return "teacherNotExist";
        } else {
            log.error("i: " + i);
            return "error";
        }
    }

    @GetMapping("/findStudentByClassId")
    public List<ClassStuDTO> findStudentByClassId(@RequestParam("id") Integer classId) {
        return stuService.getStuByClassId(classId);
    }

    @GetMapping("/findStudentByKeyword")
    public List<ClassStuDTO> findStudentByKeyword(@RequestParam("id") Integer classId, @RequestParam("studentNumber") String num,
                                                  @RequestParam("studentName") String name) {
        return stuService.getStuByClassIdAndKeyword(classId, num, name);
    }

    @PostMapping("/deleteSelectStudent")
    public String deleteSelectStudent(@RequestBody List<Serializable> ids) {
        stuService.deleteSelect(ids);
        return "success";
    }

    @GetMapping("/download-template")
    public ResponseEntity<org.springframework.core.io.Resource> downloadTemplate() {
        org.springframework.core.io.Resource resource = new ClassPathResource("templates/download/studentInfoTemplate.xlsx");

        if (!resource.exists()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Template not found");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=StudentInfoTemplate.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importExcel(@RequestParam("stu_file") MultipartFile file,
                                              @RequestParam("classId") Integer classId) {
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

            stuService.saveAllByClassId(studentList, classId);

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

    @GetMapping("/clazzTrigger")
    public String clazzTrigger(@RequestParam("id") Integer id, @RequestParam("check") String checked) {
        int status;
        if (checked.equals("true")) {
            status = 1;
        } else {
            status = 0;
        }
        classListService.switchStatus(id, status);
        return "success";
    }

    @GetMapping("/findResourceByClassId")
    public List<com.kclm.owep.entity.Resource> findResourceByClassId(@RequestParam("classId") Integer classId) {
        return resourceService.findResourceByClassId(classId);
    }

    @GetMapping("/deleteResourceFromClass")
    public String deleteResourceFromClass(@RequestParam("cid") Integer cid, @RequestParam("rid") Integer rid) {
        resourceService.deleteResourceFromClass(cid, rid);
        return "success";
    }

    @PostMapping("/deleteSelectResourceFromClass")
    public String deleteSelectResourceFromClass(@RequestParam("cid") Integer cid, @RequestBody List<Integer> ridList) {
        resourceService.deleteSelectResourceFromClass(cid, ridList);
        return "success";
    }

    @GetMapping("/findResourceByKeyword")
    public List<com.kclm.owep.entity.Resource> findResourceByKeyword(@RequestParam("classId") Integer classId,
                                                                     @RequestParam("resourceName") String resourceName,
                                                                     @RequestParam("resourceType") Integer resourceType) {
        String resourceTypeName = null;
        if (resourceType == 2) {
            resourceTypeName = "公共资源";
        } else if (resourceType == 3) {
            resourceTypeName = "课程资源";
        } else if (resourceType == 4) {
            resourceTypeName = "私有资源";
        }
        return resourceService.findResourceByKeyword(classId, resourceName, resourceTypeName);
    }

    @GetMapping("/downloadResource/{resourceId}")
    public void downloadResource(@PathVariable Long resourceId, HttpServletResponse response) {
        try {
            Resource resource = resourceService.findResourceById(resourceId);
            if (resource != null) {
                String host = "127.0.0.1";
                int port = 21; // FTP 默认端口
                String username = "zch";
                String password = "123456";
                String remotePath = resource.getResourcePath();
                // 将文件名和文件后缀结合起来
                String fileName = resource.getResourceName() + (resource.getResourceSuffix() != null ? "." + resource.getResourceSuffix() : "");
                log.debug("相对路径: " + remotePath);
                log.debug("下载资源: " + fileName);
                FTPUtil.downloadFile(host, port, username, password, remotePath, fileName, response);
            } else {
                log.error("资源未找到: " + resourceId);
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
            }
        } catch (Exception e) {
            log.error("下载资源失败", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllResource")
    public List<com.kclm.owep.entity.Resource> getAllResource() {
        return resourceService.findAll();
    }

    @GetMapping("/addResourceToClass")
    public String addResourceToClass(@RequestParam("cid") Integer cid, @RequestParam("rid") Integer rid) {
        resourceService.addResourceToClass(cid, rid);
        return "success";
    }

    @GetMapping("/findAllResourceByKeyword")
    public List<Resource> findAllResourceByKeyWord(@RequestParam("resourceName") String resourceName, @RequestParam("resourceType") String resourceType,
                                                   @RequestParam("startTime") LocalDateTime startTime, @RequestParam("endTime") LocalDateTime endTime) {
        return resourceService.findAllResourceByKeyWord(resourceName, resourceType, startTime, endTime);
    }

    @PostMapping("/insertSelectedResourceToClass")
    public String insertSelectedResourceToClass(@RequestParam("cid") Integer cid, @RequestBody List<Integer> ridList) {
        resourceService.saveSelectedResourceToClass(cid, ridList);
        return "success";
    }
}
