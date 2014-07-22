<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "org.jellydiss.singlechat.user.entity.User" %>

<% 
	User userInfo = null;

	userInfo = (User) session.getAttribute("user"); 
	
	if (userInfo == null){
		response.sendRedirect("");
	}
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="./assets/css/chat.css" >
<script type="text/javascript" src="./assets/js/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="./assets/js/chat.js" ></script>

</head>

<body>
	<div class="messages"></div>
	<div class="input">
		<textarea class="textarea"></textarea>
		<br> <font>Nickname: </font> 
		<font>  <%= userInfo.getUserId() %></font> 
		<input class="userSequence" type="hidden" name="userSequence" value="<%=userInfo.getUserSeq() %>" />
		<button>OK</button>
	</div>

</body>
</html>