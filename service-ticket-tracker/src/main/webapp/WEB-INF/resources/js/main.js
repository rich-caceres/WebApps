
$(document).ready(function(){
	var table = document.getElementById("table");
	var doc= document.getElementById("JSONticks");
	ticky= JSON.parse(doc.innerHTML);//assigns the tickets taken from the JSP and turns it to JSON
});
//creates headers for the table
function createTableHead(table, content){
	var thead= table.createTHead();
	row= table.insertRow();
	var objectProps = ["Ticket Number", "Ticket Creator", "Vehicle", "Subject"];
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
	
	for (let [key, objectInfo] of Object.entries(content)){
		let row = table.insertRow();
		let objProps= Object.getOwnPropertyNames(objectInfo);
			let cell1 = row.insertCell();
			let cell2 = row.insertCell();
			let cell3 = row.insertCell();
			let cell4 = row.insertCell();
			ticketNum = document.createTextNode(key);
			let a= document.createElement('a');
			name = document.createTextNode(objectInfo.name);
			vehicle = document.createTextNode(objectInfo.vehicle);
			subject = document.createTextNode(objectInfo.subject);
			a.appendChild(ticketNum);
			a.title= ticketNum;
			a.href="/service-ticket-tracker/listOfTickets";
			cell1.appendChild(a);
			cell2.appendChild(name);
			cell3.appendChild(vehicle);
			cell4.appendChild(subject);	
	}	
}

$( window ).on( "load", function() {
	var doc= document.getElementById("JSONticks");
	var json = JSON.parse(doc.innerHTML);
	ticky= json;
	var table = document.getElementById("table");
	//calling our methods
	 createTableHead(table, ticky);
		createTable(table, ticky);
   });