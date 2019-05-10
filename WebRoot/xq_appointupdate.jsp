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
 <script type="text/javascript">
	   function up()
		    {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
	            pop.setContent("title","File upload");
	            pop.build();
	            pop.show();
	            
		    }
	</script>
</head>


<body>
<jsp:include page="top.jsp"></jsp:include>

<div class="main clearfix ofHidden block yh">
  
	<!--左侧-->
	<jsp:include page="left.jsp"></jsp:include>

	<!--右侧-->
    <div class="main_right fright">
    	<div class="title clearfix"><font class="yh f16">Diagnostic Details</font><span class="fright f12">Home > <a href="#">Diagnostic Details</a></span></div>
    	
        <div class="newsnr">

   <input type="hidden" name="id" value="${bean.id }"/>
      <div class="nr" align="center">
        <p style="text-indent: 2em">Treatment description:&nbsp; &nbsp;   <textarea cols="50" rows="10"  readonly >${bean.content }</textarea></p>
        <p style="text-indent: 2em">Notes:&nbsp; &nbsp;   <textarea cols="50" rows="10"  readonly >${bean.appcontent }</textarea></p>
        <p style="text-indent: 2em">Prescribing:&nbsp; &nbsp;   <textarea cols="50" rows="10"  readonly >${bean.procontent }</textarea></p>
         <p style="text-indent: 2em">Total Cost($):&nbsp; &nbsp;  <input style="width:20%;height:20px;" readonly type="text" value="${bean.money }"  ></p>
      <div align="right">
         &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
           <input style="width:80px; height:25px;" onclick="javascript:history.go(-1);"  type="button" value="Back" />
         </div>
       </div>

  </div>       
    </div>
</div>
<jsp:include page="down.jsp"></jsp:include>
<script src="js/all.js" type="text/javascript"></script>

</body>
</html>