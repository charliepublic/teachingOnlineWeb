function login() {
    var form = document.getElementById("navbarNavDropdown");
    if(form.zh.value == "") {
        alert("请输入账号");
        form.zh.focus();
        return ;
    }
    if(form.mm.value == "") {
        alert("请输入密码");
        form.mm.focus();
        return ;
    }
    form.submit();
}