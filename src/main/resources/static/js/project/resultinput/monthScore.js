
$(function () {
    initTable();
});

//初始化table
function initTable() {
    $("#list").bootstrapTable({
        url: '/project/monthscore',
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
                field:'yearAndMonth',
                title:'日期',
                align:'center',
                width:150
            }, {
                field:'num',
                title:'调查总数',
                align:'center',
                width:150
            }, {
                field:'score',
                title:'总得分',
                formatter: function(value, row, index){
                    return changeFormat(value)
                },
                align:'center',
                width:150
            }
        ]
    });
}

function changeFormat(value) {
    return value.toFixed(2);
}