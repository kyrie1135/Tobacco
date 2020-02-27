$(function () {
    initTable();

    //添加按钮
    $("#mainBtnAdd").click(function () {
        clearInputs("mainModalAdd");
        $('#mainModalAdd').modal('show');
    });

    //修改按钮
    $("#mainBtnEdit").click(function () {
        if ($("#list").bootstrapTable('getSelections').length == 0){
            $('#noChoice').modal('show');
        } else {
            $('#mainModalEdit').modal('show');
            $("#standard_edit").val($("#list").bootstrapTable('getSelections')[0].evaluateStandard);
            $("#score_edit").val($("#list").bootstrapTable('getSelections')[0].evaluateTarget);
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

    //评分标准维护-》添加弹窗-》确定
    $("#btn_add_ok").click(function () {
        if (!isNotBlank($("#standard_add").val())){
            alert("评分标准不能为空");
        }
        if (!isNotBlank($("#score_add").val())){
            alert("评分标准分值不能为空");
        }
        $.ajax({
            url: '/admin/standard',
            type: 'POST',
            data: JSON.stringify({
                "evaluateTarget" : $("#score_add").val(),
                "evaluateStandard" : $("#standard_add").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function (result) {
                if (result == "200"){
                    $('#mainModalAdd').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/standard'});
                }else {
                    alert(result);
                }
            }
        });
    });

    //评分标准维护-》确认删除弹窗-》确定
    $("#mainModalDel").click(function () {
        $.ajax({
            url: '/admin/standard/',
            type: 'DELETE',
            data: JSON.stringify({
                "bickid" : $("#list").bootstrapTable('getSelections')[0].bickid
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                if (result == "200"){
                    $('#mainModalDel').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/standard'});
                }
            }
        });
    });

    //评分标准维护-》修改弹窗-》确定
    $("#btn_edit_ok").click(function () {
        $.ajax({
            url: '/admin/standard/',
            type: 'PUT',
            data: JSON.stringify({
                "bickid" : $("#list").bootstrapTable('getSelections')[0].bickid,
                "evaluateTarget" : $("#score_edit").val(),
                "evaluateStandard" : $("#standard_edit").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                if (result == "200"){
                    $('#mainModalEdit').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/standard'});
                }
            }
        });
    });

});

//初始化调查指标维护table
function initTable() {
    $('#list').bootstrapTable({
        url:'/admin/subscript',
        type:"GET",
        uniqueId:"bickid",
        singleSelect:true,
        pagination: true,
        pageSize: 8,
        paginationLoop: false,
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
                field:'targetSort',
                title:'指标归类',
                align:'center',
                width:1
            }, {
                field:'evaluateItem',
                title:'测评项目',
                align:'center',
                width:100
            },{
                field:'evaluateTarget',
                title:'评测指标',
                align:'center',
                width:60
            },{
                field:'isUse',
                title:'是否启用',
                align:'center',
                width:60
            },{
                field:'empRole',
                title:'调查人员',
                align:'center',
                width:60
            },{
                field:'evaluateCyc',
                title:'评价周期',
                align:'center',
                width:60
            },{
                field:'proportion',
                title:'权重',
                align:'center',
                width:60
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
    $('#list').bootstrapTable('hideColumn','targetSort');
}