function loadProjectDisplay() {
    $.ajax({
        type: 'get',
        url: '/loadProjectDisplay.do',
        dataType: 'json',
        success: function (data) {
            var arr = $.parseJSON(data);
            var content = "";
            for (var i = 0; i < arr.length; i++) {
                content += '            <div id="project" class="container-fluid  border" style="padding-top:70px;padding-bottom:70px">\n' +
                    '                <div class="container">\n' +
                    '                    <form class="form-inline">\n' +
                    '                        <p style="margin-right: 10px">项目名称：</p>\n' +
                    '                        <p style="margin-right: 10px">'+ arr[i].pname +'</p>\n' +
                    '                        <p style="float: right; margin-right: 10px">项目时间：</p>\n' +
                    '                        <p style="margin-right: 10px">'+ arr[i].upTime +'天</p>\n' +
                    '                    </form>\n' +
                    '                    <p>项目简介:</p>\n' +
                    '\n' +
                    '                    <p>'+arr[i].info+'</p>\n' +
                    '\n' +
                    '                <div class="text-right"><a id="href'+arr[i].pnumber+'" href="#" onclick="getFileUrl('+arr[i].pnumber+')">相关文件</a></div> </div>\n' +
                    '\n' +
                    '                </div>' ;
            }

            $('#projectdisplay').html(content);
        }
    })
}

function getFileUrl(projectnumber) {

    $.ajax({
        type: 'post',
        url: '/getFileUrl.do',
        dataType: 'json',
        data:{
          projectnumber:projectnumber
        },
        success:function (result) {
            var arr = $.parseJSON(result);
            var hrefId = "#href" + projectnumber;
            var fileUrl = arr[0].furl;

            if(fileUrl==""){
                alert("该项目还没有上传任何文件!");
            }
            else{
                window.location.replace(fileUrl);
            }
        },
        error:function () {
            alert("False");
        }
    })
}

function loadApplyManagement() {
    $.ajax({
        type: 'get',
        url: '/loadApplyManagement.do',
        dataType: 'json',
        success: function (data) {
            var arr = $.parseJSON(data);
            var content = "";


            for (var i = 0; i < arr.length; i++) {
                var projectnumber = arr[i].pnumber;
                content += ' <div id="project"'+projectnumber+' class="container border" style="padding-top:70px;padding-bottom:70px">\n' +
                    '                <div class="container">\n' +
                    '                    <form class="form-inline">\n' +
                    '                        <p style="margin-right: 10px">项目名称：</p>\n' +
                    '                        <p style="margin-right: 10px">'+arr[i].pname+'</p>\n' +
                    '                        <p style="float: right; margin-right: 10px">项目时间：</p>\n' +
                    '                        <p style="margin-right: 10px">'+arr[i].upTime+'</p>\n' +
                    '                    </form>\n' +
                    '                    <p>项目简介:</p>\n' +
                    '\n' +
                    '                    <p>'+arr[i].info+'</p>\n' +
                    '\n' +
                    '                    <div class="text-left"><a id="href'+arr[i].pnumber+'" href="#" onclick="getFileUrl('+arr[i].pnumber+')">相关文件</a></div>\n' +
                    '\n' +
                    '                    <button type="button" id="reject'+projectnumber+'" class="btn btn-secondary" onclick="rejectf('+ projectnumber +'); return false;" style="float: right;margin-left: 20px">拒绝</button>\n' +
                    '                    <button type="button" id="accept'+projectnumber+'" class="btn btn-primary" onclick="acceptf('+ projectnumber +'); return false;"style="float: right;">同意</button>\n' +
                    '                </div>\n' +
                    '            </div>' ;
            }
            $('#applyDisplay').html(content);
        }
    })
}

function rejectf(projectnumber) {

    var acceptid = "#accept"+ projectnumber;
    var rejectid = "#reject"+ projectnumber;
    $.ajax({
        type: 'get',
        url: '/rejectApply.do',
        dataType: 'json',
        data:{
            projectnumber:projectnumber
        },
        success:function (result) {
            if(result!=="申请失败")
            {
                $(rejectid).html("已拒绝");
                $(rejectid).attr("disabled",true);

                $(acceptid).attr("disabled",true);
            }else{
                window.alert("申请失败");
            }
        }
    })

}

function acceptf(projectnumber) {

    var acceptid = "#accept"+ projectnumber;
    var rejectid = "#reject"+ projectnumber;

    $.ajax({
        type: 'get',
        url: '/acceptApply.do',
        dataType: 'json',
        data:{
            projectnumber:projectnumber
        },
        success:function (result) {
            if(result!=="申请失败")
            {
                $(acceptid).html("已同意");
                $(acceptid).attr("disabled",true);

                $(rejectid).attr("disabled",true);

                // window.location.reload();
            }else{
                window.alert("申请失败");
            }
        }
    })

};

