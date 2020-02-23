$(function () {

});

//初始化评测标准列表
function initPerTable() {
    $('#perList').bootstrapTable({
        url:'/admin/satisfysurveytargetTable',
        type:"GET",
        uniqueId:"userId",
        singleSelect:true,
        columns:[
            {
                field:'userId',
                title:'#',
                align:'center',
                width:1
            },{
                field:'userName',
                title:'人员名称',
                align:'center',
                width:100
            },{
                field:'userSex',
                title:'人员性别',
                align:'center',
                width:60
            },{
                field:'userTel',
                title:'人员电话',
                align:'center',
                width:150
            },{
                field:'userEmail',
                title:'人员邮箱',
                align:'center',
                width:150
            }
        ]
    });
    $('#perList').bootstrapTable('hideColumn','userId');
}