<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<script language="javascript" type="text/javascript">

function checkform()
{
	 
	var selects=document.getElementsByTagName("select");   /
             for(var i=0;i<selects.length;i++){   
             if(selects[i].id=="xzdaanid" && selects[i].value ==""){ 
                      alert("Please complete all the questions.");
		              return false;
                }   
            }   
	 
	
	return true;
	
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
    	<div class="title clearfix"><font class="yh f16">Questionnaire </font><span class="fright f12">Home > <a href="#">Questionnaire </a></span></div>
    	
        <div class="newsnr">
        <form  method="post" action="indexmethod!kaoshiadd2"  onsubmit="return checkform()"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="10%">Number</th>
                   <th width="80%">Title</th>
                   <th width="10%">Action</th>
                    </tr>
                    
                 <c:forEach items="${list1}" var="bean" varStatus="v">    
                <tr class="tr">
                   <td>${v.index+1 }</td>
                   <td>${bean.wenti }</td>
                    <td>
                         <input  name='xzid${v.index }' type="hidden"  value="${bean.id }" />
                            <select class="select" name="xzdaan${v.index }" id="xzdaanid">
                               <option value="">--Choose--</option>
                               <option value="Y">Y</option>
                               <option value="N">N</option>
                            </select>
                   </td> 
                 </tr>
                 </c:forEach> 
              </table>
              <br/> <br/>
              <div align="right">
         &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
          <input style="width:80px; height:25px;" type="submit" value="Submit">
         </div>   
    </form>
 
  </div>    
    
    </div>
</div>
<jsp:include page="down.jsp"></jsp:include>
<script src="js/all.js" type="text/javascript"></script>
</body>
</html>