function sendMessage(){
	var params = {
			userSeq :  $('input').val(), 
			messageContent : $('textarea').val()
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
			if(($('textarea').val() != "") && ($('textarea').val() != "\n")){
				sendMessage();
			} else $('textarea').val("");
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
	
	
	$.ajax({
        url: "chat/getLastMessage",
        type: "get",
        success: function(data) {
    			$('.messages')[0].innerHTML += "><font class='nicknameMessage'>"
    					+ data.userName.replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\n/g, "<br />")
    					+ "</font>: "
    					+ data.message.messageContent.replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\n/g, "<br />")
    					+ "<br>";
    			$(".messages")[0].scrollTop = $(".messages")[0].scrollHeight + 10;
        }, error: function(a, b, c) {
            console.log(a);
            console.log(b);
            console.log(c);
        }
    });
}
setInterval("loadNewData()",3);