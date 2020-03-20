$(function () {

    //初始化table
    initTable();

    //评测项目选择框选择后， 刷新table内容
    $("#belongItem").change(function () {
        if ($("#belongItem").val() == "-"){
            $('#list').bootstrapTable('refresh',{url:'/admin/description'});
        } else {
            $('#list').bootstrapTable('refresh',{url:'/admin/descriptionbyitem/'+$("#belongItem").val()});
        }
    });

    //获取评测项目填入到select中
    $.ajax({
        url: '/admin/item',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success:function (result) {
            for (var i = 0; i<result.length ; i++){
                $("#belongItem").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
                $("#belongItemAdd").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
                $("#belongItemEdit").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
            }
        }
    });

    //添加按钮
    $("#mainBtnAdd").click(function () {
        clearInputs("mainModalAdd");
        $("#belongItemAdd > option")[0].selected = true;
        $('#mainModalAdd').modal('show');
    });

    //修改按钮
    $("#mainBtnEdit").click(function () {
        if ($("#list").bootstrapTable('getSelections').length == 0){
            $('#noChoice').modal('show');
        } else {
            $('#mainModalEdit').modal('show');
            $("#belongItemEdit").val($("#list").bootstrapTable('getSelections')[0].belongItemId);
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
                "belongItemId" : $("#belongItemAdd").val(),
                "itemName" : $("#standard_add").val(),
                "description" : $("#description_add").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function (result) {
                if (result == "200"){
                    $('#mainModalAdd').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/description'});
                }else {
                    alert(result);
                }
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
                "belongItemId" : $("#belongItemEdit").val(),
                "itemName" : $("#standard_edit").val(),
                "description" : $("#description_edit").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                if (result == "200"){
                    $('#mainModalEdit').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/description'});
                }
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
                    $('#mainModalDel').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/description'});
                }
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
        search: false,
        pagination: true,
        pageSize: 8,
        locale: 'zh-CN',
        paginationLoop: false,
        columns:[
            {
                checkbox: true
            }, {
                field:'bickid',
                title:'#',
                align:'center',
                width:1
            }, {
                field:'belongItemId',
                title:'所属评测项目',
                align:'center',
                width:150
            }, {
                field:'itemName',
                title:'评测标准',
                align:'left',
                width:150
            }, {
                field:'description',
                title:'项目标准描述',
                align:'left',
                width:150
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
    $('#list').bootstrapTable('hideColumn','belongItemId');
}

