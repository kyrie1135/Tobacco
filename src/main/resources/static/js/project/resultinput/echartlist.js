
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
    var yearAndMonth = [];
    var score = [];
    $.ajax({
        url: '/project/monthscore',
        type: 'GET',
        data: 0,
        async: false,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length ; i++){
                yearAndMonth.push(result[i].yearAndMonth);
                score.push(result[i].score);
            }
        }
    });
    option_two = {
        xAxis: {
            type: 'category',
            data: yearAndMonth
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: score,
            type: 'line'
        }]
    };
    myChartTwo.setOption(option_two);

    //分指标折线图
    var myChartThree = echarts.init(document.getElementById('main_three'));
    var zhibiao = [];
    var ser = [];
    $.ajax({
        url: '/project/targetmonthscore',
        type: 'GET',
        data: 0,
        async: false,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            //填充指标名称（去重）
            var flag = true;
            for (var i = 0; i<result.length ; i++){
                for (var j = 0; j<zhibiao.length; j++){
                    if (zhibiao[j] == result[i].zhibiao){
                        flag = false;
                    }
                }
                if (flag == true){
                    zhibiao.push(result[i].zhibiao);
                }
            }

            //填充各个指标每个月的分数
            for (var i = 0; i<zhibiao.length; i++){
                var s = {
                    name: zhibiao[i],
                    type: 'line',
                    stack: '总分',
                    areaStyle: {},
                    data: []
                }

                for(var j = 0; j<result.length; j++){
                    if (result[j].zhibiao == zhibiao[i]){
                        s.data.push(result[j].score);
                    }
                }

                ser.push(s);
            }


        }
    });
    option_three = {
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
            data: zhibiao
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
                data: yearAndMonth
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: ser
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
