# -*- coding: utf-8 -*-
import scrapy

from stock.items import DongfangPinglun


class DongfangSpider(scrapy.Spider):
    name = 'stockdfpl'

    headers = {
        # 'Cookie' : 'xq_q_token=62c76bcb2dcc3aa55d754d345301ac59fbd80d07',
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36',
    }

    def start_requests(self):
        # urls=[]
        # with open("MyGitlabScrapy/spiders/gitlabweb.csv") as file:
        # for url in file:
        # urls.append(url)
        count = 0

        base = 'http://guba.eastmoney.com/list'
        urls = []
        ids = ['300719', '300696', '002297', '002023', '300397', '600862', '300581', '002413', '002933', '600391',
               '300424', '000768', '300159', '000738', '600316', '600372', '600038', '002013', '600893', '002190',
               '600760']
        for id in ids:
            while count < 5:
                count = count + 1
                url = base + ',' + str(id) + '_' + str(count) + '.html'
                urls.append(url)
                print(url)
            count = 0
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):

        stockall = response.xpath('//*[@id="articlelistnew"]/div')

        t = response.xpath('//*[@id="stockname"]/@data-popstock').extract()
        #print(t)

        pinglun = DongfangPinglun()
        for single in stockall:
            pinglun['id'] = response.xpath('//*[@id="stockname"]/@data-popstock').extract()
            pinglun['title'] = single.xpath('span[3]/a/@title').extract()
            pinglun['zuozhe'] = single.xpath('span[4]/a/text()').extract()
            pinglun['gengxin'] = single.xpath('span[5]/text()').extract()

            yield pinglun