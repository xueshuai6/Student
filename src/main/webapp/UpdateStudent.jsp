<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
    
    function type(form){       	
    	if(form.name.value=="")
    	{
    		alert("请填写姓名！");
    		form.name.focus();
    		return false;
    	}
    	if(form.birthday.value=="")
    	{
    		alert("请输入生日");
    		form.birthday.focus();
    		return false;
    	}
    	if(form.description.value=="")
    	{
    		alert("请输入备注");
    		form.description.focus();
    		return false;
    	}
    	if(form.avgscore.value=="")
    	{
    		alert("请输入平均分");
    		form.avgscore.focus();
    		return false;
    	}
    	
    }    
    </script>
</head>
<body>
<h1><center>修改学生</center></h1>
<form action="UpdateServlet" method="post" style="margin-left:500px">
	<br><br/>
	编号：<input type="text" name="id" value="${sel.id }" readonly="readonly"/>
	<br><br/>
	姓名：<input type="text" name="name" value="${sel.name }"/>	
	<br><br/>
	生日：<input type="text" name="birthday" value="${sel.birthday }"/>
	<br><br/>
	描述：<input type="text"  name="description" value="${sel.description }"/>
	<br><br/>
	分数：<input type="text" name="avgscore" value="${sel.avgscore}"/>	
	<br><br/>
	<input type="submit" style="margin-left:100px">	
</form>
</body>
</html>