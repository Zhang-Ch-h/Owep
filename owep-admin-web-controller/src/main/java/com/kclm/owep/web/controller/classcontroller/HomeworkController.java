package com.kclm.owep.web.controller.classcontroller;

import com.kclm.owep.entity.*;
import com.kclm.owep.service.HomeworkService;
import com.kclm.owep.web.controller.ftp.FTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/clazz")
@Slf4j
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/homework")
    public ModelAndView homeList() {
        return new ModelAndView("/clazz/homework");
    }

    @GetMapping("/allHomework")
    public List<Homework> allHomework() {
        return homeworkService.getAllHomework();
    }

    @GetMapping("/getAllClass")
    public ResponseEntity<ResponseWrapper<Clazz>> getAllClass() {
        List<Clazz> clazzes = homeworkService.getAllClass();
        ResponseWrapper<Clazz> wrapper = new ResponseWrapper<>(clazzes);
        return ResponseEntity.ok(wrapper);
    }

    @GetMapping("/getChapterByCourseId")
    public ResponseEntity<ResponseWrapper<Chapter>> getAllChapter(@RequestParam("id") Integer courseId) {
        List<Chapter> chapters = homeworkService.getAllChapterByCourseId(courseId);
        ResponseWrapper<Chapter> wrapper = new ResponseWrapper<>(chapters);
        return ResponseEntity.ok(wrapper);
    }

    @GetMapping("/getCourseByClassId")
    public ResponseEntity<ResponseWrapper<Course>> getCourseByClassId(@RequestParam("id")Integer classId) {
        List<Course> courses = homeworkService.getCourseByClassId(classId);
        ResponseWrapper<Course> wrapper = new ResponseWrapper<>(courses);
        return ResponseEntity.ok(wrapper);
    }

    @GetMapping("/getSectionByChapterId")
    public ResponseEntity<ResponseWrapper<Section>> getSectionByChapterId(@RequestParam("id")Integer chapterId) {
        List<Section> sections = homeworkService.getSectionByChapterId(chapterId);
        ResponseWrapper<Section> wrapper = new ResponseWrapper<>(sections);
        return ResponseEntity.ok(wrapper);
    }

    @PostMapping("/saveHomework")
    public ResponseEntity<?> saveHomework(
            @RequestParam("uploadFile") MultipartFile file,
            @RequestParam("classId") Integer classId,
            @RequestParam("courseId") Integer courseId,
            @RequestParam("chapterId") Integer chapterId,
            @RequestParam("sectionId") Integer sectionId,
            @RequestParam("title") String workTitle,
            @RequestParam("desc") String workDescription
    ) {
        log.debug("title: " + workTitle);
        try {
            String workFileName = null;
            boolean isUploaded = true;

            // 判断上传的文件是否为空
            if (!file.isEmpty()) {
                workFileName = file.getOriginalFilename();
                // 假设您的FTPUtil已经处理好了文件上传，并返回文件路径
                isUploaded = FTPUtil.uploadFile("127.0.0.1", 21, "zch", "123456", "", "/testfile", workFileName, file.getInputStream());
            }

            // 如果文件上传成功或者文件为空，则继续处理其他业务逻辑
            if (isUploaded) {
                Homework homework = new Homework();
                Clazz clazz = new Clazz();
                clazz.setId(classId);
                homework.setClazz(clazz);
                Course course = new Course();
                course.setId(courseId);
                homework.setCourse(course);
                Chapter chapter = new Chapter();
                chapter.setId(chapterId);
                homework.setChapter(chapter);
                Section section = new Section();
                section.setId(sectionId);
                homework.setSection(section);
                homework.setWorkTitle(workTitle);
                homework.setWorkContent(workDescription);
                homework.setWorkFileName(workFileName);
                //
                Integer id = homework.getClazz().getId();
                log.debug("clazzId: " + id);
                // 调用Service层保存homework对象到数据库
                homeworkService.save(homework);

                return ResponseEntity.ok("作业添加成功！");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("作业添加失败：" + e.getMessage());
        }
    }

    @GetMapping("/toUpdateHomework")
    public Homework toUpdateHomework(@RequestParam("id") Integer homeworkId) {
        return homeworkService.getHomeworkById(homeworkId);
    }

    @PostMapping("/updateHomework")
    public ResponseEntity<?> UpdateHomework(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @ModelAttribute Homework homework) {
        try {
            String workFileName = null;
            boolean isUploaded = true;

            // 检查文件是否存在且不为空
            if (file != null && !file.isEmpty()) {
                workFileName = file.getOriginalFilename();
                // 假设您的FTPUtil已经处理好了文件上传，并返回文件路径
                isUploaded = FTPUtil.uploadFile("127.0.0.1", 21, "zch", "123456", "", "/testfile", workFileName, file.getInputStream());
            }

            // 如果文件上传成功或者文件不存在，则继续处理其他业务逻辑
            if (isUploaded) {
                if (workFileName != null) {
                    homework.setWorkFileName(workFileName);
                }
                // 更新homework对象到数据库
                homeworkService.updateHomework(homework);

                return ResponseEntity.ok("作业更新成功！");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("作业更新失败：" + e.getMessage());
        }
    }

    @GetMapping("/getHomeworkByCourseId")
    public List<Homework> getHomeworkByCourseId(@RequestParam("courseId") Integer courseId) {
        return homeworkService.getHomeworkByCourseId(courseId);
    }

    @GetMapping("/deleteHomework")
    public String deleteHomework(@RequestParam("id") Integer id) {
        String workFileName = homeworkService.getHomeworkById(id).getWorkFileName();
        //判断workFileName是否为空
        if (workFileName != null) {
            // 假设您的FTPUtil已经处理好了文件删除
            FTPUtil.deleteFile("127.0.0.1", 21, "zch", "123456", "/testfile", workFileName);
        }
        homeworkService.deleteHomework(id);
        return "success";
    }

    @PostMapping("/deleteSelectHomework")
    public String deleteSelectHomework(@RequestBody List<Serializable> ids) {
        // 查询出所有要删除的作业的文件名
        List<String> workFileNames = homeworkService.getWorkFileNames(ids);

        boolean success = true;

        // 检查文件名列表是否为空
        if (!workFileNames.isEmpty()) {
            // 创建一个映射，将每个文件名映射到同一个路径
            Map<String, String> fileMap = new HashMap<>();
            for (String filename : workFileNames) {
                fileMap.put(filename, "/testfile");
            }

            // 调用批量删除方法
            success = FTPUtil.deleteFilesInDifferentDirectories("127.0.0.1", 21, "zch", "123456", fileMap);
        }

        // 即使文件名列表为空，也继续删除数据库中的数据
        homeworkService.deleteByGroups(ids);

        return success ? "success" : "failure";
    }

    @GetMapping("/downloadHomework/{homeworkId}")
    public void downloadResource(@PathVariable Integer homeworkId, HttpServletResponse response) {
        try {
            Homework homework = homeworkService.getHomeworkById(homeworkId);
            if (homework != null) {
                String host = "127.0.0.1";
                int port = 21; // FTP 默认端口
                String username = "zch";
                String password = "123456";
                String remotePath = "/testfile";
                // 将文件名和文件后缀结合起来
                String fileName = homework.getWorkFileName();
                log.debug("相对路径: " + remotePath);
                log.debug("下载资源: " + fileName);
                FTPUtil.downloadFile(host, port, username, password, remotePath, fileName, response);
            } else {
                log.error("资源未找到: " + homeworkId);
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
            }
        } catch (Exception e) {
            log.error("下载资源失败", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
