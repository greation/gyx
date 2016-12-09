/*
 * v1.1.0
 * YiLiu
 * 20160706
 */
/**页面初始化加载数据 + 绑定事件*/
$(document).ready(function (){
	initSearchTest();
	initSearchList();
	//initSearchList();
	//initselect();
	//按钮点击事件
	$("#searchlist_search_click").click(function(){
		ajaxQuerySearchList();
	});
	$("#searchlist_search_cancel").click(function(){
		window.location.href="index.html";
	});
	$("#searchlist_search_x").click(function(){
		$("#searchlist_search_text").val("");
	});
});

/**初始化最新一次搜索内容*/
function initSearchTest(){
	if($.cookie('search_searchValue')!=''&&$.cookie('search_searchValue')!='null'){
		//初始化输入框 输入的值
		$("#searchlist_search_text").val($.cookie('search_searchValue'));
	}
}
/**重置最后一次搜索内容*/
function buildSearchValue(searchValue){
	if(searchValue){
		if(searchValue!=''){
			$.cookie('search_searchValue',searchValue);
		}
	}
}
/**初始化查询列表内容*/
function initSearchList(pageQueryParam){
	var pageQueryParam=$("#searchlist_search_text").val();
	//alert("初始化查询列表内容");
	if(pageQueryParam!=''){
		//点击查询 清空
		$("#thelist").html("<input type='hidden' value='1' />");
		ajaxQuerySearchList();
	}
}
/**绑定查询按钮事件*/
function ajaxQuerySearchList(){
	var pageQueryParam=$("#searchlist_search_text").val();
	var brand_id;
	var c_id;
	var circle_id;
	$.ajax({
         type:"post",
         url: baseUrl+"company/queryCompanyMainSearch.do",
         contentType: "application/json;charset=utf-8", //必须有
         dataType: "json", //表示返回值类型，不必须
         data: JSON.stringify({"pageQueryParam":pageQueryParam,"brand_id":brand_id,"c_id":c_id,"circle_id":circle_id,
        	 "pageNum": parseInt($("#thelist").children("input").val()),
                 "pageSize": 10
         }), 
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
         		if(pageQueryParam){
         			buildSearchListFromListPage(pageQueryParam);
         		}
         		loadSearchList(json);
         	}else if(json.state == "0"){
         		alert("发送失败"+json.message);
         	}
         }
         
 	});
	
	/**重置最后一次搜索内容*/
	buildSearchValue(pageQueryParam);
}
/**
 * @param json
 * 加载数据、做页面展示
 */
function loadSearchList(json){
	$("#searchlist_body").html(""); 
	var sdata = json.data;
	var allcontent="";
	
	var el, li, i;
	el = document.getElementById('thelist');
	$("#thelist").children("input").val(parseInt($("#thelist").children("input").val())+1);
	for(var i=0,l=sdata.length;i<l;i++){
		var company=sdata[i].company;
		var address=sdata[i].address;
		var brandstr="";
		var goodsstr="";
		var contacts=sdata[i].contacts;
		var brandList=sdata[i].brandList;
		var goodsList=sdata[i].goodsList;
		var company_id=sdata[i].company_id;
		var mobile=sdata[i].mobile;
		if(brandList!=null){
			for(var j=0,mj=brandList.length;j<mj;j++){
				brandstr=brandstr+" "+brandList[j];
			}
		}
		if(sdata[i].goodsList!=null){
			for(var k=0,mk=goodsList.length;k<mk;k++){
				goodsstr=goodsstr+" "+goodsList[k];
			}
		}
		var content = "<div class='near'><div class='up'><div class='near-l'><h3 id='companyList_"+company_id+"' value='"+company_id+"'>" +
		initStr(company)+ //company
		"</h3><font>" +
		initStr(address) +//"上海市普陀区云岭西路599弄"
		"</font></div><div class='near-r'>";
		if(sdata[i].is_address=='1'){
			//1认证
			//alert("实地认证"+sdata[i].is_address);
			content=content+"<span class='near-rsd'>实地认证</span>"
		}else{
			content=content+"<span class='near-rsd'>代理认证</span>"
		}
		content=content+
		"<i></i></div></div><div class='up'><div class='near-ld'>"+
		"<font>主营产品："+
		initStr(goodsstr)+//"电化学仪器、实验仪器"
		"</font><br/><font>经营品牌："+
		initStr(brandstr)+//"3M 霍尼韦尔 安塞尔"
		"</font></div><div class='near-r'><a href='tel:"+mobile+"' ><div class='near-r'><span class='address-add'>" +
		initStr(contacts)+//"王经理"
		"</span></div></a></div></div></div>";
		allcontent=allcontent+content;
 		//每个几点添加html
		li = document.createElement('li');
		li.innerHTML = content;
		el.appendChild(li, el.childNodes[0]);
	}
	//$("#searchlist_body").html(allcontent); 
	
	/**公司名称 绑定事件*/
	for(var i=0,l=sdata.length;i<l;i++){
		var company_id=sdata[i].company_id;
		$("#companyList_"+company_id).click(function(){
			//alert("我绑定了一个事件:"+$(this).attr("value"));
			//跳转页面并存储下个页面查询输入框值
			//$.cookie('search_searchValue',$.trim($(this).html()));
			//跳转到列表页
			delCookie("query_company_id");
			$.cookie('query_company_id',$(this).attr("value"));
			window.location.href="search-detail.html?id="+$(this).attr("value");
			//解决事件冒泡问题
			return false; 
		});
	}
	//return allcontent;
}

