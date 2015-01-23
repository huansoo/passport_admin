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
	<%@include file="jsp/global/common.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("#main_menu").tree({
				url:'data/menu_data.json',
				onClick:function(node){
					if(null != node.attributes.url){
						$.messager.alert(node.attributes.url);
						$("#myframe").src = node.attributes.url;
					}
				}
			});
		});
	</script>
  </head>
  
  <body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">欢迎您：</div>
   <!--  <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"> -->
    </div>
    <div data-options="region:'west',title:'West',split:true" style="width:150px;">
    	<ul id="main_menu"></ul>
    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
    	<iframe id="myframe" width="100%" scrolling="no" height=100% frameborder="0"></iframe>
    </div>
 </body>
</html>
