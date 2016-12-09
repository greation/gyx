<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<!-- 图片上传 -->

		<link rel="stylesheet" href="./../static/css/contact/addContacts.css" />
		<!-- <link rel="stylesheet" href="../static/css/contact/contactsDetail.css" /> -->
		<link rel="stylesheet" href="../static/css/customerActive/addCallActivities.css" />
		
		<!-- <link rel="stylesheet" href="css/callActivitiesDetail.css" /> -->
		<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../static/css/ionicons.min.css" />
		<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
		<link href="../static/css/agency.css" rel="stylesheet">

		<body id="page-top" class="index">

			 <%@ include file="/top.jsp"%>

			<!-- Header -->
			<header>
				<div class="container bg_S">
					<div class="row">
						<div class="col-md-12">
							<div class="crm_panel">
								<span style="margin-right: 10px;">
									<img src="../static/img/index/07.png"/>
								</span>
								<span class="addC">添加拜访、通话及活动</span>
							</div>
						</div>
					</div>

					<div class="row">
					<div class="bg_P">
						<img alt="" src="./../static/img/index/009.png">
					</div>
						<div class="col-lg-12">
							<!-- ../row -->
							<div class="smart-widget">
								<div class="smart-widget-header">
									<span>拜访记录</span>
									<span class="smart-widget-option">			
										<a data-toggle="collapse" class="widget-collapse-option" href="#">
											<i class="fa fa-chevron-up"></i>
										</a>
									</span>
								</div>
								<div class="smart-widget-inner table-responsive">
									<form class="form-horizontal m-top-md">
										<div class="form-group">
											<label class="col-sm-2 control-label">客户名称</label>
											<div class="col-sm-3">
											${actionRecordDoman.cusName}
											</div>
											
											<label class="col-sm-2 control-label">联系人</label>
											<div class="col-sm-3">
												${actionRecordDoman.recepter}
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">联系电话</label>
											<div class="col-sm-3">
												${actionRecordDoman.rcptPhone}
											</div>
											
											<label class="col-sm-2 control-label">拜访方式</label>
											<div class="col-sm-3">
												 <c:if  test="${actionRecordDoman.method== 0}">当面拜访</c:if>
												 <c:if  test="${actionRecordDoman.method== 1}">电话拜访</c:if>
												 <c:if  test="${actionRecordDoman.method== 2}">市场活动</c:if>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">开始时间</label>
											<div class="col-sm-3">
					                        <fmt:formatDate value="${actionRecordDoman.beginTime}" pattern="yyyy-MM-dd"/>
											</div>
											
											<label class="col-sm-2 control-label">结束时间</label>
											<div class="col-sm-3">
											<fmt:formatDate value="${actionRecordDoman.endTime}" pattern="yyyy-MM-dd"/>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">职位</label>
											<div class="col-sm-3">
												${actionRecordDoman.rcptTitle}
											</div>
											
											<label class="col-sm-2 control-label">创建时间</label>
											<div class="col-sm-3">
												<fmt:formatDate value="${actionRecordDoman.createTime}" pattern="yyyy-MM-dd"/>
											</div>
										</div>
										<div class="form-group">
											
											<label class="col-sm-2 control-label">创建人</label>
											<div class="col-sm-3">
												 ${actionRecordDoman.csName} 
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">地址信息</label>
											<div class="col-sm-9">${actionRecordDoman.address}</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">描述</label>
											<div class="col-sm-9">${actionRecordDoman.desription}</div>
										</div>
										
									</form>

								</div>
								<!-- ../smart-widget-inner -->
							</div>
                           
                           <div class="smart-widget">
								<div class="smart-widget-header">
									<span class="info">资料</span>
									<!--  -------------------------------------------------------------------->
									<form  action="../actionRecord/saveImages?Id=${actionRecordDoman.id}" id="uploadForm" enctype="multipart/form-data" method="post">
										<input name="fileToUpload" id="fileToUpload"  multiple="multiple" type="file" />
										<input type="hidden" name="Id" id="acId" value="${actionRecordDoman.id}" />
									    <input type="button" onclick="uploadFile()" value="文件上传" />
									</form>
									
									<form class="allDel" action="../actionRecord/deleAttachmentByAcgidc"  method="post">
										<input type="hidden" name="custId" id="custID" value="${actionRecordDoman.id}" />
									    <input type="button" id="delImgAll" value="全部删除" />
									</form> 
									<span class="smart-widget-option">
										<a data-toggle="collapse" class="widget-collapse-option" href="#">
											<i class="fa fa-chevron-up"></i>
										</a>
									</span>
								</div>
								<!--  -->							
							<!--  图片上传-------------------------------------- -->
								
							   <!--  -------------------------------------- -->
								<!-- ../smart-widget-inner -->
						   <div id="delIMG" class="smart-widget-inner table-responsive" style="display: block;">
								<c:forEach items="${actionRecordDoman.attachmentDto}" var="attachmentDto">
									<div class="imgDel">
									<a href="${attachmentDto.url}" target="_blank">
									<img src="${attachmentDto.url}"/></a>
									<form action="../actionRecord/deleteAttachment">
										<input type="hidden" value="${attachmentDto.ID}" />
										<input type="button" value="删除" onclick="delImage(${attachmentDto.ID})" />
							    	</form>
							    	</div>
								</c:forEach>
						  </div>
					    </div>
			
								<div class="smart-widget-footer">
										<button type="button" class="btn-lg btn-block btn_gh" onclick="editFun()">编辑</button>
										<button class="btn btn-cancel btn-lg btn-block" type="button" onclick="rebackFun()">返回</button>
									</div>
									
									<div class="smart-widget-footer foot-box">
										<div class="center-footer">
											
										</div>
										
									</div>
								
									
										
										<!-- ./smart-widget-inner -->
									</div>
									
							<!-- ../smart-widget -->
						</div>
						<!-- ../col -->
						
						<!-- ../col -->
					</div>

				</div>
				
			</header>
						

	        <%@ include file="/bottom.jsp"%>
			<!-- jQuery -->
			<script src="../static/js/jquery-1.11.1.min.js"></script>

			<!-- Bootstrap Core JavaScript -->
			<script src="../static/bootstrap/js/bootstrap.min.js"></script>

			<!-- Slimscroll -->
			<script src='../static/js/jquery.slimscroll.min.js'></script>

			<!-- Simplify -->
			<script src="../static/js/simplify/simplify.js"></script>
			
		    <!--图片上传  -->

		    <!--图片上传  -->
			<script type="text/javascript" src="../static/js/bootstrap-select.min.js"></script>

		</body>
		<script language="JavaScript">
				function editFun() {
					window.location.href="queryActionRecodDetailById?id=${actionRecordDoman.id}";
				}
				function rebackFun() {
					window.history.go(-1);
				}
         </script>
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
		     fd.append('acId',"${actionRecordDoman.id}");
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
						url:'../actionRecord/queryCustInfo',
						 data:{'Id' : $("#acId").val()
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
			console.log(id);
			 $.ajax({
					method : 'post',
					url : '../actionRecord/deleteAttachment',
					data:{'attId' : id
						},
					success : function(data) {
						if (JSON.parse(data) == "1") {
							alert("删除成功");
							$.ajax({
								url:'../actionRecord/queryCustInfo',
								 data:{'Id' : $("#custID").val()
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
		}
		
		$("#delImgAll").on("click", function(){
			$.ajax({
				method : 'post',
				url : '../actionRecord/deleAttachmentByAcgid',
				data : {
					'custId' : $("#custID").val()
				},
				success : function(data) {
					if (JSON.parse(data) == "delImgAll_OK") {
						alert("全部删除成功");
						$.ajax({
							url:'../actionRecord/queryCustInfo',
							 data:{'Id' : $("#custID").val()
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