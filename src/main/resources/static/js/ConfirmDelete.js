function confirmRepairDelete(){
var id = document.getElementById("hidden_serviceId").value;
var del = confirm("Are you sure you want to delete element with id "+ id +"?");
return del;
}

function confirmUserDelete(){
var id = document.getElementById("hidden_email").value;
var del = confirm("Are you sure you want to delete element with email "+ id +"?");
return del;
}

function confirmVehicleDelete(){
var id = document.getElementById("hidden_vehicleId").value;
var del = confirm("Are you sure you want to delete element with id "+ id +"?");
return del;
}