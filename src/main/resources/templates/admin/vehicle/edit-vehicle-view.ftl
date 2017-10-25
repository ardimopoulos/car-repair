<!DOCTYPE html>

<html>
<#import "/spring.ftl" as spring/>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/serviceReg.css">
</head>
<body>
<#include "/admin/menu_bar.ftl"/>
<div class="col-md-1"></div>
<div class="col-md-10">


       <h1>New Vehicle Form</h1>
       <form name="searchVehicle" action="/admin/edit-vehicle"  method="get" >
                 <!-- <label for="vat">VAT:</label>-->
                 <input type="text" class="form-control"  id="plate" placeholder="Enter plate number" autocomplet="off" name="plate" />
                  <button type="submit" class="btn">Search</button>
               </form>
               <br>
               <#if vehicleSearchForm??>
    <form action="/admin/edit-vehicle" method="post" name="vehicleForm">

        <div class="col-md-12">
            <div class="side">
            ${message!""}
                ${errormessage!""}
                <div class="col-md-12">
                   <div class="col-md-6">
                 <@spring.bind "repairForm.repairId"/>
                  <input type="hidden" name="repairId" value="${repairForm.repairId!""}"/>
                <@spring.bind "repairForm.plate"/>
                 <#list spring.status.errorMessages as error>
                 <span style="color:red">${error}</span>
                </#list><br>
                <label for="Plate">Plate</label>
                    <input type="text" id="plate" name="plate" placeholder="Type the plate..(ABC-1234)" value=${repairForm.plate!""}>
                <br/>
                </div>
                <div class="col-md-6">
                                 <@spring.bind "repairForm.status"/>
                                <#list spring.status.errorMessages as error>
                                    <span style="color:red">${error}</span>
                                </#list><br>
                                 <label for="Status of Service">Status of Service</label>
                            <select id="statusServ" name="status" >
                                    <option value="0" ${pending!""}>Pending</option>
                                    <option value="1" ${inProgress!""}>In progress</option>
                                    <option value="2" ${completed!""}>Completed </option>
                            </select>
                 </div>
             </div>
                <div class="col-md-12">
                <div class="col-md-6">
                <@spring.bind "repairForm.repairDate"/>
                <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                </#list><br>
                <label for="dateService">Service Date</label>
            <input type="datetime-local" id="dateServ" name="date" placeholder="Select a date" value=${repairForm.repairDate!""} >
        </div>


         </div>



                <div class="col-md-12">
                <div class="col-md-6">
                <@spring.bind "repairForm.type"/>
                <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                </#list><br>
                <label for="Type of Service">Type of Service</label>
            <select id="typeServ" name="type" required>
                    <option value="true" ${long!""}>Long</option>
                    <option value="false" ${short!""}>Short</option>
            </select>
                    </div>
                <div class="col-md-6">
                <@spring.bind "repairForm.cost"/>
                <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                </#list><br>
                <label for="Cost">Service Cost</label>
            <input type="text" id="costServ" name="cost" placeholder="Type the cost of Service.." value=${repairForm.cost!""}>
                    </div>


                </div>
                &nbsp;
            <div class="serviceRegistration">
              <@spring.bind "repairForm.description"/>
                  <#list spring.status.errorMessages as error>
                  <span style="color:red">${error}</span>
              </#list><br>
            <textarea name="description" class="form-control" rows="4" id="comment" placeholder="Type comments for the service here(255 characters limit).." ></textarea>
                </div>
                <input type="submit" value="Submit"><br><br>



            </div>

        </div>

    </form>
</div>
<div class="col-md-1"></div>


</body>

</html>