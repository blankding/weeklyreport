$(document).ready(function(){
    console.log( $("#submitBtn4"))
    $("#submitBtn4").on("click",function(e){
        // e.preventDefault();
        // e.stopPropagation();
        //获取表格中填写的信息
        var studentNumber=$("#student_number").val().trim();
        var intnum = parseInt(studentNumber);

    $.ajax({
        url:"/report/weekreport" ,    //请求的url地址
        dataType:"json",   //返回格式为json
        async:true,//请求是否异步，默认为异步，这也是ajax重要特性
        data:{"student_number":intnum,
        },    //参数值
        type:"POST",   //请求方式
        success:function(data){
        	console.log(data.data[0])
            // var a = JSON.parse(data);
            //i表示在data中的索引位置，n表示包含的信息的对象
            //alert(a);
            $('#name').html(data.data[0].student_name)
            $('#student_num').html(data.data[0].student_number)
            $('#class').html(data.data[0].class_id)
            $('#date').html(data.data[0].creatime)
            $('#aim').html(data.data[0].student_aim)
            $('#reason').html(data.data[0].reason)
            $('#problem').html(data.data[0].problem)
            $('#next_aim').html(data.data[0].next)
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
        if (Answer=='') {
            alert("请输入回答内容")
        }else {
            $.ajax({
                url: "/teacher/answer",    //请求的url地址
                dataType: "json",   //返回格式为json
                async: true,//请求是否异步，默认为异步，这也是ajax重要特性
                data: {
                    "student_num": studentNumber,
                    "answer": Answer,
                },    //参数值
                type: "POST",   //请求方式

                success: function (data) {
                    alert("提交成功！")

                    //请求成功时处理
                },
                complete: function () {
                    //请求完成的处理
                },
                error: function () {
                    alert("提交失败！")
                    //请求出错处理
                }
            });
        }
    })

})