//初始化下拉选项框
function initselect(){
	//初始化品牌多选框
	//initselectpp();
	//初始化品类多选框
	//initselectpl();
	//初始化商圈多选框
	//initselectsq();
};

function initselectpp(){
}

function initselectpl(){
	$.ajax({
        type:"post",
        url: baseUrl+"company/queryEveryChildCategory.do",
        contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        success: function (data) {
        	var json;
        	var str = JSON.stringify(data);
        	if(typeof data === 'object'){
        	    json = data;
        	}
        	else{
        	    json = eval(str);
        	}
        	if(json.state == "1"){
        		loadselectpl(json);
        	}else if(json.state == "0"){
        		alert("发送失败"+json.message);
        	}
        },
        error : function(e) {alert("发送失败");}
	});
}
//初始化商圈多选框
function initselectsq(){
	$.ajax({
         type:"post",
         url: baseUrl+"company/queryCircleInfo.do",
         contentType: "application/json;charset=utf-8", //必须有
         dataType: "json", //表示返回值类型，不必须
         success: function (data) {
         	var json;
         	var str = JSON.stringify(data);
         	if(typeof data === 'object'){
         	    json = data;
         	}
         	else{
         	    json = eval(str);
         	}
         	if(json.state == "1"){
         		loadselectsq(json);
         	}else if(json.state == "0"){
         		//样式变更
         		alert("发送失败"+json.message);
         	}
         },
         error : function(e) {alert("发送失败");}
 	});
}
//将返回的商圈数据加载进来
function loadselectsq(json){
	var sqs=json.data;
	for(var i=0,l=sqs.length;i<l;i++){
		var title=sqs[i].title;
		var circle_id=sqs[i].id;
		//<option>品类</option>
		var content = "<option value='"+circle_id+"'>"+title+"</option>" ;
		$("#select_sq_optionAll").after(content); 
	}
}
//将返回的品类数据加载进来
function loadselectpl(json){
	var pls=json.data;
	for(var i=0,l=pls.length;i<l;i++){
		var title=pls[i].title;
		var c_id=pls[i].id;
		//<option>品类</option>
		var content = "<option value='"+c_id+"'>"+title+"</option>" ;
		$("#select_pl_optionAll").after(content); 
	}
}
/**绑定新搜索数据到 最近搜索列表(cookie中存储)*/
function buildSearchListFromListPage(name){
	if(name!=''){
		//cookie设置
		if($.cookie('searchList')=='null'||$.cookie('searchList')==null){
			$.cookie('searchList',$.trim(name)); 
		}else{
			//此处需要增加去重操作 
			$.cookie('searchList',cookieSearchList($.cookie('searchList'),$.trim(name))); 
		}
		var searchList;
		if(($.cookie('searchList')+"").indexOf("|")>=0){
			searchList=$.cookie('searchList').split("|"); 
		}else{
			searchList=[$.cookie('searchList')];
		}
		var num=0;
		var newCookie="";
		if(searchList.length>5){
			//重置cookie最近搜索列
			for (i=searchList.length;i>0 ;i--){
				//当前搜索内容与历史内容做匹配去重操作
				num++;
	    		if(num==1){
	    			newCookie=$.trim(searchList[i-1]);
	    		}else{
	    			newCookie=$.trim(searchList[i-1])+"|"+newCookie;
	    		}
				if(num==5){
					break;
				}
			}
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

var myScroll,
pullDownEl, 
pullDownOffset,
pullUpEl, 
pullUpOffset,
generatedCount = 0;

function pullDownAction () {
setTimeout(function () {	// <-- Simulate network congestion, remove setTimeout from production!
	var el, li, i;
	el = document.getElementById('thelist');

	for (i=0; i<0; i++) {
		li = document.createElement('li');
		li.innerText = 'Generated row ' + (++generatedCount);
		el.insertBefore(li, el.childNodes[0]);
	}
	document.getElementById("pullUp").style.display="";
	myScroll.refresh();
}, 1000);
}

function pullUpAction () {
	setTimeout(function () {
		ajaxQuerySearchList();
		myScroll.refresh();
	}, 1000);
}

function loaded() {
pullDownEl = document.getElementById('pullDown');
pullDownOffset = pullDownEl.offsetHeight;
pullUpEl = document.getElementById('pullUp');	
pullUpOffset = 10;
//pullUpOffset = pullUpEl.offsetHeight;
myScroll = new iScroll('wrapper', {
	useTransition: true,
	topOffset: pullDownOffset,
	onRefresh: function () {
		//that.maxScrollY = that.wrapperH - that.scrollerH + that.minScrollY;
		//that.minScrollY = -that.options.topOffset || 0;
		//alert(this.wrapperH);
		//alert(this.scrollerH);
		if (pullDownEl.className.match('loading')) {
			pullDownEl.className = '';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = 'Pull down to refresh...';}
		if (pullUpEl.className.match('loading')) {
			pullUpEl.className = '';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Pull up to load more...';
		}
		
		document.getElementById("pullUp").style.display="none";
		document.getElementById("show").innerHTML="onRefresh: up["+pullUpEl.className+"],down["+pullDownEl.className+"],Y["+this.y+"],maxScrollY["+this.maxScrollY+"],minScrollY["+this.minScrollY+"],scrollerH["+this.scrollerH+"],wrapperH["+this.wrapperH+"]";
	},
	onScrollMove: function () {
		document.getElementById("show").innerHTML="onScrollMove: up["+pullUpEl.className+"],down["+pullDownEl.className+"],Y["+this.y+"],maxScrollY["+this.maxScrollY+"],minScrollY["+this.minScrollY+"],scrollerH["+this.scrollerH+"],wrapperH["+this.wrapperH+"]";
		if (this.y > 0) {
			pullDownEl.className = 'flip';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = 'Release to refresh...';
			this.minScrollY = 0;
		}
		if (this.y < 0 && pullDownEl.className.match('flip')) {
			pullDownEl.className = '';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = 'Pull down to refresh...';
			this.minScrollY = -pullDownOffset;
		}
		
		if ( this.scrollerH < this.wrapperH && this.y < (this.minScrollY-pullUpOffset) || this.scrollerH > this.wrapperH && this.y < (this.maxScrollY - pullUpOffset) ) {
			document.getElementById("pullUp").style.display="";
			pullUpEl.className = 'flip';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Release to refresh...';
		} 
		 if (this.scrollerH < this.wrapperH && this.y > (this.minScrollY-pullUpOffset) && pullUpEl.className.match('flip') || this.scrollerH > this.wrapperH && this.y > (this.maxScrollY - pullUpOffset) && pullUpEl.className.match('flip')) {
			document.getElementById("pullUp").style.display="none";
			pullUpEl.className = '';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Pull up to load more...';
		}
	},
	onScrollEnd: function () {
		document.getElementById("show").innerHTML="onScrollEnd: up["+pullUpEl.className+"],down["+pullDownEl.className+"],Y["+this.y+"],maxScrollY["+this.maxScrollY+"],minScrollY["+this.minScrollY+"],scrollerH["+this.scrollerH+"],wrapperH["+this.wrapperH+"]";
		if (pullDownEl.className.match('flip')) {
			pullDownEl.className = 'loading';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = 'Loading...';				
			pullDownAction();	// Execute custom function (ajax call?)
		} 
		 if (pullUpEl.className.match('flip')) {
			pullUpEl.className = 'loading';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Loading...';		
			pullUpAction();	// Execute custom function (ajax call?)
		}
	}
});

//setTimeout(function () { document.getElementById('wrapper').style.left = '0'; }, 800);
}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', function () { setTimeout(loaded, 200); }, false);
