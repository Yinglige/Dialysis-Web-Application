<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>No title</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
  <script type='text/javascript' src='<%=path %>/js/util.js'></script>
        <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
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
<script language="javascript" type="text/javascript">

function checkform()
{
	 
	 if (document.getElementById('userid').value=="")
	{
		alert("User account cannot be empty");
		return false;
	}
	
	 if (document.getElementById('timesid').value=="")
	{
		alert("Time cannot be empty");
		return false;
	}
	

	return true;
	
}
</script>
</head>

<body>
<form action="method!y_appointadd2" method="post"  onsubmit="return checkform()">
<input type="hidden" name="id" value="${bean.id }"/>
<table width="70%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="95%" class="STYLE1"><span class="STYLE3"></span>Add appointment</td>
              </tr>
            </table></td>
            
           
            
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          
           <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Date</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            <input style="width:50%"  type="text" readonly value="${bean.times }" />
            </span></div></td>
          </tr>
          
          <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">User</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            <select style="width:50%"  name="user" id="userid"> 
              <option value="">--Choose--</option>
              <c:forEach items="${list}" var="bean2">
              <option value="${bean2.id }">User Account：${bean2.username}，Name：${bean2.truename}</option>
               </c:forEach>
              </select>
            </span></div></td>
          </tr>

          
          <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Time</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
             <select style="width:20%" name="times" id="timesid">
             <option value="">--Choose--</option>
             <option value="8.00-9.00">8.00-9.00</option>
             <option value="9.00-10.00">9.00-10.00</option>
              <option value="10.00-11.00">10.00-11.00</option>
              <option value="13.30-14.30">13.30-14.30</option>
              <option value="15.30-16.30">15.30-16.30</option>
               <option value="16.30-17.30">16.30-17.30</option>
              </select>
            </span></div></td>
          </tr>
          
      
       
      
         
         
        </table></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          
          
          <tr>
            <td width="100%" class="STYLE4" height="22"  bgcolor="#FFFFFF"><div align="center">
           <input type="submit" value="Submit"/>
            </div></td>
          </tr>
          
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
