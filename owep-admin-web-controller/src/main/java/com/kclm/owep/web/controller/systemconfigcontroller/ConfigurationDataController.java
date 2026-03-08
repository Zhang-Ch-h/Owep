package com.kclm.owep.web.controller.systemconfigcontroller;

import com.kclm.owep.entity.SystemConfig;
import com.kclm.owep.service.ConfigDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/system")
@Slf4j
public class ConfigurationDataController {

    // 注意这个路径应该指向你controller模块的static文件夹
    private static final String UPLOAD_DIR = "./owep-admin-web-controller/src/main/resources/static/img/";

    @Autowired
    private ConfigDataService configDataService;

    @GetMapping("/config")
    public ModelAndView configList() {
        ModelAndView modelAndView = new ModelAndView("/system/config");

        // 获取配置信息
        SystemConfig config = configDataService.selectPage();

        log.debug(config.getLoginPageLogo());
        log.debug(config.getSystemPageLogo());

        // 添加图片文件名到模型中
        modelAndView.addObject("loginLogoName", config.getLoginPageLogo());
        modelAndView.addObject("sysLogoName", config.getSystemPageLogo());

        return modelAndView;
    }

    @PostMapping("/updateNameAndInfo")
    public String updateNameAndInfo(@RequestParam("systemname") String name,
                                    @RequestParam("verinfo") String info) {
        configDataService.insertNameAndInfo(name, info);
        return "success";
    }

    @PostMapping("/uploadLoginPageImage")
    public String uploadLoginPageImage(@RequestParam("imageSource") MultipartFile file) {
        if (file.isEmpty()) {
            return "error"; // 或其他错误处理
        }

        try {
            //拿到原始文件名
            String preFileName = configDataService.selectPage().getLoginPageLogo();

            // 删除原有的图片
            deletePreImage(preFileName);

            // 使用UUID生成文件名
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + fileExtension;
            Path savePath = Paths.get(UPLOAD_DIR + fileName);
            //把文件名存到数据库
            configDataService.insertLoginImage(fileName);

            // 确保目录存在
            if (!Files.exists(savePath.getParent())) {
                Files.createDirectories(savePath.getParent());
            }

            // 保存文件到指定路径
            Files.copy(file.getInputStream(), savePath);

            return "success"; // 或其他成功响应
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; // 或其他错误处理
        }
    }

    @PostMapping("/uploadSysPageImage")
    public String uploadSysPageImage(@RequestParam("imageSource") MultipartFile file) {
        if (file.isEmpty()) {
            return "error"; // 或其他错误处理
        }

        try {
            // 使用UUID生成文件名
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + fileExtension;
            Path savePath = Paths.get(UPLOAD_DIR + fileName);
            //把文件名存到数据库
            configDataService.insertSystemImage(fileName);

            // 确保目录存在
            if (!Files.exists(savePath.getParent())) {
                Files.createDirectories(savePath.getParent());
            }

            // 保存文件到指定路径
            Files.copy(file.getInputStream(), savePath);

            return "success"; // 或其他成功响应
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; // 或其他错误处理
        }
    }

    @GetMapping("/getInfo")
    public SystemConfig getInfo() {
        return configDataService.selectPage();
    }

    public boolean deletePreImage(String preFileName) {
        try {
            Path preFilePath = Paths.get(UPLOAD_DIR + preFileName);

            // 检查文件是否存在
            if (Files.exists(preFilePath)) {
                // 删除文件
                Files.delete(preFilePath);
                return true; // 删除成功
            } else {
                System.out.println("文件不存在: " + preFileName);
                return false; // 文件不存在
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // 删除失败
        }
    }

}
