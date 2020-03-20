//筛选条件-》所属部门-〉填充内容
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
    $("#belongRole").empty();
    $("#belongRole").append("<option value=''>-</option>");
    $("#belongRole").trigger('change');
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

//当筛选条件岗位改变时， 将div中显示的指标更改为此岗位的指标
$("#belongRole").change(function () {
    belongRole = $("#belongRole").val();
    if (belongRole == ""){
        belongRole = null;
    }
    $.ajax({
        url: '/admin/subscriptByRoleId/'+belongRole,
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            $("#luruMain").empty();
            $("[name = 'targets']").empty();
            for (var i = 0; i<result.length ; i++){
                $("#luruMain").append("<label class='col-sm-12 control-label'><h3 style='float: left;'>"+ result[i].evaluateTarget +"</h3></label>");
                $("#luruMain").append("<div name=\"targets\" class=\"col-sm-12\"></div>");
            }
            for (var i = 0; i<targets.length; i++){
                $("[name = 'targets']").append("<label class=\"radio-inline\">（ ）"+ targets[i] +"</label>");
                $("[name = 'targets']").append("<br>");
            }
        }
    });
});

function exportWord(){
    if ($("#luruMain > label").length == 0){
        alert("此岗位没有制定指标， 无需打印");
    }else {
        $("#luruMain").wordExport("满意度调查单");
    }
}

//用于存放满意、不满意。。。
var targets = new Array();

$(function () {

    //设置显示指标div的高度
    var ifm= window.parent.document.getElementById("mainIframe");
    $("#luruMain").height(ifm.height - 165);

    //将选项取出存到一个list中
    $.ajax({
        url: '/admin/standard',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        async: false,
        success: function (result) {
            for (var i = 0; i<result.length ; i++){
                targets.push(result[i].evaluateStandard);
            }
        }
    });

    //将所有的评测指标填充到页面中
    $.ajax({
        url: '/admin/subscript',
        type: 'GET',
        data: 0,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success: function (result) {
            $("#luruMain").empty();
            $("[name = 'targets']").empty();
            for (var i = 0; i<result.length ; i++){
                $("#luruMain").append("<label class='col-sm-12 control-label'><h3 style='float: left;'>"+ result[i].evaluateTarget +"</h3></label>");
                $("#luruMain").append("<div name=\"targets\" class=\"col-sm-12\"></div>");
            }
            for (var i = 0; i<targets.length; i++){
                $("[name = 'targets']").append("<label class=\"radio-inline\">（ ）"+ targets[i] +"</label>");
                $("[name = 'targets']").append("<br>");
            }
        }
    });
});