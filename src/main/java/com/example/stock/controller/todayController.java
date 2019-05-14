package com.example.stock.controller;

import com.example.stock.Entity.Today;
import com.example.stock.dataservice.DataMethod;
import com.example.stock.vo.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/*
*所有今日股票信息
*   url:         /today
*   后端返回所有股票信息 ArrayList
 */
@Controller
public class todayController {
    @Autowired
    private DataMethod dataMethod;
    @RequestMapping(value="/today",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Today> getallts_Code(){
        ArrayList<Today>res=new ArrayList<>();
        /*调用相关文件接口 赋值res*/
        res=dataMethod.getAlltoday();



        return res;
    }
    @RequestMapping(value="/today/query",method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Today> queryStock(QueryParams queryParams){
        ArrayList<Today>res=new ArrayList<>();
        /*调用相关文件接口 赋值res*/
        res=dataMethod.getAlltoday();

        ArrayList<Today>afterQuery = new ArrayList<>();
        for(Today t:res) {
            if(queryParams.cnaAdd(t))
                afterQuery.add(t);
        }
        System.out.println("查询today长度："+afterQuery.size());
        return afterQuery;
    }
}
