

window.onload = function () {
    thisDate();

}

function thisDate() {
    
    var today = new Date();
    var holloweenDay = new Date()
    holloweenDay = new Date(holloweenDay.getFullYear(), 9, 31, 00, 00, 00, 000);

    //halloweenDay.setFullYear(holloweenDay.getFullYear(), 9, 31);
    //var gradDay = new Date("Jul 10, 2020 18:00:00").getTime();
    if (today.getMonth() > holloweenDay.getMonth()) holloweenDay.setFullYear(holloweenDay.getFullYear() + 1, 9, 31);

    //sets interval to update the counter
    var countDown = setInterval(function () {
        //gets current time and updates it every second
        today = new Date();

        //calculate time left until holloween
        var timeLeft;
        timeLeft = holloweenDay.getTime() - today.getTime();
  
        //equations to generate counter
        var day = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
        var hour = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minute = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
        var second = Math.floor((timeLeft % (1000 * 60)) / 1000);

        //updates hours, minutes and seconds to show a 0 in front of them
        if (hour < 10) hour = "0" + hour;
        if (minute < 10) minute = "0" + minute;
        if (second < 10) second = "0" + second;

        //creates the message being generated under time left for graduation
        if (holloweenDay == today) {
            clearInterval(countDown);
            timeLeft = "Halloween is here. If you're visiting Salem have fun, stay safe, and come say hi to the Spooky Firefighters!";
            document.getElementById("date").innerHTML = timeLeft;
        } else if (day <= 1) {
            document.getElementById("date").innerHTML = "(" + hour + ":" + minute + ":" + second + " left until Halloween!)";
        } else {
            document.getElementById("date").innerHTML = "(" + day + " days left until Halloween!)";
        }

    }, 1000);

    //gets footer year
    var year = today.getFullYear();
   
    document.getElementById("footer").innerHTML = "Created by Rich C. Copyright " + year;
}
