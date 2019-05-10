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
	<!--左侧-->
	<jsp:include page="left.jsp"></jsp:include>

	<!--右侧-->
    <div class="main_right fright">
    	<div class="title clearfix"><font class="yh f16">Vitals</font><span class="fright f12">Home > <a href="#">Vitals</a></span></div>
    	 <input type="hidden" name="id" value="${bean.id }"/>
        <div class="newsnr">
        
      <h1 class="bt">Vitals</h1>
       <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Account: <input style="width:30%;" type="text" readonly  value="${bean.bianhao }"></p>
       <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Time: <input style="width:30%;" type="text" readonly  value="${bean.times }"></p>
        <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Status: <input style="width:30%;" type="text" readonly  value="${bean.stauts }"></p>
         <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;User: <input style="width:30%;" type="text" readonly  value="${bean.user.username }"></p>
          <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Name: <input style="width:30%;" type="text" readonly  value="${bean.user.truename }"></p>
           <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Gender: <input style="width:30%;" type="text" readonly  value="${bean.user.xingbie }"></p>
            <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Age: <input style="width:30%;" type="text" readonly  value="${bean.user.age }"></p>
       <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Height（feet）: <input style="width:30%;" type="text" readonly  value="${bean.sg }"></p>
         <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Weight (Pound): <input style="width:30%;" type="text" readonly value="${bean.tz }"></p>
        <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Blood type:  <input style="width:30%;" type="text" readonly value="${bean.xa }"></p>
        <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;systolic: <input style="width:30%;" type="text" readonly value="${bean.xt }"></p>
         <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Diastolic: <input style="width:30%;" type="text" readonly value="${bean.xz }"></p>
         <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Diabetes: <input style="width:30%;" type="text" readonly value="${bean.tnb }"></p>
         <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Heart Disease: <input style="width:30%;" type="text" readonly value="${bean.xxg }"></p>
         <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Emphysema (COPD): <input style="width:30%;" type="text" readonly value="${bean.xy}"></p>
          <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Pulse: <input style="width:30%;" type="text" readonly value="${bean.mb }"></p>
         <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Respirations: <input style="width:30%;" type="text" readonly value="${bean.xint }"></p>
          <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;BMI: <input style="width:30%;" type="text" readonly value="${bean.fhl }"></p>
          <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Summary:<textarea style="width:30%" rows="5" readonly >${bean.content}</textarea></p>
          <p style="text-indent: 2em">&nbsp;&nbsp;&nbsp;&nbsp;Time: ${bean.createtime }</p>
      
      <div class="share clearfix">
		<div class="fleft"><a href="javascript:history.go(-1)" class="close">Back</a></div>
    </div>
    
   
  
  </div>       
    </div>
</div>
<jsp:include page="down.jsp"></jsp:include>
<script src="js/all.js" type="text/javascript"></script>
</body>
</html>