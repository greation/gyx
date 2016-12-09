$(function circleList(){
	$.ajax({
		type:"post",
		url:baseUrl+"company/queryRecentCompanyDto.do",
		contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        data:JSON.stringify({"pageRequest": {
            "pageNum":1,
            "pageSize":10
        }
    }),
		success:function(data){
			//alert(data);
		
			var json;
			var str = JSON.stringify(data);
        	if(typeof data === 'object'){
        	    json = data;
        	}
        	else{
        	    json = eval(str);
        	}
        	var company_id ;//公司主键
        	var company;//公司名字
        	var address;//地址
        	var goodsList;//主营产品
        	var goodsListString="";//产品数据
        	var brandList;//主营品牌
        	var brandListString="";//品牌数据
        	var contacts;//联系人
        	var is_proxy;//是否认证
        	var is_address;//是否实地认证
        	var mobile;//公司电话
        	for(var i=0; i<json.data.length; i++){
        		company=json.data[i].company;
        		company_id=json.data[i].company_id;
        		address=json.data[i].address;
        		goodsList=json.data[i].goodsList;
        		brandList=json.data[i].brandList;
        		contacts=json.data[i].contacts;
        		is_proxy=json.data[i].is_proxy;
        		is_address=json.data[i].is_address;
        		mobile=json.data[i].mobile;
        		for (var j = 0; j < goodsList.length; j++) {
        			//alert(goodsList[j]);
					goodsListString=goodsListString+" "+goodsList[j];
				}
        		for (var k = 0; k < brandList.length; k++) {
        			brandListString=+brandListString+" "+brandList[k];
        		}
        		var html=
        			"<div class='near mt5'>"+
    			"<div class='up'>"+
    				"<div class='near-l'>"+
    					"<h3>"+company+"</h3>"+
    					"<font>"+address+"</font>"+
    				"</div>";
        		if(is_address == "1"){
        			html=html+"<div class='near-r'>"+
        			"<span class='rz'>实地认证</span>"+
        			"<i></i>"+
        			"</div>";
        		}
    			html=html+"</div>"+
    			"<div class='up'>"+
    				"<div class='near-ld'>"+
    					"<font>主营产品："+goodsListString+"</font><br/>"+
    					"<font>经营品牌："+brandListString+"</font>"+
    				"</div>"+
    				"<a href='tel:"+mobile+"' ><div class='near-r'>"+
    					"<span class='address-add'>"+contacts+"</span>"+
    				"</div></a>"+
    			"</div>"+
    		"</div>";
        		$("#cantactsPeople").append(html);
        	}
		},
		error : function(e) {alert("查询失败");}
	});
	
});

