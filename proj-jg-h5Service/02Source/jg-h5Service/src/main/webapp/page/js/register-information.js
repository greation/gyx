$(function(){
				$("#save").click(function(){
					var company=$("#company").val();
					var address=$("#address").val();
					var contacts=$("#contacts").val();
					var phone=$("#phone").val();
					var kindList=$("#kindList").val();
					var brandList=$("#brandList").val();
					var circle_id=$("#circle_id").val();
					var capital=$("#capital").val();
					var province=$("#province").val();
					var region=$("#region").val();
					var city=$("#city").val();
					var brandLists=$("#brandLists").val();
					var kindList=$("#kindList").val();
					$.ajax({
						type:"post",
						url:baseUrl+"user/companyRegistered.do",
						async:true,
						contentType: "application/json;charset=utf-8", 
						data:JSON.stringify({
						    "companyDto": {
						    	"company": company,
						        "address":address,
						        "contacts":contacts,
						        "phone":phone,
						        "circle_id":circle_id,
						        "capital":capital,
						        "province":province,
						        "region":region,
						        "city":city,
						        "brandLists":brandLists,
						        "kindList":kindList,
						    }
						}),
						success:function(responseText){
							alert("公司信息添加成功");
						}
				     });
				});
			});