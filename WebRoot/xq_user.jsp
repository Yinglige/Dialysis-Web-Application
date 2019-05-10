<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
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

</head>


<body>
<jsp:include page="top.jsp"></jsp:include>

<div class="main clearfix ofHidden block yh">
  <input type="hidden" name="id" value="${bean.id }"/>
	<!--left-->
	<jsp:include page="left.jsp"></jsp:include>

	<!--right-->
    <div class="main_right fright">
    	<div class="title clearfix"><font class="yh f16">Doctor List</font><span class="fright f12">Home > <a href="#">Doctor</a></span></div>
    	
        <div class="newsnr">
        
      <div class="nr">
       
      <div style="float:left;width:200px">
      <img align="middle" style="width:200px;height:200px;" src="<%=basePath %>/temp/${bean.imgpath}"> 
      
      </div >
       <div style="float:left;margin-left:30px;">
       <P>Department:${bean.keshi.name}</p>
       <P>Account:${bean.username}</p>
        <P>Name:${bean.truename}</p>
        <P>Level:${bean.zhicheng}</p>
         
         <P>Speciality:${bean.shangchang}</p>
          <P>Details:${bean.content}</p>
        </div>  
       </div>  
      <div class="share clearfix">
		<div class="fleft"><a href="javascript:history.go(-1);" class="close">Back</a></div>
    </div>
    
    
  
  </div>       
    </div>
</div>
<jsp:include page="down.jsp"></jsp:include>
<script src="js/all.js" type="text/javascript"></script>
</body>
</html>