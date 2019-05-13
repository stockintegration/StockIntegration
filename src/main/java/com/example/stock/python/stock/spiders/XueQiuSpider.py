# -*- coding: utf-8 -*-
import scrapy

from stock.items import AiGuPinglun


class XuQiuSpider(scrapy.Spider):
    name = 'stockagpl'

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
        id = 600518
        base = 'http://istock.jrj.com.cn/list'
        urls = []
        ids = ['300719', '300696', '002297', '002023', '300397', '600862', '300581', '002413', '002933', '600391',
               '300424', '000768', '300159', '000738', '600316', '600372', '600038', '002013', '600893', '002190',
               '600760']
        for id in ids:
            while count < 5:
                count = count + 1
                url = base + ',' + str(id) + ',p' + str(count) + '.html'
                urls.append(url)
                print(url)
            count = 0
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):

        stockall = response.xpath('//*[@id="topiclisttitle"]/tr')

        t = response.xpath('//div[@class="IStock_DD is_topnav"]/div[1]/div[1]/dl/dt/a[1]/text()').extract
        #print(t)

        pinglun = AiGuPinglun()
        for single in stockall[1:]:
            pinglun['id'] = response.xpath('//div[@class="IStock_DD is_topnav"]/div[1]/div[1]/dl/dt/a[1]/text()').extract()
            pinglun['title'] = single.xpath('normalize-space(td[3]/@title)').extract()
            pinglun['zuozhe'] = single.xpath('normalize-space(td[4]/text())').extract()
            pinglun['gengxin'] = single.xpath('td[5]/span/text()').extract()
            # print(pinglun)
            yield pinglun


