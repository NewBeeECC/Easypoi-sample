package com.easy.poi.sample.controller;

import cn.afterturn.easypoi.entity.vo.BigExcelConstants;
import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.easy.poi.sample.entity.ClassEntity;
import com.easy.poi.sample.entity.CourseEntity;
import com.easy.poi.sample.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/9/19.
 * Time:17:34
 * ProjectName:Easypoi-sample
 */
@Controller
@RequestMapping("student")
public class StudentController {

    /**
     * <p>一对一导出</p>
     * @param modelMap
     * @param request
     * @param response
     */
    @RequestMapping(value = "download")
    public void downloadStudent(ModelMap modelMap,HttpServletRequest request,
                                HttpServletResponse response){
        List<StudentEntity> entityList = new ArrayList<>();
        List<CourseEntity> courseEntityList = new ArrayList<>();
        CourseEntity courseEntity1  = new CourseEntity();
        courseEntity1.setName("语文");
        courseEntityList.add(courseEntity1);
        CourseEntity courseEntity2 = new CourseEntity();
        courseEntity2.setName("数学");
        courseEntityList.add(courseEntity2);

        for (int i=0;i<10;i++){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setBorthday(new Date());
            studentEntity.setName("name:"+i);
            ClassEntity classEntity = new ClassEntity();
            if (i%2==0){
                studentEntity.setSex(0);
                classEntity.setName("一班");
            }else {
                studentEntity.setSex(1);
                classEntity.setName("二班");
            }
            studentEntity.setRegistrationDate(new Date());
            studentEntity.setClassEntity(classEntity);
            entityList.add(studentEntity);
        }
        ExportParams params = new ExportParams("学生信息","studentInfo", ExcelType.XSSF);
        modelMap.put(NormalExcelConstants.DATA_LIST,entityList);
        modelMap.put(NormalExcelConstants.CLASS, StudentEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS,params);
        //设置导出文件名
        modelMap.put(NormalExcelConstants.FILE_NAME,"学生信息表:"+System.currentTimeMillis());
        PoiBaseView.render(modelMap,request,response,NormalExcelConstants.EASYPOI_EXCEL_VIEW);

    }

}
