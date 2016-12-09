$(document).ready(function () {
       $(".getyz").bind('click',function(){
       		var phone = $('.bl').val();
       	
	        if (phone == "") {
	            alert("请输入手机号");
	            return false;
	        }
	        
            $.ajax({
	            type:"post",
	            url: baseUrl+"verification/getVerificationCode.do",
	            contentType: "application/json;charset=utf-8", //必须有
	            dataType: "json", //表示返回值类型，不必须
	            //crossDomain:true,
	            //jsonp:"callback",
	            data: JSON.stringify({"phone":phone,"type":"FOR"}), 
	            success: function (data) {
            		var json;
	            	
	            	if(typeof data === 'object'){
	            	    json = data;
	            	}
	            	else{
	            	    json = eval(str);
	            	}
	            	if(json.state =="2"){
	            		alert("用户不存在，请先注册！");
	            		window.location.href="register.html";
	            	}else{
	            		if(json.state == "1"){
	            			alert("发送成功");
	            		}else if(json.state == "0"){
	            			alert("发送失败");
	            		}
	            	}
	            },
	            error : function(e) {alert("发送失败");}
        	});
        
        return false;

    });
    
    $(".sumbit").bind('click',function(){
    	
    	checked();
    })
});



function checked(){
	
	var code = $('.code').val();
	var phone = $('.iphone').val();
   	
    if (phone == "") {
        alert("请输入手机号");
        return false;
    }
    if (code == "") {
        alert("请输入验证码");
        return false;
    }
    
    $.ajax({
        type:"post",
        url: baseUrl+"verification/checkVerificationCode.do",
        contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        async: false,//同步
        //crossDomain:true,
        //jsonp:"callback",
        data: JSON.stringify({"phone":phone,"verificationCode":code,"type":"FOR"}), 

        success: function(data) {
        	var json;
        	var str = JSON.stringify(data);

        	if (typeof data === 'object') {
        		json = data;
        	} else {
        		json = eval(str);
        	}
        	if (json.state == "1") {
        		alert("验证码正确");
        		window.location.href="resetpass.html?phone="+phone;
        	} else if (json.state == "0") {
        		alert("验证码错误");
        		return false;
        	}
        },
        error : function(e) {alert("验证码错误");}
	});
    
}





