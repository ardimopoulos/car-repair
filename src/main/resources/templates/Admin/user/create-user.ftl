<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/style.css">
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
                   <li><a href="#">Create Service</a></li>
                   <li><a href="#">Edit Service</a></li>
                   <li><a href="#">Search Service</a></li>
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

    <div class="vehicleRegistration">
    <div class="col-md-2"></div>
    <div class="col-md-8">
    <header><h1>User registration form</h1>
    <h4>Please fill all the following fields</h4></header>
<div class="side">
<form action="/admin/user/create-user" id="mainForm" method="post" name="userForm">
    <label for="vat">VAT</label>
    <@spring.bind "userForm.vat"/>
    <input type="text" id="TaxNum" name="vat" placeholder="Type vat.." value="${userForm.vat!""}"/><br>
    <#list spring.status.errorMessages as error>
         <span style="color:red">${error}</span>
    </#list><br>

<@spring.bind "userForm.firstname"/>
<label for="firstname">First name</label>
     <input type="text" id="fname" name="firstname" placeholder="Type first name.." value="${userForm.firstname!""}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
         <span style="color:red">${error}</span>
    </#list><br>

<@spring.bind "userForm.lastname"/>
<label for="lastname">Last name</label>
     <input type="text" id="lname" name="lastname" placeholder="Type last name.." value="${userForm.lastname!""}"/><br>
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>

<@spring.bind "userForm.email"/>
<label for="email">e-mail</label>
     <input type="email" id="email" name="email" placeholder="Type e-mail.." value="${userForm.email!""}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>

    <label for="UserType">User Type</label>
<select id="UserType" name="UserType" required>
    <!--<option value="disabled selected">-</option>-->
    <option value="true" selected>Admin</option>
    <option value="false">Simple user</option>
</select><br>

<@spring.bind "userForm.password"/>
<label for ="password">User password</label>
    <input type="text" id="UserP" name="password" placeholder="Set new password.." />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>


<label for="configpassword">Confirm password</label>
    <input type="text" id="ConfPass" name="configpassword" placeholder="Confirm password number.." />
            <br>
<@spring.bind "userForm.address"/>
<label for="address">Address</label>
    <input type="text" id="Address" name="address" placeholder="Type address.." value="${userForm.address!""}"/><br>
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>
<!--<label for="TaxNum">Plate number</label>
    <input type="text" id="platenum" name="platenum" placeholder="Type plate number.." /><br>-->

    <!-- Choose if you want to add a vehicle:<br>
<a href="tsertsrtete.html"><button>Go to vehicle form</button></a> !-->
    <input type="submit" value="Submit">
    </form>
  <script>
     $("#signupForm").validate();
  </script>
${message!""}
    </div>
    </div>
    </div>
<div class="col-md-2">
    </div>

</body>
</html>
