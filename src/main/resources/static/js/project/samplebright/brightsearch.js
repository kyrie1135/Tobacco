$(function () {
    initTable();

    $("#searchDate, #clientsNum, #clientsName").change(function () {
        $('#list').bootstrapTable('refresh',{url:'/project/getClients/'+($("#searchDate").val() == "" ? null : $("#searchDate").val())+'/'+($("#clientsNum").val() == "" ? null : $("#clientsNum").val())+'/'+($("#clientsName").val() == "" ? null : $("#clientsName").val())});
    });
});

//初始化table
function initTable() {
    $("#list").bootstrapTable({
        url:'/project/getClients/'+($("#searchDate").val() == "" ? null : $("#searchDate").val())+'/'+($("#clientsNum").val() == "" ? null : $("#clientsNum").val())+'/'+($("#clientsName").val() == "" ? null : $("#clientsName").val()),
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
                field:'bickid',
                title:'#',
                align:'center',
                width:1
            }, {
                field:'sampleData',
                title:'抽样日期',
                align:'center',
                formatter: function(value, row, index){
                    return changeDateFormat(value)
                },
                width:150
            }, {
                field:'clientCode',
                title:'客户简码',
                align:'center',
                width:150
            }, {
                field:'clientName',
                title:'客户简称',
                align:'center',
                width:150
            }, {
                field:'diaochaData',
                title:'调查日期',
                align:'center',
                formatter: function(value, row, index){
                    return changeDateFormat(value)
                },
                width:150
            }, {
                field:'luruData',
                title:'录入日期',
                align:'center',
                formatter: function(value, row, index){
                    return changeDateFormat(value)
                },
                width:150
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
}

function changeDateFormat(target) {
    return target.substring(0, 10);
}