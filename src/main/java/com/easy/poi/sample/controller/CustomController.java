package com.easy.poi.sample.controller;

import cn.afterturn.easypoi.entity.vo.MapExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.Yangxiufeng on 2017/9/20.
 * Time:14:08
 * ProjectName:Easypoi-sample
 */
@Controller
@RequestMapping("custom")
public class CustomController {

    @RequestMapping(value = "download")
    public String download(ModelMap modelMap){
        List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
        //自定义列 第一列
        ExcelExportEntity name = new ExcelExportEntity("姓名", "name");
        name.setNeedMerge(true);
        entity.add(name);
        //第二列
        ExcelExportEntity sex = new ExcelExportEntity("性别", "sex");
        sex.setNeedMerge(true);
        sex.setReplace(new String[]{"男_1","女_0"});
        entity.add(sex);
        //第三列角色
        ExcelExportEntity roles = new ExcelExportEntity(null, "roles");
        List<ExcelExportEntity> temp = new ArrayList<>();
        temp.add(new ExcelExportEntity("角色名", "roleName"));
        temp.add(new ExcelExportEntity("角色值", "roleValue"));
        temp.add(new ExcelExportEntity("url", "url"));
        roles.setList(temp);
        entity.add(roles);

        //根据列绑定数据
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            //用户信息
            map = new HashMap<>();
            map.put("name", "用户" + i);
            map.put("sex", i%2);

            //用户拥有的角色
            List<Map<String, Object>> tempList = new ArrayList<>();
            for (int j=0;j<2;j++){
                Map<String,Object> roleMap = new HashMap<>();
                roleMap.put("roleName","管理员:"+j);
                roleMap.put("roleValue","value:"+j);
                roleMap.put("url","url:"+j);
                tempList.add(roleMap);
            }
            map.put("roles", tempList);

            list.add(map);
        }

        ExportParams params = new ExportParams("用户角色", "测试", ExcelType.XSSF);
        //设置前两列冻结
        params.setFreezeCol(2);
        //数据列表
        modelMap.put(MapExcelConstants.MAP_LIST, list);
        //列数据集
        modelMap.put(MapExcelConstants.ENTITY_LIST, entity);
        modelMap.put(MapExcelConstants.PARAMS, params);
        modelMap.put(MapExcelConstants.FILE_NAME, "自定义导出"+System.currentTimeMillis());
        return MapExcelConstants.EASYPOI_MAP_EXCEL_VIEW;
    }
    @RequestMapping(value = "download2")
    public String download2(ModelMap modelMap) {
        List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
        ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
        excelentity.setNeedMerge(true);
        entity.add(excelentity);
        entity.add(new ExcelExportEntity("性别", "sex"));

        ExcelExportEntity students = new ExcelExportEntity(null, "students");
        List<ExcelExportEntity> temp = new ArrayList<ExcelExportEntity>();
        temp.add(new ExcelExportEntity("角色名", "roleName"));
        temp.add(new ExcelExportEntity("角色值", "roleValue"));
        students.setList(temp);
        entity.add(students);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<String, Object>();
            map.put("name", "1" + i);
            map.put("sex", "2" + i);

            List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
            for (int j=0;j<2;j++){
                Map<String,Object> roleMap = new HashMap<>();
                roleMap.put("roleName","管理员:"+j);
                roleMap.put("roleValue","value:"+j);
                tempList.add(roleMap);
            }
            map.put("students", tempList);

            list.add(map);
        }

        ExportParams params = new ExportParams("2412312", "测试", ExcelType.XSSF);
        params.setFreezeCol(2);
        modelMap.put(MapExcelConstants.MAP_LIST, list);
        modelMap.put(MapExcelConstants.ENTITY_LIST, entity);
        modelMap.put(MapExcelConstants.PARAMS, params);
        modelMap.put(MapExcelConstants.FILE_NAME, "EasypoiMapExcelViewTest");
        return MapExcelConstants.EASYPOI_MAP_EXCEL_VIEW;

    }
}
