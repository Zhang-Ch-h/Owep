package com.kclm.owep.web.controller.systemconfigcontroller;

import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;
import com.kclm.owep.service.DBCopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/system")
@Slf4j
public class BackUpController {

    @Autowired
    private DBCopyService dbCopyService;

    @GetMapping("/backup")
    public ModelAndView configList() {
        return new ModelAndView("/system/backup");
    }

    @GetMapping("/allDBCopy")
    public List<DbCopyDTO> allDBCopy() {
        return dbCopyService.findAll();
    }

    @GetMapping("/getDBCopy")
    public List<DbCopyDTO> getDBCopyByTime(@RequestParam("startTime") LocalDateTime start, @RequestParam("endTime") LocalDateTime end) {
        return dbCopyService.findByTime(start, end);
    }

    @GetMapping("/backupDatabase")
    public ResponseEntity<String> backupDatabase() {
        try {
            // 调用服务层执行备份
            boolean isSuccess = dbCopyService.backupDatabase();
            if (isSuccess) {
                return ResponseEntity.ok("数据库备份成功");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("数据库备份失败");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("数据库备份异常");
        }
    }

    @GetMapping("/downloadBackup")
    public ResponseEntity<Resource> downloadBackup(@RequestParam("id") Serializable id) {
        DbCopy dbCopy = dbCopyService.getById(id);
        if (dbCopy == null || !new File(dbCopy.getFilePath()).exists()) {
            // 文件不存在，可以直接返回HttpStatus.NOT_FOUND
            return ResponseEntity.notFound().build();
        }

        try {
            String filePath = dbCopy.getFilePath(); // 从服务层获取文件完整路径
            File file = new File(filePath);

            HttpHeaders header = new HttpHeaders();
            header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"");

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            return ResponseEntity.ok()
                    .headers(header)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException e) {
            // 文件没有找到
            log.error("下载的文件没有找到", e);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // 其他异常
            log.error("下载文件时发生异常", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteBackup/{id}")
    public ResponseEntity<?> deleteBackup(@PathVariable("id") Serializable id) {
        try {
            boolean isDeleted = dbCopyService.deleteDbCopy(id);
            if (isDeleted) {
                return ResponseEntity.ok("删除成功");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("删除失败，文件可能已经不存在");
            }
        } catch (Exception e) {
            log.error("删除文件时发生异常", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除过程中出现异常");
        }
    }

    @PostMapping("/deleteSelectDBCopy")
    public ResponseEntity<?> deleteSelectedBackups(@RequestBody List<Serializable> ids) {
        try {
            // 假设 dbCopyService 有一个批量删除的方法
            Map<String, Object> result = dbCopyService.deleteSelectedDbCopies(ids);
            if (result.get("success").equals(Boolean.TRUE)) {
                return ResponseEntity.ok("批量删除成功");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("某些项删除失败: " + result.get("failed"));
            }
        } catch (Exception e) {
            log.error("批量删除文件时发生异常", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("批量删除过程中出现异常");
        }
    }
}
