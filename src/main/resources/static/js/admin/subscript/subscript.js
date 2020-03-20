$(function () {
    initTable();

    //为添加弹窗填充评测项目
    fullAddItem();

    //为修改弹窗填充评测项目
    fullEditItem();

    //为评测指标维护上层查询条件填充
    //评测项目
    $.ajax({
        url: '/admin/item',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length ; i++){
                $("#belongItem").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
            }
        }
    });

    //所属部门
    $.ajax({
        url: '/admin/org',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length ; i++){
                $("#belongOrg").append("<option value = '"+ result[i].id +"'>"+ result[i].name +"</option>");
            }
        }
    });

    //当筛选条件所属部门改变时， 为所属岗位填充内容
    $("#belongOrg").change(function () {
        orgId = $("#belongOrg").val();
        if (orgId == ""){
            orgId = null;
            $("#belongRole").empty();
        }
        $.ajax({
            url: '/admin/role/'+orgId,
            type: 'GET',
            data: 0,
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                for (var i = 0; i<result.length ; i++){
                    $("#belongRole").append("<option value = '"+ result[i].id +"'>"+ result[i].name +"</option>");
                }
            }
        });
    });

    //当筛选条件改变时
    $("#belongItem, #belongRole").change(function () {
        itemBickid = $("#belongItem").val();
        if (itemBickid == ""){
            itemBickid = null;
        }
        roleId = $("#belongRole").val();
        if (roleId == ""){
            roleId = null;
        }


        $('#list').bootstrapTable('refresh',{url:'/admin/subscriptBy/'+itemBickid+'/'+roleId+''});
    });

    //为添加弹窗填充评测指标
    $("#evaluateItemAdd").change(function () {
        $("#evaluateTargetAdd").val("");
        $("#evaluateTargetAdd").empty();
        $.ajax({
            url: '/admin/descriptionbyitem/'+$("#evaluateItemAdd").val(),
            type: 'GET',
            data: 0,
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                $("#evaluateTargetAdd").append("<option value = ''></option>");
                for (var i = 0; i<result.length ; i++){
                    $("#evaluateTargetAdd").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
                }
            }
        });
    });

    //为修改弹窗填充评测指标
    $("#evaluateItemEdit").change(function () {
        itemBickid = $("#evaluateItemEdit").val();
        $("#evaluateTargetEdit").val("");
        $("#evaluateTargetEdit").empty();
        $("#itemNameEdit").val($("#evaluateItemEdit option[value = "+ itemBickid +"]").text());
        $.ajax({
            url: '/admin/descriptionbyitem/'+itemBickid,
            type: 'GET',
            data: 0,
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                $("#evaluateTargetEdit").append("<option value = ''></option>");
                for (var i = 0; i<result.length ; i++){
                    $("#evaluateTargetEdit").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
                }
            }
        });
    });

    //添加按钮
    $("#mainBtnAdd").click(function () {
        clearInputs("mainModalAdd");
        $("#evaluateTarget").val("");
        $("#evaluateItem").val("");
        $("#evaluateCyc").val("年");
        $('#mainModalAdd').modal('show');
    });

    //修改按钮
    $("#mainBtnEdit").click(function () {
        if ($("#list").bootstrapTable('getSelections').length == 0){
            $('#noChoice').modal('show');
        } else {
            $('#mainModalEdit').modal('show');
            $("#evaluateItemEdit").val($("#list").bootstrapTable('getSelections')[0].evaluateItemBickid);
            $.ajax({
                url: '/admin/descriptionbyitem/'+$("#evaluateItemEdit").val(),
                type: 'GET',
                data: 0,
                contentType:"application/json;charset=UTF-8",
                dataType:"json",
                success: function (result) {
                    $("#evaluateTargetEdit").append("<option value = ''></option>");
                    for (var i = 0; i<result.length ; i++){
                        $("#evaluateTargetEdit").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
                        $("#evaluateTargetEdit").val($("#list").bootstrapTable('getSelections')[0].evaluateTargetBickid);
                        $("#evaluateCycEdit").val($("#list").bootstrapTable('getSelections')[0].evaluateCyc);
                        $("#proportionEdit").val($("#list").bootstrapTable('getSelections')[0].proportion);
                        $("#isUseEdit").val($("#list").bootstrapTable('getSelections')[0].isUse);
                        $("#empRoleEdit").val($("#list").bootstrapTable('getSelections')[0].empRole);
                        $("#targetSortEdit").val($("#list").bootstrapTable('getSelections')[0].targetSort);
                    }
                }
            });
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
        if (!isNotBlank($("#proportionAdd").val())){
            alert("权重不能为空");
        }
        if (!isNotBlank($("#empRoleAdd").val())){
            alert("请选择调查人员");
        }
        $.ajax({
            url: '/admin/subscript',
            type: 'POST',
            data: JSON.stringify({
                "targetSort" : $("#targetSortAdd").val(),
                "evaluateItem" : $("#evaluateItemAdd option[value = "+ $("#evaluateItemAdd").val() +"]").text(),
                "evaluateItemBickid" : $("#evaluateItemAdd").val(),
                "evaluateTarget" : $("#evaluateTargetAdd option[value = "+ $("#evaluateTargetAdd").val() +"]").text(),
                "evaluateTargetBickid" : $("#evaluateTargetAdd").val(),
                "isUse" : $("#isUseAdd").val(),
                "evaluateCyc" : $("#evaluateCycAdd").val(),
                "proportion" : $("#proportionAdd").val(),
                "empRole" : $("#empRoleAdd").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function (result) {
                if (result == "200"){
                    $('#mainModalAdd').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/subscript'});
                }else {
                    alert(result);
                }
            }
        });
    });

    //评分标准维护-》修改弹窗-》确定
    $("#btn_edit_ok").click(function () {
        $.ajax({
            url: '/admin/subscript',
            type: 'PUT',
            data: JSON.stringify({
                "bickid" : $("#list").bootstrapTable('getSelections')[0].bickid,
                "targetSort" : $("#targetSortEdit").val(),
                "evaluateItem" : $("#evaluateItemEdit option[value = "+ $("#evaluateItemEdit").val() +"]").text(),
                "evaluateItemBickid" : $("#evaluateItemEdit").val(),
                "evaluateTarget" : $("#evaluateTargetEdit option[value = "+ $("#evaluateTargetEdit").val() +"]").text(),
                "evaluateTargetBickid" : $("#evaluateTargetEdit").val(),
                "isUse" : $("#isUseEdit").val(),
                "evaluateCyc" : $("#evaluateCycEdit").val(),
                "proportion" : $("#proportionEdit").val(),
                "empRole" : $("#empRoleEdit").val()
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                if (result == "200"){
                    $('#mainModalEdit').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/subscript'});
                }
            }
        });
    });

    //评分标准维护-》确认删除弹窗-》确定
    $("#mainModalDel").click(function () {
        $.ajax({
            url: '/admin/subscript',
            type: 'DELETE',
            data: JSON.stringify({
                "bickid" : $("#list").bootstrapTable('getSelections')[0].bickid
            }),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                if (result == "200"){
                    $('#mainModalDel').modal('hide');
                    $('#list').bootstrapTable('refresh',{url:'/admin/subscript'});
                }
            }
        });
    });

});

//为添加弹窗填充评测项目
function fullAddItem() {
    $.ajax({
        url: '/admin/item',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length ; i++){
                $("#evaluateItemAdd").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
            }
        }
    }) ;
}

