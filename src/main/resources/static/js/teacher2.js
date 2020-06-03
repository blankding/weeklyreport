$(document).ready(function(){
	$("inquiryBtn").on("click",function(e){
		e.preventDefault(); //阻止a元素发生默认行为
		//jQuery方法实现
var className = $("#className").val().trim();
var committed = $("#committed").val().trim();		   			
var uncommitted = $("#uncommitted").val().trim();
var data = {"committed":committed,"className":className,"uncommitted":uncommitted};
var url = "http://localhost:8080/MobileShop/admin_manager";
	
		$.ajax({
			type:"post",
		    data:data,
		    url:url,
	        timeout:2000,
	        beforeSend:function(){ //请求前运行的函数
	        	
	        },
	        complete:function(){  //请求完成时运行的函数
	        	
	        },
	        success:function(result){  //请求成功时运行的函数
	        	console.log(result)
	        	if(result.status==0){
	        		//请求成功后，跳转到管理系统首页
	        		window.location.href="teacher2.html";
	        	}
	        },
	        fail:function(){  //请求失败时运行的函数
	        	
	        }
		})
	})
})

