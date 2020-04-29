$(function(){
    //formdatademo();

    //selectById();
});
function formdatademo(){
    console.log("begin");
    var form=document.getElementById("form");
    var formdata=new FormData(form);
    // formdata.append("username","lihao");
    // formdata.append("pwd","pwd");
    console.log(formdata.get("username"));
    $.ajax({
        sync: false,
        url: "formdata",
        type: "post",
        data: formdata,
        dataType: "json",
        contentType:false,
        processData:false,
        cache:false,
        success: function(data){
            console.log(data)
            if(data.data!=null){
                alert(data.data);
            }
        },error: function(){
            alert("error")
        }
    });
}
function login(){
    // var username=document.getElementById("username").value;
    // var pwd=document.getElementById("pwd").value;

    var username=$('#username').val();
    var pwd=hex_md5($('#pwd').val());
    $.ajax({
       url: "user/login",
       type: "get",
       data :{"username": username,
                "pwd": pwd
              },
        cache:false,
        //dataType: "json",
        success: function(data){
           console.log(data.data);
        },error: alert("login shibai")

    });
}
function selectById(){
    var id=10;
    $.ajax({
        debug:true,
        type: "get",
        sync: true,
        url: "user/selectById",
        data: {"id":id},
        dataType: "text",

        success : function (data) {
            alert("成功");
            console.log(data)
        }
    });
}