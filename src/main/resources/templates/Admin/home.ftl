
</html>

<#import "/spring.ftl" as spring/>


<head>

    <title>Sign-Up/Login Form</title>

        <#include "/base_libraries/head.ftl"/>

    <link rel="stylesheet" type="text/css" href="/css/style.css"/>


</head>


    <body>

    <#include "/Admin/menu_bar.ftl"/>

          </div>-->
          <div class="container">
           <h1>Last Services </h1>

           <table class="table table-striped">
             <thead>
               <tr>
                 <th>Firstname</th>
                 <th>Lastname</th>
                 <th>Email</th>
               </tr>
             </thead>
             <tbody>
               <tr>
                 <td>John</td>
                 <td>Doe</td>
                 <td>john@example.com</td>
               </tr>
               <tr>
                 <td>Mary</td>
                 <td>Moe</td>
                 <td>mary@example.com</td>
               </tr>
               <tr>
                 <td>July</td>
                 <td>Dooley</td>
                 <td>july@example.com</td>
               </tr>
             </tbody>
           </table>


<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>
