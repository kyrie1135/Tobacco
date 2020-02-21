
var targetSort = "";

$(function () {
    $("#targetSortBtn").click(function () {
        initTargetSortTree();
    });
    //指标归类-》选择-》确定
    $("#btn_targetSort_ok").click(function () {
        $('input[name = "targetSort"]').val(targetSort);
        $("#btn_targetSort_cancel").trigger('click');
    });
})

//初始化指标归类树（岗位树）
function initTargetSortTree() {
    $.ajax({
        type: "Get",
        url: '/admin/targetSortTree/0',
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
                    targetSort = node.text;
                },
                onNodeUnselected:function () {
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
        url:'/admin/targetSortTree/'+node.id,
        success:function(data){
            func(data);
        }
    });
}