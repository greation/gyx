
$(document).ready(function () {
       $(".getyz").bind('click',function(){
       		var phone = $('.bl').val();
	        if (phone == "") {
	            alert("请输入手机号");
	            return false;
	        }
            $.ajax({
	            type:"post",
	            url: baseUrl+"verification/getVerificationCode.do",
	            contentType: "application/json;charset=utf-8", //必须有
	            dataType: "json", //表示返回值类型，不必须
	            //crossDomain:true,
	            //jsonp:"callback",
	            data: JSON.stringify({"phone":phone,"type":"REG"}), 
	            success: function (data) {
	            	
	            	var json;
	            	
	            	/*var str = JSON.stringify(data);*/
	            	
	            	
	            	if(typeof data === 'object'){
	            	    json = data;
	            	}
	            	else{
	            	    json = eval(str);
	            	}
	            	
	            	if(json.state == "1"){
	            		alert("发送成功");
	            	}else if(json.state == "0"){
	            		alert("发送失败");
	            	}
	            	
	            	
	            	
	            },
	            error : function(e) {alert("发送失败");}
        	});
        
        return false;

    });
    
    $(".sumbit").bind('click',function(){
    	
    	var phone = $('.bl').val();
		var pass = $('.pass').val();
		var passwd = $('.passwd').val();
		
		
			
		if (phone == "") {
		    alert("请输入手机号");
		    return false;
		}
        if (pass == "") {
            alert("请输入密码");
            return false;
        }
        if (passwd == "") {
            alert("请输入确认密码");
            return false;
        }
        if(pass != passwd){
			alert("密码不一样");
			return false;
		}
    	if(!checked()){
    		
    		return false;
    		
    	}
    	$.ajax({
            type:"post",
            url: baseUrl+"user/userRegistered.do",
            contentType: "application/json;charset=utf-8", //必须有
            dataType: "json", //表示返回值类型，不必须
            async: false,//同步
            //crossDomain:true,
            //jsonp:"callback",
            data: JSON.stringify({'userDto':{'mobile':phone,'passWord':pass}}),
            success: function (data) {
            	alert("注册成功");
            	window.location.href="register-information.html";
            },
            error : function(e) {alert("注册失败");}
    	});
        return false;

    })
    
    circleList();
 
});

function checked(){
	
	var code = $('.code').val();
	var phone = $('.bl').val();
   	
    if (phone == "") {
        alert("请输入手机号");
        return false;
    }
    if (code == "") {
        alert("请输入验证码");
        return false;
    }
    
    var isstatus=false;//状态
    
    $.ajax({
        type:"post",
        url: baseUrl+"verification/checkVerificationCode.do",
        contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        async: false,//同步
        //crossDomain:true,
        //jsonp:"callback",
        data: JSON.stringify({"phone":phone,"verificationCode":code,"type":"REG"}), 

        success: function(data) {
        	var json;
        	var str = JSON.stringify(data);

        	if (typeof data === 'object') {
        		json = data;
        	} else {
        		json = eval(str);
        	}
        	if (json.state == "1") {
        		alert("验证码正确");
        		isstatus=true;
        	} else if (json.state == "0") {
        		alert("验证码错误");
        		isstatus=false;
        	}
        },
        error : function(e) {alert("验证码错误");}
	});
    
    return isstatus;
    
    
}
function circleList(){
	var pageIndex=parseInt($("#thelist").children("input").val());
	$.ajax({
		type:"post",
		url:baseUrl+"company/queryCircleInfo.do",
		//url:"http://localhost:8080/jg-h5Service/company/queryCircleInfo.do",
		contentType: "application/json;charset=utf-8", //必须有
        dataType: "json", //表示返回值类型，不必须
        data:JSON.stringify({"pageRequest": {
            "pageNum":pageIndex,
            "pageSize":1000
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
        	var el, li, i;
    		el = document.getElementById('thelist');
        	for(i=0; i<json.data.length; i++){
        		circleId=json.data[i].id;
        		title=json.data[i].title;
        		var html="<div class='commen-h mt5 lstcircle' >"+
        		"<input class='circle'  value='"+circleId+"' type='hidden' />"+
				"<span>"+title+"</span>"+
				"</div>";
        		//$("#circleList").append(html);
        		li = document.createElement('li');
    			li.innerHTML = html;
    			el.appendChild(li, el.childNodes[0]);
        	}
        	
		},
		error : function(e) {alert("查询失败");}
	});
	
}



/*var myScroll,
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
	var pageIndex=parseInt($("#thelist").children("input").val())+1;
	$("#thelist").children("input").val(pageIndex);
	circleList();
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
			//pullUpEl.className = '';
			//pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Pull up to load more...';
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

document.addEventListener('DOMContentLoaded', function () { setTimeout(loaded, 200); }, false);*/
