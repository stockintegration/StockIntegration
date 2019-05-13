package com.example.stock.controller;

import com.example.stock.Entity.Kline;
import com.example.stock.dataservice.DataMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
*交给前端所有股票代码    ts_code
* 后端返回                ArrayList<String>
* url:                   /ts_code
* 方法                   GET
*/

@Controller
public class ts_codeController {
    @RequestMapping(value="/ts_code",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<String> getallts_Code(){
        ArrayList<String>res=new ArrayList<>();
        /*读取相关文件接口 赋值res*/
        DataMethod dataMethod=new DataMethod();
        res=dataMethod.getAllstocks();

        return res;
    }
}
