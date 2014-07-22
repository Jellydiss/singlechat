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



<!DOCTYPE html>
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
		<input class="userSeq" type="hidden" name="userSeq" value="<%=userInfo.getUserSeq() %>" />
		<button>OK</button>
	</div>

</body>
</html>