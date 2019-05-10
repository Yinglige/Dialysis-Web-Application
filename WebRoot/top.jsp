<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="description" content="[!--pagedes--]" />
<meta name="keywords" content="[!--pagekey--]" />
<link href="css/master.css" type="text/css" rel="stylesheet" />
<link href="css/base.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>




</head>


<body>
<div class="head clearfix yh">
 <div class="logo block clearfix">
    	<a href="/" class="fleft">
    	<span style="font-size: wight:300px;high:30px;font-weight: bold;color:blue; margin-left:0%;">
           <h1>Dumor Dialysis<br></h1>
    </span>
    	</a>
    </div>
<div class="nav clearfix">
    	<ul class="block">
        	<li><a href="index.jsp">Home</a></li>
            <li><a href="indexmethod!xq_jichu" class="L">Introduction</a></li>
              <li><a href="indexmethod!sy_user"  class="L">Doctor</a></li>

            <c:if test="${user.role==1 }">
              <li><a href="indexmethod!sy_visit"  class="L">Appointment</a></li>
            <li><a href="indexmethod!my_visitlist" class="L">MyAppointment</a></li>
             <li><a href="indexmethod!my_visitlist2" class="L">MedicalHistory</a></li>
              <li><a href="indexmethod!my_archiveslist" class="L">Vitals</a></li>
               <li><a href="indexmethod!kaoshiadd" class="L">Questionaire</a></li>
            </c:if>
            
              <c:if test="${user.role==2 }">
            <li><a href="indexmethod!sy_appoint" class="L">Appointment</a></li>
             <li><a href="indexmethod!sy_appoint2" class="L">Treatment record</a></li>
              <li><a href="indexmethod!hz_userlist" class="L">Patient Information</a></li>
            </c:if>
        </ul>
    </div>
	
	
    
    <!--  <div class="focusBox">
			<ul class="pic">
					<li><img src="images/1.jpg"/></li>
			</ul>
			
	</div>-->


</div>


<script src="js/all.js" type="text/javascript"></script>
</body>
</html>