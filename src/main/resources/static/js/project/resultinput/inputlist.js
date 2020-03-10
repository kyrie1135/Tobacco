
var tempSatisfysurveytargetBickid = "";
var tempClientCode = "";

$(function () {
    initTable();

    $("#searchDateFrom, #searchDateTo").change(function () {
        $('#list').bootstrapTable('refresh',{url: '/project/inputlist/'+($("#searchDateFrom").val() == "" ? null : $("#searchDateFrom").val()) + '/' + ($("#searchDateTo").val() == "" ? null : $("#searchDateTo").val())});
    });

    $("#btn_empRole_ok").click(function () {
        $.ajax({
            url: '/project/saveinputresult',
            type: 'POST',
            data: JSON.stringify({
               "satisfysurveytargetBickid" : tempSatisfysurveytargetBickid,
                "subscriptBickid" : $("[name = 'pingfen']").val(),
                "clientCode" : tempClientCode
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                $('#luru').modal('hide');
                $('#list').bootstrapTable('refresh',{url: '/project/inputlist/'+($("#searchDateFrom").val() == "" ? null : $("#searchDateFrom").val()) + '/' + ($("#searchDateTo").val() == "" ? null : $("#searchDateTo").val())});
            }
        });

    });
});

//初始化table
function initTable() {
    $("#list").bootstrapTable({
        url: '/project/inputlist/'+($("#searchDateFrom").val() == "" ? null : $("#searchDateFrom").val()) + '/' + ($("#searchDateTo").val() == "" ? null : $("#searchDateTo").val()),
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
                field:'deptName',
                title:'部门名称',
                align:'center',
                width:150
            }, {
                field:'clientName',
                title:'客户名称',
                align:'center',
                width:150
            }, {
                field:'inputDate',
                title:'录入时间',
                formatter: function(value, row, index){
                    return changeDateFormat(value)
                },
                align:'center',
                width:150
            }, {
                field:'inputer',
                title:'录入人',
                align:'center',
                width:150
            }, {
                field:'getDate',
                title:'调查日期',
                align:'center',
                formatter: function(value, row, index){
                    return changeDateFormat(value, row)
                },
                width:150
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
                events:'operateEvents',
                formatter:function (value) {
                    return operateClass(value);
                }
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
}

function operateClass(value, row) {
    if (value == 0){
        return[
            '<a type="submit" id="luruA" style="color: red; cursor: pointer">..录入..</a>',
        ].join('');
    }else if (value == 1){
        return[
            '<a type="submit" id="yiluruA" style="color: green; cursor: pointer">..已录入..</a>',
        ].join('');
    }
}

window.operateEvents={
    'click #luruA': function (e, value, row) {
        $.ajax({
            url: '/project/toInputResult',
            type: 'GET',
            data: {
                subscriptBickid : JSON.stringify(row.subscriptBickid)
            },
            success: function (result) {
                $("#luruMain").empty();
                $("[name = 'pingfen']").empty();
                for (var i = 0; i<result.zhibiaoNames.length; i++){
                    $("#luruMain").append("<label class=\"col-sm-12\" name=\"biaozhun\">"+result.zhibiaoNames[i]+"</label>");
                    $("#luruMain").append("<select class=\"form-control col-sm-12\" name=\"pingfen\"></select>");
                }
                for (var j = 0; j< result.des.length; j++){
                    $("[name = 'pingfen']").append("<option value=\""+result.desBickids[j]+"\">"+result.des[j]+"</option>");
                }
                tempSatisfysurveytargetBickid = row.subscriptBickid;
                tempClientCode = row.clientCode;
            }
        });

        $('#luru').modal('show');
    },
    'click #yiluruA': function (e, value, row) {

    }
};

function changeDateFormat(target) {
    return target.substring(0, 10);
}