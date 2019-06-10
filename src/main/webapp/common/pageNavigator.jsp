<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="c_pate" style="margin-top: 5px;">
	<c:if test="${pages.total>0 }">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">总共：${pages.total }条记录，当前第${pages.pageNum }页，
					共 ${pages.pages }页 <c:if test="${page.pageNum >1}">
                 	        &nbsp;&nbsp;<a
							href="javascript:doGoPage(${page.pageNum-1 })">上一页</a>
					</c:if> <c:if test="${pages.pageNum } < ${pages.total }">
                            &nbsp;&nbsp;<a
							href="javascript:doGoPage(${page.pageNum+1 })">下一页</a>
					</c:if> 到&nbsp;<input id="pageNo" name="pageNo" type="text"
					style="width: 30px;"
					onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="3" value="${pages.pageNum }" /> &nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${pages.total<1 }">
			暂无数据！
	</c:if>
</div>
<script type="text/javascript">
	//翻页
	function doGoPage(pageNo) {
		document.getElementById("pageNo").value = pageNo;
		document.forms[0].action = list_url;
		document.forms[0].submit();
	}
</script>