<%@ page language="java" import="java.util.*,model.User" pageEncoding="UTF-8"%>
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

</head>


<body>
	
	<div class="sidebar fleft">
	
	
    	<div class="title">User Login</div>
        <div class="contact_nr">
        <c:if test="${user==null}">
         <form action="indexmethod!ulogin" method="post" onsubmit="return checkform()" >
           User Name：<input type="text" name="username" size="15" id="usernameid" /> 
          &nbsp;
          
           Password：<input type="password" name="password" size="15" id="passwordid" /> 
        &nbsp;
         Role&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<select  name="role" id="roleid" class="select"> 
                         <option value="1">User</option>
                         <option value="2">Doctor</option>
                         </select>
                         <br/>
         
          <input style="width:80px; height:25px;" type="submit" name="submit"  value="Login"  />  
          <input style="width:80px; height:25px;" type="reset" name="reset"  value="Reset"  />  
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="javascript:;" onClick="javascript:window.open('register.jsp','','width=460,height=360,left=750, top=350,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;">User Register</a>
         
        
          </form>   
             
        </c:if>
  <input type="hidden" name="id" value="${bean.id }"/>
        <c:if test="${user!=null  }">
         <form action="indexmethod!uloginout" method="post"  >
      Welcome：${user.username }  &nbsp;    Role：
           <c:if test="${user.role==1 }">User</c:if>
            <c:if test="${user.role==2 }">Doctor</c:if>
          
          Status：Login  
         <input style="width:200px; height:25px;" type="submit" name="submit"  value="Logout"  />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <a href="javascript:;" onClick="javascript:window.open('indexmethod!userupdate?id=${bean.id}','','width=460,height=360,left=750, top=350,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;">Edit Profile</a>
           
           </form>   
           </c:if>
        </div>
      
       
        <div class="title mt10">Contact Us </div>
        <div class="contact_nr">
            <p>Phone：10000000000</p>
            <p>Fax：123-456000000</p>
            <p>Address：XXX</p>
            <p>Email：XXX@dumordialysis.com</p>
          
        </div>
        
    </div>
<script src="js/all.js" type="text/javascript"></script>
</body>
</html>