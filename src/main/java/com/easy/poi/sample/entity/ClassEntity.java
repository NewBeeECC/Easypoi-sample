package com.easy.poi.sample.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * Created by Mr.Yangxiufeng on 2017/9/20.
 * Time:10:45
 * ProjectName:Easypoi-sample
 */
@ExcelTarget("ClassEntity")
public class ClassEntity {
    @Excel(name = "班级名称")
    private String name;
    @Excel(name = "班级人数")
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
