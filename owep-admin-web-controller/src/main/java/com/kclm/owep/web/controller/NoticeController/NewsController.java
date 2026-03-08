package com.kclm.owep.web.controller.NoticeController;

import com.kclm.owep.dto.NewsDTO;
import com.kclm.owep.entity.News;
import com.kclm.owep.entity.Notice;
import com.kclm.owep.service.NewsService;
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
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/newsList")
    public ModelAndView newsList() {
        return new ModelAndView("/notice/newsList");
    }

    @GetMapping("/getAllNews")
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @PostMapping("/deleteAllNews")
    public String deleteAll(@RequestBody List<Serializable> ids) {
        newsService.deleteSelect(ids);
        return "success";
    }

    @GetMapping("/deleteNew")
    public String deleteNew(@RequestParam("id") Serializable id) {
        newsService.delete(id);
        return "success";
    }

    @PostMapping("/addNew")
    public String addNew(@RequestBody News news) {
        int code = newsService.save(news);
        if(code == -1) {
            return "noTeacher";
        } else if (code == 0) {
            return "error";
        }
        return "success";
    }

    @PostMapping("/updateNew")
    public String update(@RequestBody NewsDTO newsDTO) {
        int code = newsService.update(newsDTO);
        if(code == -1) {
            return "noTeacher";
        } else if (code == 0) {
            return "error";
        }
        return "success";
    }
}
