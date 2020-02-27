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
            $("#standard_edit").val($("#list").bootstrapTable('getSelections')[0].itemName);
            $("#description_edit").val($("#list").bootstrapTable('getSelections')[0].description);
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

    //评测标准维护-》添加弹窗-〉确定
    $("#btn_add_ok").click(function () {
        if (!isNotBlank($("#standard_add").val())){
            alert("评测标准名称不能为空");
        }
        if (!isNotBlank($("#description_add").val())){
            alert("评测标准描述不能为空");
        }
        $.ajax({
            url: '/admin/description',
            type: 'POST',
            data: JSON.stringify({
                "itemName" : $("#standard_add").val(),
                "description" : $("#description_add").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function (result) {
                if (result == "200"){
                    alert("添加成功");
                    $('#mainModalAdd').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/description'});
                }else {
                    alert(result);
                }
            },error: function () {
                alert("请求失败， 请稍后再试");
            }
        });
    });

    //评测标准维护-》修改弹窗-》确定
    $("#btn_edit_ok").click(function () {
        $.ajax({
            url: '/admin/description',
            type: 'PUT',
            data: JSON.stringify({
                "bickid" : $("#list").bootstrapTable('getSelections')[0].bickid,
                "itemName" : $("#standard_add").val(),
                "description" : $("#description_add").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                if (result == "200"){
                    alert("修改成功");
                    $('#mainModalEdit').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/description'});
                }
            }, error: function () {
                alert("修改错误， 请稍后再试");
            }
        });
    });

    //评测标准维护-》确定删除弹窗-》确定
    $("#mainModalDel").click(function () {
        $.ajax({
            url: '/admin/description',
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
                    $('#list').bootstrapTable('refresh',{url:'/admin/description'});
                }
            }, error: function () {
                alert("删除错误， 请稍后再试");
            }
        });
    });

});

function initTable() {
    $('#list').bootstrapTable({
        url:'/admin/description',
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
                title:'评测标准',
                align:'center',
                width:150
            },{
                field:'description',
                title:'项目标准描述',
                align:'center',
                width:150
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
}

