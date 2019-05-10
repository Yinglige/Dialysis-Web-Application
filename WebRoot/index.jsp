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
<%
org.springframework.web.context.WebApplicationContext app = org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
dao.GonggaoDao gonggaoDao = (dao.GonggaoDao)app.getBean("gonggaoDao");
List<model.Gonggao> list = gonggaoDao.selectBeanList(0,5," where gonggaolock=0 order by createtime desc");
%>
</head>


<body>
<jsp:include page="top.jsp"></jsp:include>

<div class="main clearfix ofHidden block yh">

	<!--左侧-->
	<jsp:include page="left.jsp"></jsp:include>
    
	<!--右侧-->
    <div class="main_right fright">
    
    	<div class="clearfix">
        
    	<div class="company fleft">
        	<div class="t1"></a><span>Welcome</span></div>
            <div class="nr f12">
            
            <p><img src="images/gs_t.jpg" width="595" height="205"></p>
            </div>
        </div>
        
        
        
        
    
    
    
    </div>
        
</div>

</div>

<jsp:include page="down.jsp"></jsp:include>


<script src="js/all.js" type="text/javascript"></script>
</body>
</html>