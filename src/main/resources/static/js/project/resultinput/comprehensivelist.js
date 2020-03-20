$(function () {
    initTable();

    //填充调查员 1.填充所有组织 2.填充所属此组织的角色 3.填充所属角色的人员
    $.ajax({
        url: '/admin/org',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            // $("#belongOrg").append("<option value=''>-</option>");
            for (var i = 0; i<result.length; i++){
                $("#belongOrg").append("<option value=\""+result[i].id+"\">"+result[i].name+"</option>");
            }
        }
    });

    $("#belongOrg").change(function () {
        $("#belongRole").empty();
        $("#belongRole").append("<option value=''>-</option>");
        $("#belongRole").trigger('change');
        $.ajax({
            url: '/admin/role/'+ ($("#belongOrg").val() == "" ? null : $("#belongOrg").val()),
            type: 'GET',
            data: 0,
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                $("#Per").append("<option value=''>-</option>");
                for (var i = 0; i<result.length; i++){
                    $("#belongRole").append("<option value=\""+result[i].id+"\">"+result[i].name+"</option>");
                }
            }
        });
    });

    $("#belongRole").change(function () {
        $("#Per").empty();
        $("#Per").append("<option value=''>-</option>");
        $("#Per").trigger('change');
        $.ajax({
            url: '/admin/getpersbyroleid/'+($("#belongRole").val() == "" ? null : $("#belongRole").val()),
            type: 'GET',
            data: 0,
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                for (var i = 0; i<result.length; i++){
                    $("#Per").append("<option value=\""+result[i].name+"\">"+result[i].name+"</option>");
                }
            }
        });
    });

    //填充所属部门
    // $.ajax({
    //     url: '/admin/allcorps',
    //     type: 'GET',
    //     data: 0,
    //     contentType:"application/json;charset=UTF-8",
    //     dataType:"json",
    //     success: function (result) {
    //         for (var i = 0; i<result.length; i++){
    //             $("#belongOrg").append("<option value=\""+result[i]+"\">"+result[i]+"</option>");
    //         }
    //     }
    // });

    //当筛选条件改变时， 刷新table
    $("#searchDateFrom, #searchDateTo, #clientsName, #Per").change(function () {
        $('#list').bootstrapTable('refresh', {url: '/project/comprehensivelist/'+($("#searchDateFrom").val() == "" ? null : $("#searchDateFrom").val()) + '/' + ($("#searchDateTo").val() == "" ? null : $("#searchDateTo").val()) + '/' +($("#clientsName").val() == "" ? null : $("#clientsName").val()) + '/' +($("#Per").val() == "" ? null : $("#Per").val())});
    });

});

//初始化table
function initTable() {
    $("#list").bootstrapTable({
        url: '/project/comprehensivelist/'+($("#searchDateFrom").val() == "" ? null : $("#searchDateFrom").val()) + '/' + ($("#searchDateTo").val() == "" ? null : $("#searchDateTo").val()) + '/' +($("#clientsName").val() == "" ? null : $("#clientsName").val()) + '/' +($("#Per").val() == "" ? null : $("#Per").val()),
        type:"GET",
        data: 0,
        uniqueId:"bickid",
        singleSelect:true,
        search: false,
        pagination: true,
        pageSize: 8,
        locale: 'zh-CN',
        paginationLoop: false,
        columns:[
            {
                field:'bickid',
                title:'流水号',
                align:'center',
                width:150
            }, {
                field:'deptName',
                title:'部门名称',
                align:'center',
                width:150
            }, {
                field:'clientName',
                title:'客户名称',
                align:'center',
                width:100
            }, {
                field:'inputDate',
                title:'录入时间',
                formatter: function(value, row, index){
                    return changeDateFormat(value)
                },
                align:'center',
                width:130
            }, {
                field:'inputer',
                title:'录入人',
                align:'center',
                width:100
            }, {
                field:'getDate',
                title:'调查日期',
                align:'center',
                formatter: function(value, row, index){
                    return changeDateFormat(value, row)
                },
                width:130
            }, {
                field:'geter',
                title:'调查人',
                align:'center',
                width:150
            }, {
                field:'isOver',
                title:"调查结果",
                align:"center",
                width:150,
                formatter:function (value) {
                    return operateClass(value);
                }
            }
        ]
    });
}

function operateClass(value, row) {
    if (value == 0){
        return[
            '<span class="glyphicon glyphicon-pencil"><a style="color: red;"> 未录入</a>',
        ].join('');
    }else if (value == 1){
        return[
            '<span class="glyphicon glyphicon-ok"><a style="color: green;"> 已录入</a>',
        ].join('');
    }
}

function changeDateFormat(target) {
    temp = target.substring(0, 10);
    return temp.replace(/-/g, '/');
}