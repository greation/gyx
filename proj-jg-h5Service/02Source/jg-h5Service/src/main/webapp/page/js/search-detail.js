/*
 * v1.1.0
 * YiLiu
 * 20160706
 */
/**页面加载完绑定js*/
$(document).ready(function (){
	var query_company_id=$.cookie('query_company_id');
	query_company_id="2";
	$.ajax({
        type:"post",
        url: baseUrl+"company/queryCompanyPageInfo.do",
        contentType: "application/json;charset=utf-8", //必须有
        data: JSON.stringify({"company_id":query_company_id,
       	 		"pageNum": parseInt($("#thelist").children("input").val()),
                "pageSize": 3	
        }), 
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
        		loadSearchDetail(json);
        	}else if(json.state == "0"){
        		alert("发送失败"+json.message);
        	}
        },
        error : function(e) {alert("发送失败");}
	});
	
});


function loadMoreProducts(){
	var query_company_id=$.cookie('query_company_id');
	query_company_id="2";
	$.ajax({
        type:"post",
        url: baseUrl+"company/queryCompanyPageInfo.do",
        contentType: "application/json;charset=utf-8", //必须有
        data: JSON.stringify({"company_id":query_company_id,
   	 		"pageNum": parseInt($("#thelist").children("input").val()),
            "pageSize": 3	}), 
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
        		loadSearchDetail(json);
        	}else if(json.state == "0"){
        		alert("发送失败"+json.message);
        	}
        },
        error : function(e) {alert("发送失败");}
	});
	
	
}


//数据加载
function loadSearchDetail(json){
	var el, li, i;
	el = document.getElementById('thelist');
	$("#thelist").children("input").val(parseInt($("#thelist").children("input").val())+1);
	
	//$("#search_detail_all_p").html(""); 
	//$("#search_detail_add").html(""); 
	$("#search_detail_company_name").html(""); 
	var sdata = json.data;
	//设置公司名称
	$("#search_detail_company_name").html(sdata.company); 
	var brandstr="";
	var goodsstr="";
	var contacts=sdata.contacts;
	var brandList=sdata.brandList;
	var goodsList=sdata.goodsList;
	var address=sdata.address;
	var mobile=sdata.mobile;
	if(brandList!=null){
		for(var j=0,mj=brandList.length;j<mj;j++){
			brandstr=brandstr+" "+brandList[j];
		}
	}
	if(goodsList!=null){
		for(var k=0,mk=goodsList.length;k<mk;k++){
			goodsstr=goodsstr+" "+goodsList[k];
		}
	}
	/*<span>
	主营产品：电化学仪器、实验仪器<br />
	经营品牌：3M 霍尼韦尔 安塞尔</span>*/
	$("#search_detail_p_b").html(""); 
	var search_detail_all_p_context="";
	search_detail_all_p_context="<span>主营产品："+initStr(goodsstr)+"<br />经营品牌："+initStr(brandstr)+"</span>";
	$("#search_detail_p_b").html(search_detail_all_p_context); 
	
	
/*	<div class='address-l'>
	<span>上海市普陀区云岭西路599弄</span><br />
	<font><span class='rz'>实地认证</span><i></i></font>
	</div>
	<div class='address-r'><span><i></i>王经理</span></div>*/
	$("#search_detail_add").html(""); 
	var search_detail_add="";
	search_detail_add="<div class='address-l'><span>"+address+
		"</span><br/>";
	if(sdata.is_address=='1'){
		//1认证
		search_detail_add=search_detail_add+"<font><span class='rz'>实地认证</span><i></i></font>";
	}else{
		search_detail_add=search_detail_add+"<font><span class='rz'>代理认证</span><i></i></font>";
	}
	search_detail_add=search_detail_add+"</span><i></i></font></div><div class='address-r'><a href='tel:"+mobile+"' ><div class='near-r'><span class='address-add' >"+
		initStr(contacts)+"</span></div></a></div>";
	$("#search_detail_add").html(search_detail_add);
	
	/*<div class='near-r'><a href='tel:"+mobile+"' ><div class='near-r'><span class='address-add'>" +
	initStr(contacts)+//"王经理"
	"</span></div></a>
*/	/*<div class="newlist">
		<div class="newlist-f"><span class="newlist-t">3M口罩</span><font>0分钟前</font></div>
		<div class="newlist-f"><span>425原装 50.8MM宽＊55M</span></div>
	</div>*/
	$("#search_detail_all_p").html(""); 
	var search_detail_all_p="";
	var products=sdata.products;
	
	for(var i=0,l=products.length;i<l;i++){
		//day  hour  minute
		var timeStr="";
		if(initNumToStr(products[i].day)!='0'){
			timeStr=timeStr+initNumToStr(products[i].day)+"天";
		}
		if(initNumToStr(products[i].hour)!='0'){
			timeStr=timeStr+initNumToStr(products[i].hour)+"小时";		
		}
		if(initNumToStr(products[i].minute)!='0'){
			timeStr=timeStr+initNumToStr(products[i].minute)+"分钟";
		}
		
		var productStrHtml="<div class='newlist'><div class='newlist-f'><span class='newlist-t'>"+
		initStr(products[i].title)+"</span><font>"+timeStr+"</font></div><div class='newlist-f'><span>"+
		initStr(products[i].spec)+"</span></div></div>";
		
		li = document.createElement('li');
		li.innerHTML = productStrHtml;
		el.appendChild(li, el.childNodes[0]);
	}
	//$("#search_detail_all_p").html(search_detail_all_p); 
	$("#search_detail_upload_img_url").attr('src',baseUrl+"Uploads/200000030450126898552662144.jpg"); 
	
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
		loadMoreProducts();
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


