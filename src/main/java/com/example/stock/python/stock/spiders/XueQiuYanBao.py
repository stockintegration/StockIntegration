# -*- coding: utf-8 -*-
import scrapy

from stock.items import AiGuYanBao


class XuQiuSpider(scrapy.Spider):
    name = 'stockagyb'

    headers = {
        # 'Cookie' : 'xq_q_token=62c76bcb2dcc3aa55d754d345301ac59fbd80d07',
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36',
    }

    def start_requests(self):
        # urls=[]
        # with open("MyGitlabScrapy/spiders/gitlabweb.csv") as file:
        # for url in file:
        # urls.append(url)
        count = 1
        id = 600518
        base = 'http://istock.jrj.com.cn/yanbao_'
        urls = []
        ids = ['600760']
        for id in ids:
            while count < 5:
                if count == 1:
                    url = base + str(id) + '.html'
                    count = count + 1
                else:
                    count = count + 1
                    url = base + str(id) + '_p' + str(count) + '.html'
                urls.append(url)
                print(url)
            count = 0
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):

        stockall = response.xpath('//div[@class="istcon"]/div[1]/div[2]/table/tr')

        # t = response.xpath('//div[@class="IStock_DD is_topnav"]/div[1]/div[1]/dl/dt/a[1]/text()').extract
        # print(t)
       # / html / body / div[12] / div[1] / div[2] / table / tbody / tr[2] / td[3]
        pinglun = AiGuYanBao()
        for single in stockall[2:]:
            pinglun['id'] = '600760'
            pinglun['title'] = single.xpath('td[1]/span/a/@title').extract()
            pinglun['zuozhe'] = single.xpath('normalize-space(td[2]/text())').extract()
            pinglun['fatieshijian'] = single.xpath('td[3]/text()').extract()
            #/ html / body / div[12] / div[1] / div[2] / table / tbody / tr[2] / td[4]
            pinglun['zuihouhuifu'] = single.xpath('td[4]/text()').extract()
            print(pinglun)
            # print(pinglun)
            yield pinglun
