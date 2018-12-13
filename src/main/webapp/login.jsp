<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() 
	+ ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<!DOCTYPE html >
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<base href="<%=basePath%>">

<title>login page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		$("#myBtn").click(function(){
			
			var length=$(":checkbox:checked").length;
			alert(length);
		})
			
			
		
		
	})
	
</script>

</head>
<body >
	 <button id="myBtn" name="button">选中多少项？</button>
	 监事长<input type="checkbox" name="hello" value="1"/>
	 董事长<input type="checkbox" name="hello" value="2"/>
	 总经理<input type="checkbox" name="hello" value="3" />
	 副总经理<input type="checkbox" name="hello" value="4" />

	
</body>
</html>