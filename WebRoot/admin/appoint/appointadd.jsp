<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script language="javascript" type="text/javascript">

function checkform()
{
	 
	 if (document.getElementById('numid').value=="")
	{
		alert("Quota cannot be empty");
		return false;
	}
	var valid=/^\d*$/;
	
	if(!valid.test(document.getElementById('numid').value)){
		alert("Quota must be numbers");
		return false;
	}
	 if (document.getElementById('timesid').value=="")
	{
		alert("Available time should not be empty");
		return false;
	}
	  if (document.getElementById('userid').value=="")
	{
		alert("Doctors can't be empty");
		return false;
	}

	return true;
	
}
</script>
</head>

<body>
<form action="method!appointadd2" method="post"  onsubmit="return checkform()">
<table width="70%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="95%" class="STYLE1"><span class="STYLE3"></span>Add Medical History</td>
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
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">User</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            <select style="width:50%"  name="user" id="userid"> 
              <option value="">--Choose--</option>
              <c:forEach items="${list}" var="bean2">
              <option value="${bean2.id }">Account：${bean2.username}，Name：${bean2.truename}</option>
               </c:forEach>
              </select>
            </span></div></td>
          </tr>
          
           <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Total cost</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
            <input style="width:50%"  type="text" name="money" id="moneyid"/>
            </span></div></td>
          </tr>
          
           <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Date</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
              <input style="width:50%" type="text" name="riq" id="riqid" onfocus="WdatePicker({isShowWeek:true})"/><img onclick="WdatePicker({el:'d12'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>
            </span></div></td>
          </tr>
          
          <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Diagnostic description</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
             <textarea  cols="40" rows="8" class="STYLE6" name="content" id="contentid" ></textarea>
            </span></div></td>
          </tr>
          
          <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Prescribing</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
             <textarea  cols="40" rows="8" class="STYLE6" name="procontent" id="procontentid" ></textarea>
            </span></div></td>
          </tr>
          
          <tr>
            <td width="30%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">Notes</span></div></td>
            <td width="70%" height="22"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
             <textarea  cols="40" rows="8" class="STYLE6" name="appcontent" id="appcontentid" ></textarea>
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
