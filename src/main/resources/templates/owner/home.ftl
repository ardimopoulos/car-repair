<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>



<head>

    <title>Home</title>

        <#include "/base_libraries/head.ftl"/>

    <link rel="stylesheet" type="text/css" href="/css/style.css"/>


</head>

    <body>
    <nav class="navbar navbar-inverse">
     <div class="container-fluid">

       <ul class="nav navbar-nav navbar-right">
                     <li>
                         <a href="/logout"> <span class="glyphicon glyphicon-log-in"></span>&nbsp; Logout</a>
                     </li>
                   </ul>
     </div>
    </nav>
    <div class="container">

                     <h3>Welcome to Car Repairs</h3>
                     <br>

            <table class="table table-striped">
              <thead>
                           <tr>
                             <th>Description</th>
                             <th>Status</th>
                             <th>Date</th>
                             <th>Type</th>
                             <th>Car</th>
                           </tr>
                     </thead>
                 <tbody>
            <#if repairs??>
                <#list repairs as repair>
                           <tr align=left>
                             <td>${repair.description}</td>
                             <td><#if repair.status==0>Pending<#elseif repair.status==1>In progress<#else>Completed</#if></td>
                             <td>${repair.repairDate?datetime.iso?string("dd/MM/yyyy HH:mm:ss")}</td>
                             <td><#if repair.type == true>Big<#else>Small</#if></td>
                             <td>${repair.getVehicle().plate}</td>
                           </tr>
                </#list>
                 </tbody>
                           </table>
                           <#else>
                           There is no Service for any of your Vehicle
            </#if>
</div>
<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
</body>
</html>