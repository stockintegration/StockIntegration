package com.example.stock.controller;

import com.example.stock.Entity.Kline;
import com.example.stock.dataservice.DataMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
* 某一支具体股票的     k线指标
* 前端提供             ts_code
* 后端返回值           kline对象
* url: /kline
* 方法                 POST
*/
@Controller
public class klineController {
    @RequestMapping(value="/kline",method = RequestMethod.POST)
    @ResponseBody
    public Kline Viewkline(@RequestParam(value="ts_code",required = true)String ts_code){
        DataMethod dataMethod=new DataMethod();
        Kline res=dataMethod.findKline(ts_code);
        /*读取相关文件接口 赋值res*/
         return res;
    }
}
