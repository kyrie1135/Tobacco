$(function () {
    initTable();

    //修改按钮
    $("#mainBtnEdit").click(function () {
        if ($("#list").bootstrapTable('getSelections').length == 0){
            $('#noChoice').modal('show');
        } else {
            $('#mainModalEdit').modal('show');
        }
    });
    //删除按钮
    $("#mainBtnDel").click(function () {
        if ($("#list").bootstrapTable('getSelections').length == 0){
            $('#noChoice').modal('show');
        } else {
            $('#mainModalDel').modal('show');
        }
    });
});

//初始化评测标准列表
function initTable() {
    $('#list').bootstrapTable({
        url:'/admin/satisfysurveytargetTable',
        type:"GET",
        uniqueId:"bickid",
        singleSelect:true,
        columns:[
            {
                checkbox: true
            },
            {
                field:'bickid',
                title:'#',
                align:'center',
                width:1
            },{
                field:'evaluateStandard',
                title:'评分标准',
                align:'center',
                width:100
            },{
                field:'evaluateTarget',
                title:'分值',
                align:'center',
                width:60
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
}
