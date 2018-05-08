<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	ul li{
	float:left;
		display:blocak;
	}
</style>
</head>
<body>
<h1><center>学生数据管理</center></h1>
<input type="button" value="添加学生数据" onclick="location.href=('AddStudent.jsp')" style="margin-left:200px">
<br></br>
<table width="1000" align="center" cellspacing="0" border="1 solid " >
	<tr align="center" style="font-size:12px; font-weight:bold" height="30">
		<th width="15%">编号</th>
		<th width="10%">姓名</th>
		<th width="25%">生日</th>
		<th width="25%">备注</th>
		<th width="10%">平均分</th>
		<th width="15%">操作</th>
	</tr>
	
	<c:forEach items="${list}" var="l">
	<tr height="20" align="center">
		<td>${l.id}</td>
		<td>${l.name}</td>
		<td>${l.birthday}</td>
		<td>${l.description}</td>
		<td>${l.avgscore}</td>
		<td><input type="button" value="修改" onclick="update('${l.id}')" style="margin-left:15px ;background-color:transparent;border:0" >&nbsp;&nbsp;
		<input type="button" value="删除" onclick="del('${l.id}')" style="background-color:transparent;border:0"></td>
	</tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	</c:forEach>
</table>
 <div class="gridItem" style="padding: 10px; margin-left:100px; width: 250px; float: left; text-align: left; height: 20px; font-size: 15px;">   
        当前第<span>${page}</span>页     
        共<span >${pages}</span>页
  </div>
  <div style="margin-top:10px; margin-left:500px">
    <ul style="list-style:none; display:inline; ">
                <li><a href="QueryServlet?page=1">首页</a></li>
                <li><a href="QueryServlet?page=${page-1>1?page-1:1}">&nbsp;&nbsp;</a></li>

                <c:forEach begin="1" end="${pages}" varStatus="loop">
                    <c:set var="active" value="${loop.index==page?'active':''}"/>
                    <li class="${active}"><a href="QueryServlet?page=${loop.index}">${loop.index}</a></li>
                </c:forEach>
                <li>
                    <a href="QueryServlet?page=${page<pages?page:pages}">&nbsp;&nbsp;</a>
                </li>
                <li><a href="QueryServlet?page=${pages}">尾页</a></li>
            </ul>
      </div>
</body>
<script type="text/javascript">
	function del(s){

		if(confirm("确定删除吗")){
			location.href="${pageContext.request.contextPath}/DelServlet?id="+s;
		}
	}
	function update(i){
		if(confirm("确定修改吗")){
			location.href="${pageContext.request.contextPath}/SelServlet?id="+i;
		}
	}
</script>
</html>