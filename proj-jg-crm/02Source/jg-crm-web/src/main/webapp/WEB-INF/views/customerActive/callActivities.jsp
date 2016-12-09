<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<link rel="stylesheet"
		href="../static/css/customerActive/callActivities.css" />
	<link href="../static/css/agency.css" rel="stylesheet">
	<link href="../static/css/jeDate/jeDate.css" rel="stylesheet">
	<link href="../static/css/jeDate/jeui.css" rel="stylesheet">
	<link href="../static/css/jeDate/prism.css" rel="stylesheet">
	<link href="../static/css/jeDate/gray.css" rel="stylesheet">
	<link href="../static/css/jeDate/green.css" rel="stylesheet">
</head>
<body id="page-top" class="index">

	<%@ include file="/top.jsp"%>

	<!-- Header -->
	<header>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="crm_panel">
					<span style="margin-right: 10px;"> <img src="../static/img/index/07.png" />
					</span> <span class="addC">拜访通话及活动</span>

				</div>
			</div>
		</div>

		<div class="row">
			<form id="findActivities" method="post" action="../Cust/findActivities">
				<div class="col-md-12">
					<div class="crm_panel">

						<div class="input-group">
							<input type="text" class="form-control" placeholder="公司名称搜索" name="name">
						</div>
						<button type="submit" class="btn btn-default" style="margin-left: 10px">搜索</button>
                        <a href="../actionRecord/jumpAddActionJsp">
						<span class="addcus"><button type="button"
								class="btn btn-default addcus2">
								<span style="color: #0074C1;">+</span>添加活动
							</button> </span></a>
					</div>
					<div class="crm_panel">
						<div class="leftTime">
						<!-- <span style="height: 30px;line-height: 35px">
							<label>开始时间</label>
						</span> -->
						<span>
							<input type="text" class="workinput wicon mr25" id="inpstart" name="begintime" placeholder="开始时间" readonly>
						</span>
						</div>
						<span class="numS">—</span>
						<div class="rightTime">
						<!-- <span style="height: 30px;line-height: 35px">
						<label>结束时间</label>
						</span> -->
						<span>
							<input type="text" class="workinput wicon mr25" id="inpend" name="endtime" placeholder="结束时间" readonly>
						</span>
						</div>
					</div>
				</div>
			</form>
		</div>
		<c:forEach items="${activities}" var="act" varStatus="vs">
			<div class="row">
				<div class="col-md-12 hStyle">
					<div class="leftDate">
						<div class="yearStyle">${fn:substring(act.nowDate,0, 4)}</div>
						<div class="mouthStyle">${fn:substring(act.nowDate,5, 10)}</div>
					</div>
					<div class="rightContent">
						<ul>
							<c:forEach var="dt" items="${act.snts}" varStatus="num">

								<li><a href="../actionRecord/queryActionRecodDetail?id=${dt.id}">&nbsp;${dt.uname}&nbsp;&nbsp;拜访&nbsp;&nbsp;${dt.name}&nbsp;&nbsp;${dt.a}&nbsp;&nbsp;
								<fmt:formatDate value="${dt.endtime}" pattern="yyyy-MM-dd"/>
								</a>
								</li>
							</c:forEach>
						</ul>
					</div>

				</div>
			</div>
		</c:forEach>


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

	<script type="text/javascript"
		src="../static/js/bootstrap-select.min.js"></script>
		
     <script type="text/javascript" src="../static/js/jeDate/jedate.js"></script>
     
     <script type="text/javascript" src="../static/js/jeDate/prism.js"></script>
     
    <script type="text/javascript">
    var start = {
            dateCell: '#inpstart',
            format: 'YYYY-MM-DD',
            minDate: '1900-01-01 00:00:00', //设定最小日期为当前日期
            festival:true,
            maxDate: '2099-06-16 23:59:59', //最大日期
            isTime: true,
            choosefun: function(datas){
                 end.minDate = datas; //开始日期选好后，重置结束日的最小日期
            }
        };
        var end = {
            dateCell: '#inpend',
            format: 'YYYY-MM-DD',
            minDate: '1900-01-01 00:00:00', //设定最小日期为当前日期
            festival:true,
            maxDate: '2099-06-16 23:59:59', //最大日期
            isTime: true,
            choosefun: function(datas){
                 start.maxDate = datas; //将结束日的初始值设置为开始日的最大日期
                 $("#findActivities").submit();
            }
        };
        jeDate(start);
        jeDate(end);
    
    </script>
</body>
</html>