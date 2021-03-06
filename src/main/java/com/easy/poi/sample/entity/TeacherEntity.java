package com.easy.poi.sample.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created by Mr.Yangxiufeng on 2017/9/19.
 * Time:17:22
 * ProjectName:Easypoi-sample
 */
@ExcelTarget(value = "TeacherEntity")
public class TeacherEntity implements Serializable {
    private static final long serialVersionUID = -1907051143356107857L;
    @Excel(name = "主讲老师_major,代课老师_absent",needMerge = true)
    private String name;
    @Excel(name = "年龄",needMerge = true)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
