package com.easy.poi.sample.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/19.
 * Time:17:29
 * ProjectName:Easypoi-sample
 */
@ExcelTarget("courseEntity")
public class CourseEntity implements Serializable {
    private static final long serialVersionUID = -9166219216593050524L;

    private Integer id;

    @Excel(name = "课程名称",needMerge = true)
    private String name;

    private TeacherEntity majorTeacher;
    @ExcelEntity(id = "major",name = "教师")
    private TeacherEntity absentTeacher;

    @ExcelCollection(name = "学生")
    private List<StudentEntity> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherEntity getMajorTeacher() {
        return majorTeacher;
    }

    public void setMajorTeacher(TeacherEntity majorTeacher) {
        this.majorTeacher = majorTeacher;
    }

    public TeacherEntity getAbsentTeacher() {
        return absentTeacher;
    }

    public void setAbsentTeacher(TeacherEntity absentTeacher) {
        this.absentTeacher = absentTeacher;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
