<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!doctype html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title></title>
<meta name="description" content="[!--pagedes--]" />
<meta name="keywords" content="[!--pagekey--]" />
<link href="css/master.css" type="text/css" rel="stylesheet" />
<link href="css/base.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
  <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
  <script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>

</head>


<body>
<jsp:include page="top.jsp"></jsp:include>

<div class="main clearfix ofHidden block yh">
  <input type="hidden" name="id" value="${bean.id }"/>
	<!--左侧-->
	<jsp:include page="left.jsp"></jsp:include>

	<!--右侧-->
    <div class="main_right fright">
    	<div class="title clearfix"><font class="yh f16">Medical History</font><span class="fright f12">Home > <a href="#">Medical History</a></span></div>
    	&nbsp; 
        <div class="newsnr">
         <table width="100%" border="0"  cellpadding="0" cellspacing="0" style="background-color: #b9d8f3;"> 
         <tr style="text-align: center; ">
         <td >Doctor</td>
         <td >User</td>
         <td >AddTime</td>
         <td >Status</td>
         <td >Action</td>
         </tr>
         
        <c:forEach items="${list}" var="bean">
        <tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
        <td > ${bean.visit.user.truename }</td> 
        <td > ${bean.user.username }</td>
        <td > ${bean.createtime }</td>
        
        <td> <span style="color: red">Finished</span></td>
        <td > 
       <a href="indexmethod!xq_appointupdate?id=${bean.id}">Diagnostic details
</a> 
        </td>
        
         </tr>
          </c:forEach>
         </table>
         <br/>
      
       <div>${pagerinfo }</div>
 
  </div>       
    </div>
</div>
<jsp:include page="down.jsp"></jsp:include>
<script src="js/all.js" type="text/javascript"></script>

</body>
</html>