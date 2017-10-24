
</html>

<#import "/spring.ftl" as spring/>
<head>
    <title>Sign-Up/Login Form</title>
        <#include "/base_libraries/head.ftl"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
    <body>
    <#include "/admin/menu_bar.ftl"/>
<div class="container">
    <table id="myTable" class="table table-striped">


   <h1>Our daily Services </h1>
        <div class="search">
            &nbsp;&nbsp; <i class="glyphicon glyphicon-search"></i>

            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Type in to search">
            <button type="button" class="but">Search</button>
            <br>
            <br>
            <script>
                function myFunction() {
                    var input, filter, table, tr, td;
                    input = document.getElementById("myInput");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("myTable");
                    tr = table.getElementsByTagName("tr");
                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[5];



                        if (td) {
                            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }

            </script>


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
<#if repairs??>
    <#list repairs as repair>
               <tr>
                 <td>${repair.description}</td>
                 <td><#if repair.status==0>Not Done<#elseif repair.status==1>Stand By<#else>Done</#if></td>
                 <td>${repair.repairDate}</td>
                 <td><#if repair.type>Big<#else>Small</#if></td>
                 <td>Note done yet</td>
                   <td>${repair.getVehicle().getMember().getFirstname()}</td>
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
