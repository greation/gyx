$(document).ready(function() {
	
	$("#defaultAddress").on("click", function(){
		$.ajax({
			method : 'get',
			url : 'defaultAddress',
			data : {
				'name' : $("#_custName").val()
			},
			success : function(data) {
				if (JSON.parse(data) == "1") {
					alert("不可以添加");
					$("#_custName").focus();
				} else {
					alert("可添加");
				}
			}
		});
		
	});
	
});




function fileFunction(){
	var inputSize = $(".fileStyle-box").size();
	var i = inputSize;
	for (;i <= inputSize; i++)
	{
		var fileStr = "<input class='fileStyle-box' type='file' name="
		+'uploadFile'
		+ i 
		+" />";
	}
	$(".fileStyle").append(fileStr);
}

function custCheckIn(data,uid) {
	$.ajax({
		url:'../CustAgt/CustCheckIn',
		method:'post',
		data:{
			'id' : data,
			'uid': uid
		},
		success:function(data){
			if(JSON.parse(data) == "success"){
				alert("检入成功!");
			}else{
				alert("检入私海失败,请稍后重试!");
			}
		},
		error:function(success){
			alert("系统出错,请联系系统管理员!");
		}
	});
}


function custCheckOut(data) {
	$.ajax({
		url:'../CustAgt/CustCheckOut',
		method:'post',
		data:{
			'id' : data
		},
		success:function(data){
			if(JSON.parse(data) == "success"){
				alert("检出成功!");
			}else{
				alert("检出客户失败,请稍后重试!");
			}
		},
		error:function(success){
			alert("系统出错,请联系系统管理员!");
		}
	});
}

function test() {
	
}

