package com.kclm.owep.web.controller.NoticeController;

import com.kclm.owep.entity.Notice;
import com.kclm.owep.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/notice")
@Slf4j
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/noticeList")
    public ModelAndView noticeList() {
        return new ModelAndView("/notice/noticeList");
    }

    @GetMapping("/getAllNotice")
    public List<Notice> getAllNotice() {
        return noticeService.getAllNotice();
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestBody List<Serializable> ids) {
        noticeService.updateStatus(ids);
        return "success";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(@RequestBody List<Serializable> ids) {
        noticeService.deleteSelect(ids);
        return "success";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Serializable id) {
        noticeService.delete(id);
        return "success";
    }

    @PostMapping("/add")
    public String add(@RequestBody Notice notice) {
        int code = noticeService.save(notice);
        if(code == -1) {
            return "noTeacher";
        } else if (code == 0) {
            return "error";
        }
        return "success";
    }

    @PostMapping("/update")
    public String update(@RequestBody Notice notice) {
        int code = noticeService.update(notice);
        if(code == -1) {
            return "noTeacher";
        } else if (code == 0) {
            return "error";
        }
        return "success";
    }
}
