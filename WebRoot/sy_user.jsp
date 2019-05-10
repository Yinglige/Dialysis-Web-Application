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

	<!--left-->
	<jsp:include page="left.jsp"></jsp:include>

	<!--right-->
    <div class="main_right fright">
    	<div class="title clearfix"><font class="yh f16">Doctor</font><span class="fright f12">Home > <a href="#">Doctor</a></span></div>
    	<br/>
    	<div> <form action="indexmethod!sy_user" method="post"><span>
         Department:  <select style="width:20%;height:20px;" name="keshi">
                   <option value="" >--Choose--</option>
                 <c:forEach items="${keshilist}"  var="bean2">
                    <option value="${bean2.id }" <c:if test="${keshi== bean2.id }">selected</c:if>>${bean2.name }</option>
                 </c:forEach>
              </select>&nbsp; &nbsp; 
          Name:<input style="width:20%;height:20px;" type="text" name="truename" value="${truename }"  >
 		  <input style="width:60px; height:20px;" type="submit"  value="Search"/>
        </span> </form></div>
    	<ul class="clearfix pic_list">
    	 <c:forEach  items="${list}" var="bean">
      	<li><a href="indexmethod!xq_user?id=${bean.id }" class="pic"><img src="<%=basePath %>/temp/${bean.imgpath}"></a><p><a>Department：${bean.keshi.name }&nbsp;&nbsp; &nbsp;Doctor：${bean.truename } </a></p></li>
     </c:forEach>
      </ul>
        <div class="page clearfix">${pagerinfo }</div> 
        
    </div>


</div>
<jsp:include page="down.jsp"></jsp:include>
<script src="js/all.js" type="text/javascript"></script>
</body>
</html>