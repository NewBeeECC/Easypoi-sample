package com.easy.poi.sample.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.easy.poi.sample.entity.CourseEntity;
import com.easy.poi.sample.entity.StudentEntity;
import com.easy.poi.sample.entity.TeacherEntity;
import com.easy.poi.sample.util.CourseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/20.
 * Time:9:44
 * ProjectName:Easypoi-sample
 */
@Controller
@RequestMapping("course")
public class CourseController {

    /**
     * <p>一对多导出</p>
     * @param modelMap
     * @param request
     * @param response
     */
    @RequestMapping(value = "download")
    public void downloadStudent(ModelMap modelMap, HttpServletRequest request,
                                HttpServletResponse response){

        ExportParams params = new ExportParams("课程表","studentInfo", ExcelType.XSSF);
        modelMap.put(NormalExcelConstants.DATA_LIST, CourseUtil.getCourseList());
        modelMap.put(NormalExcelConstants.CLASS, CourseEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS,params);
        //设置导出文件名
        modelMap.put(NormalExcelConstants.FILE_NAME,"课程信息表:"+System.currentTimeMillis());
        PoiBaseView.render(modelMap,request,response,NormalExcelConstants.EASYPOI_EXCEL_VIEW);

    }

}
