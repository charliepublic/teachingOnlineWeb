function loadClsInfo() {
    $.ajax({
        type:'get',
        url:'/AllClass.do',
        dataType:'json',
        success: function (data) {
            var arr = $.parseJSON(data);
            var content = "<table class=\"table-hover\" style=\"border:1px;width: 100%\">\n" +
                "            <thead>\n" +
                "                 <tr>\n" +
                "                     <th>班号</th>\n" +
                "                     <th>班名</th>\n" +
                "                     <th>操作</th>\n"+
                "                  </tr>\n" +
                "            </thead>";
            for (var i=0;i<arr.length;i++){
                content +='<tr><td>'+arr[i].cnumber+'</td><td>'+arr[i].cname+'</td>' +
                    '<td><button type="button" class="btn btn-primary" data-toggle="modal" id="'+ arr[i].cnumber+'" data-target="#myModalUpdata" onclick="setCNum(id)">修改</button>' +
                    '<button type="button" class="btn btn-primary" data-toggle="modal" id="'+ arr[i].cnumber+'" onclick="deleteCls(id)">删除</button></td></tr>';

            }
            content += "</table>";
            $('#clsInfo').html(content);
        }
    })

}

function setCNum(cnumber) {
    $('#showClass_num').val(cnumber);
}

function createClass() {
    var cname=$('#CreateClass_name').val();
    $.ajax({
        type:'post',
        url:'/addClass.do',
        dataType:'json',
        data:{
            'Cname':cname
        },
        success:function (data) {
            window.location.reload();
        }

    })

}

function changeClass() {
    var cnumber=$('#showClass_num').val();
    var cname=$('#Class_name').val();
    $.ajax({
        type:'get',
        url:'/changeClass.do',
        dataType:'json',
        data:{
            'Cnumber':cnumber,
            'Cname':cname
        },
        success:function (result) {
            if(result== '修改成功')
            window.location.reload();
        }

    })
    
}

function deleteCls(cnumber) {

    $.ajax({
        type: 'get',
        url: '/removeClass.do',
        data: {
            'Cnumber': cnumber
        },
        dataType: 'json',
        success: function (result) {
            alert(result);
            if (result == '删除成功'){
                window.location.reload();
            }
        }
    });
    
}

function findClassById() {
    var Cnumber=$('#selectCls').val();
    $.ajax({
        type:'get',
        url:'/findClassById.do',
        data:{
            'Cnumber':Cnumber
        },
        dataType:'json',
        success: function (result) {
            var arr = $.parseJSON(result);
            var content = "<table class=\"table-hover\" style=\"border:1px;width: 100%\">\n" +
                "            <thead>\n" +
                "                 <tr>\n" +
                "                     <th>班号</th>\n" +
                "                     <th>班名</th>\n" +
                "                     <th>操作</th>\n"+
                "                  </tr>\n" +
                "            </thead>";
            for (var i=0;i<arr.length;i++){
                content +='<tr><td>'+arr[i].cnumber+'</td><td>'+arr[i].cname+'</td>' +
                    '<td><button type="button" class="btn btn-primary" data-toggle="modal" id="'+ arr[i].cnumber+'" data-target="#myModalUpdata" onclick="setCNum(id)">修改</button>' +
                    '<button type="button" class="btn btn-primary" data-toggle="modal" id="'+ arr[i].cnumber+'" onclick="deleteCls(id)">删除</button></td></tr>';

            }
            content += "</table>";
            $('#clsInfo').html(content);
        }
    })
}