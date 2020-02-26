$(function () {

    //初始化table
    initTable();

    //修改按钮
    $("#mainBtnEdit").click(function () {
        if ($("#list").bootstrapTable('getSelections').length == 0){
            $('#noChoice').modal('show');
        } else {
            $('#mainModalEdit').modal('show');
            $("#item_edit").val($("#list").bootstrapTable('getSelections')[0].itemName);
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

    //评测项目维护-》添加弹窗-〉确定
    $("#btn_add_ok").click(function () {
        if (!isNotBlank($("#item_add").val())){
            alert("评测项目名称不能为空");
        }
        $.ajax({
            url: '/admin/item',
            type: 'POST',
            data: JSON.stringify({
                "itemName" : $("#item_add").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function (result) {
                if (result == "200"){
                    alert("添加成功");
                    $('#mainModalAdd').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/item'});
                }else {
                    alert(result);
                }
            },error: function () {
                alert("请求失败， 请稍后再试");
            }
        });
    });

    //评测项目-》修改弹窗-》确定
    $("#btn_edit_ok").click(function () {
        $.ajax({
            url: '/admin/item',
            type: 'PUT',
            data: JSON.stringify({
                "bickid" : $("#list").bootstrapTable('getSelections')[0].bickid,
                "itemName" : $("#item_edit").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                if (result == "200"){
                    alert("修改成功");
                    $('#mainModalEdit').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/item'});
                }
            }, error: function () {
                alert("修改错误， 请稍后再试");
            }
        });
    });

    //评测项目-》确定删除弹窗-》确定
    $("#mainModalDel").click(function () {
        $.ajax({
            url: '/admin/item',
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
                    $('#list').bootstrapTable('refresh',{url:'/admin/item'});
                }
            }, error: function () {
                alert("删除错误， 请稍后再试");
            }
        });
    });

});

function initTable() {
    $('#list').bootstrapTable({
        url:'/admin/item',
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
                field:'itemName',
                title:'项目名称',
                align:'center',
                width:150
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