<#import "/spring.ftl" as spring/>
<head>
    <title>Sign-Up/Search Form</title>
        <#include "/base_libraries/head.ftl"/>
</head>
    <body>
    <#include "/Admin/menu_bar.ftl"/>
            <#if errorMessage??>
            <div class="container">
            <div class="alert alert-danger" role="alert">
             ${errorMessage}
            </div>
            </div>
            </#if>
            <div class = "container">

               <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
               <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                 <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Vat</a>
                </li>
               <li class="nav-item">
                 <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Date</a>
                </li>
                <li class="nav-item">
                 <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Plate</a>
                 </li>
                 <li class="nav-item">
                  <a class="nav-link" id="v-pills-dates-tab" data-toggle="pill" href="#v-pills-dates" role="tab" aria-controls="v-pills-dates" aria-selected="false">Between Dates</a>
                  </li>

               </div>
               <form action="/admin/search-repair" method="POST" id="repairSearchForm" name = "repairSearchForm">
               <div class="tab-content" id="v-pills-tabContent">
                 <div class="tab-pane fade" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <@spring.bind "repairSearchForm.vat"/>
                        <input type="text" class="form-control" id="vat" placeholder="Enter vat" name="vat" /><br>
                    <#list spring.status.errorMessages as error>
                        <span>${error}</span>
                    </#list>

                    <input type="submit" class="btn btn-info" name="button" value="Search Vat">

                </div>
                 <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                    <@spring.bind "repairSearchForm.date"/>
                        <input type="text" class="form-control" id="date" placeholder="Enter date" name="date" /><br>
                    <#list spring.status.errorMessages as error>
                        <span>${error}</span>
                    </#list>

                    <input type="submit" class="btn btn-info" name="button" value="Search Date">

                </div>
                 <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                    <@spring.bind "repairSearchForm.plate"/>
                        <input type="text" class="form-control" id="plate" placeholder="Enter plate" name="plate" /><br>
                    <#list spring.status.errorMessages as error>
                        <span>${error}</span>
                    </#list>

                    <input type="submit" class="btn btn-info" name="button" value="Search Plate">

                </div>
                <div class="tab-pane fade" id="v-pills-dates" role="tabpanel" aria-labelledby="v-pills-dates-tab">
                    <div class="col-md-6">
                        <@spring.bind "repairSearchForm.startDate"/>
                            <input type="text" class="form-control" id="startDate" placeholder="Enter Start Date" name="startDate" /><br>
                        <#list spring.status.errorMessages as error>
                            <span>${error}</span>
                        </#list>
                    </div>
                    <div class="col-md-6">
                        <@spring.bind "repairSearchForm.beforeDate"/>
                            <input type="text" class="form-control" id="beforeDate" placeholder="Enter Before Date" name="beforeDate" /><br>
                        <#list spring.status.errorMessages as error>
                            <span>${error}</span>
                        </#list>
                    </div>
                    <input type="submit" class="btn btn-info" name="button" value="Search Between">

                </div>

                </form>

</div>

<hr>
<#if repairs??>
<div class="container">
<table class="table">
   <tr>
   <th>Date</th>
     <th>Description</th>
     <th>Status</th>
     <th>Time</th>
     <th>Type</th>
     <th>User</th>
   </tr>
   <#list repairs as repair>
                  <tr>
                    <td>${repair.date}</td>
                    <td>${repair.description}</td>
                    <td><#if repair.status==0>Not Done<#elseif repair.status==1>Stand By<#else>Done</#if></td>
                     <td>${repair.time}</td>
                    <td><#if repair.type>Big<#else>Small</#if></td>
                    <td>${repair.getMember().getFirstname()}</td>

    <th><a href="/admin/edit-repair"><button type="button" class="btn btn-info">Edit</button></a></th>
    </form>
    <form action ="/admin/delete-repair" name="deleteForm" id ="deleteForm" method="POST">
        <input type="hidden" name="hidden_email" id="hidden_email" value="">
    <th><input type="submit" class="btn btn-danger" value="Delete"></th>
    </form>
  </tr>
  </#list>
</table>
</#if>


<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>