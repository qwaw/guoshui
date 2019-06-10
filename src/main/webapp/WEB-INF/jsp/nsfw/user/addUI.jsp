<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>用户管理</title>
<script type="text/javascript"
	src="${basePath }js/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
    var vResult = false;
    	//校验帐号唯一
    	function doVerify(){
    		//1、获取帐号
    		var account = $("#account").val();
    		if(account != ""){
    			//2、校验 
    			$.ajax({
    				url:"${basePath}nsfw/user_verifyAccount.action",
    				data: {"user.account": account},
    				type: "post",
    				async: false,//非异步
    				success: function(msg){
    					if("true" != msg){
    						//帐号已经存在
    						alert("帐号已经存在。请使用其它帐号！");
    						//定焦
    						$("#account").focus();
    						vResult = false;
    					} else {
    						vResult = true;
    					}
    				}
    			});
    		}
    	}
    	//提交表单
    	function doSubmit(){
    		var name = $("#name");
    		if(name.val() == ""){
    			alert("用户名不能为空！");
    			name.focus();
    			return false;
    		}
    		var password = $("#password");
    		if(password.val() == ""){
    			alert("密码不能为空！");
    			password.focus();
    			return false;
    		}
    		//帐号校验
    		doVerify();
    		if(vResult){
	    		//提交表单
	    		document.forms[0].submit();
    		}
    	}
    </script>
</head>
<body class="rightBody">
	<form id="form" name="form" action="${basePath }nsfw/user/add"
		method="post" enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>用户管理</strong>&nbsp;-&nbsp;新增用户
						</div>
					</div>
					<div class="tableH2">新增用户</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="200px">所属部门：</td>
							<td>
								<label> 
									<input type="radio" name="dept" value="1">部门A&nbsp;
								</label> 
								<label> 
									<input type="radio" name="dept" value="0">部门B&nbsp;
								</label>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">头像：</td>
							<td><input type="file" name="headImg" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">用户名：</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">帐号：</td>
							<td><input type="text" name="account"></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">密码：</td>
							<td><input type="text" name="password"></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">性别：</td>
							<td>
								<label> 
									<input type="radio" name="gener" value="1">男&nbsp;
								</label> 
								<label> 
									<input type="radio" name="gener" value="0">女&nbsp;
								</label>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">角色：</td>
							<td><checkbox list="#roleList" name="userRoleIds"
									listKey="roleId" listValue="name"></checkbox></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">电子邮箱：</td>
							<td><input type="text" name="email"></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">手机号：</td>
							<td><input type="text" name="mobile"></textfield></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">生日：</td>
							<td>
								<input type="date">
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">状态：</td>
							<td>
								<label> 
									<input type="radio" name="state" value="1" checked="checked">有效&nbsp;
								</label> 
								<label> 
									<input type="radio" name="state" value="0">无效&nbsp;
								</label>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">备注：</td>
							<td><input type="text" name="memo"></td>
						</tr>
					</table>
					<div class="tc mt20">
						<input type="button" class="btnB2" value="保存" onclick="doSubmit()" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>