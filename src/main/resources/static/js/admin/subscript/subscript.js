$(function () {
    initTable();

    //为添加、修改弹窗填充评测项目
    $.ajax({
        url: '/admin/item',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            for (var i = 0; i<result.length ; i++){
                $("#evaluateItem").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
            }
        }
    });

    //为添加、修改弹窗填充评测指标
    $("#evaluateItem").change(function () {
        itemBickid = $("#evaluateItem").val();
        $("input[name = 'itemName']").val($("#evaluateItem option[value = "+ itemBickid +"]").text());
        $.ajax({
            url: '/admin/descriptionbyitem/'+itemBickid,
            type: 'GET',
            data: 0,
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success: function (result) {
                for (var i = 0; i<result.length ; i++){
                    $("#evaluateTarget").append("<option value = '"+ result[i].bickid +"'>"+ result[i].itemName +"</option>");
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
        if (!isNotBlank($("input[name = 'proportion']").val())){
            alert("权重不能为空");
        }
        if (!isNotBlank($("input[name = 'empRole']").val())){
            alert("请选择调查人员");
        }
        $.ajax({
            url: '/admin/subscript',
            type: 'POST',
            data: JSON.stringify({
                "targetSort" : $("input[name = 'targetSort']").val(),
                "evaluateItem" :$("input[name = 'itemName']").val(),
                "evaluateTarget" : $("#evaluateTarget option[value = "+ $("#evaluateTarget").val() +"]").text(),
                "isUse" : $("input[name = 'isUse']").val(),
                "evaluateCyc" : $("#evaluateCyc").val(),
                "proportion" : $("input[name = 'proportion']").val(),
                "empRole" : $("input[name = 'empRole']").val()
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
                width:100
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
}