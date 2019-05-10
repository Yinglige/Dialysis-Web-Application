<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

 <!doctype html>
 <html lang="zh-CN">
 <head>
  
    <link rel="stylesheet" href="css/common.css">
   <link rel="stylesheet" href="css/main.css">
   <script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="js/common.js"></script>
   <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
   
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
        }); 
        
      }); 
   </script>
   <script language="javascript" type="text/javascript" src="../js/jquery.min.js"></script>

   <title></title>
 </head>
 <body>
  <form action="indexmethod!appointupdate2" method="post"  onsubmit="return checkform()">
   <input type="hidden" name="id" value="${bean.id }"/>
  <div class="container">
    
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">Add Medical record</b></div>
            <div class="box_center">
             
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                
                  <tr>
                  <td class="td_right">Treatment description:</td>
                  <td class="">
                 <textarea cols="50" rows="10"  name="content" id="contentid" ></textarea>
                  </td>
                 </tr>  

                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="submit" class="btn btn82 btn_save2" value="保存"> 
                   </td>
                 </tr>
               </table>
               
            </div>
          </div>
        </div>
     </div>
   </div> 
   </form>
 </body>
 <script language="javascript" type="text/javascript">

function checkform()
{
	 
	 if (document.getElementById('usernameid').value=="")
	{
		alert("User account cannot be empty");
		return false;
	}

	if (document.getElementById('passwordid').value=="")
	{
		alert("Password cannot be empty");
		return false;
	}
	if (document.getElementById('passwordid').value.length<6)
	{
		alert("Password length must be greater than 6 bits");
		return false;
	}
	if (document.getElementById('password2id').value != document.getElementById('passwordid').value)
	{
		alert("Confirm that the password is inconsistent with the password");
		return false;
	}	 
	if (document.getElementById('truenameid').value=="")
	{
		alert("Name cannot be empty");
		return false;
	}
	

   if(document.getElementById('telephoneid').value==""){
    alert("Telephone can't be empty");
    return false;
   }	
   if(document.getElementById('telephoneid').value.length!=10){
    alert("Telephone must be 10 bits ");
    return false;
   }
   if(document.getElementById('jiguanid').value==""){
    alert("state cannot be empty");
    return false;
   }	
	if(document.getElementById('addressid').value==""){
    alert("Address cannot be empty ");
    return false;
   }	
   if(document.getElementById('ageid').value==""){
    alert("Age cannot be empty ");
    return false;
   }
   if(document.getElementById('ageid').value.length!=2){
    alert("Age must be an integer between 0 and 100  ");
    return false;
   }  
	
	return true;
}

</script>
 </html>
  