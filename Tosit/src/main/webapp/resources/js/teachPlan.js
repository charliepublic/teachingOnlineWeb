function loadPlan() {
    $.ajax({
        type: 'get',
        url: '/loadPlan.do',
        dataType: 'json',
        success: function (data) {
            var arr = $.parseJSON(data);
            var content = "";
            for (var i = 0; i < arr.length; i++) {
                content += '<div class="container-fluid  border" style="padding-top:70px; padding-bottom:70px"><div><h4>教学计划：<span id="plan_name">' + arr[i].planName + '</span></h4></div><br><div><h5>策划人：<span id="plane_people">' + arr[i].teacherName +
                    '</span></h5></div><div class="text-left" style="float:right"><a href="' + arr[i].url + '">查看</a></div><br><button type="button" class="btn btn-secondary" style="float: left;">删除</button></div>';
            }
            $('#plans').html(content);
        }
    })
}

function inputPlanName() {
    var file = $('#uploadTeachPlan').val();
    var FileExt=file.replace(/[^\\\/]*[\\\/]+/g,"");
    $('#plan-name').val(FileExt);
}