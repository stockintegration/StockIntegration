package com.example.stock.Entity;

import java.util.ArrayList;

public class Forecast {
    public Forecast(String ts_code, ArrayList<String> ann_date, ArrayList<String> end_date, ArrayList<String> type,
			ArrayList<String> p_change_min, ArrayList<String> p_change_max, ArrayList<String> net_profit_min,
			ArrayList<String> net_profit_max, ArrayList<String> summary, ArrayList<String> change_reason) {
		super();
		this.ts_code = ts_code;
		this.ann_date = ann_date;
		this.end_date = end_date;
		this.type = type;
		this.p_change_min = p_change_min;
		this.p_change_max = p_change_max;
		this.net_profit_min = net_profit_min;
		this.net_profit_max = net_profit_max;
		this.summary = summary;
		this.change_reason = change_reason;
	}
	private String ts_code;
    private ArrayList<String> ann_date;
    private ArrayList<String> end_date;
    private ArrayList<String> type;
    private ArrayList<String> p_change_min;
    private ArrayList<String> p_change_max;
    private ArrayList<String> net_profit_min;
    private ArrayList<String> net_profit_max;
    private ArrayList<String> summary;
    private ArrayList<String> change_reason;
	public String getTs_code() {
		return ts_code;
	}
	public void setTs_code(String ts_code) {
		this.ts_code = ts_code;
	}
	public ArrayList<String> getAnn_date() {
		return ann_date;
	}
	public void setAnn_date(ArrayList<String> ann_date) {
		this.ann_date = ann_date;
	}
	public ArrayList<String> getEnd_date() {
		return end_date;
	}
	public void setEnd_date(ArrayList<String> end_date) {
		this.end_date = end_date;
	}
	public ArrayList<String> getType() {
		return type;
	}
	public void setType(ArrayList<String> type) {
		this.type = type;
	}
	public ArrayList<String> getP_change_min() {
		return p_change_min;
	}
	public void setP_change_min(ArrayList<String> p_change_min) {
		this.p_change_min = p_change_min;
	}
	public ArrayList<String> getP_change_max() {
		return p_change_max;
	}
	public void setP_change_max(ArrayList<String> p_change_max) {
		this.p_change_max = p_change_max;
	}
	public ArrayList<String> getNet_profit_min() {
		return net_profit_min;
	}
	public void setNet_profit_min(ArrayList<String> net_profit_min) {
		this.net_profit_min = net_profit_min;
	}
	public ArrayList<String> getNet_profit_max() {
		return net_profit_max;
	}
	public void setNet_profit_max(ArrayList<String> net_profit_max) {
		this.net_profit_max = net_profit_max;
	}
	public ArrayList<String> getSummary() {
		return summary;
	}
	public void setSummary(ArrayList<String> summary) {
		this.summary = summary;
	}
	public ArrayList<String> getChange_reason() {
		return change_reason;
	}
	public void setChange_reason(ArrayList<String> change_reason) {
		this.change_reason = change_reason;
	}
   
}
