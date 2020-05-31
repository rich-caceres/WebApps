
$(document).ready(function(){
	var ticketList = '${ticket}';
	var ticketToString= JSON.parse(ticketList);
	$("#tick").load(function(){
	$("#tick").text(ticketToString);
	});
	});
