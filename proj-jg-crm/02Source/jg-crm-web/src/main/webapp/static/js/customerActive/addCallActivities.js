$(document).ready(function() {
	$("#closeS").click(function() {
		$("#myModal").hide();
	});
});

function ctacts(data) {
	$("#myModal").hide();
	var recepter = $(data).text();
	var rcptPhone = $(data).next().text();
	var position = $(data).next().next().text();
	$("#recepter").val(recepter);
	$("#rcptPhone").val(rcptPhone);
	$("#position").val(position);
}



function fileFunction(){
	var inputSize = $(".fileStyle-box").size();
	var i = inputSize;
	for (;i <= inputSize; i++)
	{
		var fileStr = "<input class='fileStyle-box' type='file' name="
		+'uploadFile'
		+ i 
		+" />";
	}
	$(".fileStyle").append(fileStr);
}
function isCustomer(){
	var cusName=$("#cusName").val();
	var jsonStr = {
			cusName :cusName
		};
		
		$.ajax({
			type : "post",
			url : "isCustomer",
			data : jsonStr,
			dataType : "json",
			async : false,
			success : function(data) {
				if(data!=null&&data!=''){
					alert(data);
				}
			}
})
}

function queryPhoneNoByCusNameandTname(){
	var cusName=$("#cusName").val();
	var tName=$("#recepter").val();
	var jsonStr = {
			cusName :cusName,
			tName :tName
		};
		
		$.ajax({
			type : "post",
			url : "queryPhoneNoByCusNameandTname",
			data : jsonStr,
			dataType : "json",
			async : false,
			success : function(data) {
				 alert(data);
			}
	
})
}

function queryContact(){
	var cusName=$("#CusName").val();
	var jsonStr = {
			cusName :cusName,
			tName :tName
		};
		
		$.ajax({
			type : "post",
			url : "queryPhoneNoByCusNameandTname",
			data : jsonStr,
			dataType : "json",
			async : false,
			success : function(data) {
				 alert(data);
			}
	
})
}

/*function test12(data){
	var uname = $("#findKefu").val();
	alert(uname);
	$.ajax({
		url : "queryContactsListByOwer",
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
}*/

function findContacts(){
	
	var jsonStr = {
			id:$("#CusName").val()
		};
	
	$.ajax({
		url : "queryContactsListByOwer",
		type : "post",
		data :jsonStr,
		dataType : "html",
		success : function(response) {
			
			var datas = JSON.parse(response);
			
			var str = "<thead>" +
					"<tr>" +
					"<th>联系人</th>" +
					"<th>联系电话</th>" +
					"<th>职位</th>" +
					"</tr>" +
					"</thead>" +
					"<tbody>";
			for (var i = 0; i < datas.length; i++) {
				
				str += "<tr>" +
						"<td class='ctacts' onclick='ctacts(this)'>" +
						datas[i].recepter +
						"</td>" +
						"<td class='ctactsPhone'>" +
						datas[i].rcptPhone +
						"</td>" +
						"<td class='ctactsPhone'>" +
						datas[i].position +
						"</td>" +
						"</tr>";
			}
			
			str += "</tbody>";
			
			$("#mtable").html(str);
			$("#myModal").show();
			
		},
		
		error : function(success) {
			alert("请选择客户!");
		}
		
	});
	
	
	/*var jsonStr = {
			id:"9029413cd7134bfc91bc2a6e16e96df2"
			id:$("#CusName").val()
		};
	
		$.ajax({
			url : "queryContactsListByOwer",
			type : "post",
			data :jsonStr,
			dataType : "json",
			success : function(response) {
				var datas = JSON.parse(response);
				var str = "<div class='input-group find_left'><input id='findKefu' type='text' class='form-control fs_16' style='font-weight: normal;' placeholder='客服查询' name='name'></div>"
						+ "<div class='find_right'><button type='submit' class='btn btn-default' id='btn_default' style='background-color: #0074c1;color: #fff;'"
						+ "onclick='test12()'>查询</button></div><table  id='mtable' class='table table-bordered'><thead><tr><th>姓名</th><th>用户名</th><th style='color: #333'>操作</th></tr></thead><tbody>";
				for (var i = 0; i < datas.length; i++) {
					str += "<tr><td>"
							+ datas[i].name
							+ "</td><td>"
							+ datas[i].uname
							+ "</td><td><button type='submit'onclick='custCheckIn(&quot;"+datas[i].uid+"&quot;)'"+">选择</a></td></tr>";
				}
				str += "</tbody></table>";
				$("#div1").html(str);
				$("#myModal").show();
			},
			error : function(success) {
				alert("请选择客户!");
			}
		});*/
}


function rebackFun() {
	window.history.go(-1);
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
function tableContacts()
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







