package com.kclm.owep.web.controller.classcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/clazz")
@Slf4j
public class StudyProcessController {

    @GetMapping("/studyProcess")
    public ModelAndView studyProcessList() {
        return new ModelAndView("/clazz/studyProcess");
    }

}
