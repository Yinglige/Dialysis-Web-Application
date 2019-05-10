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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
  <script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
 <script type="text/javascript">
	   function up()
		    {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
	            
		    }
	</script>
</head>


<body>
<jsp:include page="top.jsp"></jsp:include>

<div class="main clearfix ofHidden block yh">
  <input type="hidden" name="id" value="${bean.id }"/>
	<!--left-->
	<jsp:include page="left.jsp"></jsp:include>

	<!--right-->
    <div class="main_right fright">
    	<div class="title clearfix"><font class="yh f16">Appointment</font><span class="fright f12">Home > <a href="#">Appointment</a></span></div>
    	&nbsp; 
    	<div> <form action="indexmethod!sy_visit" method="post"><span>
    	   Department:<select style="width:20%;height:20px;" name="keshi">
                   <option value="" >--Choose--</option>
                 <c:forEach items="${keshilist}"  var="bean2">
                    <option value="${bean2.id }" <c:if test="${keshi== bean2.id }">selected</c:if>>${bean2.name }</option>
                 </c:forEach>
              </select>&nbsp; &nbsp; 
    Doctor Name:<input style="width:20%;height:20px;" type="text" name="truename" value="${truename }"  >
    Available Time: <input style="width:20%;height:20px;" type="text" name="times" value="${times }" onfocus="WdatePicker({isShowWeek:true})"><img onclick="WdatePicker({el:'d12'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>
 		  <input style="width:40px; height:20px;" type="submit"  value="Search"/>
        </span> </form></div>
        &nbsp; 
        <div class="newsnr">
         <table width="100%" border="0"  cellpadding="0" cellspacing="0" style="background-color: #b9d8f3;"> 
         <tr style="text-align: center; ">
         <td >Department</td>
         <td >Doctor</td>
         <td >Available Time</td>
         <td >Number</td>
         <td >Current Reservation</td>
         <td >Status</td>
         <td >WorkTime</td>
         <td >Action</td>
         </tr>
         
        <c:forEach items="${list}" var="bean">
        <tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
        <td > ${bean.user.keshi.name }</td>
        <td > ${bean.user.truename }</td>
        <td > ${bean.times }</td>
        <td > ${bean.num }</td>
        <td > ${bean.bnum }</td>
        <td > 
          <c:if test="${bean.stauts!='Full'}">${bean.stauts }</c:if>
         <span style="color: red"><c:if test="${bean.stauts=='Full'}">${bean.stauts }</c:if></span>
        </td>
        <td > ${bean.gztime }</td>
        <td >
         <c:if test="${bean.stauts!='Full'}"> <a href="indexmethod!appointadd?id=${bean.id}">Schedule</a></c:if>
         <c:if test="${bean.stauts=='Full'}"> No Action</c:if>
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