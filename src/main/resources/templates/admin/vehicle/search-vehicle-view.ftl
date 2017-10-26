<#import "/spring.ftl" as spring/>
<head>
    <title>Search Form</title>
        <#include "/base_libraries/head.ftl"/>
        <link rel="stylesheet" type="text/css" href="/css/searchFormsStyle.css"/>
</head>
    <body>
    <#include "/admin/menu_bar.ftl"/>

            <div class = "container">

               <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
               <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                 <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Vat</a>
                </li>
               <li class="nav-item">
                 <a class="nav-link" id="v-pills-plate-tab" data-toggle="pill" href="#v-pills-plate" role="tab" aria-controls="v-pills-plate" aria-selected="false">Plate</a>
                </li>

               </div>
               <form action="/admin/search-vehicle" method="POST" id="vehicleSearchForm" name = "vehicleSearchForm">
               <br>
               <div class="tab-content" id="v-pills-tabContent">
                 <div class="tab-pane fade" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <input type="text" class="form-control" id="vat" placeholder="Enter vat" name="vat" /><br>

                    <input type="submit" class="btn btn-info" name="button" value="Search Vat">

                </div>
                 <div class="tab-pane fade" id="v-pills-plate" role="tabpanel" aria-labelledby="v-pills-plate-tab">
                        <input type="text" class="form-control" id="plate" placeholder="Enter plate" name="plate" /><br>

                    <input type="submit" class="btn btn-info" name="button" value="Search Plate">

                </div>


                </form>

</div>
<#if errorMessage??>
<div class="col-md-10">
<div class="alert alert-danger" role="alert">
 ${errorMessage}
</div>
</div>
</#if>
<hr>
<#if vehicles??>
<div class="col-md-10">



<table class="table" id="myTable">
   <tr>
   <th>Brand</th>
   <th>Model</th>
     <th>Color</th>
     <th>Plate</th>
     <th>Year</th>
     <th>First name</th>
     <th>Last name</th>
   </tr>
   <#list vehicles as vehicle>
                  <tr>
                    <td>${vehicle.brand}</td>
                    <td>${vehicle.model}</td>
                    <td>${vehicle.color}</td>
                     <td>${vehicle.plate}</td>
                    <td>${vehicle.year?substring(7)}</td>
                    <td>${vehicle.getMember().getFirstname()}</td>
                    <td>${vehicle.getMember().getLastname()}</td>

    <th><a href="/admin/edit-vehicle?p=${vehicle.plate}"><button type="button" class="btn btn-info">Edit</button></a></th>

    <form action ="/admin/delete-vehicle" name="deleteForm" id ="deleteForm" method="POST">
        <input type="hidden" name="hidden_vehicleId" id="hidden_vehicleId" value="${vehicle.vehicleId}">
    <th><input type="submit" class="btn btn-danger" value="Delete"></th>
    </form>
  </tr>
  </#list>
</table>
</#if>


<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>

    </body>