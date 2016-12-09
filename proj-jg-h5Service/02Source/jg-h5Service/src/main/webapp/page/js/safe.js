$(document).ready(function () {
	$("#Exit").click(function(){
		$.ajax({
			type:"post",
			url:baseUrl+"user/safetyExit.do",
			async:true,
			contentType: "application/json;charset=utf-8",
			success:function(data){
				var obj = JSON.parse(data);
				if(initStr(obj.data) == 'true'){
					alert("退出成功")
            		window.location.href="index.html";
				}else if(initStr(obj.state) == -1){
					alert("请登入以后再操作!");
            		return;
				}else{
					alert("退出失败");
				}
			},
            error : function(e) {alert("退出失败");}
	     });
	});
	
	
	/*$("#modifyPassWord").click(function(){
		$.ajax({
			type:"post",
			url:baseUrl+"user/resetPassWord.do",
			async:true,
			contentType: "application/json;charset=utf-8", 
            data:JSON.stringify({
                 "modified_type":"LOG",  
			}),
			success:function(data){
              if(data==1){
              alert("修改成功");
              window.location.href='index.html';
               }
			},
            error : function(e) {alert("修改失败");}
	     });
	});*/
});




