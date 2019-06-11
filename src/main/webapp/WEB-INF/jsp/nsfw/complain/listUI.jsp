<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉受理管理</title>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
  	var list_url = "${basePath}nsfw/complain_listUI.action";
  	//搜索
  	function doSearch(){
  		//重置页号
  		$("#pageNo").val(1);
  		document.forms[0].action = list_url;
  		document.forms[0].submit();
  	}
  	//受理
  	function doDeal(compId){
  		document.forms[0].action = "${basePath}nsfw/complain_dealUI.action?complain.compId=" + compId;
  		document.forms[0].submit();
  	}
  	//投诉统计
  	function doAnnualStatistic(){
  		document.forms[0].action = "${basePath}nsfw/complain/annualStatisticChartUI";
  		document.forms[0].submit();
  	}
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	投诉标题：<input type="text" name="comp_title">
                    </li>
                    <li>
                       	投诉时间：<input type="text" name="comp_time">
                    </li>
                    <li>
                       	状态：<input type="text" name="state">
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                    	<input type="button" value="统计" class="s_button" onclick="doAnnualStatistic()"/>&nbsp;
                    </li>

                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td align="center">投诉标题</td>
                            <td width="120" align="center">被投诉部门</td>
                            <td width="120" align="center">被投诉人</td>
                            <td width="140" align="center">投诉时间</td>
                            <td width="100" align="center">受理状态</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                        <c:forEach items="${complainPage.list }" var="complain">
                        	<tr>
                                <td align="center">${complain.comp_title }</td>
                                <td align="center">${complain.to_comp_dept }</td>
                                <td align="center">${complain.to_comp_name }</td>
                                <td align="center">${complain.comp_time }</td>
                                <td align="center">${complain.state }</td>
                                <td align="center">
                                	<c:if test="${complain.state!=2 }">
                                    	<a href="javascript:doDeal('${complain.comp_id }')">受理</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
			<%-- <jsp:include pageNum="/common/pageNavigator.jsp"/> --%>
			总共:${complainPage.total }&nbsp;条记录, 总页数：${complainPage.pages }
			&nbsp;,当前第${complainPage.pageNum }页, 
			<a href="${basePath}nsfw/role/listUI?pageNum=1">首页</a>
			<c:if test="${complainPage.pageNum > 1}">
				<a href="${basePath}nsfw/role/listUI?pageNum=${complainPage.pageNum - 1}">上一页</a>
			</c:if>
			<c:if test="${complainPage.pageNum < complainPage.pages }">
				<a href="${basePath}nsfw/role/listUI?pageNum=${complainPage.pageNum + 1}">下一页</a>
			</c:if>
			<a href="${basePath}nsfw/role/listUI?pageNum=${complainPage.pages}">尾页</a>
		</div>
	</div>
</form>

</body>
</html>