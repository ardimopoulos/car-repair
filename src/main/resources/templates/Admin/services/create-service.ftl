<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>

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


       <h1>New Service Form</h1><br>
    <form action="insert.php" method="post" name="repairForm">
        <div class="col-md-12">
            <div class="side">
                <div class="col-md-12">
                   <div class="col-md-6">
                <@spring.bind "repairForm.vat"/>
                <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                </#list>
                <label for="VAT">VAT</label>
                    <input type="number" id="taxNum" name="vat" placeholder="Type the VAT of the Owner.." value=${repairForm.vat!""}>
                <br/>
                </div>
                <div class="col-md-6">
                <@spring.bind "repairForm.date"/>
                <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                </#list>
                <label for="dateService">Service Date</label>
            <input type="datetime-local" id="dateServ" name="date" placeholder="Select a date" value=${repairForm.date!"" ></div>

                </div>

                 <div class="col-md-6">
                                 <@spring.bind "repairForm.status"/>
                                <#list spring.status.errorMessages as error>
                                    <span style="color:red">${error}</span>
                                </#list>
                                 <label for="Status of Service">Status of Service</label>
                            <select id="statusServ" name="status" >
                                    <option value="Stand by" selected>Pending</option>
                                    <option value="in progress">In progress</option>
                                    <option value="Completed">Completed </option>
                            </select>
                 </div>

                <div class="col-md-12">
                <div class="col-md-6">
                <@spring.bind "repairForm.type"/>
                <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                </#list>
                <label for="Type of Service">Type of Service</label>
            <select id="typeServ" name="type" required>
                    <option value="true">Long</option>
                    <option value="false">Short</option>
            </select>
                    </div>
                <div class="col-md-6">
                <@spring.bind "repairForm.cost"/>
                <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                </#list>
                <label for="Cost">Service Cost</label>
            <input type="number" id="costServ" name="cost" placeholder="Type the cost of Service.." value=${repairForm.cost!"">
                    </div>
                
              
                </div>
                &nbsp;
            <div class="serviceRegistration">
              <@spring.bind "repairForm.description"/>
                  <#list spring.status.errorMessages as error>
                  <span style="color:red">${error}</span>
              </#list>
            <textarea name="description" class="form-control" rows="4" id="comment" placeholder="Type comments for the service here.." value=${repairForm.description!"">
            </textarea>
                </div>
                <input type="submit" value="Submit"><br><br>
                
                

            </div>

        </div>

    </form>
</div>
<div class="col-md-1"></div>


</body>

</html>