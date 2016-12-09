<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>鲸工</title>
	<!-- Bootstrap Core CSS -->
	<!-- <link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
	
	
	<link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="../static/css/agency.css" rel="stylesheet">
	<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
	<link rel="stylesheet" href="../static/css/ionicons.min.css" />
	<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
	<link rel="stylesheet" href="../static/css/customer/customerList.css" />
</head>
<body id="page-top" class="index" onload="test()">
	
		<%@ include file="/top.jsp"%>

	<!-- Header -->
	<header>

	<div class="container">
		<div class="row" id="apps">
			<form method="post" action="../Cust/findCustomerInfo" id="findCusts">
				<div class="col-md-12">
					<div class="crm_panel">
						<div class="input-group">
							<input type="text" class="form-control fs_16" style="font-weight: normal;" placeholder="公司名称搜索" name="name">
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
                        <a href="../customer/jumpAddcustomer">
							<span class="addcus">
								<button type="button" class="btn btn-default addcus2">
									<span style="color: #0074C1;font-size: 25px; line-height: 20px">+</span>
									<span style="font-size: 16px;">添加客户</span>
								</button>
							</span>
						</a>
					</div>
					<div class="crm_panel">
						<select  class="selectpicker" onchange="searchContent()" name="sregion" id="search_region" data-hide-disabled="true" data-live-search="true">
							<optgroup>
								<option value="">所在地区</option>
								<c:forEach items="${regionList}" var="clist">
									<option value="${clist.code }"  <c:if  test="${clist.code == search.sregion}"> selected="selected"</c:if>>${clist.caption}</option>
								</c:forEach>
							</optgroup>
						</select>
						<select  class="selectpicker" id="search_industry" name="sindustry" onchange="searchContent()" data-hide-disabled="true" data-live-search="true" >
					<optgroup>
						<option value="">所在行业</option>
						<c:forEach items="${industryList}" var="inlist">
							<option value="${inlist.code }" <c:if  test="${inlist.code == search.sindustry}"> selected="selected"</c:if>>${inlist.caption}</option>
						</c:forEach>
					</optgroup>
						</select> 
						<select  class="selectpicker" onchange="searchContent()" name="suserID"  id="search_user" data-hide-disabled="true" data-live-search="true">
							<optgroup>
								<option value="">所属客服</option>
								<c:forEach items="${UserList}" var="ulist">
									<option value="${ulist.ID}" <c:if test="${ulist.ID==search.suserID }">selected="selected"</c:if>>${ulist.name}</option>
								</c:forEach>
							</optgroup>
						</select> 
						<select  id="search_level" onchange="searchContent()" name="slevel" class="selectpicker" >
							<optgroup>
								<option value=""<c:if test="${search.slevel==''||search.slevel==null}">selected="selected" </c:if>>客户级别</option>
								<option value="1" <c:if test="${search.slevel==1}">selected="selected"</c:if>>A</option>
								<option value="2" <c:if test="${search.slevel==2}">selected="selected"</c:if>>B</option>
								<option value="3" <c:if test="${search.slevel==3}">selected="selected"</c:if>>C</option>
							</optgroup>
						</select> 
						<select id="search_Classification" onchange="searchContent()" name="sclassification" class="selectpicker" >
							<optgroup>
								<option value="" <c:if test="${search.sclassification==''||search.sclassification==null}">selected="selected" </c:if>>客户状态</option>
								<option value="2" <c:if test="${search.sclassification==2}">selected="selected" </c:if>>未成交 </option>
								<option value="1" <c:if test="${search.sclassification==1}">selected="selected" </c:if>>已成交</option>
							</optgroup>
						</select> 
						<select  id="search_Channel" onchange="searchContent()" name="schannel" class="selectpicker" >
							<optgroup>
								<option value="">渠道来源</option>
						<c:forEach items="${sourceList}" var="slist">
							<option value="${slist.code }" <c:if test="${slist.code==search.schannel }">selected="selected"</c:if>>${slist.caption}</option>
						</c:forEach>
							</optgroup>
						</select> 
						<input type="hidden" value="${search.tID }">
						<select  id="search_cust" onchange="searchContent()" name="uID" class="selectpicker addcus"  >
							<optgroup>
								<option value="">所有客户</option>
								<option value="${search.uID}">我的客户</option>
							</optgroup>
						</select>
					</div>
				</div>
			</form>
		</div>
		
		
		<div class="row" id="remocediv">
			<c:forEach items="${custs}" var="user" varStatus="vs">
			<input type="hidden" name="custGID" value="${user.GID}">  
				<div class="col-lg-4">
					<div class="smart-widget widget-purple">
						 
						
							
						 
						<div class="smart-widget-inner">
							<div class="smart-widget-body">
								<div>
									<div>
										<span class="sea_header"><a href="<c:if test="${user.owner==bean.GID}"> ../customer/customerInfo?custId=${user.ID }</c:if>
											<c:if test="${user.owner!=bean.GID}">javascript:alert('不是本客服客户');</c:if>">${user.name}</a></span>
											<br><hr>
										<span style=" right: 80px;">客户等级： 
										<span class="fs_18">
											 <c:if test="${user.level==null||user.level==''}">未知</c:if>
											<c:if test="${user.level==1}">A</c:if>
											<c:if test="${user.level==2}">B</c:if>
											<c:if test="${user.level==3}">C</c:if></span>
										</span>
										<span style="position: absolute; right: 40px;">客户活跃度： 
										<span class="fs_18"><c:if test="${ user.actives==null}">0</c:if><c:if test="${ user.actives!=null}">${user.actives}</c:if></span>
										</span>
									</div>
									<div class="contdiv">
										<li style="right: 80px;float:left;"><c:if test="${user.uGID==uuowner  }">联系人数：<span>${user.conCount}</span>人</c:if>
											<c:if test="${user.uGID!=uuowner }">客服姓名：<span>${user.uName}</span></c:if>	
										</li>
										<li  style="position: absolute; right: 40px;"><c:if test="${user.uGID==uuowner&&user.uGID!=null }">行动记录数：<span>${user.notesCount}</span>条</c:if>
											<c:if test="${user.uGID!=uuowner||user.uGID==null }">客服电话：<span>${user.uMobile}</span></c:if>	
										</li>
											</div>
								</div>
							</div>
							<br>
							<div class="smart-widget-footer">
								<c:if test="${user.uGID==uuowner&&user.uGID!=null}">
								<button type="button" class="btn btn-primary btn-lg btn-block" onclick="custCheckOut('${user.ID}')" >捡出</button>
								</c:if>
								<c:if test="${user.uGID!=uuowner&&user.uGID!=null}">
									<button type="button" style="visibility: hidden;" class="btn btn-primary btn-lg btn-block" >隐藏</button>
								</c:if> 
                                 <c:if test="${user.owner==null||user.owner==''}">
                                 <button class="btn-lg btn-block btn_gh" type="button" onclick="custCheckIn('${user.ID}','')" >捡入</button>
                                 <button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" 
                                   data-target="#myModal" onclick="test11('${user.ID}')">分配</button></c:if>
							</div>
							
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		
		
		<div class="foot-box">
				<div class="center-footer">
					<span>上一页</span>
					<span>下一页</span>
				</div>
			
			</div>
		
	</div>
	
	</header>

		<%@ include file="/bottom.jsp"%>
	
    
    <script type="text/javascript" src="../static/js/bootstrap-select.min.js"></script>
    
    <script type="text/javascript" src="../static/js/customer/customerList.js"></script>
    
    
    
    
    
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
            
			
         </div>
         <div id="div2" class="modal-footer">
            <!-- <button type="button" class="btn btn-default" >上一页</button>
            <button type="button" class="btn btn-primary">下一页</button> -->
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>

<!-- <div id="blackS" class="modal-backdrop fade in" style="display: none"></div> -->

</body>
</html>