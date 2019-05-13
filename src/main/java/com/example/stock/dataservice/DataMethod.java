package com.example.stock.dataservice;

import com.example.stock.Entity.Forecast;
import com.example.stock.Entity.Kline;
import com.example.stock.Entity.Stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataMethod {
	/*根据code返回改股票的所有评论信息
	* 返回类型：ArrayList<String>
	传入ts_code*/
	 public ArrayList<String> findComments(String s){
		ArrayList<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
        	int k=0;
            br = new BufferedReader(new FileReader("src/main/java/com/example/stock/python/dfpl.csv"));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
            	if (k==0){
            		k=k+1;
            		continue;
            	}
            		
               //System.out.println(line);
               int i =line.lastIndexOf(",");
               int index=line.indexOf(",");
               int j=line.indexOf(",",index+1);
               //System.out.println(line.substring(j+1, i));
               if (line.substring(index+1,j).equals(s.substring(0,s.length()-3))) {
            	   if(!line.substring(j+1, i).equals("")){
            		   dataList.add(line.substring(j+1, i));
            	   }
               }
               //System.out.println("");
               
            }
        }catch (Exception e) {
        }
        System.out.println("________________________________");
        BufferedReader br1=null;
        try { 
            br1 = new BufferedReader(new FileReader("src/main/java/com/example/stock/python/agpl.csv"));
            String line = ""; 
            while ((line = br1.readLine()) != null) { 
            
               //System.out.println(line);
               int i =line.lastIndexOf(",");
               int index=line.indexOf(",");
               int j=line.indexOf(",",index+1);
               
               if (line.substring(index+1,j).equals(s.substring(0,s.length()-3))) {
            	   if(!line.substring(j+1, i).equals("")){
            		   System.out.println(line.substring(j+1, i));
            		   dataList.add(line.substring(j+1, i));
            	   }
               }
               //System.out.println("");
               
            }
        }catch (Exception e) {
        }
		return  dataList;
		
	}

	/*根据code获得对应的基本信息
	* 返回类型：Stock
	* 传入ts_code*/
	public Stock findBasicMessage(String code){

		 Stock s=new Stock();
		 BufferedReader br=null;
		 try {
			 br = new BufferedReader(new FileReader("src/main/java/com/example/stock/python/data/stockbasic.csv"));
			 String line = "";
			 while ((line = br.readLine()) != null) {

				 //System.out.println(line);
				 //int i =line.lastIndexOf(",");

				 int index=line.indexOf(",");

				 int i=line.indexOf(",",index+1);
				 if (line.substring(index+1, i).equals(code)) {
					 s.setTs_code(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setChairman(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setManager(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setSecretary(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setReg_capital(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setSetup_date(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setProvince(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setCity(line.substring(index+1, i));
					 System.out.println(line.substring(index+1, i));
					 index=i;

					 i=line.indexOf(",",index+1);
					 s.setIntroduction(line.substring(index+1));
					 System.out.println(line.substring(index+1));
				 }
				 //stocks.add(s);
			 }
		 }catch (Exception e) {
		 }
		 return s;
	 }

	 /*根据code获得对应的股票k线图
	 * 返回类型：kline
	 * 传入ts_code*/
	 public Kline findKline(String s) {
		 //ArrayList<String> dataList=new ArrayList<String>();
	        Kline kline;
	        ArrayList<String> time=new ArrayList<String>();
	        ArrayList<String> close=new ArrayList<String>();
	        ArrayList<String> open=new ArrayList<String>();
	        ArrayList<String> high=new ArrayList<String>();
	        ArrayList<String> low=new ArrayList<String>();
	        ArrayList<String> change=new ArrayList<String>();
	        ArrayList<String> vol=new ArrayList<String>();
	        ArrayList<String> amount=new ArrayList<String>();
	        
	        BufferedReader br=null;
	        try { 
	        	
	            br = new BufferedReader(new FileReader("src/main/java/com/example/stock/python/data/monthk.csv"));
	            String line = ""; 
	            while ((line = br.readLine()) != null) { 
	            	
	            		
	               //System.out.println(line);
	               String[] strings=line.split(",");
	               if (strings[1].equals(s)) {
	            	   time.add(strings[2]);
	            	   close.add(strings[3]);
	            	   open.add(strings[4]);
	            	   high.add(strings[5]);
	            	   low.add(strings[6]);
	            	   change.add(strings[7]);
	            	   vol.add(strings[8]);
	            	   amount.add(strings[9]);
	            	   System.out.println(strings[3]);
	               }
	               
	               //System.out.println(line.substring(j+1, i));
	               
	               //System.out.println("");
	               
	            }
	        }catch (Exception e) {
	        }
	        System.out.println(time.size());
	        kline=new Kline(s, time, close, open, high, low, change, vol, amount);
	        System.out.println(kline);
	       // for(int i=0;i<dataList.size();i++) {
	        //	System.out.println(dataList.get(i));
	        //}
	        return kline;
		}

	/*获得所有股票的ts_code
	返回类型：ArrayList<String>
	无参数传入
	* */
	 public ArrayList<String> getAllstocks(){
		 ArrayList<String> strings=new ArrayList<String>();
	        int k=0;
	        BufferedReader br=null;
	        try { 
	        	
	            br = new BufferedReader(new FileReader("src/main/java/com/example/stock/python/ts_code.csv"));
	            String line = ""; 
	            while ((line = br.readLine()) != null) { 
	            	if (k==0) {
	            		k=1;
	            		continue;
	            	}
	            	System.out.println(line);
	            	strings.add(line);
	               //System.out.println(line);
	              
	               //System.out.println(line.substring(j+1, i));
	               
	               //System.out.println("");
	               
	            }
	        }catch (Exception e) {
	        }
		return strings;
		 
	 }

	 /*根据code获得对应的股票预期信息
	* 返回：Forecast类型
	* 传入ts_code*/
	 public Forecast findForecast(String s) {
		 Forecast forecast;
	        BufferedReader br=null;
	        
	         ArrayList<String> ann_date=new ArrayList<String>();
	       ArrayList<String> end_date=new ArrayList<String>();
	        ArrayList<String> type=new ArrayList<String>();
	       ArrayList<String> p_change_min=new ArrayList<String>();
	        ArrayList<String> p_change_max=new ArrayList<String>();
	         ArrayList<String> net_profit_min=new ArrayList<String>();
	         ArrayList<String> net_profit_max=new ArrayList<String>();
	        ArrayList<String> summary=new ArrayList<String>();
	        ArrayList<String> change_reason=new ArrayList<String>();
	        try { 
	        	
	            br = new BufferedReader(new FileReader("src/main/java/com/example/stock/python/data/forecast.csv"));
	            String line = ""; 
	            while ((line = br.readLine()) != null) { 
	            	int index=line.indexOf(",");
		               
		               int i=line.indexOf(",",index+1);
		               if(line.substring(index+1, i).equals(s)){
		               //System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               ann_date.add(line.substring(index+1, i));
		               System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               end_date.add(line.substring(index+1, i));
		               System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               type.add(line.substring(index+1, i));
		               System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               p_change_min.add(line.substring(index+1, i));
		               System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               p_change_max.add(line.substring(index+1, i));
		               System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               net_profit_min.add(line.substring(index+1, i));
		               System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               net_profit_max.add(line.substring(index+1, i));
		               System.out.println(line.substring(index+1, i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               summary.add(line.substring(index+1,i));
		               System.out.println(line.substring(index+1,i));
		               index=i;
		               
		               i=line.indexOf(",",index+1);
		               change_reason.add(line.substring(index+1));
		               System.out.println(line.substring(index+1));
		               index=i;
	               //System.out.println(line);
		               }
	               //System.out.println(line.substring(j+1, i));
	               
	               //System.out.println("");
	               
	            }
	        }catch (Exception e) {
	        }
	        forecast=new Forecast(s, ann_date, end_date, type, p_change_min, p_change_max, net_profit_min, net_profit_max, summary, change_reason);
	 return forecast;
	 }


}
