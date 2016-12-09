$(document).ready(function () {
    $(".sumbit").bind('click',function(){
		var pass = $('.pass').val();
		var passwd = $('.passwd').val();
		var phone=initStr(getUrlParam("phone"));
		//alert(phone);
        if (pass == "") {
            alert("请输入密码");
            return false;
        }
        if (passwd == "") {
            alert("请输入确认密码");
            return false;
        }
        if(pass != passwd){
			alert("密码不一样");
			return false;
		}
    	$.ajax({
            type:"post",
            url: baseUrl+"user/resetPassWord.do",
            contentType: "application/json;charset=utf-8", //必须有
            dataType: "json", //表示返回值类型，不必须
            async: false,//同步
            //crossDomain:true,
            //jsonp:"callback",
            data: JSON.stringify({'mobile':phone,'password':passwd,'modified_type':'FOR'}),
            success: function (data) {
            	var json;
            	var str = JSON.stringify(data);
            	if(typeof data === 'object'){
            	    json = data;
            	}
            	else{
            	    json = eval(str);
            	}
            	if(json.state=='1'){
            		alert("修改成功");
            		window.location.href="login.html";
            	}else{
            		alert("修改失败"+data.message);
            	}
            
            },
            error : function(e) {alert("注册失败");}
    	});
        return false;
    })
});























