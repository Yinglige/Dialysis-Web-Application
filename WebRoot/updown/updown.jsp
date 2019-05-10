<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jspsmart.upload.*" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body> 
      <% 
          String fujianPath=request.getParameter("fujianPath");
          String fujianYuashiMing=request.getParameter("fujianYuashiMing");
          fujianYuashiMing=java.net.URLDecoder.decode(fujianYuashiMing,"UTF-8");
          System.out.println(fujianYuashiMing+fujianPath);
          
          SmartUpload su = new SmartUpload();  

          su.initialize(pageContext); 

          su.setContentDisposition(null); 
          
          su.downloadFile(fujianPath, null, new String(fujianYuashiMing.getBytes(), "ISO8859-1")); 
          //downloadFile(String sourceFilePathName, String contentType, String destFileName)
          out.clear();
          out=pageContext.pushBody(); 
      %> 

      
  </body>
</html>
