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
	<style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
        .fitem input{
            width:160px;
        }
    </style>
	<script type="text/javascript">
			$(function(){
				$("#system_code_list_table").datagrid({
					url:"systemCode/getSystemCodeList",
					loadMsg:"正在加载......",
					iconCls:"icon-ok", 
					striped:true,
					collapsible:true,			//是否要滑动效果
					//fitColumns: true ,
					pagination: true,//是否分页
					pageNumber: 1,
					pageList:[5,10,15,20],
					rownumbers: true,
					frozenColumns:[[
					     {
					    	 field:"id",
					    	 checkbox:true
					     }
					]],
					columns:[[
						{title:"代码英文",field:"code",align:"center",width:150},
						{title:"代码中文",field:"name",align:"center",width:150},
						{title:"是否有效",field:"type",align:"center",width:150,
							formatter:function(value,row,index){
								if(value == 1){
									return "<span style='color:green;'>有效</span>"; 
								}else if(value == -1){
									return "<span style='color:red;'>无效</span>";
								}
							}
						},{title:"创建时间",field:"create_date",align:"center",width:150,
							formatter:function(value,row,index){
								return value;
							}
							
						}
					]]
				/* ,
					toolbar:[{
				         text:'新增' , 	//按钮的名称
				         iconCls: "icon-add", //按钮的图标样式
				         handler: function(){ 	//点击按钮时所触发的函数
				        	 showDialog();
						}
				     },{
				         text:'修改' , 	//按钮的名称
				         iconCls: 'icon-edit' , //按钮的图标样式
				         handler: function(){ 	//点击按钮时所触发的函数
								var node = $("#system_code_list_table").datagrid("getSelected");		//获得你所选中的行 (对象)
								if(node){
									var par = 
									$.post("systemCode/getSysteCodeById",{"id":node.id},function(data){
										alert(data.data);
									});
								} else {
									$.messager.alert("提示","请选择一条记录!","error");	
								}
						}
				     }]*/
				}); 
				//修改table footer信息
				displayMsg($("#system_code_list_table"));
				
				$("#code_save").click(function(){
					$("#fm").form("submit",{
						url:"systemCode/saveSystemCodeType",
						onSubmit:function(){
							//return false来阻止提交
							return $(this).form("validate");
						},
						success:function(data){
							var json = jQuery.parseJSON(data);
							if(json.status == 200){
								$.messager.alert("操作提示", "操作成功", "ok",function(){
									close_dialog();
									refreshDataGrid();
								});
							}
						}
					});
				});
			});
			function refreshDataGrid(){
				$("#system_code_list_table").datagrid("reload");
			}
			//关闭编辑码表类型窗口
			function close_dialog(){
				$('#dlg').dialog('close');
			}
			var url;
			function newUser(){
				$("#dlg").dialog("open").dialog("setTitle","新建");
				$("#fm").form("clear");
			}
			function editUser(){
				var row = $("#system_code_list_table").datagrid("getSelected");
				if(row){
					$("#dlg").dialog("open").dialog("setTitle","修改");
					$("#fm").form("load", row);
				}else{
					$.messager.alert("提示","请选择一条记录!","error");	
				}
			}
	</script>
  </head>
  
  <body>
    <table id="system_code_list_table" toolbar="#toolbar" pagination="true" rownumbers="true" fitColumns="true" singleSelect="true">
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser();">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser();">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser();">删除</a>
    </div>
    <div id="dlg" class="easyui-dialog" style="width:400px;height:180px;top: 50px;"
            closed="true" buttons="#dlg-buttons">
      <!--   <div class="ftitle">User Information</div> -->
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>码表类型英文:</label>
                <input name="code" class="easyui-textbox" required="true" missingMessage="该项必须填写">
            </div>
            <div class="fitem">
                <label>码表类型中文:</label>
                <input name="name" class="easyui-textbox" required="true" missingMessage="该项必须填写">
            </div>
            <div class="fitem">
                <label>是否有效:</label>
                                        是
                 <input type="radio" style="width: 10px;" name="type" checked=true value="1" />
			        &nbsp;&nbsp;&nbsp; 否<input type="radio" style="width: 10px;"  name="system.type" value="-1" />
            </div>
        </form>
    </div>
    <div id="dlg-buttons" align="center">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="code_save" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="close_dialog()" style="width:90px">取消</a>
    </div>
 </body>
</html>
