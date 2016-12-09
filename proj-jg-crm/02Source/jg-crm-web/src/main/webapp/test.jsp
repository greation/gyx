<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>上传文件</title>
</head>
<body>
${user}
<br/>

	<form action="login/insertContacts" method="post" enctype="multipart/form-data"> 
	<input type="text" name="username"><br/>
	<input type="text" name="userpwd"><br/>
	<input type="file" name="fileTest"><br/>
	<input type="file" name="fileTest1"><br/>
	<input type="file" name="fileTest2"><br/>
	<input type="submit" value="Submit" />
	</form>
</body>
</html>