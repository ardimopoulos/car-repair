<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>



<head>

    <title>Home</title>

        <#include "/base_libraries/head.ftl"/>

    <link rel="stylesheet" type="text/css" href="/css/style.css"/>


</head>

    <body>
    <div class="container">
             <header>
                     <h1>Welcome to Car Repairs</h1>
                     </header>
<table class="table">
              <thead>
                           <tr>
                             <th>Description</th>
                             <th>Status</th>
                             <th>Date</th>
                             <th>Type</th>
                             <th>Time</th>
                             <th>Car</th>
                           </tr>
                     </thead>
                 <tbody>
            <#if repairs??>
                <#list repairs as repair>
                           <tr>
                             <td>${repair.description}</td>
                             <td><#if repair.status==0>Not Done<#elseif repair.status==1>Stand By<#else>Done</#if></td>
                             <td>${repair.repairDate}</td>
                             <td><#if repair.type>Big<#else>Small</#if></td>
                             <td>Not done Yet</td>
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