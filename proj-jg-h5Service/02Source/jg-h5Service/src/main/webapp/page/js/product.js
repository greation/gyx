$(document).ready(function () {
	   
});

function release(){
	 window.location.href="sendbrand.html";
}
  
	$("#thelist").on("click",'.delPro',function(){
	    var proid=$(this).children("input").val();
	    alert(proid);
	$.ajax({
        type:"post",
        url: baseUrl+"company/deleteReleaseProduct.do",
        contentType: "application/json;charset=utf-8", // 必须有
        dataType: "json", // 表示返回值类型，不必须
        data: JSON.stringify({"id":proid}),
        success: function (data) {
        	 window.location.reload();
        },
           error : function(e) {alert("删除失败");}
   	});
});
 


$(function circleList(){
	  $.ajax({
          type:"post",
          url: baseUrl+"company/queryReleaseProductInfo.do",
          contentType: "application/json;charset=utf-8", // 必须有
          dataType: "json", // 表示返回值类型，不必须
          data:JSON.stringify({"pageRequest": {
              "pageNum":1,
              "pageSize":10
          }
      }),
          success: function (data) {
       	  // alert(11);
       	var json;
  			var str = JSON.stringify(data);
          	if(typeof data === 'object'){
          	    json = data;
          	}
          	else{
          	    json = eval(str);
          	}
     if(json.state == -1 ){
    	 alert("请登入以后再操作");
    		window.location.href="login.html";
     }else if(json.state == 1){
          	var proid ;//
          	var title;// 产品名称
          	var spec;//规格
          	var quantity;//数量
          	var unit;//单位
          	var add_time;//发布时间
            var mins;
          	var el, li, i;
    		el = document.getElementById('thelist');
          	// 	alert(str);
          	for(i=0; i<json.data.length; i++){
          		proid=json.data[i].id;
          		title=json.data[i].title;
          		spec = json.data[i].spec;
          		quantity= json.data[i].quantity;
          		unit= json.data[i].unit;
          		add_time= json.data[i].add_time;
          		mins= json.data[i].timeago;
          		if(quantity == 0){
          			quantity ="";
          			unit="";
          		}
          		
          		if(mins> 59){
        			mins = "1小时前"
        		}else if(mins< 59){
        			mins = json.data[i].timeago+"分钟前"
        		}
          		
          		//alert(id+title+spec+quantity+unit);
          		var html=
          			"<div class='newlist'>"+
          				"<div class='newlist-f'>"+
          					"<span class='newlist-t'>"+title+"</span>"+
      						"<font>" +
      							mins+
		    				"</font>"+
		    			"</div>"+
		    			"<div class='newlist-f'>" +
			    			"<span>"+
			    				spec+quantity+unit+
			    			"</span>" +
		    			"</div>"+
		    			"<div class='delete-pr delPro'>"+
		    				"<img src='images/delete_03.png' />" +
		    					"<input name='delId' type='hidden' value='"+ proid + "'/>"+
		    			"</div>"+
	    			"</div>";
		           		li = document.createElement('li');
		    			li.innerHTML = html;
		    			el.appendChild(li, el.childNodes[0]);
        	}
     }else{
    	 alert("查询失败");
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
         url: baseUrl+"company/queryReleaseProductInfo.do",
         contentType: "application/json;charset=utf-8", // 必须有
         dataType: "json", // 表示返回值类型，不必须
         data:JSON.stringify({"pageRequest": {
             "pageNum":pageIndex,
             "pageSize":10
         }
     }),
         success: function (data) {
      	  // alert(11);
      	var json;
 			var str = JSON.stringify(data);
         	if(typeof data === 'object'){
         	    json = data;
         	}
         	else{
         	    json = eval(str);
         	}
         	var proid ;//
         	var title;// 产品名称
         	var spec;//规格
         	var quantity;//数量
         	var unit;//单位
         	var add_time;//发布时间
         	var el, li, i;
   		el = document.getElementById('thelist');
         	// 	alert(str);
         	for(i=0; i<json.data.length; i++){
         		proid=json.data[i].id;
         		title=json.data[i].title;
         		spec = json.data[i].spec;
         		quantity= json.data[i].quantity;
         		unit= json.data[i].unit;
         		add_time= json.data[i].add_time;
         		if(quantity == 0){
         			quantity ="";
         			unit="";
         		}
         		//alert(id+title+spec+quantity+unit);
         		var html=
         			"<div class='newlist'>"+
         				"<div class='newlist-f'>"+
         					"<span class='newlist-t'>"+title+"</span>"+
     						"<font>" +
     							add_time+
		    				"</font>"+
		    			"</div>"+
		    			"<div class='newlist-f'>" +
			    			"<span>"+
			    				spec+quantity+unit+
			    			"</span>" +
		    			"</div>"+
		    			"<div class='delete-pr delPro'>"+
		    				"<img src='images/delete_03.png' />" +
		    					"<input name='delId' type='hidden' value='"+ proid + "'/>"+
		    			"</div>"+
	    			"</div>";
		           		//$("#myProductList").append(html);
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

