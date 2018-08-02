function loadPlan() {
    $.ajax({
        type: 'get',
        url: '/loadPlan.do',
        dataType: 'json',
        success: function (data) {
            var arr = $.parseJSON(data);
            var content = "";
            for (var i = 0; i < arr.length; i++) {
                content += '<div class="container-fluid  border" style="height: 140px;">' +
                                '<div class="my-3"><h4>教学计划：<span id="plan_name">' + arr[i].planName.replace(/(.*\/)*([^.]+).*/ig,"$2") + '</span></h4></div>' +
                                '<div class="mt-3"><h5>策划人：<span id="plane_people">' + arr[i].teacherName + '</span></h5></div>' +
                                '<div><button type="button" class="btn btn-secondary float-right" id=' + arr[i].teacherId + ' onclick="deletePlan(id); return false;">删除</button><a class="btn btn-primary float-right mr-sm-2" href="' + arr[i].url + '">查看</a></div></div>';
            }
            $('#plans').html(content);
        }
    });
}

function inputPlanName() {
    var file = $('#uploadTeachPlan').val();
    var FileExt=file.replace(/[^\\\/]*[\\\/]+/g,"");
    $('#plan-name').val(FileExt);
}

function createPlan() {
    $('#plan-name').val("");
    var formdata = new FormData($('#uploadForm')[0]);
    var file = $('#uploadTeachPlan').val();
    var fileType = /\.[^\.]+/.exec(file);
    if(fileType != '.pdf') {
        alert("请上传pdf文件！");
        return ;
    }
    if(file == '') {
        alert("请选择文件！！");
    } else {
        $.ajax({
            type: 'post',
            url: '/createPlan.do',
            data: formdata,
            dataType: 'json',
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (returndata) {
                alert(returndata);
                window.location.reload();
            },
            error: function (err) {
                alert("创建失败");
            }
        });
    }
}

function deletePlan(btnId) {
    $.ajax({
        type: 'get',
        url: '/deletePlan.do',
        data: {
            'id': btnId
        },
        dataType: 'json',
        success: function (result) {
            alert(result);
            if (result == '删除成功！'){
                window.location.reload();
            }
        }
    });
}