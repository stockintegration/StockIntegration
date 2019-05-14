package com.example.stock.vo;

import com.example.stock.Entity.Today;

import java.util.regex.Pattern;

/**
 * Created by Joson on 2019-05-14.
 */
public class QueryParams {
    private String code;
    private Double pb_down;
    private Double pb_up;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPb_down() {
        return pb_down;
    }

    public void setPb_down(double pb_down) {
        this.pb_down = pb_down;
    }

    public Double getPb_up() {
        return pb_up;
    }

    public void setPb_up(double pb_up) {
        this.pb_up = pb_up;
    }
    public boolean cnaAdd(Today t) {
        Pattern pattern = Pattern.compile(code);
        boolean isMatchCode = Pattern.matches(code,t.getCode());
        boolean isMatchName = Pattern.matches(code,t.getName());
        if(!isMatchName&&!isMatchCode)
            return false;
        if(Double.parseDouble(t.getPb())<getPb_down()||Double.parseDouble(t.getPb())>getPb_up())
            return false;
        return true;

    }
}
