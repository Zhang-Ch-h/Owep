package com.kclm.owep.service.impl;

import com.kclm.owep.convert.DBCopyConvert;
import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;
import com.kclm.owep.mapper.DBCopyMapper;
import com.kclm.owep.service.DBCopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;


/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class DBCopyServiceImpl implements DBCopyService {

    @Autowired
    private DBCopyMapper dbCopyMapper;

    @Autowired
    private DBCopyConvert DBCopyConvert;

    @Override
    public List<DbCopyDTO> findAll() {
        try {
            List<DbCopy> dbCopies = dbCopyMapper.selectAll();
            List<DbCopyDTO> dbCopyDTOS = DBCopyConvert.toDbCopyDTO(dbCopies);
            return dbCopyDTOS;
        } catch (Exception e) {
            log.error("查询备份数据库失败", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<DbCopyDTO> findByTime(LocalDateTime start, LocalDateTime end) {
        try {
            List<DbCopy> dbCopies = dbCopyMapper.selectByTime(start, end);
            List<DbCopyDTO> dbCopyDTOS = DBCopyConvert.toDbCopyDTO(dbCopies);
            return dbCopyDTOS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public boolean backupDatabase() {
        String databaseName = "owep-dev-base1";  // 数据库名称
        String dbUsername = "root";    // 数据库用户名
        String dbPassword = "123456";    // 数据库密码
        String backupPath = "D:\\file\\db_copy"; // 备份文件保存路径
        String fileName = "dbcopy_" + System.currentTimeMillis() + ".sql";
        String backupFile = backupPath + File.separator + fileName;

        // 使用 ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "mysqldump -u" + dbUsername + " -p" + dbPassword + " " + databaseName + " > " + backupFile);

        try {
            Process process = processBuilder.start();

            // 读取错误流
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                log.debug(line);
                System.out.println(line);
            }

            int processComplete = process.waitFor();
            if (processComplete == 0) {
                DbCopy dbCopy = new DbCopy();
                //
                dbCopy.setFileName(fileName);
                dbCopy.setStatus(1);
                dbCopy.setFilePath(backupFile);
                dbCopyMapper.save(dbCopy);
                log.debug("备份成功");
                return true;
            } else {
                log.debug("备份失败");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public DbCopy getById(Serializable id) {
        try {
            return dbCopyMapper.selectById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public boolean deleteDbCopy(Serializable id) {
        DbCopy dbCopy = getById(id);
        if (dbCopy != null) {
            // 删除文件
            File file = new File(dbCopy.getFilePath());
            if (file.exists() && !file.delete()) {
                // 如果文件存在并且删除失败，记录日志并返回false
                log.error("无法删除文件：" + dbCopy.getFilePath());
                return false;
            }

            // 删除数据库记录
            dbCopyMapper.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> deleteSelectedDbCopies(List<Serializable> ids) {
        Map<String, Object> result = new HashMap<>();
        List<Serializable> failedIds = new ArrayList<>();

        for (Serializable id : ids) {
            // 这里的逻辑是调用之前的 deleteDbCopy 方法
            // 可能需要捕获异常以确保即使一些删除失败，循环也会继续
            boolean isDeleted = deleteDbCopy(id);
            if (!isDeleted) {
                failedIds.add(id);
            }
        }

        boolean allSuccess = failedIds.isEmpty();
        result.put("success", allSuccess);
        result.put("failed", failedIds);
        return result;
    }
}