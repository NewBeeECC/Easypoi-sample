package com.easy.poi.sample.util;

import com.easy.poi.sample.entity.CourseEntity;
import com.easy.poi.sample.entity.StudentEntity;
import com.easy.poi.sample.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/20.
 * Time:9:55
 * ProjectName:Easypoi-sample
 */
public class CourseUtil {

    public static List<CourseEntity> getCourseList(){
        List<CourseEntity> courseEntityList = new ArrayList<>();
        //数学
        CourseEntity math = new CourseEntity();
        math.setName("数学");
        TeacherEntity mathTeacherEntity = new TeacherEntity();
        mathTeacherEntity.setName("王老师");
        math.setAbsentTeacher(mathTeacherEntity);
        courseEntityList.add(math);
        //语文
        CourseEntity chinese = new CourseEntity();
        chinese.setName("语文");
        TeacherEntity chineseTeacher = new TeacherEntity();
        chineseTeacher.setName("李老师");
        chinese.setAbsentTeacher(chineseTeacher);
        courseEntityList.add(chinese);

        List<StudentEntity> studentList = new ArrayList<>();
        for (int i = 0;i<5;i++){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName("学生 : "+i);
            studentEntity.setBorthday(new Date());
            if (i%2==0){
                studentEntity.setSex(0);
            }else {
                studentEntity.setSex(1);
            }
            studentList.add(studentEntity);
        }
        math.setStudents(studentList);
        chinese.setStudents(studentList);
        return courseEntityList;
    }

}
