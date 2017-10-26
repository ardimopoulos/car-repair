function plateValidation() {
    var plate = document.getElementById("plate").value;
    if( plate.match(/^[A-Z]{3}-[0-9]{4}$/) ){document.getElementById("plate").style.borderColor = "#33cc33";
    }else{document.getElementById("plate").style.borderColor = "#E34234";}
}