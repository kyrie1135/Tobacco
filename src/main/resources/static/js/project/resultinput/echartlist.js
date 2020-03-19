
$(function () {
    //设置显示指标div的高度
    var ifm= window.parent.document.getElementById("mainIframe");
    $("#main").height(ifm.height);

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

// var myChart = echarts.init(document.getElementById('main'));
// var data = genData(50);
//
// option = {
//     title: {
//         text: '同名数量统计',
//         subtext: '纯属虚构',
//         left: 'center'
//     },
//     tooltip: {
//         trigger: 'item',
//         formatter: '{a} <br/>{b} : {c} ({d}%)'
//     },
//     legend: {
//         type: 'scroll',
//         orient: 'vertical',
//         right: 10,
//         top: 20,
//         bottom: 20,
//         data: data.legendData,
//
//         selected: data.selected
//     },
//     series: [
//         {
//             name: '姓名',
//             type: 'pie',
//             radius: '55%',
//             center: ['40%', '50%'],
//             data: data.seriesData,
//             emphasis: {
//                 itemStyle: {
//                     shadowBlur: 10,
//                     shadowOffsetX: 0,
//                     shadowColor: 'rgba(0, 0, 0, 0.5)'
//                 }
//             }
//         }
//     ]
// };
//
// myChart.setOption(option);
//
//
// function genData(count) {
//     var nameList = [
//         '赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张', '孔', '曹', '严', '华', '金', '魏', '陶', '姜', '戚', '谢', '邹', '喻', '柏', '水', '窦', '章', '云', '苏', '潘', '葛', '奚', '范', '彭', '郎', '鲁', '韦', '昌', '马', '苗', '凤', '花', '方', '俞', '任', '袁', '柳', '酆', '鲍', '史', '唐', '费', '廉', '岑', '薛', '雷', '贺', '倪', '汤', '滕', '殷', '罗', '毕', '郝', '邬', '安', '常', '乐', '于', '时', '傅', '皮', '卞', '齐', '康', '伍', '余', '元', '卜', '顾', '孟', '平', '黄', '和', '穆', '萧', '尹', '姚', '邵', '湛', '汪', '祁', '毛', '禹', '狄', '米', '贝', '明', '臧', '计', '伏', '成', '戴', '谈', '宋', '茅', '庞', '熊', '纪', '舒', '屈', '项', '祝', '董', '梁', '杜', '阮', '蓝', '闵', '席', '季', '麻', '强', '贾', '路', '娄', '危'
//     ];
//     var legendData = [];
//     var seriesData = [];
//     var selected = {};
//     for (var i = 0; i < count; i++) {
//         name = Math.random() > 0.65
//             ? makeWord(4, 1) + '·' + makeWord(3, 0)
//             : makeWord(2, 1);
//         legendData.push(name);
//         seriesData.push({
//             name: name,
//             value: Math.round(Math.random() * 100000)
//         });
//         selected[name] = i < 6;
//     }
//
//     return {
//         legendData: legendData,
//         seriesData: seriesData,
//         selected: selected
//     };
//
//     function makeWord(max, min) {
//         var nameLen = Math.ceil(Math.random() * max + min);
//         var name = [];
//         for (var i = 0; i < nameLen; i++) {
//             name.push(nameList[Math.round(Math.random() * nameList.length - 1)]);
//         }
//         return name.join('');
//     }
// }
