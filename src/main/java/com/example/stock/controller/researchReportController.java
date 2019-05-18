package com.example.stock.controller;

import com.example.stock.Entity.Analysis;
import com.example.stock.dataservice.DataMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/*
 * 某一支具体股票的     研究报告
 * 前端提供             ts_code
 * 后端返回值           analysis对象Arraylist
 * url                  /research
 * 方法                 POST
 * */
@Controller
public class researchReportController {
    @Autowired
    private DataMethod dataMethod;
    @RequestMapping(value="/research",method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Analysis> getResearchReport(@RequestParam("ts_code")String ts_code){
        ArrayList<Analysis>res=new ArrayList<>();//等待实体类和方法接口
        /*读取相关文件接口 赋值res*/
        res=dataMethod.findAnalysis(ts_code);
        return res;
    }
}
