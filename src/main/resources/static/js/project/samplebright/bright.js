$(function () {

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

});