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
  <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

</head>


<body>
<jsp:include page="top.jsp"></jsp:include>

<div class="main clearfix ofHidden block yh">
  

	<jsp:include page="left.jsp"></jsp:include>

	
    <div class="main_right fright">
    	<div class="title clearfix"><font class="yh f16">Schedule An Appointment</font><span class="fright f12">Home > <a href="#">Appointment</a></span></div>
    	
        <div class="newsnr">
        
      <form action="indexmethod!appointadd2" method="post"  onsubmit="return checkform()">
   <input type="hidden" name="id" value="${bean.id }"/>
      <div class="nr" align="center">
       <p style="text-indent: 2em">Date:&nbsp; &nbsp; 
          <input type="text" readonly value="${bean.times }" style="width:20%">
          </p>
           <p style="text-indent: 2em">Time:&nbsp; &nbsp; 
            <select style="width:20%" name="times" id="timesid">
             <option value="">--Choose--</option>
             <option value="8.00-9.00">8.00-9.00</option>
             <option value="9.00-10.00">9.00-10.00</option>
              <option value="10.00-11.00">10.00-11.00</option>
              <option value="13.30-14.30">13.30-14.30</option>
              <option value="15.30-16.30">15.30-16.30</option>
               <option value="16.30-17.30">16.30-17.30</option>
              </select>
          </p>
      <div align="right">
         &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
          <input style="width:80px; height:25px;" type="submit" value="Submit">
           <input style="width:80px; height:25px;" onclick="javascript:history.go(-1);"  type="button" value="Back" />
         </div>
       </div>
      </form>

  </div>       
    </div>
</div>
<jsp:include page="down.jsp"></jsp:include>
<script src="js/all.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
function checkform()
{
	 if (document.getElementById('timesid').value=="")
	{
		alert("Time cannot be empty");
		return false;
	}

	return true;
	
}
</script>
</body>
</html>
