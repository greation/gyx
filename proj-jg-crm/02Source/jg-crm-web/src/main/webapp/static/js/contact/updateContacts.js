var successOrNo=false;
$(document).ready(function() {
	
	$("#email").blur(function(){
		if($("#email").val()!=""&&!$("#email").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
			alert("邮箱格式不正确 请重新输入");
			$("#email").val("");
		}
	});
	
	
			 var SuccessCount=0;
			 var partValue=$("#checkphone").val();
			if($("#con_gender").val()==1){
				$("#sex_girl").attr('checked', 'checked'); 
			}else{
				$("#sex_man").attr('checked', 'checked'); 
			}
			
			$("#checkphone").blur(function() {
				var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
				if(!myreg.test($("#checkphone").val())) 
				{ 
				    alert('请输入有效的手机号码！'); 
				    $("#checkphone").val("");
				}else{
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
							if(partValue!=$("#checkphone").val()){
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
										successOrNo=false;
									 SuccessCount++;
									}
								}else{
									alert("可以添加");
									successOrNo=true;
									
								}
							}else{
								console.info("本身，可以添加");
								successOrNo=true;
							}
							
						} 
					});
					 
				} 
				} 
			});
			
		});
		function updateContacts() {
			console.info($("#con_ID").val()==""||$("#con_ID").val()==null);
			 if($("#con_ID").val()==""||$("#con_ID").val()==null){
				//添加的方法
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
					console.info("新增");
					 $("#ContactForm").submit();//添加客户
				}
			}else{
				var name = $("#con_name").val();//联系人姓名
				var owner = $("#nature-of-company").val(); //客户所有者
				var phone = $("#checkphone").val();//联系电话
				if (name.toString().trim() == "") {
					alert("联系人姓名不可为空");
				}else if(owner=="客户名"){
					alert("请添加客户名");
				}else if(phone.toString().trim()==""){
					alert("手机号不可为空");
					$("#checkphone").focus();
				}else{
					$("#ContactForm").attr("action", "updateContacts"); 
					$("#ContactForm").submit();
					}} 
		}
		function saveAndCreate() {
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
				if(successOrNo==true){
					$("#ContactForm").attr("action", "insertAndCreateContacts"); 
					$("#ContactForm").submit();
				}else{
					alert("请更改手机号");
				}
				
			}
			
		}
		function _cancel(){
			$("#reForm").submit();
		}
		