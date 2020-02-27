
var empRole = "";
var targetSort = ""

$(function () {
    $("#empRoleBtn").click(function () {
        initTargetSortTree();
    });
    //指标归类-》选择-》确定
    $("#btn_empRole_ok").click(function () {
        $('input[name = "empRole"]').val(empRole);
        $('input[name = "targetSort"]').val(targetSort);
        $("#btn_empRole_cancel").trigger('click');
    });
})

//初始化指标归类树（岗位树）
function initTargetSortTree() {
    $.ajax({
        type: "Get",
        url: '/admin/orgTree/0000',
        data: 0,
        dataType: "json",
        success: function (result) {
            $("#tree").treeview({
                data: result,
                levels: 1,
                showTags: true,
                loadingIcon:"fa fa-hourglass",//懒加载过程中显示的沙漏字符图标
                lazyLoad:loadNode,
                onNodeSelected:function (event,node) {
                    empRole = $("#"+ node.parentid +"").text();
                    empRole += node.text;
                    targetSort = node.parentid;
                },
                onNodeUnselected:function () {
                    empRole = "";
                    targetSort = "";
                }
            });
        }
    });
}
//懒加载子node
function loadNode(node,func) {
    $.ajax({
        type:"get",
        url:'/admin/roleTree/'+node.id,
        success:function(data){
            func(data);
        }
    });
}