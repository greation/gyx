
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>鲸工</title>

<!-- Bootstrap Core CSS -->
<link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link rel="stylesheet" href="../static/css/contact/addContacts.css" />
<link rel="stylesheet" href="../static/css/customer/customerDetail.css" />
<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
<link rel="stylesheet" href="../static/css/ionicons.min.css" />
<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="../static/css/agency.css">


<body id="page-top" class="index">

	<!-- Navigation -->
	<%@ include file="/top.jsp"%>

	<!-- Header -->
	<header>
		<div class="container bg_S">

			<div class="row">
				<div class="bg_P">
					<img alt="" src="./../static/img/index/009.png">
				</div>
				<div class="col-md-12">
					<div class="crm_panel">
						<span style="margin-right: 10px;"> <img
							src="../static/img/index/07.png" />
						</span> <span class="addC">客户详细资料</span>

					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<!-- ./row -->

					<div class="smart-widget">
						<div class="smart-widget-header">
							<span>客户信息</span> <span class="smart-widget-option"> <a
								data-toggle="collapse" class="widget-collapse-option" href="#">
									<i class="fa fa-chevron-up"></i>
							</a>
							</span>
						</div>
						<div class="smart-widget-inner table-responsive">
							<form class="form-horizontal m-top-md">
								<div class="form-group">
									<label class="col-sm-2 control-label">客户名称</label>
									<div class="col-sm-3">${custBean.name}</div>
									
									<label class="col-sm-2 control-label">所在地区</label>
									<div class="col-sm-3">
										<c:forEach items="${regionList}" var="clist">
											<c:if test="${clist.code== custBean.region}">
												${clist.caption}
												</c:if>
										</c:forEach>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">联系人</label>
									<div class="col-sm-3">${custBean.conname}</div>
									
									<label class="col-sm-2 control-label">联系电话</label>
									<div class="col-sm-3">${custBean.telphone}</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">其他联系方式</label>
									<div class="col-sm-3">${custBean.faxes}</div>
									
									
									<label class="col-sm-2 control-label">客户状态</label>
									<div class="col-sm-3">
										<c:choose>
											<c:when test="${custBean.classification=='1'}">已成交
										 	 </c:when>
											<c:when test="${custBean.classification=='2'}">未成交
										 	 </c:when>
										</c:choose>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">客户级别</label>
									<div class="col-sm-3">
										<c:choose>
											<c:when test="${custBean.level=='1'}">A类
										 	 </c:when>
											<c:when test="${custBean.level=='2'}">B类
										 	 </c:when>
											<c:when test="${custBean.level=='3'}">C类
										 	 </c:when>
										</c:choose>
									</div>
									
									<label class="col-sm-2 control-label">客户类型</label>
									<div class="col-sm-3">
									<c:choose>
											<c:when test="${custBean.custType=='0'}">采购商
										 	 </c:when>
											<c:when test="${custBean.custType=='1'}">供应商
										 	 </c:when>
									</c:choose>
									</div>
								</div>
									
								
								<div class="form-group">
									<label class="col-sm-2 control-label">所在行业</label>
									<div class="col-sm-3">
										<c:forEach items="${industryList}" var="inlist">
											<c:if test="${inlist.code== custBean.industry}">
												${inlist.caption}
											</c:if>
										</c:forEach>
									</div>
									
									
									<label class="col-sm-2 control-label">渠道来源</label>
									<div class="col-sm-3">
										<c:forEach items="${channelList}" var="chlist">
											<c:if test="${chlist.code== custBean.channel}">
												${chlist.caption}
												</c:if>
										</c:forEach>
									</div>
									
								</div>
								
								<div class="form-group">
									
									
									<label class="col-sm-2 control-label">创建者</label>
									<div class="col-sm-3">${user.name}</div>
									
									
									<label class="col-sm-2 control-label">创建时间</label>
									<div class="col-sm-3">
										<fmt:formatDate value="${custBean.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
									</div>
								</div>
								
								
								<div class="form-group">
									<label class="col-sm-2 control-label">地址信息</label>
									<c:forEach items="${addList}" var="address" varStatus="vs">
										<div class="col-sm-9">${address.address}</div>
									</c:forEach>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">描述</label>
									<div class="col-sm-9">${custBean.description}</div>
								</div>
								
							</form>
							
						</div>
						
					</div>
					
					<!-- -------------------------------------------------------------------------------------------------- -->
					<div class="smart-widget">
						<div class="smart-widget-header">
							<span style="font-size: 16px; color: #0074C1; font-weight: bold;">联系人信息</span>
							<span class="addcus4"> <a
								href="../contact/searchContsByID?ID=${custBean.custId}&group=1"
								type="button" class="btn btn-default"> <span class="addS">+</span>
									<span class="">添加联系人</span>
							</a>
							</span> <span class="smart-widget-option"> <a
								data-toggle="collapse" class="widget-collapse-option" href="#">
									<i class="fa fa-chevron-up"></i>
							</a>
							</span>
						</div>

						<div class="smart-widget-inner table-responsive"
							style="display: block;">
							<div class="describe w100">
								<div class="col-lg-9 describe-box describe-T">
									<ul>
										<c:forEach items="${contList}" var="cont" varStatus="vs">
											<li><span>${cont.name}&nbsp;</span><span>${cont.gender}&nbsp;</span><span>${cont.telphone}&nbsp;</span><span>${cont.position}&nbsp;</span>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						
					</div>


					<!-- -------------------------------------------------------------------------------------------------- -->
					<div class="smart-widget">
						<div class="smart-widget-header">
							<span style="font-size: 16px; color: #0074C1; font-weight: bold;">活动记录</span>
							<span class="addcus4"> <a
								href="../actionRecord/jumpAddActionJspByCusDetailId?id=${custBean.custId}"
								type="button" class="btn btn-default"> <span class="addS">+</span>
									<span class="">添加活动记录</span>
							</a>
							</span> <span class="smart-widget-option"> <a
								data-toggle="collapse" class="widget-collapse-option" href="#">
									<i class="fa fa-chevron-up"></i>
							</a>
							</span>
						</div>



						<div class="smart-widget-inner table-responsive"
							style="display: block;">
							<div class="describe w100">
								<div class="col-lg-9 describe-box describe-T">
									<ul>
										<%-- <c:forEach items="${contList}" var="cont" varStatus="vs">
											<li>联系人姓名：<span>${cont.name}&nbsp;&nbsp;&nbsp;&nbsp;</span><span>联系人姓名：${cont.gender}&nbsp;&nbsp;&nbsp;&nbsp;</span><span>联系人电话：${cont.telphone}&nbsp;&nbsp;&nbsp;&nbsp;</span><span>职务${cont.position}&nbsp;&nbsp;&nbsp;</span>
											</li>
										</c:forEach> --%>
									</ul>
								</div>
							</div>
						</div>
						<!-- ./smart-widget-inner -->
					</div>

					<!-- -------------------------------------------------------------------------------------------------- -->
					<!--<div class="smart-widget">
						<div class="smart-widget-header">
							<span style="font-size: 16px; color: #0074C1; font-weight: bold;">描述</span>
							<span class="smart-widget-option"> <a
								data-toggle="collapse" class="widget-collapse-option" href="#">
									<i class="fa fa-chevron-up"></i>
							</a>
							</span>
						</div>
						<div class="smart-widget-inner table-responsive"
							style="display: block;">
							<div class="describe w100">
								<div class="col-lg-9 describe-box describe-T">
									${custBean.description}</div>
							</div>
						</div>
						<!-- ./smart-widget-inner 
					</div> -->
					<div class="smart-widget">
						<div class="smart-widget-header">
							<span class="custInfo">客户资料</span>

							<!--  -------------------------------------------------------------------->

							<form action="../customer/insertCustInfo" id="uploadForm" enctype="multipart/form-data" method="post">
								 <input name="fileToUpload" id="fileToUpload"  multiple="multiple" type="file" />
								<input type="hidden" name="custId" id="custId" value="${custBean.custId}" />
									 <input type="button" onclick="uploadFile()" value="文件上传" />
							</form>
							
							<form class="allDel" action="../customer/delImgAll"  method="post">
								<input type="hidden" name="custId" id="custID" value="${custBean.custId}" />
									 <input type="button" id="delImgAll" value="全部删除" />
							</form> 

							<!--  -------------------------------------------------------------------->

							<span class="smart-widget-option"> <a
								data-toggle="collapse" class="widget-collapse-option" href="#">
									<i class="fa fa-chevron-up"></i>
							</a>
							</span>
						</div>
						
						<div id="delIMG" class="smart-widget-inner table-responsive" style="display: block;">
							<c:forEach items="${actionRecordDoman}" var="attachmentDto">
								<div class="imgDel">
								<a href="${attachmentDto.url}" target="_blank">
									<img src="${attachmentDto.url}"/>
									</a>
									<form class="deleSingle"  action="../customer/deleteCustInfo">
										<input type="hidden" value="${attachmentDto.ID}"> 
										<input type="button" value="删除" onclick="delImage(${attachmentDto.ID})" />
									</form>
								</div>
							</c:forEach>
						</div>
					</div>


					<div class="smart-widget">
						<div class="smart-widget-header">
							<span style="font-size: 16px; color: #0074C1; font-weight: bold;">历史纪录</span>
							<span class="smart-widget-option"> <a
								data-toggle="collapse" class="widget-collapse-option" href="#">
									<i class="fa fa-chevron-up"></i>
							</a>

							</span>
						</div>
						<div class="smart-widget-inner table-responsive"
							style="display: none;">
							<div class="describe w100">
								<div class="col-lg-9 describe-box describe-T">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>操作</th>
												<th>内容</th>
												<th>操作人</th>
												<th>操作时间</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${tracesList}" var="traces">
												<tr>
													<td><c:if test="${traces.action==0}">新增</c:if> <c:if
															test="${traces.action==1}">更改</c:if></td>

													<td style="text-align: left">${traces.text}</td>
													<td>${traces.creator}</td>
													<td><fmt:formatDate value="${traces.updateTime}"
															pattern="yyyy-MM-dd HH:mm:ss" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- ./smart-widget-inner -->
					</div>
					<div class="smart-widget-footer">
						<c:if test="${custBean.owner == ''}">
							<button type="button" class="btn-lg btn-block btn_gh"
								onclick="custCheckIn('${custBean.custId}','')">捡入</button>
						</c:if>
						<c:if test="${custBean.owner != ''}">
							<button type="button" class="btn-lg btn-block btn_gh"
								onclick="custCheckOut('${custBean.custId}'),''">捡出</button>
						</c:if>
						<a href="junmUpdatePage?custId=${custBean.custId}" type="button"
							class="btn btn-primary btn-lg btn-block">编辑</a>
						<button class="btn btn-cancel btn-lg btn-block"
							onclick="javascript:history.go(-1)" type="button">返回</button>
					</div>
					<!-- ./smart-widget -->
				</div>
			</div>
		</div>

		<!-- --------------------------------------------------------------------------------------------------- -->
	</header>
	<!-- 引入底部页面 -->
	<%@ include file="/bottom.jsp"%>
	<!-- Slimscroll -->
	<script src='../static/js/jquery.slimscroll.min.js'></script>
	<!-- Simplify -->
	<script src="../static/js/simplify/simplify.js"></script>
	<script src="../static/js/jquery.form.js"></script>
	<script type="text/javascript" src="../static/js/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="../static/js/customer/customerDetail.js"></script>

	<script type="text/javascript">
		var xmlHttp;
		function uploadFile() {
			 var folder= $("#fileToUpload").val();
		        if($.trim(folder)==""){
		            alert("请选择文件");
		            return false;
		        }
		        
		    if (window.File && window.FileList) {
		     var fd = new FormData();
		     var files = document.getElementById('fileToUpload').files;
		     for (var i = 0; i < files.length; i++) {  
		       fd.append("file"+i, files[i]);
		     }
		     fd.append('custId',"${custBean.custId}");
		     xmlHttp = new XMLHttpRequest();
		   	  
		     xmlHttp.onreadystatechange = zswFun;
		     xmlHttp.open("POST", document.getElementById('uploadForm').action,true);
		     xmlHttp.send(fd);	
		   } else {
			   alert("不支持HTML5");
		   }
		}
		function zswFun(){   
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){   
			   var b = xmlHttp.responseText;  
		        if(b == '"upload_ok"'){  
					alert("上传成功！"); 
					$("#fileToUpload").prop("value",""); 
					$.ajax({
						url:'../customer/queryCustInfo',
						 data:{'custId' : $("#custId").val()
							},
						success:function(response){
						var datas = JSON.parse(response);
						var str ="";
						for (var i = 0; i < datas.length; i++) {
							str+="<div class='imgDel'>"
								+"<a href='"
								+datas[i].url
								+"'target='_blank'>"
								+"<img src='"
								+datas[i].url
								+"'/></a>"
								+"<form class='deleSingle' action='../customer/deleteCustInfo'>"
								+"<input type='hidden' value="
								+datas[i].id
								+">"
								+"<input type='button' value='删除' onclick='delImage("
								+datas[i].id
								+")'/></form>"
								+"</div>";
							}
							$("#delIMG").html(str);
						}
						});
		        }else{    
		            alert("上传失败！");    
		        }   
		    }     
		} 
		
		
		function delImage(id){
			 $.ajax({
					method : 'post',
					url : '../customer/deleteCustInfo',
					data:{'attId' : id
						},
					success : function(data) {
						if (JSON.parse(data) == "1") {
							alert("删除成功");
							$.ajax({
								url:'../customer/queryCustInfo',
								 data:{'custId' : $("#custID").val()
									},
								success:function(response){
								var datas = JSON.parse(response);
								var str ="";
								for (var i = 0; i < datas.length; i++) {
									str+="<div class='imgDel'>"
										+"<a href='"
										+datas[i].url
										+"'target='_blank'>"
										+"<img src='"
										+datas[i].url
										+"' width='100' height='100'/></a>"
										+"<form class='deleSingle' action='../customer/deleteCustInfo'>"
										+"<input type='hidden' value="
										+datas[i].id
										+">"
										+"<input type='button' value='删除' onclick='delImage("
										+datas[i].id
										+")'/></form>"
										+"</div>";
									}
									$("#delIMG").html(str);
								}
							});
						} else {
							alert("删除失败");
						}
					}
				});
		}
		
		$("#delImgAll").on("click", function(){
			$.ajax({
				method : 'post',
				url : '../customer/delImgAll',
				data : {
					'custId' : $("#custID").val()
				},
				success : function(data) {
					if (JSON.parse(data) == "delImgAll_OK") {
						alert("全部删除成功");
						$.ajax({
							url:'../customer/queryCustInfo',
							 data:{'custId' : $("#custID").val()
								},
							success:function(response){
							var datas = JSON.parse(response);
							var str ="";
							for (var i = 0; i < datas.length; i++) {
								str+="<div class='imgDel'>"
									+"<a href='"
									+datas[i].url
									+"'target='_blank'>"
									+"<img src='"
									+datas[i].url
									+"'/></a>"
									+"<form class='deleSingle' action='../customer/deleteCustInfo'>"
									+"<input type='hidden' value="
									+datas[i].id
									+">"
									+"<input type='button' value='删除' onclick='delImage("
									+datas[i].id
									+")'/></form>"
									+"</div>";
								}
								$("#delIMG").html(str);
							}
						});
					} else {
						alert("删除失败");
					}
				}
			});
		});

	</script>
</html>
