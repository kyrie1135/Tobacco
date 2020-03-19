$(function () {
    initTable();
});

//初始化table
function initTable() {
    $("#list").bootstrapTable({
        url: '/admin/subscript',
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
                title: '序号',
                formatter: function (value, row, index) {
                    return index+1;
                },
                align:'center',
                width:30
            },{
                field:'evaluateTargetBickid',
                title:'调查项目',
                align:'center',
                formatter: function(row, value, index){
                    return getEvaluateTarget(value);
                },
                width:150
            }, {
                field:'evaluateTargetBickid',
                title:'汇总数量',
                align:'center',
                formatter: function(row, value, index){
                    return getEvaluateTargetNum(value);
                },
                width:150
            }, {
                title: '   ',
                align:'center',
                events:'operateEvents',
                formatter: function(row, value, index){
                    return getDetails(value);
                },
                width:150
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
}

//调查项目
function getEvaluateTarget(value) {
    var temp = "";
    $.ajax({
        url: '/admin/getdescriptionbybickid',
        type: 'GET',
        data: {
            bickid : value.evaluateTargetBickid
        },
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        async:false,
        success: function (result) {
            temp = result.itemName;
        }
    });
    return temp;
}

//汇总数量
function getEvaluateTargetNum(value) {
    var temp = "";
    $.ajax({
        url: '/admin/getdescriptionnumbybickid',
        type: 'GET',
        data: {
            bickid : value.bickid
        },
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        async:false,
        success: function (result) {
            temp = result.length;
        }
    });
    return temp;
}

//返回详情
function getDetails() {
    return[
        '<a type="submit" id="xiangqing" style="color: blue; cursor: pointer">..详情..</a>',
    ].join('');
}

//暂存调查指标bickid
var temp = "";
window.operateEvents={
    'click #xiangqing': function (e, value, row) {
        temp = row.bickid;
        $("#myModalLabel").text(row.evaluateTarget);
        initModelTable();
        //获得所有的评测标准， 并填充到模态框中
        $.ajax({
            url: '/admin/standard',
            type: 'GET',
            data: 0,
            async: false,
            success: function (result) {
                $("#luruMain").append();
            }
        });
        $('#myModel').modal('show');
        // $.ajax({
        //     url: '/project/',
        //     type: 'GET',
        //     data: {
        //         subscriptBickid : JSON.stringify(row.subscriptBickid)
        //     },
        //     success: function (result) {
        //
        //     }
        // });
    }
}

//初始化model中的table
function initModelTable() {
    heji = 0;
    $("#modelList").bootstrapTable({
        url: '/admin/standard',
        type:"GET",
        data: 0,
        uniqueId:"bickid",
        singleSelect:true,
        search: false,
        pagination: true,
        pageSize: 8,
        paginationLoop: false,
        showFooter:true,
        columns:[
            {
                field:'bickid',
                title:'#',
                align:'center',
                width:1
            }, {
                title: '序号',
                formatter: function (value, row, index) {
                    return index+1;
                },
                align:'center',
                width:30
            },{
                field:'evaluateStandard',
                title:'满意度项目',
                align:'center',
                footerFormatter: function(value){
                    return "合计";
                },
                width:150
            },{
                field:'evaluateStandard',
                title:'汇总数量',
                align:'center',
                formatter: function (value, row, index) {
                    return getStandardNum(value, row, index);
                },
                footerFormatter: function(){
                    return heji;
                },
                width:150
            }
        ]
    });
    $('#modelList').bootstrapTable('hideColumn','bickid');
}

var heji = 0;
function getStandardNum(value, row, index) {
    var num = "";
    //根据评测指标bickid和评测标准bickid或得评测标准的数量
    $.ajax({
        url: '/admin/gettargetnum',
        type: 'GET',
        data: {
            subscriptBickid : temp,
            targetBickid : row.bickid
        },
        async: false,
        success: function (result) {
            num = result;
        }
    });
    heji += num;
    return num;
}
