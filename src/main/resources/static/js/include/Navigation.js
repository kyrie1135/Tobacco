$(function () {
    //点击首页响应
    $("#indexForm").click(function () {
        $("#mainIframe").attr('src', '/project/toechartlist');
    });

    //iframe高度设置
    var topMenu = window.document.getElementById('topMenu'); //顶层菜单
    var ifm = document.getElementById("mainIframe"); //iframe
    var ifoot = document.getElementById("ifoot"); //脚部
    ifm.height = document.documentElement.clientHeight - topMenu.offsetHeight - ifoot.offsetHeight;

    $('ul.sidebar-menu li').click(function () {
        var li = $('ul.sidebar-menu li.active');
        li.removeClass('active');
        $(this).addClass('active');
    });

    $('.myLeftMenu').click(function (e) {
        var url = $(this).attr('data');
        $('#container').load(url);
    });

    //获取App
    getMenuMApp();


    $.ajax({
        type: "GET",
        url: '/login/getUserName',
        data: 0,
        async: false,
        dataType:"text",
        success: function (result) {
            $("#userName1").html(result);
            $("#userName2").html(result);
            $("#userName3").html(result);
        }
    });
});

function getMenuMApp() {
    $.ajax({
        type: "Get",
        url: '/main/menuApp',
        data: 0,
        dataType: "json",
        success: function (result) {
            var menu = $("#menu");
            for (var i = 0; i < result.length; i++){
                menu.append("<li class=\"treeview\">\n" +
                    "<a href=\"#\"><i class=\"fa fa-link\"></i> <span>" + result[i].appName +"</span>\n" +
                    "<span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span></a>\n" +
                    "<ul id=" + result[i].appCode + " class=\"treeview-menu\"></ul>\n" +
                    "</li>")
            }
            //为App添加Mod
            getMenuMod();
        }
    });
}

function getMenuMod() {
    $.ajax({
        type: "Get",
        url: '/main/menuMod',
        data: 0,
        dataType: "json",
        success: function (result) {
            for (var i = 0; i< result.length; i++){
                $("#" + result[i].moduleAppid + "").append("<li><a href=\"javascript:void(0)\" style='margin-left: 35px' onclick=\"getModuleUrl(this)\" class=\"myLeftMenu\" data="+result[i].moduleUrl+">" + result[i].moduleName + "</a></li>");
            }
        }
    });
}

//功能模块跳转
function getModuleUrl(obj) {
    $("#mainIframe").attr('src', $(obj).attr("data"));
}