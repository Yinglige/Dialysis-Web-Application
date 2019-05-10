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
  <form action="indexmethod!userupdate2" method="post"  onsubmit="return checkform()">
  <input type="hidden" name="id" value="${bean.id }"/>
  <div class="container">
    
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">Edit Profile</b></div>
            <div class="box_center">
             
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">

                  <tr>
                  <td class="td_right">Account:</td>
                  <td class="">
                  <input type="text" name="username" readonly id="usernameid" value="${bean.username }" class="input-text lh30" size="40">
                  </td>
                 </tr>
                 
                 <tr>
                  <td class="td_right">Name:</td>
                  <td class="">
                  <input type="text" name="truename" id="truenameid" value="${bean.truename }" class="input-text lh30" size="40">
                  </td>
                 </tr>
                 
                 <tr>
                  <td class="td_right">Password:</td>
                  <td class="">
                  <input type="text" name="password" id="passwordid" value="${bean.password }" class="input-text lh30" size="40">
                  </td>
                 </tr>
                 
                 
                  <tr>
                  <td class="td_right">Age:</td>
                  <td class="">
                  <input type="text" name="age" id="ageid" value="${bean.age }" class="input-text lh30" size="40">
                  </td>
                 </tr>
               
                 
                
                 
                   <tr>
                  <td class="td_right">Gender:</td>
                  <td class="">
                  <span class="fl">
                      <div class="select_border"> 
                   <div class="select_containers "> 
                  <select  name="xingbie" id="xingbieid"> 
                    <option value="male"<c:if test="${bean.xingbie=='male' }">selected</c:if>>Male</option>
                    <option value="female"<c:if test="${bean.xingbie=='female' }">selected</c:if>>Female</option>
                   </select>
                  </div> 
                  </div>     
                    </span> 
                  </td>
                 </tr>
                 
                   <tr>
                  <td class="td_right">Country:</td>
                  <td class="">
                  <input type="text" name="jiguan" id="jiguanid" value="${bean.jiguan }" class="input-text lh30" size="40">
                  </td>
                 </tr>
                 
                  <tr>
                  <td class="td_right">Phone:</td>
                  <td class="">
                  <input type="text" name="telephone" id="telephoneid" value="${bean.telephone }" class="input-text lh30" size="40">
                  </td>
                 </tr>
                
                  <tr>
                  <td class="td_right">Address:</td>
                  <td class="">
                  <input type="text" name="address" id="addressid" value="${bean.address }" class="input-text lh30" size="40">
                  </td>
                 </tr>
                   
                     <tr>
                  <td class="td_right">Email:</td>
                  <td class="">
                  <input type="text" name="email" id="emailid" value="${bean.email }" class="input-text lh30" size="40">
                  </td>
                 </tr>  
                 
               
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="submit" class="btn btn82 btn_save2" value="Save"> 
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
  