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
    @Excel(name = "主讲老师_major,代课老师_absent",isImportField = "true_major,true_absent",needMerge = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
