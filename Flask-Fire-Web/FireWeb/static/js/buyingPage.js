buyingPageCounter();

function buyingPageCounter() {
    var shirtsInStock = new Date(2020, 9, 1, 0, 00, 00, 000);

    var shirtCountdown = setInterval(function () {
        //gets current time and updates it every second
        var today = new Date();
        //FORTESTINGvar today = new Date(2021, 10, 1, 0, 00, 00, 000);
        //calculate time left until holloween
        var shirtInStock;
        shirtInStock = shirtsInStock.getTime() - today.getTime();
        var day = Math.floor(shirtInStock / (1000 * 60 * 60 * 24));

        if (shirtsInStock.getTime() < today.getTime()) {
            clearInterval(shirtCountdown);
            document.getElementById("shirtInStock").innerHTML = "Available SFD Shirt Designs";
        } else if (day < 1) {
            document.getElementById("shirtInStock").innerHTML = "Less then 24 hours left until shirts are in stock.";
        } else {
            document.getElementById("shirtInStock").innerHTML = day + " days left until shirts are in stock.";
        }

    }, 1000);
}