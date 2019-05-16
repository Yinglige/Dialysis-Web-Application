<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="10%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="95%" class="STYLE1"><span class="STYLE3"></span>Report statistics list</td>
              </tr>
             
            </table></td>
          <td width="40%" class="STYLE1">
                <form action="method!tj_appointlist" method="post">
                 <input style="width:10%" type="text" name="startime" value="${startime }" onfocus="WdatePicker({isShowWeek:true})"/><img onclick="WdatePicker({el:'d12'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>
             --  <input style="width:10%" type="text" name="endtime" value="${endtime }" onfocus="WdatePicker({isShowWeek:true})"/><img onclick="WdatePicker({el:'d12'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>
 				<input type="submit"  value="Search"/>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </form>
                
             
                </td>   
                 
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
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" >
          <tr>
            <td width="auto" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Date</span></div></td>
              <td width="auto" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Number of appointments</span></div></td>
          </tr>
          <c:forEach items="${list}" var="bean">
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${bean[0]}</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${bean[1]}</span></div></td>  
          </tr>
          </c:forEach>
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
            <td class="STYLE4">&nbsp;&nbsp;${pagerinfo }</td>
           
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
