$(function circleList(){
	$.ajax({
		type:"post",
		url:baseUrl+"/company/queryCircleInfo.do",
		/*url:"http://localhost:8080/jg-h5Service/company/queryCircleInfo.do",*/
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
        	
        	var id ;//商圈主键
        	var title;//商圈名
        	var provincialCity;//地址
        	var companysTotal;//累计入住商家
        	var todayProductsTotal;//今日发布供货数
        	var pic;//商圈图片
        	var el, li, i;
    		el = document.getElementById('thelist');
        	for(i=0; i<json.data.length; i++){
        		circleId=json.data[i].id;
        		title=json.data[i].title;
        		provincialCity=json.data[i].provincialCity;
        		companysTotal=json.data[i].companysTotal;
        		if("undefined" == typeof companysTotal){
        			companysTotal=0;
        		}
        		todayProductsTotal=json.data[i].todayProductsTotal;
        		if("undefined" == typeof todayProductsTotal){
        			todayProductsTotal=0;
        		}
        		pic=json.data[i].pic;
        		var html=
        			"<section onclick='jumpRegister()'>" +
	        			"<input name='circle' value='"+circleId+"' hidden='hidden' />" +
						"<div class='h40'></div>" +
							"<div class='shop'>" +
							"<div class='shop-l'>" +
							"<div class='shop-t'>" +
							"<h3>"+title+"</h3>" +
							"<br />" +
							"<span>"+provincialCity+"</span>" +
							"</div>" +
							"<div class='shop-t'>" +
							"<font>累计入驻"+companysTotal+"家商家</font>" +
							"<br />" +
							"<span>今日发布"+todayProductsTotal+"条供货信息</span>" +
							"</div>" +
							"</div>" +
							"<div class='shop-r'>" +
							"<span>" +
							"<img src='"+pic+"'/>" +
							"</span>" +
							"</div>" +
						"</div>" +
					"</section>";
        		li = document.createElement('li');
    			li.innerHTML = html;
    			el.appendChild(li, el.childNodes[0]);
        	}
        	
		},
		error : function(e) {alert("查询失败");}
	});
	
});

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
	var el, li, i;
	el = document.getElementById('thelist');
	var iii=$("#thelist").children("input").val();
	//alert(iii);
	var iiii=parseInt(iii)+1;
	var pageIndex=parseInt(iiii);
	$("#thelist").children("input").val(iiii);
	$.ajax({
		type:"post",
		url:baseUrl+"/company/queryCircleInfo.do",
		/*url:"http://localhost:8080/jg-h5Service/company/queryCircleInfo.do",*/
		contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        data:JSON.stringify({"pageRequest": {
            "pageNum":pageIndex,
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
        	
        	var id ;//商圈主键
        	var title;//商圈名
        	var provincialCity;//地址
        	var companysTotal;//累计入住商家
        	var todayProductsTotal;//今日发布供货数
        	var pic;//商圈图片
        	var el, li, i;
    		el = document.getElementById('thelist');
        	for(i=0; i<json.data.length; i++){
        		circleId=json.data[i].id;
        		title=json.data[i].title;
        		provincialCity=json.data[i].provincialCity;
        		companysTotal=json.data[i].companysTotal;
        		if("undefined" == typeof companysTotal){
        			companysTotal=0;
        		}
        		todayProductsTotal=json.data[i].todayProductsTotal;
        		if("undefined" == typeof todayProductsTotal){
        			todayProductsTotal=0;
        		}
        		pic=json.data[i].pic;
        		var html=
        			"<section onclick='jumpRegister()'>" +
	        			"<input name='circle' value='"+circleId+"' hidden='hidden' />" +
						"<div class='h40'></div>" +
							"<div class='shop'>" +
							"<div class='shop-l'>" +
							"<div class='shop-t'>" +
							"<h3>"+title+"</h3>" +
							"<br />" +
							"<span>"+provincialCity+"</span>" +
							"</div>" +
							"<div class='shop-t'>" +
							"<font>累计入驻"+companysTotal+"家商家</font>" +
							"<br />" +
							"<span>今日发布"+todayProductsTotal+"条供货信息</span>" +
							"</div>" +
							"</div>" +
							"<div class='shop-r'>" +
							"<span>" +
							"<img src='"+pic+"'/>" +
							"</span>" +
							"</div>" +
						"</div>" +
					"</section>";
        		li = document.createElement('li');
    			li.innerHTML = html;
    			el.appendChild(li, el.childNodes[0]);
        	}
        	
		},
		error : function(e) {alert("查询失败");}
	});
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
