<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
    
    function type(form){       	
    	 if(form.id.value=="")
    	{
    		alert("请填写编号！");
    		form.id.focus();
    		return false;
    	}
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
<h1><center>添加学生</center></h1>
<form action="AddServlet" method="post" onsubmit="return type(this);" style="margin-left:500px">
	<br><br/>
	编号：<input type="text" name="id" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>*只能输入数字
	<br><br/>
	姓名：<input type="text" name="name"/>	
	<br><br/>
	生日：<input type="text" name="birthday"/>
	<br><br/>
	描述：<input type="text"  name="description" />
	<br><br/>
	分数：<input type="text" name="avgscore" />	
	<br><br/>
	<input type="submit" style="margin-left:100px">		
</form>
</body>
</html>