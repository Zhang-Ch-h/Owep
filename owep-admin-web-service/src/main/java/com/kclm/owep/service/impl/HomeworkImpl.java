package com.kclm.owep.service.impl;

import com.kclm.owep.entity.*;
import com.kclm.owep.mapper.*;
import com.kclm.owep.service.HomeworkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class HomeworkImpl implements HomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public List<Homework> getAllHomework() {
        try {
            List<Homework> homeworkList = homeworkMapper.selectAll();

            for (Homework homework : homeworkList) {
                // 检查并处理Clazz为空的情况
                if (homework.getClazz() == null) {
                    homework.setClazz(new Clazz());
                }

                // 检查并处理Course为空的情况
                if (homework.getCourse() == null) {
                    homework.setCourse(new Course());
                }
            }

            return homeworkList;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Clazz> getAllClass() {
        try {
            return clazzMapper.selectAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Chapter> getAllChapterByCourseId(Integer courseId) {
        try {
            return chapterMapper.selectAllByCourseId(courseId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Course> getCourseByClassId(Integer classId) {
        try{
            return courseMapper.selectCourseByClassId(classId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Section> getSectionByChapterId(Integer chapterId) {
        try{
            return sectionMapper.selectByChapterId(chapterId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void save(Homework homework) {
        try{
            homeworkMapper.save(homework);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public Homework getHomeworkById(Integer homeworkId) {
        try{
            Homework homework = homeworkMapper.selectById(homeworkId);
            //判断class、course、chapter、section是否为空
            if (homework.getClazz() == null) {
                log.debug("Enter the judgment where 'Profession' is empty.");
                homework.setClazz(new Clazz()); // 设置新的 Profession 对象
            }

            if (homework.getCourse() == null) {
                log.debug("Enter the judgment where 'Course' is empty.");
                homework.setCourse(new Course()); // 设置新的 Course 对象
            }

            if (homework.getChapter() == null) {
                log.debug("Enter the judgment where 'Chapter' is empty.");
                homework.setChapter(new Chapter()); // 设置新的 Chapter 对象
            }

            if (homework.getSection() == null) {
                log.debug("Enter the judgment where 'Section' is empty.");
                homework.setSection(new Section()); // 设置新的 Section 对象
            }

            return homework;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void updateHomework(Homework homework) {
        try{
            homeworkMapper.update(homework);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Homework> getHomeworkByCourseId(Integer courseId) {
        try {
            List<Homework> homeworkList = homeworkMapper.selectHomeworkbByCourseId(courseId);

            for (Homework homework : homeworkList) {
                // 检查并处理Clazz为空的情况
                if (homework.getClazz() == null) {
                    homework.setClazz(new Clazz());
                }

                // 检查并处理Course为空的情况
                if (homework.getCourse() == null) {
                    homework.setCourse(new Course());
                }
            }

            return homeworkList;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteHomework(Integer id) {
        try{
            homeworkMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<String> getWorkFileNames(List<Serializable> ids) {
        try{
            return homeworkMapper.selectWorkFileNames(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteByGroups(List<Serializable> ids) {
        try{
            homeworkMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
