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
<script language="javascript" type="text/javascript">
 function add_words()
{
	
 var valus = documnet.getElementsById("productid");
  if(valus.length!=0)
  {
  var str = ""；
  for(var i=0;i<valus.length;i++)  
  {
  if(valus[i].checked)
  {
  str+= valus[i].value;
  }
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
    	<div class="title clearfix">Add Medical Record<span class="fright f12">Home > <a href="#">Add Medical Record</a></span></div>
    	
        <div class="newsnr">
        
      <form action="indexmethod!appointupdate2" method="post"  onsubmit="return checkform()">
   <input type="hidden" name="id" value="${bean.id }"/>
      <div class="nr" align="center">
        <p style="text-indent: 2em">Diagnostic description:&nbsp; &nbsp;   <textarea cols="50" rows="5"  name="content" id="contentid" ></textarea></p>
         <br/>
          <p style="text-indent: 2em">Notes:&nbsp; &nbsp;   <textarea cols="50" rows="5"  name="appcontent" id="appcontentid" ></textarea></p>
           <br/>
           
           <p style="text-indent: 2em">medication:&nbsp; &nbsp; 
           <table>
          <c:forEach items="${productlist}" var="bean2">
          <tr>
          <td>
         <input name="product" type="checkbox" id="productid" onClick="add_words();"  value="${bean2.id }" />Medication Name：${bean2.name } &nbsp;  
          <input type="text" name="pb${bean2.id }" id="productid" class="input-text lh30" size="10">Amount   
         </td>
         </tr>
         </c:forEach>
          </table>
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

</body>
</html>