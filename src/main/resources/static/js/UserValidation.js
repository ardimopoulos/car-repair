function vatValidation() {
    var vat = document.getElementById("vat").value;
    if(vat != ""){
        if( vat.match(/^[0-9]{9}$/) ){
            document.getElementById("vat").style.borderColor = "#33cc33";
            document.getElementById("vat_error").innerHTML="";
        return true;
        }else{
            document.getElementById("vat").style.borderColor = "#E34234";
            document.getElementById("vat_error").innerHTML="Give 9 numbers from 0 to 9";
        return false;
        }
    }else{document.getElementById("vat").style.borderColor = "#ccc";document.getElementById("vat_error").innerHTML=""; return false;}
}

function emailValidation() {
    var email = document.getElementById("email").value;
    if(email != ""){
        if( email.match(/^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$/) ){
            document.getElementById("email").style.borderColor = "#33cc33";
            document.getElementById("email_error").innerHTML="";
        }else{
            document.getElementById("email").style.borderColor = "#E34234";
            document.getElementById("email_error").innerHTML="Give valid email";
          }
      }else{
          document.getElementById("email").style.borderColor = "#ccc";
          document.getElementById("email_error").innerHTML="";
      }
}