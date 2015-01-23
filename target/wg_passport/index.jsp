<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	{'id':26,'investment_amount':11000,'cooperation_way':'战略合作修改', 'investment_unit':'卡威锋网修改', 'project_brief':'本项目针对钓鱼岛', 'title':'国防部战略导弹'}
     		
     {'minvestment_amount':11000,'cooperation_way':'战略合作修改', 'investment_unit':'卡威锋网修改', 'project_brief':'本项目针对钓鱼岛', 'title':'国防部战略导弹'}
	
	===================================
	专利技术
	--新增、修改
	{'investment_amount':11000,'cooperation_type':11, 'investment_area':22, 'patent_brief':'本项目针对钓鱼岛', 'title':'国防部战略导弹'}
	--查询列表
	
	{'id':12}
	-->

  </head>
  
  <body>
    <form  id="form1" method="post" action="user/checkUserCorrect?json={'id':'15'}"> 
		<!-- <input  name="json" value="investmentArea"/> -->
	<input  id="GetDataBtn" value="测试" type="submit"/>  

<p><span id="article_link" style="display:none;z-index:100"></span></p>
</form>  
  </body>
</html>
