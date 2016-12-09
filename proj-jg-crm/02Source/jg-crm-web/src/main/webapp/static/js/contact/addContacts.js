var successOrNo=false;
$(document).ready(function() {
	 var SuccessCount=0;
	
			$("#checkphone").blur(function() {
				var phone = $("#checkphone").val();//联系电话
				if(phone.toString().trim()==""){
					alert("手机号不可为空");
					$("#checkphone").focus();
				}else{
					$.ajax({
						url : 'checkContacts',
						data : {
							'telphone' : $("#checkphone").val()
						},
						success : function(data) {
							if(data!="[]"){
							var jsonData = eval(data);
								if(jsonData[0]==null){
									alert("此手机号主人暂无客服,请重新填写");
									$("#checkphone").val(""); 
									successOrNo=false;
								}
								if(SuccessCount>=0){
									alert("此手机号已是客服”"+jsonData[0].name+"”下客户的联系人手机号。请联系客服:"+jsonData[0].mobile);
									$("#checkphone").val(""); 
									successOrNo=false;
								}
							}else{
								alert("可以添加");
								successOrNo=true;
								SuccessCount--;
							}
						} 
						 
					});
				}
				
				
			});
		});

		function saveContacts() {
			var name = $("#con_name").val();//联系人姓名
			var owner = $("#nature-of-company").val(); //客户所有者
			var phone = $("#checkphone").val();//联系电话
			if (name.toString().trim() == "") {
				alert("联系人姓名不可为空");
			}else if(owner==0){
				alert("请添加客户名");
			}else if(phone.toString().trim()==""){
				alert("手机号不可为空");
			}else{
				$("#saveContact").submit();
			}
			
			
		}
		
		
		function saveAndCreateContacts() {
			var name = $("#con_name").val();//联系人姓名
			var owner = $("#nature-of-company").val(); //客户所有者
			var phone = $("#checkphone").val();//联系电话
			if (name.toString().trim() == "") {
				alert("联系人姓名不可为空");
			}else if(owner==0){
				alert("请添加客户名");
			}else if(phone.toString().trim()==""){
				alert("手机号不可为空");
			}else{
				if(successOrNo=true){
					$("#saveContact").attr("action", "insertAndCreateContacts"); 
					$("#saveContact").submit();
				}else{
					alert("请更改手机号");
				}
				
			}
			
		}
		function _cancel(){
			$("#reForm").submit();
		}