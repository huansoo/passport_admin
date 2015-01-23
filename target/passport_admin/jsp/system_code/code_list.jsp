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
	<%@include file="../../jsp/global/common.jsp" %>

	<script type="text/javascript">
			$(function(){
				$("#system_code_list_table").datagrid({
					url:"systemCode/getSystemCodeList",
					loadMsg:"正在加载......",
					iconCls:"icon-ok", 
					striped:true,
					collapsible:true,			//是否要滑动效果
					fitColumns: true ,
					frozenColumns:[[
					     {
					    	 field:"id",
					    	 checkbox:true
					     }
					]],
					columns:[[
						{title:"代码英文",field:code,align:"center"'},
						{title:"代码中文",field:name,align:"center"},
						{titel:"是否有效",field:type,align:"center",
							formatter:function(value,row,index){
								if(value == 1){
									return "<span style='color:green;'>有效</span>"; 
								}else if(value == -1){
									return "<span style='color:red;'>无效</span>";
								}
							}
						}
					]]
				});
			});
	</script>
  </head>
  
  <body>
    <table id="system_code_list_table"></table>
 </body>
</html>
