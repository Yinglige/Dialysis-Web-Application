<%@ page language="java" import="java.util.*,model.User" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link rel=stylesheet type=text/css href="css/zzsc.css"/>
<script type=text/javascript src="js/jquery.min.js"></script>
</head>
<body>
<!-- Begin -->
 <div id="firstpane" class="menu_list">
    <p class="menu_head">User Management</p>
    <div style="display:none" class=menu_body >
      <a href="method!userlist" target="rightFrame">User Management</a>
    </div>
    <p class="menu_head">Department Management</p>
    <div style="display:none" class=menu_body >
      <a href="method!keshiadd" target="rightFrame">Add Department</a>
       <a href="method!keshilist" target="rightFrame">Department Management</a>
    </div>
     <p class="menu_head">Doctor Management</p>
    <div style="display:none" class=menu_body >
      <a href="method!y_useradd" target="rightFrame">Add Doctor</a>
      <a href="method!y_userlist" target="rightFrame">Doctor Management</a>
    </div>
  
     <p class="menu_head">Appointment time setting</p>
    <div style="display:none" class=menu_body >
      <a href="method!visitadd" target="rightFrame">Set up Time</a>
      <a href="method!visitlist" target="rightFrame">Appointment management</a>
    </div>
    <p class="menu_head">Vitals Management</p>
    <div style="display:none" class=menu_body >
      <a href="method!archiveslist" target="rightFrame">Vitals Management</a>
    </div>

     <p class="menu_head">Medicine Management</p>
    <div style="display:none" class=menu_body >
      <a href="method!productadd" target="rightFrame">Add Medicine</a>
      <a href="method!productlist" target="rightFrame">Medicine Management</a>
    </div>
     <p class="menu_head">Questionaire Management</p>
    <div style="display:none" class=menu_body >
        <a href="method!shitiadd" target="rightFrame">Add question</a>
         <a href="method!shitilist" target="rightFrame">Questionaire Management</a>
    </div>
    
    <p class="menu_head">Questionnaire Results</p>
    <div style="display:none" class=menu_body >
         <a href="method!kaoshilist" target="rightFrame">Questionnaire Results</a>
    </div>
    
      <p class="menu_head">Medical History</p>
    <div style="display:none" class=menu_body >
        <a href="method!appointadd" target="rightFrame">Add Medical History</a>
        <a href="method!appointlist" target="rightFrame">Medical History</a>
    </div>
    
    
    

</div>
<script type=text/javascript>
$(document).ready(function(){
	$("#firstpane .menu_body:eq(0)").show();
	$("#firstpane p.menu_head").click(function(){
		$(this).addClass("current").next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	$("#secondpane .menu_body:eq(0)").show();
	$("#secondpane p.menu_head").mouseover(function(){
		$(this).addClass("current").next("div.menu_body").slideDown(500).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	
});
</script>

<!-- End -->

</body>
</html>