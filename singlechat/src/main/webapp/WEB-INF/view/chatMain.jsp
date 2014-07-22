<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "org.jellydiss.singlechat.user.entity.User" %>

<% 
	User userInfo = null;

	userInfo = (User) session.getAttribute("userInfo"); 
	
	if (userInfo == null){
		response.sendRedirect("/webchat/login");
	}
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="./assets/css/chat.css" style="">

<script type="text/javascript" src="./assets/js/jquery-2.1.1.min.js" ></script>

<script type="text/javascript">
function sendMessage(){
	var params = {
			userSequence :  $('input').val(), 
			message : $('textarea').val()
	};

	$.ajax({
		  type: 'POST',
		  url: "chat/insertChat",
		  data: params,
		  contentType: "application/x-www-form-urlencoded; charset=utf-8",
		  success: function	(){
		  }
		});
	 $('textarea').val("");
	
};


$(document)
.ready(
		function() {
			$('button').click(function() {
				if(($('textarea').val() != "") && ($('textarea').val() != "\n"))
					sendMessage();
			});
		});

$(document).keydown(function(k) {
	if (k.which == 13) {
			if(($('textarea').val() != "") && ($('textarea').val() != "\n"))
				sendMessage();
		}
});

$(document).keyup(function(k) {
	if (k.which == 13) {
		 $('textarea').val("");
	}
});


/* var lastSequence = getLastSequence(); */
var currentSequence = 0; 
var lastSequence = 0;

var tempSeq = 0;
setInterval("loadNewData()",3);

function loadNewData(){
	getLastSequence();
	
	if( lastSequence > currentSequence) {
		loadData();
		currentSequence = lastSequence;
	}
	
	
}


function getLastSequence (){
	$.ajax({
        url: "chat/getLastSequence",
        type: "get",
        dataType: "json",
        success: function(data){
        	lastSequence = data.lastSeq;
        	if(currentSequence == 0){
        		currentSequence = data.lastSeq;
        	}
        	  	
        }
	});
	return tempSeq;
};


function loadData(){
	var dataParam = "currentSequence=" + currentSequence;
	
	
	$.ajax({
        url: "chat/chatData",
        type: "get",
        data : dataParam,
        success: function(data) {
        	
        	
        	$.each(data, function(key) {
        		var list = data[key];	
				for(var i = 0; i < list.length; i++){					
    	
    			$('.messages')[0].innerHTML += "><font class='nicknameMessage'>"
    					+ data.chatLists[i].userName.replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\n/g, "<br />")
    					+ "</font>: "
    					+ data.chatLists[i].message.replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\n/g, "<br />")
    					+ "<br>";
    			$(".messages")[0].scrollTop = $(".messages")[0].scrollHeight + 10;
    		}
        		
        		
        	});
        	
        	
        	ob = data;
        }, error: function(a, b, c) {
            console.log(a);
            console.log(b);
            console.log(c);
        }
    });

}



	
</script>
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