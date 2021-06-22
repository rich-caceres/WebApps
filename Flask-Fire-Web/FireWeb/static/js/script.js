

window.onload = function () {

    var today = new Date();
    if(today.getMonth() === 11) document.getElementById("holidayDiv").style.visibility = 'visible';
    thisDate(today);
}

function thisDate(today) {
    
    //var today = new Date();
    var holloweenDay = new Date();
    var christmasDay = new Date();
    christmasDay = new Date(christmasDay.getFullYear(), 11, 25);
    holloweenDay = new Date(holloweenDay.getFullYear(), 9, 31);
    //halloweenDay.setFullYear(holloweenDay.getFullYear(), 9, 31);
    //var gradDay = new Date("Jul 10, 2020 18:00:00").getTime();
    if (today.getMonth() > holloweenDay.getMonth()) holloweenDay.setFullYear(holloweenDay.getFullYear() + 1, 9, 31);
 
    //sets interval to update the counter
    var countDown = setInterval(function () {
        //gets current time and updates it every second
        today = new Date();
        //today = new Date(2021, 9, 31);
        //FOR TESTINGconsole.log(holloweenDay);
        //console.log(today);
        //calculate time left until holloween

        var timeLeft;
        timeLeft = holloweenDay.getTime() - today.getTime();
        //console.log(timeLeft);

        //equations to generate counter
        var day = Math.ceil(timeLeft / (1000 * 60 * 60 * 24));
        var hour = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minute = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
        var second = Math.floor((timeLeft % (1000 * 60)) / 1000);
        //console.log(day);
        //updates hours, minutes and seconds to show a 0 in front of them
        if (hour < 10) hour = "0" + hour;
        if (minute < 10) minute = "0" + minute;
        if (second < 10) second = "0" + second;

        //creates the message being generated under time left for graduation
        if (holloweenDay.getTime() == today.getTime()) {
            clearInterval(countDown);
           var thisText = "Happy Halloween! <br> If you're in the city please follow social distancing guidelines and wear your mask!";
            document.getElementById("date").innerHTML = thisText;
        } else if (day <= 1) {
            document.getElementById("date").innerHTML = "(" + hour + ":" + minute + ":" + second + " left until Halloween!)";
        } else {
            document.getElementById("date").innerHTML = "(" + day + " days left until Halloween!)";
        }


    }, 1000);

    //gets footer year
    var year = today.getFullYear();
   
    //document.getElementById("footer").innerHTML = "Created by Rich C. Copyright " + year;
}
