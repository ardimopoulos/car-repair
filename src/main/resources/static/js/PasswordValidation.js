function passValidation() {
 var pass1= document.getElementById("UserP").value;
 var pass2 = document.getElementById("ConfPass").value;
 if(pass1 != "" && pass2 != ""){
     if (pass1 != pass2) {
         document.getElementById("UserP").style.borderColor = "#E34234";
         document.getElementById("ConfPass").style.borderColor = "#E34234";
         return false;
     } else {
         document.getElementById("UserP").style.borderColor = "#33cc33";
         document.getElementById("ConfPass").style.borderColor = "#33cc33";
         return true;
     }
 }else{
 document.getElementById("UserP").style.borderColor = "#ccc";
  document.getElementById("ConfPass").style.borderColor = "#ccc";
 return false;}
}