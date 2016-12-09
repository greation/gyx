/*
 * v1.1.0
 * YiLiu
 * 20160706
 */
/**页面加载完绑定js*/
$(document).ready(function (){
	//delCookie("searchList");
	/**初始化最近搜索列表(cookie中存储)*/
	
	initSearchList();
	//文本框失去焦点事件 刘毅
	/*$("#search_hotsearch_text").blur(function(){
		var searchVal=$("#search_hotsearch_text").val();
		//cookie 里面查询最近搜索内容
		if(!$.trim(searchVal)== ""){
			if($.cookie('searchList')=='null'||$.cookie('searchList')==null){
				$.cookie('searchList',$("#search_hotsearch_text").val()); 
				initSearchList();
			}else{
				var searchList = $.cookie('searchList');
				$.cookie('searchList',searchList+"|"+$("#search_hotsearch_text").val()); 
				initSearchList();
			}
			$.cookie('search_searchValue',$.trim(searchVal));
		}
		 window.location.href="searchlist.html";
    });
    //取消按钮点击事件
	$("#search_hotsearch_cancel").click(function(){
		$("#search_hotsearch_text").val("");
	})*/
	$("#search_hotsearch_click").click(function(){
		var searchVal=$("#search_hotsearch_text").val();
		//cookie 里面查询最近搜索内容
		if(!$.trim(searchVal)== ""){
			$.cookie('search_searchValue',$.trim(searchVal));
			if($.cookie('searchList')=='null'||$.cookie('searchList')==null){
				$.cookie('searchList',$("#search_hotsearch_text").val()); 
				initSearchList();
			}else{
				//var searchList = $.cookie('searchList');
				$.cookie('searchList',cookieSearchList($.cookie('searchList'),$("#search_hotsearch_text").val()));
				//$.cookie('searchList',searchList+"|"+$("#search_hotsearch_text").val()); 
				initSearchList();
			}
			
		}
		//跳转到列表页
		window.location.href="searchlist.html";
    });
    
	//取消按钮点击事件
	/**取消按钮点击事件*/
	/*$("#search_hotsearch_cancel").click(function(){
		$("#search_hotsearch_text").val("");
		//解决事件冒泡问题
		return false; 
	});*/
	
	/**x 按钮点击事件*/
	$("#search_hotsearch_x").click(function(){
		$("#search_hotsearch_text").val("");
		//解决事件冒泡问题
		return false; 
	})
});

/**初始化最近搜索列表(cookie中存储)
 * 绑定最近一次输入内容
 * */
function initSearchList(){
	if($.cookie('search_searchValue')!=''&&$.cookie('search_searchValue')!='null'){
		//初始化输入框 输入的值
		$("#search_hotsearch_text").val($.cookie('search_searchValue'));
	}
	if($.cookie('searchList')){
		var searchList;
		if(($.cookie('searchList')+"").indexOf("|")>=0){
			searchList=$.cookie('searchList').split("|"); 
		}else{
			searchList=[$.cookie('searchList')];
		}
		var num=0;
		$("#search_search-list").html("");
		var newCookie="";
		for (i=searchList.length;i>0 ;i--){
			num++;
			var content = "<div class='search-listi'><span id='search_search-listi"+i+"' value='"+$.trim(searchList[i])+"'>"+
			initStr($.trim(searchList[i-1]))+"</span></div>";
    		$("#search_search-list").append(content); 
    		//子节点绑定事件
    		$("#search_search-listi"+i).click(function(){
    			//跳转页面并存储下个页面查询输入框值
    			$.cookie('search_searchValue',$.trim($(this).html()));
    			//跳转到列表页
    			window.location.href="searchlist.html";
    			//解决事件冒泡问题
    			return false; 
    		})
    		if(num==1){
    			newCookie=$.trim(searchList[i-1]);
    		}else{
    			newCookie=$.trim(searchList[i-1])+"|"+newCookie;
    		}
			if(num==5){
				break;
			}
		}
		if(searchList.length>5){
			$.cookie('searchList',newCookie);
		}
	}
}



/**重置cookie列数据 针对重复查询的*/
function  cookieSearchList(oldCookie,newSerachValue){
	var newCookie="";
	var searchList=oldCookie.split("|");
	var num=0;
	//当前搜索内容与历史内容做匹配去重操作
	for (i=searchList.length;i>0 ;i--){
		if(newSerachValue==searchList[i-1]){
			//存在重复不在新列里做排序
		}else{
			num++;
			if(num==1){
				newCookie=$.trim(searchList[i-1]);
			}else{
				newCookie=$.trim(searchList[i-1])+"|"+newCookie;
			}
		}
	}
	if($.trim(newCookie)!=''){
		newCookie=newCookie+"|"+newSerachValue;
	}else{
		newCookie=newSerachValue;
	}
	return newCookie;
}
