package com.example.stock.datagetter;

/**
 * Created by Daniel on 2016/5/8.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 存放需要的各种参数
 */
public class Paramaters {
    /**
     * 相对路径
     */
    public static final String ABSOLUTE_PATH = "cache/";

    /**
     * 获得cache文件夹的路径
     *
     * @return
     */
    public static String getPath() {
        return Paramaters.class.getResource("/").getPath().substring(1) + ABSOLUTE_PATH;
    }

    public static BufferedReader getBufferedReader(String fileName) {
        return new BufferedReader(new InputStreamReader((Paramaters.class.getResourceAsStream
                ("/" + ABSOLUTE_PATH + fileName)), Charset.forName("utf8")));
    }

    public static void main(String[] args) {
        System.out.println(getPath());
    }
}
