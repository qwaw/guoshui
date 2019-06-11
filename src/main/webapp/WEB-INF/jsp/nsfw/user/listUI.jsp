<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>用户管理</title>
<%@include file="/common/header.jsp"%>
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
      		document.forms[0].action = "${basePath}nsfw/user/addUI";
      		document.forms[0].submit();
      	}
      	//编辑
      	function doEdit(id){
      		document.forms[0].action = "${basePath}nsfw/user/editUI?userId=" + id;
      		document.forms[0].submit();
      	}
      	//删除
      	function doDelete(id){
      		document.forms[0].action = "${basePath}nsfw/user/deleteUser?userId=" + id;
      		document.forms[0].submit();
      	}
      	//导出用户列表
      	function doExportExcel(){
      		window.open("${basePath}nsfw/user/exportExcel?pageNum=${userPage.pageNum}");
      	}
      	//导入
      	function doImportExcel(){
      		var file1=$("#file1");
      		if(file1==null || file1.val()==""){
      			alert("导入的文件不能为空");
      			return;
      		}else if(!file1.val().endsWith(".xls") && !file1.val().endsWith(".xlsx") ){
      			alert("请上传xls或xlsx文件");
      			return;
      		}else{
      			document.forms[0].action = "${basePath}nsfw/user/importExcel";
          		document.forms[0].submit();
      		}
      	}
      	var list_url = "${basePath}nsfw/user_listUI.action";
    	//搜索
      	function doSearch(){
      		//重置页号
      		$("#pageNo").val(1);
      		document.forms[0].action = list_url;
      		document.forms[0].submit();
      	}
    </script>
</head>
<body class="rightBody">
	<form name="form1" action="" method="post" enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>用户管理</strong>
						</div>
					</div>
					<div class="search_art">
						<li>
							用户名：<input type="text" name="userName" id="userName" >
						</li>
						<li>
							<input type="submit" class="s_button" value="搜 索"/>
						</li>
						<li style="float:right">
							<input type="button" value="新增" class="s_button" onclick="doAdd()" />&nbsp; 
							<input type="button" value="删除" class="s_button" onclick="doDeleteAll()" />&nbsp; 
							<input type="button" value="导出" class="s_button" onclick="doExportExcel()" />&nbsp; 
							<input id="file1" name="file" type="file" /> 
							<input type="button" value="导入" class="s_button" onclick="doImportExcel()" />&nbsp;
						</li>
					</div>

					<div class="t_list" style="margin: 0px; border: 0px none;">
						<table width="100%" border="0">
							<tr class="t_tit">
								<td width="30" align="center">
									<input type="checkbox" id="selAll" onclick="doSelectAll()" />
								</td>
								<td width="140" align="center">用户名</td>
								<td width="140" align="center">帐号</td>
								<td width="160" align="center">所属部门</td>
								<td width="80" align="center">性别</td>
								<td align="center">电子邮箱</td>
								<td width="100" align="center">操作</td>
							</tr>
							<c:forEach items="${userPage.list }" var="user">
								<tr>
									<td align="center"><input type="checkbox"
										name="selectedRow" value="${user.id }" /></td>
									<td align="center">${user.name }</td>
									<td align="center">${user.account }</td>
									<td align="center">${user.dept }</td>
									<td align="center">${user.gender == true ? '男':'女' }</td>
									<td align="center">${user.email }</td>
									<td align="center">
										<a href="javascript:doEdit('${user.id }')">编辑</a>
										<a href="javascript:doDelete('${user.id }')">删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<%-- <jsp:include pageNum="/common/pageNavigator.jsp"/> --%>
				总共:${userPage.total }&nbsp;条记录, 总页数：${userPage.pages }
				&nbsp;,当前第${userPage.pageNum }页, 
				<a href="${basePath}nsfw/user/listUI?pageNum=1">首页</a>
				<c:if test="${userPage.pageNum > 1}">
					<a href="${basePath}nsfw/user/listUI?pageNum=${userPage.pageNum - 1}">上一页</a>
				</c:if>
				<c:if test="${userPage.pageNum < userPage.pages }">
					<a href="${basePath}nsfw/user/listUI?pageNum=${userPage.pageNum + 1}">下一页</a>
				</c:if>
				<a href="${basePath}nsfw/user/listUI?pageNum=${userPage.pages}">尾页</a>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
function doDeleteAll(){
	
	var selects = $("input[name='selectedRow']:checked");
	var userIds = new Array(); 
	for(var i = 0 ; i < selects.length ; i ++){
		userIds.push(selects[i].value);
	}
	if(userIds.length > 0 ){
		$.ajax({
			url:"${basePath}nsfw/user/deleteUsers",
			type:"get",
			data:{"userIds":userIds},
			traditional: true,//这里设置为true
			success:function(data){
				if(data.code == 1){
					window.location.href="${basePath}nsfw/user/listUI";
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