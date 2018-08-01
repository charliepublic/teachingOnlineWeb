function login() {
    var zh,mm;
    zh = $("#zh").val();
    mm = $("#mm").val();
    $.ajax({
        type:'post',
        url:'/loginAction.do',
        dataType:'json',
        data:{
            zh: zh,
            mm: mm
        },
        success: function(result) {
            if (result !== "登录失败") {
                $("#zh").css("display","none");
                $("#mm").css("display","none");
                $("#loginBtn").css("display","none");
                $("#name").html(result);
                $("#hello").css("display","inline");
                $("#backend").css("display","inline");
            } else {
                window.alert("账号或密码错误！");
            }
        }
    });
}