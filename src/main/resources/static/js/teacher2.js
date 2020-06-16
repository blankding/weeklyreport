$(document).ready(function(){
	$("#inquiryBtn").on("click",function(e){
//。。。。。。。。。。。。。。。。。。。。。	这是一句密码   			
		$.ajax({
			type:"get",
            dataType:"json",   //返回格式为json
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
		    data:{
		   "class_id":1//
		    },
		    url:"/report/count",
	        success:function(result){  //请求成功时运行的函数
	        	console.log(result)
	        	if(result.status==0){
	        	$('.one_number').html(result.data)
	        	var num=38
	        	$('.one_numbers').html(num-result.data) 
	        		//请求成功后，跳转到管理系统首页
	        		//window.location.href="teacher2.html";
	        	}
	        },
	        error:function(){  //请求失败时运行的函数
	        	
	        }
		})
		
		
			$.ajax({
			type:"get",
            dataType:"json",   //返回格式为json
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
		    data:{
		   "class_id":2//
		    },
		    url:"/report/count",
	        success:function(result){  //请求成功时运行的函数
	        	console.log(result)
	        	if(result.status==0){
	        	$('.two_number').html(result.data)
	        	var num1=39
	        	$('.two_numbers').html(num1-result.data) 
	        		//请求成功后，跳转到管理系统首页
	        		//window.location.href="teacher2.html";
	        	}
	        },
	        error:function(){  //请求失败时运行的函数
	        	
	        }
		})
		
		
		
		
			$.ajax({
			type:"get",
            dataType:"json",   //返回格式为json
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
		    data:{
		   "class_id":3//
		    },
		    url:"/report/count",
	        success:function(result){  //请求成功时运行的函数
	        	console.log(result)
	        	if(result.status==0){
	        	$('.three_number').html(result.data)
	        	var num2=39
	        	$('.three_numbers').html(num2-result.data) 
	        		//请求成功后，跳转到管理系统首页
	        		//window.location.href="teacher2.html";
	        	}
	        },
	        error:function(){  //请求失败时运行的函数
	        	
	        }
		})
		
		
		
		
		  $.ajax({
			type:"get",
            dataType:"json",   //返回格式为json
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
		    data:{
		   "class_id":4//
		    },
		    url:"/report/count",
	        success:function(result){  //请求成功时运行的函数
	        	console.log(result)
	        	if(result.status==0){
	        	$('.four_number').html(result.data)
	        	var num3=40
	        	$('.four_numbers').html(num3-result.data) 
	        		//请求成功后，跳转到管理系统首页
	        		//window.location.href="teacher2.html";
	        	}
	        },
	        error:function(){  //请求失败时运行的函数
	        	
	        }
		})
		
		
	})
})

