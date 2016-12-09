$(document).ready(function () {
	//绑定事件 register-information_over
	/**x 按钮点击事件*/
	$("#register-information_over").click(function(){
		//back=myInfo
		var back=getUrlParam("back");
		if(back=='myInfo'){
			window.location.href="my.html";
		}else{
			window.location.href="index.html";
		}
	})
	
	$.ajax({
        type:"post",
        url: baseUrl+"company/queryTopCategoryInfo.do",
        contentType: "application/json;charset=utf-8",
        dataType: "json", //表示返回值类型，不必须
        async: false,
        success: function(data) {
          var a=JSON.stringify(data);
          var b=JSON.parse(a);
          var arrs=b.data;
          for(var i=0;i<arrs.length;i++){
        	  $("#tab2").append($("<div class='product-t' id="+arrs[i].id+"><div class='product-title'><i></i><span>"+arrs[i].title+"</span><a class='iconr'></a></div><div class='product-list'> <ul></ul></div></div>"));
        	  $("[id="+arrs[i].id+" ]").click(function(){
//         		  $("div[id="+$(this).attr("id")+"] ul").toggle(1500);
        		  //清空元素
//         		  $("div[id="+$(this).attr("id")+"] ul").empty();
        		  if($("div[id="+$(this).attr("id")+"] ul").find("li").length==0){
        			  //如果ul里面
            		  $.ajax({
            		        type:"post",
            		        url: baseUrl+"company/queryChildCategoryInfo.do",
            		        contentType: "application/json;charset=utf-8",
            		        dataType: "json",
            		        data: JSON.stringify({"topid":$(this).attr("id")}), 
            		        async: false,
            		        success: function (data) {
            		        	  var a=JSON.stringify(data);
            		              var b=JSON.parse(a);
            		              var arrs1=b.data;
            		              for(var j=0;j<arrs1.length;j++){
             		            	 $("div[id="+arrs1[j].topid+"] ul").append("<li><span>"+arrs1[j].title+"</span><a class='addpro' id="+arrs1[j].id+" title="+arrs1[j].title+"  href='javascript:void(0)'>添加类目</a></li>");
             		            	 $("[id="+arrs1[j].id+"]").click(function(e){
    								  $("[id="+$(this).attr("id")+"]").toggleClass("caselpro");
    								 if($("[id="+$(this).attr("id")+"]").attr("class")=='addpro caselpro'){
    									//已经添加状态
    									$("#tab2").append("<input type='hidden' name='name' ids="+$(this).attr("id")+" value="+$(this).attr("title")+">");
    									$("#tab2").append("<input type='hidden' name='id' ids1="+$(this).attr("id")+" value="+$(this).attr("id")+">");
    									 $("[id="+$(this).attr("id")+"]").html("类目已添加");
    								 }else{
    									 //未添加状态
    									$("[id=tab2] input[ids="+$(this).attr("id")+"]").remove();
    									$("[id=tab2] input[ids1="+$(this).attr("id")+"]").remove();
    									 $("[id="+$(this).attr("id")+"]").html("添加类目");
    								 }
    								  return false;
             		            	})
            		              }
            		        },
            		        error : function(e) {alert("验证失败");}
            			});
        		  }else{
        			  $("div[id="+$(this).attr("id")+"] ul").toggle(100);
        		  }
        		  return false;
        	  })
          }
        },
        error : function(e) {alert("发送失败");}
	});
});