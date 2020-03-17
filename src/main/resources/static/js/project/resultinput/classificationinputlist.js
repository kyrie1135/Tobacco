$(function () {

    initTable();

    //填充调查员 1.填充所有角色 2.填充所属此角色的人员
    $.ajax({
        url: '/admin/allroles',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length; i++){
                $("#belongRole").append("<option value=\""+result[i].id+"\">"+result[i].name+"</option>");
            }
        }
    });
    $("#Per").append("<option value=''>-</option>");
    $("#belongRole").change(function () {
        $("#Per").empty();
        $("#Per").append("<option value=''>-</option>");
        $.ajax({
            url: '/admin/getpersbyroleid/'+$("#belongRole").val(),
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

    //当筛选条件选择调查员时
    $("#Per").change(function () {
        $('#list').bootstrapTable('refresh', {url: '/project/classificationsearch/'+($("#Per").val() == "" ? null : $("#Per").val())});
    });

});

//初始化table
function initTable() {
    $("#list").bootstrapTable({
        url: '/project/classificationsearch/null',
        type:"GET",
        data: 0,
        uniqueId:"bickid",
        singleSelect:true,
        search: false,
        pagination: true,
        pageSize: 8,
        paginationLoop: false,
        columns:[
            {
                field:'indexName',
                title:'指标名称',
                align:'center',
                width:150
            }, {
                field:'satisfaction',
                title:'满意度',
                align:'center',
                width:150
            }, {
                field:'times',
                title:'次数',
                align:'center',
                width:100
            }, {
                field:'score',
                title:'得分',
                align:'center',
                width:130
            }
        ]
    });
}