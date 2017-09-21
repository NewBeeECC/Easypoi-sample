package com.easy.poi.sample.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.easy.poi.sample.entity.CourseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.Yangxiufeng on 2017/9/21.
 * Time:11:01
 * ProjectName:Easypoi-sample
 */
@Controller
public class ImportController {

    @RequestMapping(value = "import")
    public
    ModelAndView goImport(HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.setViewName("importExcel");
        return modelAndView;
    }

    @RequestMapping(value = "uploadExcel")
    public @ResponseBody
    String uploadExcel(HttpServletRequest request){
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("excel");
            if (multipartFile != null){
                ImportParams params = new ImportParams();
                params.setTitleRows(1);
                params.setHeadRows(3);
                InputStream is = multipartFile.getInputStream();
                List<CourseEntity> list = ExcelImportUtil.importExcel(is, CourseEntity.class,params);
                System.out.println(list);
//                List<Map<String,Object>> mapList = ExcelImportUtil.importExcel(is,Map.class,params);
//                System.out.println(mapList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

}
