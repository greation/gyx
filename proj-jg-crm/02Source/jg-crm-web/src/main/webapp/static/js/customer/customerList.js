var param_region=null;
	var param_industry=null;
	var param_user=null;
	var param_level=null;
	var param_Classification=null;
	var param_Channel=null;
	var param_cust =null;
$(document).ready(function() {
	console.info(param_level+"-----******-------");
	$("#closeS").on("click", function(){
		$(".modal-backdrop").hide();
		
	});

	$("#btn_default").on("click",function(){
	});
	
});
	function test12(data){
		var uname = $("#findKefu").val();
		alert(uname);
		$.ajax({
			url : '../stafopt/findUnderlingInfo',
			method : 'post',
			data : {
				name:uname
			},
			success : function(response) {
				var datas = JSON.parse(response);
				var str = "";
				for (var i = 0; i < datas.length; i++) {
					str += "<tr><td>"
							+ datas[i].name
							+ "</td><td>"
							+ datas[i].uname
							+ "</td><td><button type='submit'onclick='custCheckIn(&quot;"+data+"&quot;,&quot;"+datas[i].uid+"&quot;)'"+">选择</a></td></tr>";
				}
				$("tbody").html(str);
				$("#myModal").show();
			},
			error : function(success) {
				alert("系统出错,请联系系统管理员!");
			}
		});
	}

	function test11(data){
			$.ajax({
				url : '../stafopt/findUnderlingInfo',
				method : 'post',
				data : {
					name:""
				},
				success : function(response) {
					var datas = JSON.parse(response);
					var str = "<div class='input-group find_left'><input id='findKefu' type='text' class='form-control fs_16' style='font-weight: normal;' placeholder='客服查询' name='name'></div>"
							+ "<div class='find_right'><button type='submit' class='btn btn-default' id='btn_default' style='background-color: #0074c1;color: #fff;'"
							+ "onclick='test12(&quot;"+data+"&quot;)'>查询</button></div><table  id='mtable' class='table table-bordered'><thead><tr><th>姓名</th><th>用户名</th><th style='color: #333'>操作</th></tr></thead><tbody>";
					for (var i = 0; i < datas.length; i++) {
						str += "<tr><td>"
								+ datas[i].name
								+ "</td><td>"
								+ datas[i].uname
								+ "</td><td><button type='submit'onclick='custCheckIn(&quot;"+data+"&quot;,&quot;"+datas[i].uid+"&quot;)'"+">选择</a></td></tr>";
					}
					str += "</tbody></table>";
					$("#div1").html(str);
					$("#myModal").show();
				},
				error : function(success) {
					alert("系统出错,请联系系统管理员!");
				}
			});
	}


function custCheckIn(data,uid) {
	$.ajax({
		url:'../CustAgt/CustCheckIn',
		method:'post',
		data:{
			'id' : data,
			'uid': uid
		},
		success:function(data){
			if(JSON.parse(data) == "success"){
				document.getElementById('findCusts').submit();
			}else{
				alert("检入私海失败,请稍后重试!");
			}
		},
		error:function(success){
			alert("系统出错,请联系系统管理员!");
		}
	});
}


function custCheckOut(data) {
	$.ajax({
		url:'../CustAgt/CustCheckOut',
		method:'post',
		data:{
			'id' : data
		},
		success:function(data){
			if(JSON.parse(data) == "success"){
				document.getElementById('findCusts').submit();
			}else{
				alert("检出客户失败,请稍后重试!");
			}
		},
		error:function(success){
			alert("系统出错,请联系系统管理员!");
		}
	});
}



//注：样式有点丑，但是功能是实现的,按照的是每页显示10数据加一行表头
var mytable;
var my_new_table;
var my_href1;
var my_href2;
var temp1=0;
var temp2=0;
var flag1 = false;
var flag2 = false;
var flag3 = false;
var trows=0;
var pags = 0;
var count=0;
function test()
{
	 mytable = document.getElementById("mtable");
	trows =mytable.rows.length;  
	if (trows%10==0)
	{
		pags=trows/10;
	}
	else
	{
		pags = parseInt(trows/10)+1;
	}
	if(trows>10)
	{
		//隐藏mytable表格
		mytable.style.display="none";
		//则需要调用一个函数，将表格分页
		showTable();
		for (var i=0;i<pags ;i++ )
		{
			if (i==0)
				document.getElementById('mtable'+i).style.display="table";
			else
				document.getElementById('mtable'+i).style.display="none";
		}

		showLink();
	}
}

