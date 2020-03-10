
var tempOrg = "";

$(function () {
    $("#empRoleBtnAdd").click(function () {
        initTargetSortTree();
        initPerTable();
        $('#perlist').bootstrapTable('refresh',{url:'/admin/getpersbyroleid/0'});
    });
    //指标归类-》选择-》确定
    $("#btn_empRole_ok").click(function () {
        $("#empRoleAdd").val($('#perlist').bootstrapTable('getSelections')[0].name);
        $("#targetSortAdd").val(tempOrg);
        $('#myModal').modal('hide');
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
                    if (node.parentId == undefined){
                        $('#perlist').bootstrapTable('refresh',{url:'/admin/getpersbyorgid/'+node.id});
                        tempOrg = node.id;
                    }else {
                        $('#perlist').bootstrapTable('refresh',{url:'/admin/getpersbyroleid/'+node.id});
                        tempOrg = node.parentId;
                    }
                },
                onNodeUnselected:function () {
                    $('#perlist').bootstrapTable('refresh',{url:'/admin/getpersbyroleid/null'});
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

//初始化调查人员table
function initPerTable() {
    $('#perlist').bootstrapTable({
        url:'/admin/getpersbyroleid/0',
        type:"GET",
        uniqueId:"id",
        singleSelect:true,
        pagination: true,
        pageSize: 8,
        paginationLoop: false,
        columns:[
            {
                checkbox: true
            },
            {
                field:'id',
                title:'#',
                align:'center',
                width:1
            },{
                field:'name',
                title:'姓名',
                align:'center',
                width:1
            }
        ]
    });
    $('#perlist').bootstrapTable('hideColumn','id');
}