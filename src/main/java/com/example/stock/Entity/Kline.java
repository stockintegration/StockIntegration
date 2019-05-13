package com.example.stock.Entity;

import java.util.ArrayList;

public class Kline {

    public Kline(String ts_code, ArrayList<String> timelist, ArrayList<String> closelist, ArrayList<String> openlist,
			ArrayList<String> highlist, ArrayList<String> lowlist, ArrayList<String> changelist,
			ArrayList<String> vollist, ArrayList<String> amountlist) {
		super();
		this.ts_code = ts_code;
		this.timelist = timelist;
		this.closelist = closelist;
		this.openlist = openlist;
		this.highlist = highlist;
		this.lowlist = lowlist;
		this.changelist = changelist;
		this.vollist = vollist;
		this.amountlist = amountlist;
	}

	private String ts_code;
    private ArrayList<String> timelist;
    private ArrayList<String> closelist;
    private ArrayList<String> openlist;
    private ArrayList<String> highlist;
    private ArrayList<String> lowlist;
    private ArrayList<String> changelist;
    private ArrayList<String> vollist;
    private ArrayList<String> amountlist;
    
    public String getTs_code() {
        return ts_code;
    }

    public void setTs_code(String ts_code) {
        this.ts_code = ts_code;
    }

    public ArrayList<String> getCloselist() {
        return closelist;
    }

    public void setCloselist(ArrayList<String> closelist) {
        this.closelist = closelist;
    }

    public ArrayList<String> getOpenlist() {
        return openlist;
    }

    public void setOpenlist(ArrayList<String> openlist) {
        this.openlist = openlist;
    }

    public ArrayList<String> getHighlist() {
        return highlist;
    }

    public void setHighlist(ArrayList<String> highlist) {
        this.highlist = highlist;
    }

    public ArrayList<String> getLowlist() {
        return lowlist;
    }

    public void setLowlist(ArrayList<String> lowlist) {
        this.lowlist = lowlist;
    }

    public ArrayList<String> getChangelist() {
        return changelist;
    }

    public void setChangelist(ArrayList<String> changelist) {
        this.changelist = changelist;
    }

    public ArrayList<String> getVollist() {
        return vollist;
    }

    public void setVollist(ArrayList<String> vollist) {
        this.vollist = vollist;
    }

    public ArrayList<String> getAmountlist() {
        return amountlist;
    }

    public void setAmountlist(ArrayList<String> amountlist) {
        this.amountlist = amountlist;
    }

	public ArrayList<String> getTimelist() {
		return timelist;
	}

	public void setTimelist(ArrayList<String> timelist) {
		this.timelist = timelist;
	}
}