function showLink()
{
	
	/*my_div = document.createElement("div");
	//div属性
	my_div.id="div2";
	my_div.class="modal-footer";
	my_div.onclick="test2()";
	document.getElementById('modal_content').appendChild(my_div);*/
	//超链接1
	my_href1 = document.createElement("button");
	//超链接1属性
	my_href1.id="mf1";
	my_href1.href="#";
	my_href1.type="button";
	my_href1.className="btn btn-primary";
	my_href1.innerText="上一页";
	
	//超链接2
	my_href2 = document.createElement("button");
	//超链接2属性
	my_href2.id="mf2";
	my_href2.href="#";	
	my_href2.type="button";
	my_href2.className="btn btn-default";
	my_href2.innerText="下一页";	

	//添加到div2中去
	flag1 = document.getElementById('div2').appendChild(my_href1);
	flag2 = document.getElementById('div2').appendChild(my_href2);
	addEvent();
}

function addEvent()
{
	//点击 上一页
	if (flag1)
	{
		var et1 = document.getElementById("mf1");
		et1.onclick = function ()
		{
			if (temp2>0)
			{
				temp2-=1;
				for (var i=0;i<pags ;i++ )
				{
					if (i==temp2)
						document.getElementById('mtable'+i).style.display="table";
					else
						document.getElementById('mtable'+i).style.display="none";
				}
			}
		
		};
	}
	//点击 下一页
	if (flag2)
	{
		var et2 = document.getElementById("mf2");
		et2.onclick = function ()
		{
			//注意此处条件要为pags-1 不然会显示出来一个空的table表
			if (temp2<pags-1)
			{
				temp2+=1;
				for (var i=0;i<pags ;i++ )
				{
					if (i==temp2)
						document.getElementById('mtable'+i).style.display="table";
					else
						document.getElementById('mtable'+i).style.display="none";
				}
			}					
		};
	}		
}
//完成创建共有多少张表
function showTable()
{
	for (var count=0;count<pags ;count++ )
	{
		my_new_table = document.createElement("table");
		my_new_table.id = "mtable"+count;
		my_new_table.className="table table-bordered";
		
		if(temp1+10<trows)
		{
			//for中的11既是确定每页显示都少行
			for (var i=0;i<11 ;i++ )
			{
				var myRow = my_new_table.insertRow(i);

				for (var j=0;j<3 ;j++ )
				{
					if (i==0)
					{
						myRow.insertCell(j).innerText=mytable.rows[i].cells[j].innerText;
						continue;
					}
					myRow.insertCell(j).innerText=mytable.rows[i+temp1].cells[j].innerText;
				}
			}	
		}
		else
		{
			for (var i=0;i<trows-temp1 ;i++ )
			{
				var myRow = my_new_table.insertRow(i);

				for (var j=0;j<3 ;j++ )
				{
					if (i==0)
					{
						myRow.insertCell(j).innerText=mytable.rows[i].cells[j].innerText;
						continue;
					}
					myRow.insertCell(j).innerText=mytable.rows[i+temp1].cells[j].innerText;
				}
			}	
		}
		//表示创建一个my_new_table之后，将
//mytable.rows[i+temp1].cells[j].innerText	指向原来表格的下面10行数据头部		
		temp1+=10;
		document.getElementById('div1').appendChild(my_new_table);
	}
	
}
//其余的功能实现起来也就简单了。。。。。。。。。。。


