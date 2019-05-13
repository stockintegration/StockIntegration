package com.example.stock.datagetter;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Daniel on 2016/5/8.
 */

/**
 * python 程序执行器
 */
public class PythonExecutor {
    public static final String CMD = "E:/python-3.7.3-embed-amd64/python";

    public void excute(String fileName) throws IOException, InterruptedException {
        fileName="src/main/java/com/example/stock/python/tushare/"+fileName;
        String cmd="python "+fileName;
        Process pro = Runtime.getRuntime().exec(cmd);
        InputStream is = pro.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readLine();
        pro.waitFor();
    }

    public void excuteWrittenFile(String pyFile) throws IOException, InterruptedException {
        excute(pyFile);
        System.out.println("生成文件完成");
    }

}
