$(function () {

    //初始化table
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
                    $('#mainModalAdd').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/item'});
                }else {
                    alert(result);
                }
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
                    $('#mainModalEdit').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/item'});
                }
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
                    $('#mainModalDel').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/item'});
                }
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
                field:'itemName',
                title:'项目名称',
                align:'center',
                width:150
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
}