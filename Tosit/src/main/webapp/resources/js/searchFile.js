function searchFile() {
    var form = document.getElementById('getFileName');
    //这里做用户判断
    var b = form.search.value;
    var a = $('#search').val();
    if (a === '') {
        alert("请输入搜索内容！");
        return ;
    }


    // form.submit();

  $.ajax({
        type: 'get',
        url: '/searchTeacherFile.do',
        data: {
            'fileName': a
        },
        dataType: 'json',
        success: function (data) {
            var arr = $.parseJSON(data);
            var content = "";
            for (var i = 0; i < arr.length; i++) {
                content += "<div class=\"container-fluid  border\">\n" +
                    "            <div class=\"container my-4\">\n" +
                    "                <div>\n" +
                    "                    <p style='font-size:25px'>文件名：<a  href=\"" + arr[i].furl + "\">"+arr[i].filename+"</a></p> <h5>提交者：" +arr[i].tnumber +"</h5>\n" +
                    "\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class='container'><p style='font-size: 15px'>文件描述："+arr[i].detail+"</p></div></div>" +
                    "";
            }
            $('#showFile').html(content);
        }
    })


}

function onLoadFileForShow() {
    $.ajax({
        type: 'get',
        url: '/onLoad.do',
        data: {
        },
        dataType: 'json',
        success: function (data) {
            var arr = $.parseJSON(data);
            var content = "";
            for (var i = 0; i < arr.length; i++) {
                content += "<div class=\"container-fluid  border\">\n" +
                    "            <div class=\"container my-4\">\n" +
                    "                <div>\n" +
                    "                    <p style='font-size:25px'>文件名：<a  href=\"" + arr[i].furl + "\">"+arr[i].filename+"</a></p> <h5>提交者：" +arr[i].tnumber +"</h5>\n" +
                    "\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class='container'><p style='font-size: 15px'>文件描述："+arr[i].detail+"</p></div></div>" +
                    "";
            }
            $('#showFile').html(content);
        }
    })
}
