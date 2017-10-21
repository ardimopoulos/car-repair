<#import "/spring.ftl" as spring/>
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="/css/newCustomer.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
             crossorigin="anonymous">
    </script>
    <script src="/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/Userreg222.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
    <body>
    <nav class="navbar navbar-inverse">
     <div class="container-fluid">
       <div class="navbar-header">
         <a class="navbar-brand" href="#">Car Repairs</a>
       </div>
       <ul class="nav navbar-nav">
         <li class="active"><a href="/admin">Home</a></li>
         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Users<span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="/admin/create-user">Create User</a></li>
             <li><a href="/admin/search-user">Search User</a></li>
             <li><a href="/admin/edit-user">Edit User</a></li>

           </ul>
         </li>
         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Repairs<span class="caret"></span></a>
                 <ul class="dropdown-menu">
                        <li><a href="/admin/new-service">Create Service</a></li>
                        <li><a href="/admin/update-service">Edit Service</a></li>
                        <li><a href="/admin/search-service">Search Service</a></li>
                 </ul>
               </li>

       </ul>
       <ul class="nav navbar-nav navbar-right">
                     <li>
                         <a href="/"> <span class="glyphicon glyphicon-log-in"></span>&nbsp; Logout</a>
                     </li>
                   </ul>
     </div>
    </nav>
 <script>
         function myFunction() {
             var pass1 = document.getElementById("UserP").value;
             var pass2 = document.getElementById("ConfPass").value;
             if (pass1 != pass2) {
                 //alert("Passwords Do not match");
                 document.getElementById("UserP").style.borderColor = "#E34234 ";
                 document.getElementById("ConfPass").style.borderColor = "#E34234 ";
             } else {
                 document.getElementById("UserP").style.borderColor = "#33cc33";
                 document.getElementById("ConfPass").style.borderColor = "#33cc33 ";
             } {
                 var pass1 = document.getElementById("UserP").value;
                 var pass2 = document.getElementById("ConfPass").value;
                 var ok = true;
                 if (pass1 != pass2) {
                     //alert("Passwords Do not match");
                     document.getElementById("UserP").style.borderColor = "#E34234 ";
                     document.getElementById("ConfPass").style.borderColor = "#E34234 ";
                     ok = false;
                 } else {
                     document.getElementById("UserP").style.borderColor = "#33cc33 ";
                     document.getElementById("ConfPass").style.borderColor = "#33cc33 ";
                 }
                 return ok;
             }
         }

     </script>
    <div class="userForm">
    <div class="col-md-1"></div>
    <div class="col-md-10">
    <#if userId??>
    <a href="/admin/create-vehicle?id=${userId!""}">Go to vehicle form</a>
    ${message!""}
    </#if>
    <h1>User registration form</h1>

    <form action="/admin/create-user" id="mainForm" method="post" name="userForm" onsubmit="return myFunction()">
     <div class="col-md-12">

            <div class="col-md-12">
            <div class="side">
            <h4>Please fill all the following fields:</h4>
                <div class="col-md-6">
                     <label for="vat">VAT</label>
                         <@spring.bind "userForm.vat"/>
                    <input type="number" id="TaxNum" name="vat" placeholder="Type vat.." value="${userForm.vat!""}"/>

                     <#list spring.status.errorMessages as error>
                     <span style="color:red">${error}</span>
                        </#list>
                 </div>
                    <div class="col-md-6">

                                 <@spring.bind "userForm.email"/>
                                 <label for="email">e-mail</label>
                                  <input type="email" id="email" name="email" placeholder="Type e-mail.." value="${userForm.email!""}">
                                    <#list spring.status.errorMessages as error>
                                  <span style="color:red">${error}</span>
                             </#list>
                             </div>

                <div class="col-md-6">
                    <@spring.bind "userForm.lastname"/>
                    <label for="lastname">Last name</label>
                    <input type="text" id="lname" name="lastname" placeholder="Type last name.." value="${userForm.lastname!""}"/>
                    <#list spring.status.errorMessages as error>
                    <span style="color:red">${error}</span>
                    </#list>

                </div>
             <div class="col-md-6">
                                 <@spring.bind "userForm.firstname"/>
                             <label for="firstname">First name</label>
                             <input type="text" id="fname" name="firstname" placeholder="Type first name.." value="${userForm.firstname!""}"/>
                             <#list spring.status.errorMessages as error>s
                                  <span style="color:red">${error}</span>
                              </#list>
                              </div>
                <div class="col-md-6">

                    <label for="UserType">User Type</label>

                    <select id="UserType" name="UserType" required>
                    <!--<option value="disabled selected">-</option>-->
                    <option value="true" selected>Admin</option>
                    <option value="false">Simple user</option>
                        </select>
                </div>
                <div class="col-md-6">

                <@spring.bind "userForm.password"/>
                    <label for ="password">User password</label>
                   <input type="text" id="UserP" name="password" placeholder="Set new password.." />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list></div>
        <div class="col-md-6">

            <@spring.bind "userForm.address"/>
            <label for="address">Address</label>
             <input type="text" id="Address" name="address" placeholder="Type address.." value="${userForm.address!""}"/><br>
            <#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list></div>
                <div class="col-md-6">

                  <label for="configpassword">Confirm password</label>
                 <input type="text" id="ConfPass" name="configpassword" placeholder="Confirm password number.." />
            </div>

<!--<label for="TaxNum">Plate number</label>
    <input type="text" id="platenum" name="platenum" placeholder="Type plate number.." /><br>-->
<br>
    <input type="submit" value="Submit" >
     </div>
     </div>
    </form>
  <script>
     $("#signupForm").validate();
  </script>



    </div>
    </div>
<div class="col-md-1"></div>

</body>
</html>
