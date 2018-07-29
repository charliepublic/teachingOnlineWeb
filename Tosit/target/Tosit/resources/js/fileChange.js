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
                content += "<div  class=\"container-fluid  border\" style=\"padding-top:70px;padding-bottom:70px\">\n" +
                    "            <div class=\"container\">\n" +
                    "                <div class=\"form-inline\">\n" +
                    "                    <a  href=\""+arr[i].furl+ "\">"+arr[i].filename+"</a> <h6 style=\"float: contour\" >提交者："+arr[i].tnumber +"</h6>\n" +
                    "\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <p>"+arr[i].detail+"</p>"+"<button type=\"submit\"  class=\"btn btn-primary float-left\" onclick=\"\">修改描述</button>\n" +
                    "            <button type=\"submit\"  class=\"btn btn-primary float-right\" onclick=\"deleteFile()\">删除</button>" +
                    "       </div>"
                ;
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
                content += "<div  class=\"container-fluid  border\" style=\"padding-top:70px;padding-bottom:70px\">\n" +
                    "            <div class=\"container\">\n" +
                    "                <div class=\"form-inline\">\n" +
                    "                    <a   href=\""+arr[i].furl+ "\">"+arr[i].filename+"</a> " +
                    "                    <h6 style=\"float: contour\" >提交者："+arr[i].tnumber +"</h6>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <p>"+arr[i].detail+"</p>"+"<button type=\"button\"  class=\"btn btn-primary float-left\" data-toggle=\"modal\" data-target=\"#addDetail\">修改描述</button>\n" +
                    "            <button  id='"+ arr[i].furl +"' type=\"submit\"  class=\"btn btn-primary float-right\" onclick=\"deleteFile('"+arr[i].furl+"')\">删除</button></div>"
                ;
            }
            $('#showFile').html(content);
        }
    })
}

function deleteFile( furl) {
        //var filefurl = furl
        $.ajax({
            type: 'get',
            url: '/onDelete.do',
            data: {
                furl:furl
            },
            dataType: 'json',
        })
        onLoadFileForShow();
        window.location.reload();
}

function changeDetail(furl) {
    $.ajax({
        type: 'get',
        url: '/onChangeDetail.do',
        data: {
            furl:furl
        },
        dataType: 'json',
    })
    onLoadFileForShow();
    window.location.reload();
}