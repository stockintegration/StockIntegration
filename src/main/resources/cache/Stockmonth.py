import tushare as ts
import sys
import os
import pandas as pd


curPath = os.path.abspath(os.path.dirname(__file__))
rootPath = curPath[:curPath.find("python") + len("python")]
tscode = pd.read_csv(rootPath + '/ts_code.csv')
datapath = rootPath + '/data/monthk.csv'
if os.path.exists(datapath):
    os.remove(datapath)
pro = ts.pro_api('ad61951cf7049e83378bc62f464f37ce45fb4032a1214d00b96d8e26')

for tscode in tscode.ts_code:


    df = pro.monthly(ts_code=tscode, start_date='20180101',end_date='20190430',fields='ts_code,trade_date,open,high,low,close,vol,amount,change')
    #print(df)

    if os.path.exists(datapath):
        df.to_csv(datapath, mode='a',header=None)
    else:
        df.to_csv(datapath)

# df.to_csv('~/PycharmProjects/StockIntegration/sw.csv',encoding="utf8")
