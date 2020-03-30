// $("#loginBtn").click(function () {
//     let name = $("#userName").val();
//     let pwd = $("#userPassword").val();
//     if (isNotBlank(name) && isNotBlank(pwd)){
//         $.ajax({
//             url: '/login/login',
//             type: 'POST',
//             data: JSON.stringify({
//                 "userId" : name,
//                 "userPassword" : pwd
//             }),
//             dataType:"json",
//             success: function () {
//                 alert("success");
//             }
//         });
//     }else {
//         alert("用户名和密码不能为空");
//     }
// });