$(function () {
    initTable();

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
                    alert("添加成功");
                    $('#mainModalAdd').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/standard'});
                }else {
                    alert(result);
                }
            },error: function () {
                alert("请求失败， 请稍后再试");
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
                    alert("删除成功");
                    $('#mainModalDel').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/standard'});
                }
            }, error: function () {
                alert("删除错误， 请稍后再试");
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
                    alert("修改成功");
                    $('#mainModalEdit').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/standard'});
                }
            }, error: function () {
                alert("修改错误， 请稍后再试");
            }
        });
    });

});

//初始化评测标准列表
function initTable() {
    $('#list').bootstrapTable({
        url:'/admin/standard',
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

function isNotBlank(text) {
    if (text != null && text.trim() != ""){
        return true;
    }else {
        return false;
    }
}