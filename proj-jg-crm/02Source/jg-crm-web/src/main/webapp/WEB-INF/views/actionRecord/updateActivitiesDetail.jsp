<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<link rel="stylesheet" href="./../static/css/contact/addContacts.css" />
		<link rel="stylesheet" href="../static/css/customerActive/addCallActivities.css" />
		<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../static/css/ionicons.min.css" />
		<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
		<link href="../static/css/agency.css" rel="stylesheet">
		<link href="../static/css/jeDate/jedate.css" rel="stylesheet">
		<link href="../static/css/jeDate/jeui.css" rel="stylesheet">
		<link href="../static/css/jeDate/prism.css" rel="stylesheet">
		<link href="../static/css/jeDate/gray.css" rel="stylesheet">
		<link href="../static/css/jeDate/green.css" rel="stylesheet">
		
		<body id="page-top" class="index" onload="tableContacts()">

			<!-- Navigation -->
		  <%@ include file="/top.jsp"%>
			<!-- Header -->
			<header>
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="crm_panel">
								<span style="margin-right: 10px;">
									<img src="../static/img/index/07.png"/>
								</span>
								<span class="addC">
									<c:if  test="${pageType != 'UPDATE'}">新增行动记录</c:if>
									<c:if  test="${pageType == 'UPDATE'}">修改行动记录</c:if>
								</span>
							</div>
						</div>
					</div>

					<div class="row">
						<form class="form-horizontal m-top-md" action="<c:if  test="${pageType!= 'UPDATE'}">saveActionRecords</c:if><c:if  test="${pageType =='UPDATE'}">updateActionRecords</c:if>" method="post" enctype="multipart/form-data">
							<div class="col-lg-12">
								<!-- ./row -->
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
										<div class="form-horizontal m-top-md" style="float: left; width: 50%;">
											<div class="form-group">
										 
											<label class="col-sm-3 control-label">客户名称</label>
											<div class="col-sm-4">
												<select id="CusName" class="selectpicker"
													data-hide-disabled="true" name="actionrecord.cusId"
													data-live-search="true">
													<optgroup>
														<option value="0">客户名称</option>
														<c:forEach items="${CustomerPojoList}" var="customerPojo" >
														<option value="${customerPojo.id }" <c:if  test="${customerPojo.id == actionRecordDoman.cusId}"> selected="selected"</c:if>
														 >${customerPojo.name}</option>
														</c:forEach>
													</optgroup>
												</select>
											</div>
										  
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">联系电话</label>
												<div class="col-sm-9">
													<input id="rcptPhone" type="text" class="form-control" name="actionrecord.rcptPhone" value="${actionRecordDoman.rcptPhone}">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">开始时间</label>
												<div class="col-sm-9">
													<input type="text" class="workinput wicon mr25" id="inpstart" name="actionrecord.beginTime" value="<fmt:formatDate value="${actionRecordDoman.beginTime}" pattern="yyyy-MM-dd"/>" readonly>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">职位</label>
												<div class="col-sm-9">
													<input id="position" type="text" class="form-control" name="actionrecord.rcptTitle" value="${actionRecordDoman.rcptTitle}" >
												</div>
											</div>
										</div>
										
										<div class="form-horizontal m-top-md" style="float: right; width: 50%;">
											<div class="form-group">
												<label class="col-sm-3 control-label">联系人</label>
												<div class="col-sm-6">
													<input type="text" class="form-control" id="recepter"  name="actionrecord.recepter" value="${actionRecordDoman.recepter}">
												</div>
												<div class="col-sm-3">
													<input type="button" class="form-control" id="recepter"  value="查询" onclick="findContacts()">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">方式</label>
												<div class="col-sm-9">
													<select id="first-disabled" class="selectpicker" data-hide-disabled="true" data-live-search="true" name="actionrecord.method">
                                                    <optgroup>
												            <option value="0"  <c:if  test="${actionRecordDoman.method== 0}">selected="selected"</c:if>>当面拜访</option>
															<option value="1"  <c:if  test="${actionRecordDoman.method== 1}">selected="selected"</c:if>>电话拜访</option>
															<option value="2"  <c:if  test="${actionRecordDoman.method== 2}">selected="selected"</c:if>>市场活动</option>
													</optgroup>
												</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">结束时间</label>
												<div class="col-sm-9">
													<input type="text" class="workinput wicon mr25" id="inpend" name="actionrecord.endTime" value="<fmt:formatDate value="${actionRecordDoman.endTime}" pattern="yyyy-MM-dd"/>" readonly>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">地址</label>
												<div class="col-sm-9">
													<input type="text"  class="form-control" name="actionrecord.address" value="${actionRecordDoman.address}" >
												</div>
											</div>
										
											
			
											<div class="form-group">
												<label class="col-sm-3 control-label">&nbsp;</label>
												<div class="col-sm-9">
													
												</div>
											</div>
										</div>
										
									</div>
									<!-- ./smart-widget-inner -->
								</div>
								<input type="hidden" class="form-control" id="id"  <c:if  test="${pageType!= 'UPDATE'}"></c:if><c:if  test="${pageType =='UPDATE'}">name="actionrecord.id"</c:if> value="${actionRecordDoman.id}">
								<div class="smart-widget">
									<div class="smart-widget-header">
										拜访描述
										<span class="smart-widget-option">						
										<a data-toggle="collapse" class="widget-collapse-option" href="#">
											<i class="fa fa-chevron-up"></i>
										</a>
										</span>
									</div>
									<div class="smart-widget-inner table-responsive" style="display: block;">
										<div class="form-horizontal m-top-md">
											<div class="form-group">
												<label class="control-label" style="float: left;">描述</label>
												<div class="col-lg-11">
													<textarea rows="3" class="form-control" name="actionrecord.desription">${actionRecordDoman.desription}</textarea>
												</div><!-- /.col -->
											</div>
										</div>
									</div>
									<!-- ./smart-widget-inner -->
								</div>							
								<div class="smart-widget-footer">
									<button type="submit" class="btn-lg btn-block btn_gh">保存</button>
									<button class="btn btn-cancel btn-lg btn-block" type="button" onclick="rebackFun()">取消</button>
								</div>
								<!-- ./smart-widget -->
							</div>
							<!-- ./col -->
						</form>
					</div>
				</div>	
			</header>
			<%@ include file="/bottom.jsp"%>
			<!-- jQuery -->
		 

			<!-- Slimscroll -->
			<script src='../static/js/jquery.slimscroll.min.js'></script>

			<!-- Simplify -->
			<script src="../static/js/simplify/simplify.js"></script>

			<script type="text/javascript" src="../static/js/bootstrap-select.min.js"></script>
			
			<script type="text/javascript" src="../static/js/jeDate/jedate.js"></script>
			
			<script type="text/javascript" src="../static/js/jeDate/prism.js"></script>
			
			<script type="text/javascript" src="../static/js/jeDate/dateReady.js"></script>
			
			<script type="text/javascript" src="../static/js/customerActive/addCallActivities.js"></script>
		
			
			<script type="text/javascript">
			function formSub(){
				
				if($("#CusName").val()==0){
					alert("公司名称为空");
					return ;
				}
				if($("#recepter").val()==0){
					alert("联系人为空");
					return ;
				}
				
				$("#actForm").submit();
			}
			</script>
			
			
			<!--  -->
	 
			
			
			
			
			
			    
<!-- 模态框（Modal） -->
<div class="modal fade in" id="myModal" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="false">
   <div class="modal-dialog">
      <div id="modal_content" class="modal-content">
         <div class="modal-header">
            <button id="closeS" type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" style="font-family: Microsoft Yahei;" id="myModalLabel">
               	请为该客户选择指派客服
            </h4>
         </div>
         <div id= "div1" class="modal-body">            
			<table  id='mtable' class='table table-bordered'>
			
			</table>
         </div>
         <div id="div2" class="modal-footer">
         
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>

			

		</body>

</html>