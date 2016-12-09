$(document).ready(function () {
       $(".sumbit").bind('click',function(){
       		var phone = $('.iphone').val();
       		var pwd = $('.password').val();
       	
	        if (phone == "") {
	            alert("请输入手机号");
	            return false;
	        }else if (pwd == "") {
	            alert("请输入密码");
	            return false;
	        }
            $.ajax({
	            type:"post",
	            url: baseUrl+"user/userIsLogin.do",
	            contentType: "application/json;charset=utf-8", //必须有
	            dataType: "json", //表示返回值类型，不必须
	            //crossDomain:true,
	            //jsonp:"callback",
	            data: JSON.stringify({'userDto':{'mobile':phone,'passWord':pwd}}),
	            success: function (data) {
	            	/*alert(data);*/
	            	var json;
	            	
	            	var str = JSON.stringify(data);
	            	
	            	if(typeof data === 'object'){
	            	    json = data;
	            	}
	            	else{
	            	    json = eval(str);
	            	}
	            	if(json.state == '1'){
	            		alert("登录成功");
	            		window.location.href="index.html";
	            	}else{
	            		alert("用户名或密码输入错误");
	            		return;
	            	} 
	            },
	            error : function(e) {alert("登录失败");}
        	});
        
        return false;

    })
});