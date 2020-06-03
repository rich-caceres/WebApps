let table = document.querySelector("table")

$(document).ready(function(){
	var doc= document.getElementById("JSONticks");
	var i = 0;
	var names= "" ;
	ticky=JSON.parse(doc.innerHTML);
	for(i in ticky) {
		names += " <td>" + ticky[i].name + "</td>" + " <td>" + ticky[i].vehicle + "</td>" + " <td>" + ticky[i].date + "</td>";
		console.log(names);
	}
	doc.innerHTML = names;
});

