<%@ page language="java" import="java.util.*,model.Manager" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>No Title</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #2b7dbb;
}
-->
</style>
<script type="text/JavaScript">

</script>
</head>

<body onload="MM_preloadImages('images/main_07_1.gif','images/main_08_1.gif','images/main_10_1.gif','images/main_11_1.gif','images/main_12_1.gif','images/main_13_1.gif','images/main_14_1.gif')">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="57" background="images/main_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="110" height="57" background="images/main_01.gif">&nbsp;</td>
        <td><table width="743" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="28" background="images/main_03.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="61" height="29" background="images/main_06.gif">&nbsp;</td>
                <td width="72"><a href="method!passwordupdate" target="rightFrame"><img src="images/main_07.gif" name="Image1" width="72" height="29" border="0" id="Image1" onmouseover="MM_swapImage('Image1','','images/main_07_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="72"><a href="method!managerupdate" target="rightFrame"><img src="images/main_08.gif" name="Image2" width="72" height="29" border="0" id="Image2" onmouseover="MM_swapImage('Image2','','images/main_08_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="292" background="images/main_09.gif">&nbsp;</td>
                <td width="40"><a href="right.jsp" target="rightFrame"><img src="images/main_10.gif" name="Image3" width="40" height="29" border="0" id="Image3" onmouseover="MM_swapImage('Image3','','images/main_10_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="44"><a href="javascript:history.go(-1);" target="rightFrame"><img src="images/main_11.gif" name="Image4" width="44" height="29" border="0" id="Image4" onmouseover="MM_swapImage('Image4','','images/main_11_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="43"><a href="javascript:history.go(1);" target="rightFrame"><img src="images/main_12.gif" name="Image5" width="43" height="29" border="0" id="Image5" onmouseover="MM_swapImage('Image5','','images/main_12_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="44"><a href="javascript:history.go(0);" target="rightFrame"><img src="images/main_13.gif" name="Image6" width="44" height="29" border="0" id="Image6" onmouseover="MM_swapImage('Image6','','images/main_13_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="39"><a href="method!loginout" target="_parent"><img src="images/main_14.gif" name="Image7" width="39" height="29" border="0" id="Image7" onmouseover="MM_swapImage('Image7','','images/main_14_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="36"><img src="images/main_15.gif" width="36" height="29" /></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="102" background="images/main_05.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="26" background="images/main_18.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" height="26" background="images/main_16.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="76" height="23" valign="bottom"><table width="74" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="18" ></td>
              </tr>
            </table></td>
            <td width="76" valign="bottom"><table width="74" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="18" ></td>
              </tr>
            </table></td>
            <td width="76" valign="bottom"><table width="74" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="18" ></td>
              </tr>
            </table></td>
            <td valign="bottom">&nbsp;</td>
          </tr>
        </table></td>
        <td width="200"><img src="images/user.gif" width="10" height="10" /> <span class="STYLE1">Welcome:${manager.username }   Role:Admin</span></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
