package com.easy.poi.sample.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/21.
 * Time:12:38
 * ProjectName:Easypoi-sample
 */
public class ClassName implements Serializable {
    private static final long serialVersionUID = 7194714819757269587L;

    @Excel(name="班级")
    private String name;

    @ExcelCollection(name="小组A")
    private List<StudentEntity> arrA;

    @ExcelCollection(name="小组B")
    private List<StudentEntity> arrB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getArrA() {
        return arrA;
    }

    public void setArrA(List<StudentEntity> arrA) {
        this.arrA = arrA;
    }

    public List<StudentEntity> getArrB() {
        return arrB;
    }

    public void setArrB(List<StudentEntity> arrB) {
        this.arrB = arrB;
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "name='" + name + '\'' +
                ", arrA=" + arrA +
                ", arrB=" + arrB +
                '}';
    }
}