function searchContent(){
	var search_region=$("#search_region").val();//所在地区
	var search_industry=$("#search_industry").val();//所在行业
	var search_user=$("#search_user").val();//所属客服
	var search_level=$("#search_level").val();//客户级别
	var search_Classification=$("#search_Classification").val();//客户状态
	var search_Channel=$("#search_Channel").val();//渠道来源
	var search_cust=$("#search_cust").val();//所有客户  我的客户
	$("#remocediv").remove();
	var str="<div class='row' id='remocediv'></div>";
	$("#apps").after(str);
	$.getJSON("../Cust/findCustomerInfoAjax",{
		sregion:search_region,
		sindustry:search_industry,
		suserID:search_user,
		slevel:search_level,
		sclassification:search_Classification,
		sChannel:search_Channel,
		tID:$("#search_cust").val()
	}, function(data) {
		for(var i=0;i<data[0].length;i++){
			var aUrl=null;
			var level=null;
			var strButton=null;
			var strCust=null;
			var actives=0;
			//url
			if(data[0][i].owner==data[1].GID){
				aUrl="../customer/customerInfo?custId="+data[0][i].ID;
			}else{
				aUrl="javascript:alert('不是本客户');";
			}
			//客户等级
			if(data[0][i].level==""||data[0][i].level==null)level="未知";
			if(data[0][i].level==1)level="A";
			if(data[0][i].level==2)level="B";
			if(data[0][i].level==3)level="C";
			console.info("data[0][i].uGID==="+data[0][i].uGID);
			console.info("data[1].GID=="+data[1].GID);
			console.info("data[0][i].owner==="+data[0][i].owner);
			//判断是否是客服或者其它
			if(data[0][i].uGID==data[1].GID&&data[0][i].uGID!=null){
				strCust="<li style=' right: 80px;float:left;'>联系人数：<span>"+data[0][i].conCount+"</span>人</li><li  style='position: absolute; right: 40px;'>行动记录数：<span>"+data[0][i].notesCount+"</span>人</li>";
			}else{
				strCust="<li style='right: 80px;float:left;' >客服姓名：<span>"+data[0][i].uName+"</span></li><li style='position: absolute; right: 40px;'>客服电话：<span>"+data[0][i].uMobile+"</span></li>";
			}
			if(data[0][i].uGID==data[1].GID&&data[0][i].uGID!=null){
				strButton="<button type='button' class='btn btn-primary btn-lg btn-block' onclick='custCheckOut("+data[0][i].ID+")' >捡出</button>";
				console.info("检出");
			}
			if(data[0][i].uGID!=data[1].GID&&data[0][i].uGID!=null){
				console.info("隐藏");
				strButton="<button type='button' style='visibility: hidden;' class='btn btn-primary btn-lg btn-block' >隐藏</button>";
			}
			if(data[0][i].owner==null||data[0][i].owner==""){
				console.info("全部");
				strButton="<button class='btn-lg btn-block btn_gh' type='button' onclick='custCheckIn("+data[0][i].ID+",'')' >捡入</button><button type='button' class='btn btn-primary btn-lg btn-block' data-toggle='modal' data-target='#myModal' onclick='test11("+data[0][i].ID+")'>分配</button>";
			}
			if(data[0][i].actives==null&&data[0][i].actives==""){
				actives=0;
			}
			 //<div class='smart-widget-header'>" +"<div class='comlogo'>Honeywell</div></div>
			 var str11=	"<input type='hidden' name='custGID' value="+data[0][i].GID+"> " +
			 		"<div class='col-lg-4'><div class='smart-widget widget-purple'>" +
			 		"<div class='smart-widget-inner'><div class='smart-widget-body'><div><div>" +
			 		"<span class='sea_header'><a href='"+aUrl+"'>"+data[0][i].name+"</a></span><br/><hr/> <span style='right: 80px;'>客户等级： <span class='fs_18'>"+level+"</span> <span style='position: absolute; right: 40px;'>客户活跃度： <span class='fs_18'>"+actives+"</span></div>"+
			 		"<div class='contdiv'>"+strCust+"</div></div></div><br>" +
			 		"<div class='smart-widget-footer'>"+strButton+"</div></div></div></div>";
			 $("#remocediv").append(str11);
		}
    });
 
	 
 
}
 
 
		
		
		
		
		
		







