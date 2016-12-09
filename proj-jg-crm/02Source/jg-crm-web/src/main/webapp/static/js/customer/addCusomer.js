var _AddressCount = 1;
$(document).ready(function() {
	$("#_custName").blur(function() {
		
		if($("#oldCustBeanName").val()!=$("#_custName").val()){
			$.ajax({
				method : 'post',
				url : 'queryCustomerName',
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
		}
	});
	
	 var SuccessCount=0;
	$("#checkphone").blur(function() {
		var phone = $("#checkphone").val();//联系电话
		if(phone.toString().trim()==""){
			alert("手机号不可为空");
			$("#checkphone").focus();
		}else{
			$.ajax({
				url : '../contact/checkContacts',
				data : {
					'telphone' : $("#checkphone").val()
				},
				success : function(data) {
				 
						if(data!="[]"){
							successOrNo=false;
						var jsonData = eval(data);
							if(jsonData[0]==null){
								alert("此手机号主人暂无客服,请重新填写");
								$("#checkphone").val(""); 
								successOrNo=false;
							}
							if(SuccessCount>=0){
								alert("此手机号已是客服”"+jsonData[0].name+"”下客户的联系人手机号。请联系客服:"+jsonData[0].mobile);
								$("#checkphone").val(""); 
							 SuccessCount++;
							}
						}else{
							alert("可以添加");
							
						}
					 
					
				} 
			});
			 
		}
	});
	
	
	
});

function addAddress() {

	$("#detailedAddress")
			.append(
					"<div class='form-horizontal m-top-md'><div class='form-group'><label class='col-sm-2 control-label'>详细地址"
							+ _AddressCount
							+ "</label>"
							+ "<input type='hidden' name='addressList["
							+ _AddressCount
							+ "].name' value='详细地址"
							+ _AddressCount
							+ "'><div class='col-sm-7'>"
							+ "<input type='text' class='form-control' name='addressList["
							+ _AddressCount + "].address'></div></div></div>");
	_AddressCount++;

}

function savaCustomer() {
	var custName = $("#_custName").val();// 客户名称
	var corpKind = $("#_corpKind").val();// 公司性质
	var industry = $("#_industry").val();// 所在行业
	if (custName.toString().trim() == "") {
		alert("联系人姓名不可为空");
	} else  if (corpKind == 0) {
		alert("请选择公司性质");
	} else if (industry == 0) {
		alert("请选择所在行业");
	} else {
		$("#saveForm").attr("action", "custAdd"); 
		$("#saveForm").serialize();
		$("#saveForm").submit();
	}
}
function savaAndCreateCustomer() {
	var custName = $("#_custName").val();// 客户名称
	var corpKind = $("#_corpKind").val();// 公司性质
	var industry = $("#_industry").val();// 所在行业
	if (custName.toString().trim() == "") {
		alert("联系人姓名不可为空");
	} else if (corpKind == 0) {

		alert("请选择公司性质");
	} else if (industry == 0) {
		alert("请选择所在行业");
	} else {
			$.ajax({
				method:"GET",
				url : '../customer/custAddRedirect',
				data : 	$("#saveForm").serialize(),
				success : function(data) {
					if (JSON.parse(data) == "ok") {
						alert("添加成功");
						window.location.href="../customer/jumpAddcustomer";
					} else {
						alert("添加失敗");
					}
				}
			});
		
	}
}
