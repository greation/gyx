$(function circleList(){
	alert(11);
	$.ajax({
		type:"post",
		/*url:baseUrl+"/company/queryCircleInfo.do",*/
		url:baseUrl+"company/queryRecentCompanyDto.do",
		contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        data:JSON.stringify({"pageRequest": {
            "pageNum":1,
            "pageSize":10
        }
    }),
		success:function(data){
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
        	var is_proxy//是否认证
        	var is_address；//是否实地认证
        	var el;
    		el = document.getElementById('thelist');
        	for(i=0; i<json.data.length; i++){
        		company=json.data[i].company;
        		company_id=json.data[i].company_id;
        		address=json.data[i].address;
        		goodsList=json.data[i].goodsList;
        		brandList=json.data[i].brandList;
        		contacts=json.data[i].contacts;
        		is_proxy=json.data[i].is_proxy;
        		is_address=json.data[i].is_address;
        		todayProductsTotal=json.data[i].todayProductsTotal;
        		for (j = 0; j < goodsList.length; j++) {
					goodsListString=goodsListString+" "+goodsList[j];
				}
        		for (k = 0; k < brandList.length; k++) {
        			brandListString=+brandListString+" "+brandList[k];
        		}
        		var html=
        			"<div class='near mt5'>"+
    			"<div class='up'>"+
    				"<div class='near-l'>"+
    					"<h3>"+company+"</h3>"+
    					"<font>"+address+"</font>"+
    				"</div>"+
    				"<div class='near-r'>"+
    					"<span>实地认证</span>"+
    					"<i></i>"+
    				"</div>"+
    			"</div>"+
    			"<div class='up'>"+
    				"<div class='near-ld'>"+
    					"<font>主营产品："+goodsListString+"</font>"+
    					"<font>经营品牌："+brandListString+"</font>"+
    				"</div>"+
    				"<div class='near-r'>"+
    					"<span><i></i>"+contacts+"</span>"+
    				"</div>"+
    			"</div>"+
    		"</div>";
        		$("#cantactsPeople").append(html);
        	}
		},
		error : function(e) {alert("查询失败");}
	});
	
});
