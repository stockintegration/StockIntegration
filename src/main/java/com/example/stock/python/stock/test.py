import easyquotation

qt = easyquotation.use('sina')
qtt = easyquotation.use('tencent')
#print(qt.real('162411'))

#print(qtt.real('162411'))

count = 0
id = 600518
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
