# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class StockItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    stock_code = scrapy.Field()
    stock_name = scrapy.Field()
    # 今开
    stock_today_openprice = scrapy.Field()
    # 最高
    stock_today_maxprice = scrapy.Field()
    # 最低
    stock_today_minprice = scrapy.Field()
    # 成交量
    stock_dealnum = scrapy.Field()
    # 总市值
    stock_allvalue = scrapy.Field()
    # 流通市值
    stock_transfervalue = scrapy.Field()
    # 市盈
    stock_earn = scrapy.Field()
    # 市净
    stock_true = scrapy.Field()
    # 资金今日主力净流入？？？？？
    stock__today_in = scrapy.Field()
    # 主力排名
    stock__today_in_range = scrapy.Field()
    # 资金5日主力净流入？？？？？
    stock__five_today_in = scrapy.Field()
    # 5主力排名
    stock__five_today_in_range = scrapy.Field()
    # 资金10日主力净流入？？？？？
    stock__ten_today_in = scrapy.Field()
    # 10主力排名
    stock__ten_today_in_range = scrapy.Field()
    pass


class XueQiuStockItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    stock_code = scrapy.Field()
    stock_name = scrapy.Field()
    # 今开
    stock_today_openprice = scrapy.Field()
    # 最高
    stock_today_maxprice = scrapy.Field()
    # 最低
    stock_today_minprice = scrapy.Field()
    # 昨收
    stock_yesterday_price = scrapy.Field()
    # 涨停
    stock_upstop = scrapy.Field()
    # 跌停
    stock_downstop = scrapy.Field()
    # 成交量
    stock_dealnum = scrapy.Field()
    # 成交额
    stock_dealprice = scrapy.Field()
    # 量比
    liangbi = scrapy.Field()
    # 换手
    huanshou = scrapy.Field()
    # 市盈率(动）
    shiyinglv_act = scrapy.Field()
    # 市盈率(TTM)
    shiyinglv_ttm = scrapy.Field()
    # 市盈率(静）
    shiyinglv_jing = scrapy.Field()
    # 市净率
    shijinglv = scrapy.Field()
    # 委比
    weibi = scrapy.Field()
    # 振幅
    zhenfu = scrapy.Field()

    meigushouyi = scrapy.Field()
    guxi = scrapy.Field()
    zongguben = scrapy.Field()
    zongshizhi = scrapy.Field()
    meigujingzichan = scrapy.Field()
    guxilv = scrapy.Field()
    liutonggu = scrapy.Field()
    liutongzhi = scrapy.Field()

    wuerzhouzuigao = scrapy.Field()
    wuerzhouzuidi = scrapy.Field()
    huobidanwei = scrapy.Field()
    pass


class AiGuPinglun(scrapy.Item):
    id = scrapy.Field()
    title = scrapy.Field()
    zuozhe = scrapy.Field()
    gengxin = scrapy.Field()
    pass
class DongfangPinglun(scrapy.Item):
    id = scrapy.Field()
    title = scrapy.Field()
    zuozhe = scrapy.Field()
    gengxin = scrapy.Field()
    pass