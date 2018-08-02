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
                    "                <div>\n" +
                    "                    <p  style='font-size: 25px;'>文件名：<a href=\""+arr[i].furl+ "\">"+arr[i].filename+"</a></p>" +
                    "                    <h5 class='my-3' style=\"float: contour\" >提交者："+arr[i].tnumber +"</h5>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class='container'>" +
                    "               <p style='font-size: 15px;'>"+arr[i].detail+"</p>" +
                    "               <button type=\"button\"  class='btn btn-primary float-left' " +
                    "data-toggle=\"modal\" data-target=\"#addDetail"+i+"\">修改描述</button>\n" +
                    "               <button   type=\"submit\"  class=\"btn btn-primary float-right\"" +
                    " onclick=\"deleteFile('"+arr[i].furl+"')\">删除</button></div></div>"
                    +   "<div class=\"modal fade\" id=\"addDetail"+i+"\">\n" +
                    "        <div class=\"modal-dialog\">\n" +
                    "            <div class=\"modal-content\">\n" +
                    "\n" +
                    "                <!-- 模态框头部 -->\n" +
                    "                <div class=\"modal-header\">\n" +
                    "                    <h4 class=\"modal-title\">修改描述</h4>\n" +
                    "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <!-- 模态框主体 -->\n" +
                    "                <div class=\"modal-body\">\n" +
                    "                    <div class=\"input-group mb-3\">\n" +
                    "                        <input type=\"text\" class=\"form-control\" id=\""+arr[i].furl+"\" \n" +
                    "                               placeholder=\"请输入文档描述......\" aria-label=\"Recipient's username\"\n" +
                    "                               aria-describedby=\"button-addon2\">\n" +
                    "                        <div class=\"input-group-append\">\n" +
                    "                            <button class=\"btn btn-primary\" type=\"button\" onclick=\"changeDetail('"+arr[i].furl+"')\">修改</button>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <!-- 模态框底部 -->\n" +
                    "                <div class=\"modal-footer\">\n" +
                    "                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭</button>\n" +
                    "                </div>\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>"
                ;
            }
            $('#showFile').html(content);
        }

    });
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
                    "                <div>\n" +
                    "                    <p style='font-size: 25px;'>文件名：<a href=\""+arr[i].furl+ "\">"+arr[i].filename+"</a></p>" +
                    "                    <h5 class='my-3' style=\"float: contour\" >提交者："+arr[i].tnumber +"</h5>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class='container'>" +
                    "               <p style='font-size: 15px;'>文件描述："+arr[i].detail+"</p>"+"<button type=\"button\"  class=\"btn btn-primary float-left\" " +
                    "data-toggle=\"modal\" data-target=\"#addDetail"+i+"\">修改描述</button>\n" +
                    "            <button   type=\"submit\"  class=\"btn btn-primary float-right\"" +
                    " onclick=\"deleteFile('"+arr[i].furl+"')\">删除</button></div></div>"
                +   "<div class=\"modal fade\" id=\"addDetail"+i+"\">\n" +
                    "        <div class=\"modal-dialog\">\n" +
                    "            <div class=\"modal-content\">\n" +
                    "\n" +
                    "                <!-- 模态框头部 -->\n" +
                    "                <div class=\"modal-header\">\n" +
                    "                    <h4 class=\"modal-title\">修改描述</h4>\n" +
                    "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <!-- 模态框主体 -->\n" +
                    "                <div class=\"modal-body\">\n" +
                    "                    <div class=\"input-group mb-3\">\n" +
                    "                        <input type=\"text\" class=\"form-control\" id=\""+arr[i].furl+"\" \n" +
                    "                               placeholder=\"请输入文档描述......\" aria-label=\"Recipient's username\"\n" +
                    "                               aria-describedby=\"button-addon2\">\n" +
                    "                        <div class=\"input-group-append\">\n" +
                    "                            <button class=\"btn btn-primary\" type=\"button\" onclick=\"changeDetail('"+arr[i].furl+"')\">修改</button>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <!-- 模态框底部 -->\n" +
                    "                <div class=\"modal-footer\">\n" +
                    "                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭</button>\n" +
                    "                </div>\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>"
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
            dataType: 'json'
        });
        onLoadFileForShow();
        window.location.reload();
}

function changeDetail(furl) {
    var newDetail = document.getElementById(furl).value;
   // alert(furl);
    $.ajax({
        type: 'get',
        url: '/onChangeDetail.do',
        data: {
            furl:furl,
            newDetail:newDetail
        },
        dataType: 'json'
    });
    window.location.reload();
}

function addNewFile() {
    var form = new FormData($('#uploadForm')[0]);

    $.ajax({
        type: 'post',
        url: '/addFile.do',
        data: form,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success:function (result) {
            alert("done");
        },
        error:function (err) {
            alert("false");
        }

    });
     window.location.reload();
}