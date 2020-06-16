$(document).ready(function(){
        /*
         * JSON测试代码
         * var userObj = {"name":"zs2016","password":"123456"};
            console.log("js对象userObj转化成JSON字符串：");
            console.log(JSON.stringify(userObj));  //将js对象转化成JSON字符串

            var userStr = '{"name":"zs2016","password":"123456"}';
            console.log("JSON字符串userStr转化成js对象：");
            console.log(JSON.parse(userStr));                 //将JSON字符串转化成js对象
        */
        $("#submitBtn1").on("click",function(e){
            var username=$("#userName").val().trim();
            var password=$("#password").val().trim();
            console.log("userName",username);
            if(username == '' ){
                alert("用户名不能为空！");
                return ;
            }else if(password == ''){
                alert("密码不能为空！");
                return ;
            }

            $.ajax({
                     url:"student/login" ,    //请求的url地址
                     dataType:"json",   //返回格式为json
                     async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                    data:{"student_number":username,
                        "password":password},    //参数值
                    type:"POST",   //请求方式
                     beforeSend:function(){
                         //请求前的处理
                     },
                 success:function(data){
                	 console.log()
                         if (data.status==0) {
                             window.location.href = "/student/student";
                             window.sessionStorage.setItem('username',data.data.student_name)
                                window.sessionStorage.setItem('studennum',username)
                         }else {
                             alert("密码或账户有误")
                         }
                     },
                 error:function(){
                         alert("登陆失败！")
                      //请求出错处理
                   }
             });
    })



$("#submitBtn2").on("click",function(e){
    var username=$("#userName").val().trim();
    var password=$("#password").val().trim();
 //  alert("1")
    console.log("userName",username);
    if(username == '' ){
        alert("用户名不能为空！");
        return ;
    }else if(password == ''){
        alert("密码不能为空！");
        return ;
    }
    $.ajax({
        url:"teacher/login" ,    //请求的url地址
        dataType:"json",   //返回格式为json
        async:true,//请求是否异步，默认为异步，这也是ajax重要特性
        data:{"teacher_num":username,
            "password":password},    //参数值
        type:"POST",   //请求方式
        beforeSend:function(){
            //请求前的处理
        },
        success:function(data){
        	 
            if (data.status==0) {
                window.location.href = "/teacher/teacher";
            	  window.sessionStorage.setItem('username',data.data.teacher_name)
            	  
            
            }else {
                alert("密码或账户有误")
            }
        },
        error:function(){
            alert("登陆失败！")
            //请求出错处理
        }
    });


})
})
