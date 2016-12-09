$(document).ready(function () {
    
    $.ajax({
        type:"post",
        url: baseUrl+"user/homeDynamic.do",
        contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        //crossDomain:true,
        //jsonp:"callback",
        success: function (data) {
            /*alert("查询成功"+JSON.stringify(data));*/
            /*$(".preview").html(testData); */
            
            var json;
        	
        	var str = JSON.stringify(data);
        	
        	
        	if(typeof data === 'object'){
        	    json = data;
        	}
        	else{
        	    json = eval(str);
        	}
        	
        	
        	
        	/*//公司名称
        	var company = json.data[0].company;
        	//商品名称
        	var title = json.data[0].title;
        	//商品类型
        	var ty = json.data[0].ty;
        	//时间
        	var mins = json.data[0].mins;*/
        	
        	
        	

        	var sdata = json.data;
        	
        	for(var i=0,l=sdata.length;i<l;i++){
        		
        		var ty;
        		
        		if(sdata[i].ty == 0){
        			ty = "搜索"
        		}else if(sdata[i].ty == 1){
        			ty = "供应"
        		}
        		
        		var mins;
        		
        		if(sdata[i].mins > 59){
        			mins = "1小时前"
        		}else if(sdata[i].mins < 59){
        			mins = sdata[i].mins+"分钟前"
        		}
        		
        		
        		var content = "<div class='newlist' id='companyNewList'>" +
				"<div class='newlist-f'>" +
				"<span class='newlist-t'>"+sdata[i].title+"</span>" +
				"<font>"+mins+"</font>" +
				"</div>" +
				"<div class='newlist-f'>" +
				"<span class='company'>"+sdata[i].company+"</span>" +
				"<font>"+ty+"</font>" +
				"</div>" +
				"</div>";
        		
        		
        		$("#companyNewListStart").append(content); 
        		
        		
    		}
        	/*alert(sdata.length); */
        	
        	
            
        },
        error : function(e) {alert("查询失败");}
	});
    
    //搜索输入框跳转 刘毅
    $("#indext_location_input").click(function(){
    	window.location.href="search.html";
    });
    
    
    
  //搜索输入框跳转 刘毅
    $("#index_icon-my").click(function(){
    	window.location.href="my.html";
    });
    
  //搜索输入框跳转 刘毅
    $("#index_icon-send").click(function(){
    	window.location.href="product.html";
    });
    
    $("#index_icon-shop").click(function(){
    	window.location.href="search.html";
    });
        
});

