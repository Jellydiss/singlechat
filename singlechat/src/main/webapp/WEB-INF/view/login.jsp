<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Single chat Login</title>
<style>
.login { background:#ccc; }
h1 { font-size: 24px; }
.loginbox { background: #444; padding: 10px; width: 400px; margin: 4% auto 0 auto; position: relative; }
.loginboxinner {
	background: #fff; padding: 20px; position: relative; border: 1px solid #333;
	-moz-box-shadow: inset 0 1px 0 #444; -webkit-box-shadow: inset 0 1px 0 #444; box-shadow: inset 0 1px 0 #444;
}
.loginheader { height: 40px; }
.loginform { margin-top: 20px; }

.loginbox h1 { font-size: 30px; letter-spacing: 1px; color: #555; font-weight: normal; padding-top: 10px; }
.loginbox .logo { position: absolute; top: 10px; right: 20px; }
.logo img { height:60px; width:60px; }
.loginbox p { margin: 10px 0 15px 0; }
.loginbox label { display: block; color: #666; letter-spacing: 1px; font-size: 18px; }
.loginbox input {
	padding: 12px 10px; background: #282828; color: #ccc;
	font-family: Arial, Helvetica, sans-serif; margin-top: 8px; font-size: 15px; border: 0; width: 340px;
	-moz-box-shadow: 0 1px 0 #444; -webkit-box-shadow: 0 1px 0 #444; box-shadow: 0 1px 0 #444; outline: none;
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


@media screen and (max-width: 430px) {

	body { font-size: 11px; }
	button, input, select, textarea { font-size: 11px; }

	.loginbox { width: auto; margin: 10px; }
	.loginbox input { width: 95%; }
	.loginbox button { width: 100%; }
}



</style>


</head>
<body>
<div class="loginbox" >
	<div class="loginboxinner radius">
    	<div class="loginheader">
    		<h1 class="title">Single chat</h1>
        	<div class="logo"><img src="./assets/img/logo.png" /></div>
    	</div><!--loginheader-->
        <div class="loginform">
        	<form id="login" action="" method="post">
            	<p>
                <label for="username" class="bebas">Username</label>
             <input type="text" id="username" name="username" value="" class="radius2" />
                </p>
                <p>
                <label for="password" class="bebas">Password</label>
                <input type="password" id="password" name="password"  class="radius2" />
                </p>
                <p>
               <button class="radius title" name="client_login">Login</button>
                </p>
            </form>
        </div><!--loginform-->
    </div><!--loginboxinner-->
</div><!--loginbox-->


</body>
</html>