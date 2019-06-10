<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<script type="text/javascript" src="/js/jquery/jquery-1.10.2.min.js"></script>
<title>角色管理</title>
<script type="text/javascript">

  	//全选、全反选
	function doSelectAll(){
		// jquery 1.6 前
		//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
		//prop jquery 1.6+建议使用
		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
	}
  	//新增
  	function doAdd(){
  		document.forms[0].action = "${basePath}nsfw/role/addUI";
  		document.forms[0].submit();
  	}
  	//编辑
  	function doEdit(id){
  		document.forms[0].action = "${basePath}nsfw/role/editUI?roleId=" + id;
  		document.forms[0].submit();
  	}
  	//删除
  	function doDelete(id){
  		document.forms[0].action = "${basePath}nsfw/role/deleteRole?roleId=" + id;
  		document.forms[0].submit();
  	}

    </script>
</head>
<body class="rightBody">
	<form name="form1" action="${basePath}nsfw/role/listUI" method="post">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>角色管理 </strong>
						</div>
					</div>
					<div class="search_art">
						<li>
							角色名称：
							<input type="text" name="selectName" id="selectName">
						</li>
						<li><input type="button" class="s_button" value="搜 索"
							onclick="doSearch()" /></li>
						<li style="float: right;">
							<input type="button" value="新增" onclick="doAdd()" />&nbsp; 
							<input type="button" value="删除" onclick="doDeleteAll()" />&nbsp;
						</li>
					</div>

					<div class="t_list" style="margin: 0px; border: 0px none;">
						<table width="100%" border="0">
							<tr class="t_tit">
								<td width="30" align="center"><input type="checkbox"
									id="selAll" onclick="doSelectAll()" /></td>
								<td width="120" align="center">角色名称</td>
								<td align="center">权限</td>
								<td width="80" align="center">状态</td>
								<td width="120" align="center">操作</td>
							</tr>
							<c:forEach items="${rolePage.list }" var="role">
								<tr>
									<td align="center"><input type="checkbox"
										name="selectedRow" value="${role.role_id }" /></td>
									<td align="center">${role.name }</td>
									<td align="center">
										<c:forEach items="${role.privileges }" var="privilege">
                                			${privilege.code } &nbsp;
                                		</c:forEach>
                                	</td>
									<td align="center">${role.state == 1 ? '有效':'无效' }</td>
									<td align="center"><a
										href="javascript:doEdit('${role.role_id }')">编辑</a> <a
										href="javascript:doDelete('${role.role_id }')">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<%-- <jsp:include pageNum="/common/pageNavigator.jsp"/> --%>
				总共:${rolePage.total }&nbsp;条记录, 总页数：${rolePage.pages }
				&nbsp;,当前第${rolePage.pageNum }页, 
				<a href="${basePath}nsfw/role/listUI?pageNum=1">首页</a>
				<c:if test="${rolePage.pageNum > 1}">
					<a href="${basePath}nsfw/role/listUI?pageNum=${rolePage.pageNum - 1}">上一页</a>
				</c:if>
				<c:if test="${rolePage.pageNum < rolePage.pages }">
					<a href="${basePath}nsfw/role/listUI?pageNum=${rolePage.pageNum + 1}">下一页</a>
				</c:if>
				<a href="${basePath}nsfw/role/listUI?pageNum=${rolePage.pages}">尾页</a>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
function doDeleteAll(){
	
	var selects =	$("input[name='selectedRow']:checked");
	var roleIds = new Array(); 
	for(var i = 0 ; i < selects.length ; i ++){
		roleIds.push(selects[i].value);
	}
	if(roleIds.length > 0 ){
		$.ajax({
			url:"${basePath}nsfw/role/deleteRoles",
			type:"get",
			data:{"roleIds":roleIds},
			traditional: true,//这里设置为true
			success:function(data){
				if(data.code == 1){
					window.location.href="${basePath}nsfw/role/listUI";
				}else{
					alert("删除失败");
				}
				
			}
		})
	}
	return ;
}
</script>
</html>