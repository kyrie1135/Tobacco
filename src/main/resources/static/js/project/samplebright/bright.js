$(function () {

    initTable();
    setDateMaxToToday();
    //筛选-》保存点击
    $("#btn_empRole_ok").click(function () {
        var arr = $('#clientTable').bootstrapTable('getData');

        $.ajax({
            url: '/project/saveSearchClients',
            type: 'POST',
            data: {
                params : JSON.stringify(arr),
                date : JSON.stringify($("#getDate").val()),
                diaochaDate : JSON.stringify($("#diaochaDate").val()),
                luruDate : JSON.stringify($("#luruDate").val()),
                luruPer : JSON.stringify($("#luruPer").val())
            },
            success: function (result) {
                $('#myModal').modal('hide');
                alert("保存成功， 请在督查抽样分析处查看")
            }
        });
    });
    //抽样日期填充当前日期
    var now = new Date();
    var time = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
    $("#getDate").val(time);

    //为客户经理select填充options
    $.ajax({
        url: '/project/getMgrs',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            $("#clientMGR").append("<option>所有客户经理</option>");
            for (var i = 0; i<result.length ; i++){
                $("#clientMGR").append("<option>"+ result[i] +"</option>");
            }
        }
    });

    //为客户分类select填充options
    $.ajax({
        url: '/project/getTypes',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            $("#clientType").append("<option>所有客户分类</option>");
            for (var i = 0; i<result.length ; i++){
                $("#clientType").append("<option>"+ result[i] +"</option>");
            }
        }
    });

    //为经营业态select填充options
    $.ajax({
        url: '/project/getStates',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            $("#workState").append("<option>所有经营状态</option>");
            for (var i = 0; i<result.length ; i++){
                $("#workState").append("<option>"+ result[i] +"</option>");
            }
        }
    });

    //筛选点击
    $("#search").click(function () {
        if ($("#getNum").val() == ""){
            alert("请填写抽样数量");
        }else if ($("#diaochaDate").val() == ""){
            alert("请填写调查日期");
        }else if ($("#luruDate").val() == ""){
            alert("请填写录入日期");
        }else if ($("#luruPer").val() == ""){
            alert("请填写录入人员")
        }else {
            $('#myModal').modal('show');
            $('#clientTable').bootstrapTable('refresh',{url:'/project/searchClients/'+$("#clientType").val()+'/'+$("#workState").val()+'/'+$("#clientMGR").val()+'/'+$("#getNum").val()});
        }
    });

});

function initTable() {
    $("#clientTable").bootstrapTable({
        url:'',
        type:"GET",
        uniqueId:"clientCode",
        singleSelect:true,
        search: false,
        pagination: true,
        pageSize: 8,
        paginationLoop: false,
        columns:[
            {
                checkbox: true
            }, {
                field:'clientCode',
                title:'#',
                align:'center',
                width:1
            }, {
                field:'facilityNum',
                title:'客户简码',
                align:'center',
                width:150
            }, {
                field:'clientName',
                title:'客户名称',
                align:'center',
                width:150
            }
        ]
    });
    $('#clientTable').bootstrapTable('hideColumn','clientCode');
}

$(function(){

})

function setDateMaxToToday() {
    var date_now = new Date();
    //得到当前年份
    var year = date_now.getFullYear();
    //得到当前月份
    var month = date_now.getMonth()+1 < 10 ? "0"+(date_now.getMonth()+1) : (date_now.getMonth()+1);
    //得到当前日子（多少号）
    var date = date_now.getDate() < 10 ? "0"+date_now.getDate() : date_now.getDate();
    //设置input标签的max属性
    $("#diaochaDate, #luruDate").attr("min",year+"-"+month+"-"+date);
}