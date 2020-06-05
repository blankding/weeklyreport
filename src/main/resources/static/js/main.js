/* 
* @Author: Marte
* @Date:   2016-12-08 15:16:40
 * @Last Modified by: mikey.zhaopeng
 * @Last Modified time: 2020-06-04 10:38:46
*/

$(document).ready(function(){
    //左侧导航栏动效
    $(".navTitle").on("click",function(){
      if($(this).parent().hasClass('selected')){
        $(this).parent().removeClass('selected');  
        $(this).next().slideUp();
       }else{ 
        $(this).parent().siblings().removeClass('selected');  
        $(this).parent().addClass('selected');
        $(this).next().slideDown();
        $(this).parent().siblings().children(".item").slideUp();
      }  
    });


   
})
$('#names').html(window.sessionStorage.getItem('username'))