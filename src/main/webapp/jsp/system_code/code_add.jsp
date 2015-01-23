<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="../../jsp/global/common.jsp" %>
	
	<script type="text/javascript">

	
			$(function(){
					//对于日期的控件添加 
					/* $('#birthday , #ruzhiTime').datebox( {
						currentText : '今天',
						closeText : '关闭',
						disabled : false,
						required : true,
						missingMessage : '必填字段!' , 
						formatter : formatDate
					});
					//对于薪水的校验 
					$('#baseSalary ,#phoneComm , #baoxianComm , #busComm').numberbox({min:0 ,max:100000 ,precision:0});
					
					//表单验证 
					$('#subform').click(function(){
						if($('#myform').form('validate')){
							$('#myform').get(0).submit();
							//$.messager.alert('提示信息','新增成功！','info');
						} else {
							$.messager.alert('提示信息','新增失败！','info');
						}
			
					}); */
					$("#code_save").click(function(){
						$("#myform").form("submit",{
							url:"systemCode/saveSystemCodeType",
							onSubmit:function(){
								//return false来阻止提交
								return true;
							},
							success:function(data){
								var json = jQuery.parseJSON(data);
								if(json.status == 200){
									$.messager.alert("操作提示", "操作成功", "ok", function(){
										parent.close_dialog();
										parent.refreshDataGrid();
									});
								}
							}
						});
					});
					
			});
			
	</script>
  </head>
  
  <body>
  </body>
</html>
