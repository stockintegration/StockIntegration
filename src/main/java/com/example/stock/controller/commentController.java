package com.example.stock.controller;

import com.example.stock.dataservice.DataMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
 * 某一支具体股票的     评论数据
 * 前端提供             ts_code
 * 后端返回值           ArrayList<String>
 * url                  /comment
 * 方法                 POST
 * */
@Controller
public class commentController {
    @RequestMapping(value="/comment",method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<String> getComment(@RequestParam(value="ts_code",required = true)String ts_code){
        ArrayList<String>res=new ArrayList<>();
        DataMethod dataMethod=new DataMethod();
        /*读取相关文件接口 赋值res*/
        res=dataMethod.findComments(ts_code);
        return res;
    }
}
