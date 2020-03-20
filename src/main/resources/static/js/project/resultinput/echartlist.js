
$(function () {
    //设置显示指标div的高度
    var ifm= window.parent.document.getElementById("mainIframe");
    $("#main").height(ifm.height/2);
    $("#main_two").height(ifm.height/2-20);
    $("#main_two").width(ifm.offsetWidth/2);
    $("#main_three").height(ifm.height/2-20);
    $("#main_three").width(ifm.offsetWidth/2-13);

    //1. 根据评测标准个数, 生成多个div
    $.ajax({
        url: '/admin/standard',
        type: 'GET',
        data: 0,
        async: false,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length; i++){
                $("#main").append("<div id=\"mainechart"+result[i].bickid+"\" style=\"width: 600px;height:400px;float: left\"></div>");

                //2.为每一个div添加饼图
                var myChart = echarts.init(document.getElementById('mainechart'+result[i].bickid));
                var data = genData(result[i].bickid, result[i].evaluateStandard);

                option = {
                    title: {
                        text: data.text,
                        subtext: '纯属虚构',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        right: 10,
                        top: 20,
                        bottom: 20,
                        data: data.legendData,

                        selected: data.selected
                    },
                    series: [
                        {
                            name: '姓名',
                            type: 'pie',
                            radius: '55%',
                            center: ['40%', '50%'],
                            data: data.seriesData,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };

                myChart.setOption(option);
            }
        }
    });

    //折线图
    var myChartTwo = echarts.init(document.getElementById('main_two'));
    option_two = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };
    myChartTwo.setOption(option_two);

    //分指标折线图
    var myChartThree = echarts.init(document.getElementById('main_three'));
    option_three = {
        title: {
            text: '堆叠区域图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '邮件营销',
                type: 'line',
                stack: '总量',
                areaStyle: {},
                data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
                name: '联盟广告',
                type: 'line',
                stack: '总量',
                areaStyle: {},
                data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
                name: '视频广告',
                type: 'line',
                stack: '总量',
                areaStyle: {},
                data: [150, 232, 201, 154, 190, 330, 410]
            },
            {
                name: '直接访问',
                type: 'line',
                stack: '总量',
                areaStyle: {},
                data: [320, 332, 301, 334, 390, 330, 320]
            },
            {
                name: '搜索引擎',
                type: 'line',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'top'
                    }
                },
                areaStyle: {},
                data: [820, 932, 901, 934, 1290, 1330, 1320]
            }
        ]
    };
    myChartThree.setOption(option_three);

});


function genData(bickid, evaluateStandard) {
    var legendData = [];
    var seriesData = [];
    var selected = {};

    //获取维护的评测指标
    $.ajax({
        url: '/admin/subscript',
        type: 'GET',
        data: 0,
        async:false,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length; i++){
                temp = 0;
                legendData.push(result[i].evaluateTarget);
                //通过评测指标bickid和评测标准bickid查个数
                $.ajax({
                    url: '/admin/gettargetnum',
                    type: 'GET',
                    data:{
                        subscriptBickid : result[i].bickid,
                        targetBickid : bickid
                    },
                    async: false,
                    contentType:"application/json;charset=UTF-8",
                    dataType:"json",
                    success: function (result) {
                        temp = result;
                    }
                });
                seriesData.push({
                    name: result[i].evaluateTarget,
                    value: temp
                });
                if (temp == 0){
                    selected[result[i].evaluateTarget] = false;
                }
            }
        }
    });

    return {
        text : evaluateStandard,
        legendData: legendData,
        seriesData: seriesData,
        selected: selected
    };

}