//为修改弹窗填充测评项目
function fullEditItem() {
    $.ajax({
        url: '/admin/item',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length ; i++){
                $("#evaluateItemEdit").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
            }
        }
    });
}

//初始化调查指标维护table
function initTable() {
    $('#list').bootstrapTable({
        url:'/admin/subscript',
        type:"GET",
        uniqueId:"bickid",
        singleSelect:true,
        pagination: true,
        pageSize: 8,
        locale: 'zh-CN',
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
                field:'evaluateItemBickid',
                title:'测评项目',
                align:'center',
                formatter: function(value, row, index){
                    return changeEvaluateItemBickid(value)
                },
                width:60
            },{
                field:'evaluateItemBickid',
                title:'测评项目bickid',
                align:'center',
                width:1
            },{
                field:'evaluateTargetBickid',
                title:'评测指标',
                align:'left',
                formatter: function(value, row, index){
                    return changeEvaluateTargetBickid(value)
                },
                width:130
            },{
                field:'evaluateTargetBickid',
                title:'评测指标',
                align:'center',
                width:1
            },{
                field:'isUse',
                title:'是否启用',
                align:'center',
                width:30
            },{
                field:'empRole',
                title:'调查人员',
                align:'center',
                width:100
            },{
                field:'evaluateCyc',
                title:'评价周期',
                align:'center',
                width:30
            },{
                field:'proportion',
                title:'权重',
                align:'center',
                width:30
            }
        ]
    });
    $('#list').bootstrapTable('hideColumn','bickid');
    $('#list').bootstrapTable('hideColumn','targetSort');
    $('#list').bootstrapTable('hideColumn','evaluateItemBickid');
    $('#list').bootstrapTable('hideColumn','evaluateTargetBickid');
}

function changeEvaluateItemBickid(value) {
    var target = "";
    $.ajax({
        url: '/admin/changeevaluateItemBickid',
        type: 'GET',
        data: {
            evaluateItemBickid : JSON.stringify(value)
        },
        async: false,
        success:function (result) {
            target = result;
        }
    });
    return target;
}

function changeEvaluateTargetBickid(value) {
    var target = "";
    $.ajax({
        url: '/admin/changeevaluateTargetBickid',
        type: 'GET',
        async: false,
        data: {
            evaluateTargetBickid : JSON.stringify(value)
        },
        success:function (result) {
            target = result;
        }
    });
    return target;
}