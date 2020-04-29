$(function(){
    //formdatademo();

    selectById();
});
function demo(){
    console.log("niaho");
}
function formdatademo(){
    var formdata=new FormData();
    //var  user={username:"xiaoli",pwd:"123456"};
    formdata.append('user',"nhao");
    console.log(formdata.get("user"));
    $.ajax({
        sync: false,
        url: "html/dataform",
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
            alert(data.data);
        },
        error : alert("error"),
    });
}