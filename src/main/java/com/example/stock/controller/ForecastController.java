package com.example.stock.controller;

import com.example.stock.Entity.Forecast;
import com.example.stock.Entity.Kline;
import com.example.stock.dataservice.DataMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
 * 某一支具体股票的     预测数据
 * 前端提供             ts_code
 * 后端返回值           forecast对象
 * url                  /forcast
 * 方法                 POST
* */
@Controller
public class ForecastController {
    @RequestMapping(value="/forcast",method = RequestMethod.POST)
    @ResponseBody
        public Forecast makeforecast(@RequestParam("ts_code")String ts_code){
        System.out.println(ts_code);
        DataMethod dataMethod=new DataMethod();
        Forecast res=dataMethod.findForecast(ts_code);
        /*读取相关文件接口 赋值res*/
       return res;
    }
}
