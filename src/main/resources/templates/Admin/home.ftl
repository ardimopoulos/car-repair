
</html>

<#import "/spring.ftl" as spring/>
<head>
    <title>Sign-Up/Login Form</title>
        <#include "/base_libraries/head.ftl"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
    <body>
    <#include "/Admin/menu_bar.ftl"/>
<div class="container">
    <table class="table table-striped">

   <h1>Last Services </h1>
         <thead>
               <tr>
                 <th>Description</th>
                 <th>Status</th>
                 <th>Date</th>
                 <th>Type</th>
                 <th>Time</th>
                 <th>Name</th>
               </tr>
         </thead>
     <tbody>
<#if services??>
    <#list services as service>
               <tr>
                 <td>${service.description}</td>
                 <td><#if service.status==0>Not Done<#elseif service.status==1>Stand By<#else>Done</#if></td>
                 <td>${service.date}</td>
                 <td><#if service.type>Big<#else>Small</#if></td>
                 <td>${service.time}</td>
                 <td>Note done yet</td>
               </tr>
    </#list>
     </tbody>
               </table>
               <#else>
               There is no Service for today
</#if>

</div>
<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>
