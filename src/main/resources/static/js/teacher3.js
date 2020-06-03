$(document).ready(function(){
    $("#submitBtn4").on("click",function(e){
        e.preventDefault();
        e.stopPropagation();
        //获取表格中填写的信息
        var studentNumber=$("#student_number").val().trim();
        var intnum = parseInt(studentNumber);
        alert(studentNumber)
    $.ajax({
        url:"/student/studentNumber" ,    //请求的url地址
        dataType:"json",   //返回格式为json
        async:true,//请求是否异步，默认为异步，这也是ajax重要特性
        data:{"student_num":intnum,
        },    //参数值
        type:"POST",   //请求方式
        success:function(data){
            var a = JSON.parse(data);
            //i表示在data中的索引位置，n表示包含的信息的对象
            alert(a);

        },
        error:function(){
            alert("提交失败！")
            //请求出错处理
        }
    })
    })
    $("#submitBtn3").on("click",function(e){
        e.preventDefault();
        e.stopPropagation();
        //获取表格中填写的信息
        var studentNumber=$("#student_number").val().trim();
        var Answer =$("#answer").val().trim();
        alert(studentNumber)
        alert(Answer)


        $.ajax({
            url:"/teacher/answer" ,    //请求的url地址
            dataType:"json",   //返回格式为json
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
            data:{"student_num":studentNumber,
                "answer":Answer,
            },    //参数值
            type:"POST",   //请求方式

            success:function(data){
                alert("提交成功！")

                //请求成功时处理
            },
            complete:function(){
                //请求完成的处理
            },
            error:function(){
                alert("提交失败！")
                //请求出错处理
            }
        });

    })

})
