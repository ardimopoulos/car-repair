
</html>

<#import "/spring.ftl" as spring/>


<head>

    <title>Sign-Up/Login Form</title>

        <#include "/base_libraries/head.ftl"/>

    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
    <body>
    <#include "/Admin/menu_bar.ftl"/>

    <table class="table table-striped">
    <div class="container">
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
                 <td>${service.status}</td>
                 <td>${service.date}</td>
                 <td>${service.type}</td>
                 <td>${service.time}</td>
                 <td>Note done yet</td>
               </tr>
    </#list>
     </tbody>
               </table>
</#if>
</div>
<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>