function loadProjectManagement() {
    $.ajax({
        type: 'get',
        url: '/loadProjectDisplay.do',
        dataType: 'json',
        success:function (data) {
            var arr = $.parseJSON(data);
            var content='';
            for (var i = 0; i < arr.length; i++) {

                var projectnumber = arr[i].pnumber;

                content += ' <div id="project'+projectnumber+'" class="container-fluid  border" style="padding-top:70px;padding-bottom:70px">\n' +
                    '                <div class="container">\n' +
                    '                    <form class="form-inline">\n' +
                    '                        <p style="margin-right: 10px">项目名称：</p>\n' +
                    '                        <p style="margin-right: 10px">'+arr[i].pname+'</p>\n' +
                    '                        <p style="float: right; margin-right: 10px">项目时间：</p>\n' +
                    '                        <p style="margin-right: 10px">'+arr[i].upTime+'</p>\n' +
                    '                    </form>\n' +
                    '                    <p>项目简介:</p>\n' +
                    '\n' +
                    '                    <p>'+arr[i].info+'</p>\n' +
                    '\n' +
                    '                    <button type="button" id="changeDescription" class="btn btn-primary float-left"onclick="changeDescriptionf('+projectnumber+');return false;">修改描述</button>\n' +
                    '                    <button type="button" id="DeleteProject'+projectnumber+'" class="btn btn-secondary float-right"onclick="deleteProjectf('+projectnumber+');return false;" >删除</button>\n' +
                    '                </div> <div id="divChange'+projectnumber+'"></div></div>';
            }
            $('#projectmanagement').html(content);
        }

    })
}

function searchProject() {

    var projectName = $("#searchproject").val();

    $.ajax({
        type:'post',
        url:'/searchProject.do',
        dataType:'json',
        data:{
            projectName:projectName,
        },
        success:function (data) {

            var arr = $.parseJSON(data);
            var content = '';
            for (var i = 0; i < arr.length; i++) {

                var projectnumber = arr[i].pnumber;

                content += ' <div id="project' + projectnumber + '" class="container-fluid  border" style="padding-top:70px;padding-bottom:70px">\n' +
                    '                <div class="container">\n' +
                    '                    <form class="form-inline">\n' +
                    '                        <p style="margin-right: 10px">项目名称：</p>\n' +
                    '                        <p style="margin-right: 10px">' + arr[i].pname + '</p>\n' +
                    '                        <p style="float: right; margin-right: 10px">项目时间：</p>\n' +
                    '                        <p style="margin-right: 10px">' + arr[i].upTime + '</p>\n' +
                    '                    </form>\n' +
                    '                    <p>项目简介:</p>\n' +
                    '\n' +
                    '                    <p>' + arr[i].info + '</p>\n' +
                    '\n' +
                    '                    <button type="button" id="changeDescription" class="btn btn-primary float-left"onclick="changeDescriptionf(' + projectnumber + ');return false;">修改描述</button>\n' +
                    '                    <button type="button" id="DeleteProject' + projectnumber + '" class="btn btn-secondary float-right"onclick="deleteProjectf(' + projectnumber + ');return false;" >删除</button>\n' +
                    '                </div> <div id="divChange' + projectnumber + '"></div></div>';
            }

            $('#projectmanagement').html(content);
        },
        error:function () {
            alert("查询失败!");
        }
    })

}

function changeDescriptionf(projectnumber) {

    $.ajax({
        success:function () {

            var divID = "#divChange"+projectnumber;
            var content='';
            content += '                        <p><br><br></p>\n' +
                '                        <div>\n' +
                '\n' +
                '                            <textarea type="text" class="form-control changeInfo-form-control" id="changeProjectIfo"></textarea>\n' +
                '                        </div>\n' +
                '                        <p><br></p>\n' +
                '                        <div>' +
                '                             <button type="submit" style="float: right;margin-right: 15px"id="changeSubmit'+projectnumber+'" class="btn btn-primary"onclick="changeSubmit('+projectnumber+')">提交</button>\n'+
                '                        </div>';
            $(divID).html(content);
        }
    })
}

function changeSubmit(projectnumber) {

    var projectInfo  = $("#changeProjectIfo").val();
    var submitId = "#changeSubmit" + projectnumber;
    $.ajax({
        type: 'post',
        url: '/changeSubmit.do',
        dataType: 'json',
        data:{
            projectInfo:projectInfo,
            projectnumber:projectnumber
        },
        success:function (result) {
            if(result!=="提交失败")
            {
                 alert("修改成功！");
                 window.location.reload();

                // $(submitId).html("修改成功");
                // $(submitId).attr("disabled",true);

            }else{
                window.alert("提交失败");
            }
        }
    })
}

function deleteProjectf(projectnumber) {
    var deleteid = "#DeleteProject"+projectnumber;
    $.ajax({
        type:'post',
        url: '/deleteProject.do',
        dataType: 'json',
        data:{
            projectnumber:projectnumber
        },
        success:function (result) {
            if(result!=="删除失败")
            {

                window.alert("删除成功");
                window.location.reload();
            }else{
                window.alert("删除失败");
            }
        }
    })
}

function newProjectf() {
    var projectName,projectUptime,projectInfo;
    projectName = $("#newProjectName").val();
    projectUptime = $("#newProjectUptime").val();
    projectInfo = $("#newProjectInfo").val();

    $.ajax({

        type:'get',
        url:'/newProject.do',
        dataType:'json',
        data:{
            projectName:projectName,
            projectUptime:projectUptime,
            projectInfo:projectInfo
        },

        success:function (result) {

            if (result !== "新建项目失败") {

                alert("done!");
                window.location.reload();
            } else {
                window.alert("新建项目失败！");
            }

        }
    })
}

