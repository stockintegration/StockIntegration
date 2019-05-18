var ts_code=window.location.search.substr(1)
var comments=[]
var researchs=[]
var totalPages=0
var reTotalPages=0
$.ajax({
    type: "POST",
    url: "http://localhost:8080/basicInfo",
    data: {"ts_code": ts_code},
    async: false,
    success: function (data) {
        document.getElementById('chairman').innerHTML=data.chairman
        document.getElementById('manager').innerHTML=data.manager
        document.getElementById('secretary').innerHTML=data.secretary
        document.getElementById('reg_capital').innerHTML=data.reg_capital
        document.getElementById('setup_date').innerHTML=data.setup_date.substr(0,4)+"-"+data.setup_date.substr(4,2)+"-"+data.setup_date.substr(6,2)
        document.getElementById('location').innerHTML=data.province+"-"+data.city
        document.getElementById('introduction').innerHTML=data.introduction
    }
})

$.ajax({
    type:"POST",
    url:"http://localhost:8080/kline",
    data:{"ts_code":ts_code},
    async:false,
    success:function (data) {
        // 数据意义：开盘(open)，收盘(close)，最低(lowest)，最高(highest)
        var k_data=[]
        //alert(JSON.stringify(data))
        for(var i=data.timelist.length-1;i>=0;i--){
            var k_signle_data=[]

            k_signle_data.push(data.timelist[i].substr(0,4)+"-"+data.timelist[i].substr(4,2)+"-"+data.timelist[i].substr(6,2))
            k_signle_data.push(data.openlist[i])
            k_signle_data.push(data.closelist[i])
            k_signle_data.push(data.lowlist[i])
            k_signle_data.push(data.highlist[i])
            k_data.push(k_signle_data)
        }
        var data0 = splitData(k_data);


        function splitData(rawData) {
            var categoryData = [];
            var values = []
            for (var i = 0; i < rawData.length; i++) {
                categoryData.push(rawData[i].splice(0, 1)[0]);
                values.push(rawData[i])
            }
            return {
                categoryData: categoryData,
                values: values
            };
        }

        function calculateMA(dayCount) {
            var result = [];
            for (var i = 0, len = data0.values.length; i < len; i++) {
                //alert(i)
                if (i < dayCount) {
                    result.push('-');
                    continue;
                }
                var sum = 0;
                for (var j = 0; j < dayCount; j++) {
                    //alert(data0.values[i-j][1])
                    sum += parseFloat(data0.values[i - j][1]);
                }
                //alert(sum)
                result.push(sum / dayCount);
            }
            return result;
        }



        option = {
            title: {
                text: '月k',
                left: 100
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            legend: {
                data: ['月K', 'MA5', 'MA10']
            },
            grid: {
                bottom: '15%'
            },
            xAxis: {
                type: 'category',
                data: data0.categoryData,
                scale: true,
                boundaryGap : false,
                axisLine: {onZero: false},
                splitLine: {show: false},
                splitNumber: 20,
                min: 'dataMin',
                max: 'dataMax'
            },
            yAxis: {
                scale: true,
                splitArea: {
                    show: true
                }
            },
            series: [
                {
                    name: '月K',
                    type: 'candlestick',
                    data: data0.values,
                    markPoint: {
                        label: {
                            normal: {
                                formatter: function (param) {
                                    return param != null ? Math.round(param.value) : '';
                                }
                            }
                        },
                        data: [
                            {
                                name: 'XX标点',
                                coord: ['2013/5/31', 2300],
                                value: 2300,
                                itemStyle: {
                                    normal: {color: 'rgb(41,60,85)'}
                                }
                            },
                            {
                                name: 'highest value',
                                type: 'max',
                                valueDim: 'highest'
                            },
                            {
                                name: 'lowest value',
                                type: 'min',
                                valueDim: 'lowest'
                            },
                            {
                                name: 'average value on close',
                                type: 'average',
                                valueDim: 'close'
                            }
                        ],
                        tooltip: {
                            formatter: function (param) {
                                return param.name + '<br>' + (param.data.coord || '');
                            }
                        }
                    },
                    markLine: {
                        symbol: ['none', 'none'],
                        data: [
                            [
                                {
                                    name: 'from lowest to highest',
                                    type: 'min',
                                    valueDim: 'lowest',
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    label: {
                                        normal: {show: false},
                                        emphasis: {show: false}
                                    }
                                },
                                {
                                    type: 'max',
                                    valueDim: 'highest',
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    label: {
                                        normal: {show: false},
                                        emphasis: {show: false}
                                    }
                                }
                            ],
                            {
                                name: 'min line on close',
                                type: 'min',
                                valueDim: 'close'
                            },
                            {
                                name: 'max line on close',
                                type: 'max',
                                valueDim: 'close'
                            }
                        ]
                    }

                },
                {
                    name: 'MA5',
                    type: 'line',
                    data: calculateMA(5),
                    smooth: true,
                    lineStyle: {
                        normal: {opacity: 0.5}
                    }
                },
                {
                    name: 'MA10',
                    type: 'line',
                    data: calculateMA(10),
                    smooth: true,
                    lineStyle: {
                        normal: {opacity: 0.5}
                    }
                }

            ]
        };
        var myChart = echarts.init(document.getElementById('kline'));
        myChart.setOption(option);


    }

})

$.ajax({
    type:"POST",
    url:"http://localhost:8080/forcast",
    data:{"ts_code":ts_code},
    async:false,
    success:function (data) {
        for(var i=0;i<data.ann_date.length;i++){
            document.getElementById('forecast').innerHTML+="        <div class=\"row\">\n" +
                "            <div class=\"col-md-2 info-title\">公告日期</div>\n" +
                "            <div class=\"col-md-1\">"+data.ann_date[i].substr(0,4)+"."+data.ann_date[i].substr(4,2)+"."+data.ann_date[i].substr(6,2)+"</div>\n" +
                "            <div class=\"col-md-2 info-title\">结束日期</div>\n" +
                "            <div class=\"col-md-1\">"+data.end_date[i].substr(0,4)+"."+data.end_date[i].substr(4,2)+"."+data.end_date[i].substr(6,2)+"</div>\n" +
                "            <div class=\"col-md-2 info-title\">类型</div>\n" +
                "            <div class=\"col-md-1\">"+data.type[i]+"</div>\n" +
                "            <div class=\"col-md-1 info-title\">业绩预告摘要</div>\n" +
                "            <div class=\"col-md-2\">"+data.summary[i]+"</div>\n" +
                "        </div>\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col-md-2 info-title\">预告净利润变动幅度下限</div>\n" +
                "            <div class=\"col-md-1\">"+data.p_change_min[i]+"%"+"</div>\n" +
                "            <div class=\"col-md-2 info-title\">预告净利润变动幅度上限</div>\n" +
                "            <div class=\"col-md-1\">"+data.p_change_max[i]+"%"+"</div>\n" +
                "            <div class=\"col-md-2 info-title\">预告净利润下限(万元)</div>\n" +
                "            <div class=\"col-md-1\">"+data.net_profit_min[i]+"</div>\n" +
                "            <div class=\"col-md-2 info-title\">预告净利润上限(万元)</div>\n" +
                "            <div class=\"col-md-1\">"+data.net_profit_max[i]+"</div>\n" +
                "        </div>\n"
                if(i!=data.ann_date.length-1) {
                    document.getElementById("forecast").innerHTML += "        <div class=\"row\">\n" +
                        "            <div class=\"col-md-2 info-title\">业绩变动原因</div>\n" +
                        "            <div class=\"col-md-10\">" + data.change_reason[i] + "</div>\n" +
                        "        </div>"
                }
                else{
                    document.getElementById("forecast").innerHTML += "        <div class=\"row\" style=\"border-bottom: 1px solid \">\n" +
                        "            <div class=\"col-md-2 info-title\">业绩变动原因</div>\n" +
                        "            <div class=\"col-md-10\">" + data.change_reason[i] + "</div>\n" +
                        "        </div>"
                }
        }
    }
})

$.ajax({
    type:"POST",
    url:"http://localhost:8080/comment",
    async:false,
    data:{"ts_code":ts_code},
    success:function (data) {
        comments=data
        if(data.length<=20) {
            for (var i = 0; i < data.length; i++) {
                document.getElementById('comment').innerHTML += "            <tr><td>" + data[i] + "</td></tr>\n"
            }
        }
        else {
            for (var i = 0; i < 20; i++) {
                document.getElementById('comment').innerHTML += "            <tr><td>" + data[i] + "</td></tr>\n"
            }

            totalPages = Math.floor((data.length - 1) / 20) + 1;
            document.getElementById('pagination').innerHTML+=" <li><a href=\"javascript:void(0)\" onclick='turnPage(1)'>&laquo;</a></li>"
            for (var i = 1; i <= totalPages; i++) {
                document.getElementById('pagination').innerHTML += "<li><a href='javascript:void(0)' onclick='turnPage("+i+")'>"+i+"</a></li>"
            }
            document.getElementById('pagination').innerHTML+=" <li><a href=\"javascript:void(0)\" onclick='turnPage("+totalPages+")'>&raquo;</a></li>"

        }
    }
})

$.ajax({
    type:"POST",
    url:"http://localhost:8080/research",
    async:false,
    data:{"ts_code":ts_code},
    success:function (data) {
        alert(data.length)
        researchs=data
        if(data.length<=20) {
            for (var i = 0; i < data.length; i++) {
                 document.getElementById('research').innerHTML += "            <tr><td colspan='6'>" + data[i].title + "</td>" +
                     "<td colspan='3'>"+data[i].author+"</td>"+
                     "<td colspan='3'>"+data[i].time+"</td></tr>"
            }
        }
        else {
            for (var i = 0; i < 20; i++) {
                document.getElementById('research').innerHTML += "            <tr><td colspan='6'>" + data[i].title + "</td>" +
                    "<td colspan='3'>"+data[i].author+"</td>"+
                    "<td colspan='3'>"+data[i].time+"</td></tr>"
            }

            reTotalPages = Math.floor((data.length - 1) / 20) + 1;
            document.getElementById('pagination2').innerHTML+=" <li><a href=\"javascript:void(0)\" onclick='turnPage2(1)'>&laquo;</a></li>"
            for (var i = 1; i <= reTotalPages; i++) {
                document.getElementById('pagination2').innerHTML += "<li><a href='javascript:void(0)' onclick='turnPage2("+i+")'>"+i+"</a></li>"
            }
            document.getElementById('pagination2').innerHTML+=" <li><a href=\"javascript:void(0)\" onclick='turnPage2("+reTotalPages+")'>&raquo;</a></li>"

        }
    }
})

function turnPage(page) {
    document.getElementById('comment').innerHTML = ""
    if (page == totalPages) {
        for (var i = 20 * (page - 1); i < comments.length; i++) {
            document.getElementById('comment').innerHTML += "            <tr><td>" + comments[i] + "</td></tr>\n"
        }
    }
    else {
        for (var i = 20 * (page - 1); i < page * 20; i++) {
            document.getElementById('comment').innerHTML += "            <tr><td>" + comments[i] + "</td></tr>\n"
        }
    }
}

/**
 * 研究翻页
 * @param page
 */
function turnPage2(page) {
    document.getElementById('research').innerHTML = ""
    if (page == totalPages) {
        for (var i = 20*(page - 1); i < researchs.length; i++) {
            document.getElementById('research').innerHTML += "            <tr><td colspan='6'>" + researchs[i].title + "</td>" +
                "<td colspan='3'>"+researchs[i].author+"</td>"+
                "<td colspan='3'>"+researchs[i].time+"</td></tr>"
        }
    }
    else {
        for (var i = 20 * (page - 1); i < page * 20; i++) {
            document.getElementById('research').innerHTML += "            <tr><td colspan='6'>" + researchs[i].title + "</td>" +
                "<td colspan='3'>"+researchs[i].author+"</td>"+
                "<td colspan='3'>"+researchs[i].time+"</td></tr>"
        }
    }
}