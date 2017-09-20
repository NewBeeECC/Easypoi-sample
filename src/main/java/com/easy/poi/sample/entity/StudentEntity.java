package com.easy.poi.sample.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/19.
 * Time:17:29
 * ProjectName:Easypoi-sample
 */
@ExcelTarget("StudentEntity")
public class StudentEntity implements Serializable {
    private static final long serialVersionUID = -6951812138400561343L;

    private String id;
    @Excel(name = "学生姓名",width = 30,needMerge = true)
    private String name;
    @Excel(name = "性别",replace = {"男_1","女_0"},suffix = "生")
    private int sex;
    @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd",width = 30,isImportField = "true_st")
    private Date borthday;
    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd",width = 30)
    private Date registrationDate;

    @ExcelEntity
    private ClassEntity classEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBorthday() {
        return borthday;
    }

    public void setBorthday(Date borthday) {
        this.borthday = borthday;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}
