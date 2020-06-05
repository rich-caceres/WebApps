
$(document).ready(function(){
	var table = document.getElementById("table");
	var doc= document.getElementById("JSONticks");
	ticky= JSON.parse(doc.innerHTML);
});

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
			name = document.createTextNode(objectInfo.name);
			vehicle = document.createTextNode(objectInfo.vehicle);
			subject = document.createTextNode(objectInfo.subject);
			cell1.appendChild(ticketNum);
			cell2.appendChild(name);
			cell3.appendChild(vehicle);
			cell4.appendChild(subject);
			
		
	}	
}

function iterateThisTest(content){
	
	for(const [key, entryInfo] of Object.entries(content)){
		
		console.log(key, entryInfo);
		let entry = entryInfo;
		//console.log(entry.name);
		
	}
	
}

$( window ).on( "load", function() {
	var doc= document.getElementById("JSONticks");
	var json = JSON.parse(doc.innerHTML);
	ticky= json;
	//console.log(ticky);
	var table = document.getElementById("table");
	 createTableHead(table, ticky);
		createTable(table, ticky);
		iterateThisTest(ticky);
   });


