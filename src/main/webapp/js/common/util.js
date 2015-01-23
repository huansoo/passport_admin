
/**
 * 列表相关方法封装
 */
function displayMsg($table){
	var pager = $table.datagrid('getPager');
	pager.pagination({
		loading:false,
		showPageList:true,
		showRefresh:true,
		beforePageText:'第',
		afterPageText:'页,共{pages}页',
		displayMsg:'当前显示记录数:第{from}到{to}条记录,共{total}条记录'
	});
}