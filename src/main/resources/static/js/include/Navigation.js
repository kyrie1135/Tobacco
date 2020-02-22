$(function () {
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
        //  console.log(url);
        $('#container').load(url);
    });

    //获取App
    getMenuMApp();
    //为App添加Mod
    getMenuMod();
});

function moveToSubscriptAdd() {
    $("#mainIframe").attr("src", "/admin/subscriptAdd");
}

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
                $("#" + result[i].moduleAppid + "").append("<li><a href=\"javascript:void(0)\" onclick=\"getMenuMApp()\" class=\"myLeftMenu\" data=\"add.html\">" + result[i].moduleName + "</a></li>");
            }
        }
    });
}