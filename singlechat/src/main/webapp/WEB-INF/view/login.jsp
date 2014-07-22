<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi">
<title>Single chat Login</title>
<link rel="stylesheet" type="text/css" href="./assets/css/login.css" />
<script type="text/javascript" src="./assets/js/jquery-2.1.1.min.js" ></script>

<script>
$(document).ready(function(){
	$('#button').click(function(){
		var userId=$('#userId').val();
		var userPw=$('#userPw').val();

	if(userId=="")
	{
		$('#dis').slideDown().html("<span>Please type Username</span>");
		return false;
	}
	if(userPw=="")
		{
			$('#dis').slideDown().html('<span id="error">Please type Password</span>');
				return false;
			}
	$('#login').submit();
		});
	
	});
</script>


</head>
<body>
<div class="loginbox" >
	<div class="loginboxinner radius">
    	<div class="loginheader">
    		<h1 class="title">Single chat</h1>
        	<div class="logo"><img src="./assets/img/logo.png"  /></div>
    	</div><!--loginheader-->
        <div class="loginform">
        		<form id="login" action="" method="post">
	            	<div class="input_row" id="id_area">
		            	<span class="input_box">
		            		
		                  	<input type="text" id="userId" name="userId" value="" class="radius2" placeholder="User name"/>
		                </span> 	
	                </div>
                <div class="input_row" id="id_area">
                	<input type="password" id="userPw" name="userPw"  class="radius2" placeholder="Password" />
                </div>
                <label id="dis"></label><br>
                <p>
               	<button type="button" id="button" class="radius title" name="button">Login</button>
                </p>
            </form>
        </div><!--loginform-->
    </div><!--loginboxinner-->
</div><!--loginbox-->


</body>
</html>