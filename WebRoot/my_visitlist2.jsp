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
	<!--左侧-->
	<jsp:include page="left.jsp"></jsp:include>

	<!--右侧-->
    <div class="main_right fright">
        <c:if test="${user.role==1 }">
    	<div class="title clearfix"><font class="yh f16">Medical History</font><span class="fright f12">Home> <a href="#">Medical History</a></span></div>
    	</c:if>
    		&nbsp; 
    	  <c:if test="${user.role==2 }">
    	  <input  onclick="javascript:history.go(-1);"  type="button" value="Back" />
    	  </c:if>
    	   &nbsp;   &nbsp; 
        <div class="newsnr">
         <table width="100%" border="0"  cellpadding="0" cellspacing="0" style="background-color: #b9d8f3;"> 
         <tr style="text-align: center; ">
         
         <td >User</td>
         <td >Total Cost</td>
         <td >Date of treatment</td>
          <td >Action</td>
         </tr>
         
        <c:forEach items="${list}" var="bean">
        <tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
        <td > ${bean.user.username }</td>
        <td > ${bean.money}</td>
        <td > ${bean.riq }</td>
         <td > 
       <a href="indexmethod!xq_appointupdate?id=${bean.id}">Details of treatment</a>   &nbsp; &nbsp; 
        
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