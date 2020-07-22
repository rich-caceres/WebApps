
$(document).ready(function(){
	var table = document.getElementById("table");
	var doc= document.getElementById("JSONticks");
	ticky= JSON.parse(doc.innerHTML);//assigns the tickets taken from the JSP and turns it to JSON
});

$( window ).on( "load", function() {
	var doc= document.getElementById("JSONticks");
	var json = JSON.parse(doc.innerHTML);
	ticky= json;
	var table = document.getElementById("table");
	
	//calling our methods
	 createTableHead(table, ticky);
	 createTable(table, ticky);
});

//creates headers for the table
function createTableHead(table, content){
	var thead= table.createTHead();
	row= table.insertRow();
	var objectProps = ["Ticket Number", "Ticket Creator", "Vehicle", "Subject", "Status"];
	for(let key of objectProps){
		let th = document.createElement("th");
		let text= document.createTextNode(key);
		th.appendChild(text);
		row.appendChild(th);
	}
}
//Tables is created here
function createTable(table, content){
	let ticketNum="";
	let name = "";
	let vehicle ="";
	let subject = "";
	let status = "";
	
	for (let [key, objectInfo] of Object.entries(content)){
		let row = table.insertRow();
		let objProps= Object.getOwnPropertyNames(objectInfo);
			let cell1 = row.insertCell();
			let cell2 = row.insertCell();
			let cell3 = row.insertCell();
			let cell4 = row.insertCell();
			let cell5 = row.insertCell();
			let ticketNum = document.createTextNode(key);
			let a= document.createElement('a');
			name = document.createTextNode(objectInfo.name);
			vehicle = document.createTextNode(objectInfo.vehicle);
			subject = document.createTextNode(objectInfo.subject);
			status = document.createTextNode(objectInfo.status);
			a.appendChild(ticketNum);
			a.title= ticketNum.toString();
			a.href="/service-ticket-tracker/getTicket/" + key;
			cell1.appendChild(a);
			cell2.appendChild(name);
			cell3.appendChild(vehicle);
			cell4.appendChild(subject);
			cell5.appendChild(status);
	}	
}

