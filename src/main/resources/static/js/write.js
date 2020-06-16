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
        $("#submitBtn").on("click",function(e){
             e.preventDefault();
             e.stopPropagation();
            //获取表格中填写的信息
            var studentNumber=$("#student_Number").text().trim();
            var classid =$("#class").text().trim();
            var teacherNum= $("#teacher_Num").text().trim();
            var studyAim=$("#study_Aim").text().trim();
            var reason=$("#Reason").text().trim();
            var problem=$("#Problem").text().trim();
            var nextAim=$("#next_Aim").text().trim();
            
            console.log("studentNumber",studentNumber);
            if(studentNumber == '' ){
                alert("学号不能为空！");
                return ;
            }else if(classid == ''){
                alert("班级不能为空！");
                return ;
            }else if(teacherNum == ''){
                alert("教师工号不能为空！");
                return ;
            }else if(studyAim == ''){
                alert("学习目标不能为空！");
                return ;
            }else if(reason == ''){
                alert("理由不能为空！");
                return ;
            }else if(problem == ''){
                alert("问题不能为空！");
                return ;
            }else if(nextAim == ''){
                alert("下阶段目标不能为空！");
                return ;
            }else{
                $.ajax({
                    url:"/student/report_add" ,    //请求的url地址
                    dataType:"json",   //返回格式为json
                    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                   data:{"student_num":studentNumber,
                       "class_id":classid,
                       "teacher_number":teacherNum,
                       "study_aim":studyAim,
                       "reason":reason,
                       "problem":problem,
                       "next_aim":nextAim,
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
            	
            }


        })

    })




