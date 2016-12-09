$(document).ready(function (){
	$.ajax({
        type:"post",
        url: baseUrl+"company/queryDetailUserInfo.do",
        contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        success: function (data) {
        	var json;
        	if(typeof data === 'object'){
        	    json = data;
        	}
        	else{
        	    json = eval(str);
        	}
        	if(json.state == "1"){
        		//只对有效查询条件才存入cookie 最近搜索列
        		/**重载cookie最近搜索数据*/
        		loadMyPageInfo(json);
        	}else if(json.state == "0"){
        		alert("发送失败"+json.message);
        	}
        }
	});
	
	
	
	
	
	/**取消按钮点击事件*/
	$("#myhtnl_cTitle").click(function(){
		window.location.href="person-information.html";
		//解决事件冒泡问题
		return false; 
	});
	
});

function loadMyPageInfo(json){
	/*{
	    "state": 1,
	    "message": null,
	    "data": {
	        "user_id": 11462,
	        "company_id": 2,
	        "id": 9,
	        "username": "uu20160617143229",
	        "mobile": "15806588403",
	        "companyName": null,
	        "province": 3,
	        "city": 38,
	        "region": 418,
	        "address": "上海邺品贸易有限公司",
	        "contacts": "任兵兵1",
	        "phone": "13917924920",
	        "categoryList": [
	            "工具耗材",
	            "量具",
	            "工业安全",
	            "个人劳保",
	            "刀刃具",
	            "小型设备",
	            "清洁防锈"
	        ],
	        "brandList": [
	            "史丹利Stanley",
	            "易尔拓YATO",
	            "欧文IRWIN"
	        ],
	        "circle": "九星市场4",
	        "license": "/Uploads/2016-07-06/577c91e0e857e.jpeg",
	        "area": "安徽巢湖无为县"
	    }
	}*/
	var data=json.data;
	var contacts=data.contacts;
	var companyName=data.companyName;
	var mobile=data.mobile;
	
	$('#myhtml_phoneN').html(mobile);
	$('#myhtml_company').html(companyName);
	//是否实地认证
	if(initStr(data.is_address)=='1'){
		$('#myhtml_logoName').html("实地认证");
	}else{
	}
	
	if(companyName==''||companyName==null){
		$('#myhtml_logoName').html("待完善信息");
		$("#myhtml_logoName").click(function(){
			window.location.href="register-information.html?back=myInfo";
			//解决事件冒泡问题
			return false; 
		});
	}

	
	
}