<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi">
<title>Single chat Login</title>
<style>
.login { background:#ccc; }
h1 { font-size: 24px; }
.loginbox { padding: 10px; width: 400px; margin: 4% auto 0 auto; position: relative; }
.loginboxinner {
	background: #fff; padding: 12px; position: relative; border: 1px solid #333;
	-moz-box-shadow: inset 0 1px 0 #444; -webkit-box-shadow: inset 0 1px 0 #444; box-shadow: inset 0 1px 0 #444;
}
.loginheader { height: 40px; }
.loginform { margin-top: 20px; }

.loginbox h1 { font-size: 30px; letter-spacing: 1px; color: #555; font-weight: normal; padding-top: 10px; }
.loginbox .logo { position: absolute; top: 40px; right: 20px; }
.logo img {  height:40px; width:40px; }
.loginbox p { margin: 10px 0 15px 0; }
.loginbox label { display: block; color: #666; letter-spacing: 1px; font-size: 18px; }
.loginbox input {
	position: relative;
	width: 100%;
	padding: 7px 0px 6px;
	height: 16px;
	z-index: 9;
	border: medium none;
	background: none repeat scroll 0% 0% #FFF;
	font-size: 15px;
	color: #000;
	line-height: 16px;
	font-family: Arial, Helvetica, sans-serif; 
}
.loginbox button {
	background: #999; padding: 10px 20px; font-size: 18px; border: 0; letter-spacing: 1px; color: #333; width: 360px;
	-moz-box-shadow: 1px 1px 3px #222; -webkit-box-shadow: 1px 1px 3px #222; box-shadow: 1px 1px 3px #222; cursor: pointer;
}
.loginbox button.default { background: #999; color: #333; }
.loginbox button.hover { background: #ccc; color: #000; }
.loginbox button:active { background: #111; color: #fff; }
.loginerror { color: #990000; background: #fbe3e3; padding: 0 10px; overflow: hidden; display: none; }
.loginerror { -moz-border-radius: 2px; -webkit-border-radius: 2px; border-radius: 2px; }
.loginerror p { margin: 10px 0; }

.radius { -moz-border-radius: 3px; -webkit-border-radius: 3px; border-radius: 3px; }
.title { font-family: 'BebasNeueRegular', Arial, Helvetica, sans-serif; }
.input_row {
    position: relative;
    border: 1px solid #DADADA;
    padding: 10px 35px 10px 15px;
    margin: 0px 0px 10px;
    background: none repeat scroll 0% 0% #FFF;
    height: 29px;
}




	body {position: relative;
		  height: 100%;
          font-size : 15px; }
	button, input, select, textarea { font-size: 15px; }

	.loginbox { width: auto; margin: 12px; }
	.loginbox input { width: 95%; }
	.loginbox button { width: 100%; }




</style>


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
		                  	<input type="text" id="username" name="username" value="" class="radius2" placeholder="User name"/>
		                </span> 	
	                </div>
                <div class="input_row" id="id_area">
                <input type="password" id="password" name="password"  class="radius2" placeholder="Password" />
                </div>
                <p>
               <button class="radius title" name="client_login">Login</button>
                </p>
            </form>
        </div><!--loginform-->
    </div><!--loginboxinner-->
</div><!--loginbox-->


</body>
</html>