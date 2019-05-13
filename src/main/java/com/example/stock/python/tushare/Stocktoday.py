import tushare as ts
import sys
import os
import pandas as pd


curPath = os.path.abspath(os.path.dirname(__file__))
rootPath = curPath[:curPath.find("python") + len("python")]
tscode = pd.read_csv(rootPath + '/ts_code.csv')
datapath = rootPath + '/data/todaydata.csv'
if os.path.exists(datapath):
    os.remove(datapath)
pro = ts.pro_api('ad61951cf7049e83378bc62f464f37ce45fb4032a1214d00b96d8e26')
data = ts.get_today_all()

data.to_csv(datapath,encoding='utf8')

# df.to_csv('~/PycharmProjects/StockIntegration/sw.csv',encoding="utf8")
