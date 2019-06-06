<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
    <div align="center" style="text-align: center; width: 100%;height: 100%;overflow: hidden">
    	<!-- 标题 -->
        <div style="text-align: center; width: 100%;">
        	<h1>${infoOne.title }</h1>
        </div>
        <hr/>
        <!-- 时间、作者 -->
        <div style="text-align: center; width: 100%;color:#ccc;font-size:12px;">
                                    信息分类：${infoOne.type }&nbsp;&nbsp;&nbsp;&nbsp;
        	创建人：${infoOne.creator }&nbsp;&nbsp;&nbsp;&nbsp;
        	创建时间：${infoOne.create_time }	
        </div>
        <div style="text-align: center; width: 100%;padding:8px;">
        	${infoOne.content }
        </div>
    </div>
    
  </body>
</html>
