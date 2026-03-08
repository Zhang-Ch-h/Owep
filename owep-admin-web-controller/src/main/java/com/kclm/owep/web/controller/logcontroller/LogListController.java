package com.kclm.owep.web.controller.logcontroller;

import com.kclm.owep.entity.SystLog;
import com.kclm.owep.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogListController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/list")
    public ModelAndView logList() {
        return new ModelAndView("/log/list");
    }

    @GetMapping("/allLog")
    public List<SystLog> getAll() {
        return sysLogService.getAll();
    }

    @GetMapping("/getAllLogByKeyWords")
    public List<SystLog> getByKeyWords(@RequestParam("name") String name, @RequestParam("start") LocalDateTime start,
                                       @RequestParam("end") LocalDateTime end) {
        return sysLogService.getByKeyWords(name, start, end);
    }
}
