package com.example.stock.controller;

import com.example.stock.Entity.Stock;
import com.example.stock.dataservice.DataMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
 * 某一支具体股票的     基本数据
 * 前端提供             ts_code
 * 后端返回值           Stock对象
 * url                  /basicInfo
 * 方法                 POST
 * */
@Controller
public class basicInfoController {

    @RequestMapping(value="/basicInfo",method = RequestMethod.POST)
    @ResponseBody
    public Stock getbasicInfo(@RequestParam(value="ts_code",required = true)String ts_code){
        DataMethod dataMethod=new DataMethod();
        Stock res=dataMethod.findBasicMessage(ts_code);
        /*读取相关文件接口 赋值res*/
        return res;
    }
}
