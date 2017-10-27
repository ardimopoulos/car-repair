<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
<title>Add user</title>

     <#include "/base_libraries/head.ftl"/>
     <link rel="stylesheet" type="text/css" href="/css/newCustomer.css">
</head>
<body>
<#include "/admin/menu_bar.ftl"/>

    <div class="col-md-1"></div>
    <div class="col-md-10">
       <h1>User Registration Form</h1><br>
        <form action="/admin/create-user" id="mainForm" method="post" name="userForm" onsubmit="return passValidation()">

            <div class="col-md-12">
                <div class="side">
                <span style="color: #4CAF50; font-weight: bold; font-size:14px">${message!""}</span>
                <span style="color: red; font-weight: bold; font-size:14px">${errorMessage!""}</span>
                    <div class="col-md-12">
                   <div class="col-md-6">
                    <@spring.bind "userForm.firstname"/>
                     <#list spring.status.errorMessages as error>
                          <span style="color:red">${error}</span>
                     </#list><br/>
                    <label for="firstname">First name</label>
                         <input type="text" id="fname" name="firstname" placeholder="Type first name.." value="${userForm.firstname!""}"/>
                        </div>
                    <div class="col-md-6">
                    <@spring.bind "userForm.lastname"/>
                    <#list spring.status.errorMessages as error>
                        <span style="color:red">${error}</span>
                     </#list><br/>
                    <label for="lastname">Last name</label>
                         <input type="text" id="lname" name="lastname" placeholder="Type last name.." value="${userForm.lastname!""}"/><br>
                        </div>
                    <div class="col-md-6">
                    <@spring.bind "userForm.vat"/>
                    <#list spring.status.errorMessages as error>
                         <span style="color:red">${error}</span>
                    </#list><br/>
                     <label for="vat">VAT</label>
                            <input type="text" id="TaxNum" name="vat" placeholder="Type vat.." value="${userForm.vat!""}"/><br>
                        </div>
                    <div class="col-md-6">
                    <label for="UserType">User Type</label>
                    <select id="UserType" name="UserType">
                        <option value="true" ${admin!""}>Admin</option>
                        <option value="false" ${simple!""}>Simple user</option>
                    </select>
                    </div>
                    </div>
                    <div class="col-md-12">
                    <div class="col-md-6">
                    <@spring.bind "userForm.password"/>
                    <#list spring.status.errorMessages as error>
                         <span style="color:red">${error}</span>
                    </#list><br/><span style="color:red" id="UserP_error"></span>
                    <br/>
                        <label for ="password">User password</label>
                        <input type="password" id="UserP" name="password" placeholder="Set new password.." onkeyup="passValidation()"/>
                        </div>
                    <div class="col-md-6">
                    <label for="configpassword">Confirm password</label>
        <input type="password" id="ConfPass" name="configpassword" placeholder="Confirm password number.." onkeyup=""passValidation()"></div>
           <span id="UserP_error"></span></div>
            <div class="col-md-12">
    <div class="col-md-6">
                    <@spring.bind "userForm.address"/>
                    <#list spring.status.errorMessages as error>
                       <span style="color:red">${error}</span>
                    </#list><br/>
                    <label for="address">Address</label>
                    <input type="text" id="Address" name="address" placeholder="Type address.." value="${userForm.address!""}"/>
                    </div>
        <div class="col-md-6">
                    <@spring.bind "userForm.email"/>
                    <#list spring.status.errorMessages as error>
                       <span style="color:red">${error}</span>
                    </#list><br/>
                        <label for="email">E-mail</label>
                             <input type="email" id="email" name="email" placeholder="Type e-mail.." value="${userForm.email!""}">
         </div>
         <div class="col-md-8">
          <@spring.bind "userForm.addVehicle"/>
                <label for="vehicle">Add vehicle</label> <input type="checkbox" name="addVehicle" value="true" ${checked!""     }>
            </div>
                    </div>
                    &nbsp;<br>
                    <input type="submit" value="Submit"><br><br>
                 </div>
            </div>
        </form>
    </div>
    <div class="col-md-1">
    </div>



    </body>
    <#include "/base_libraries/footer.ftl"/>
    <#include "/base_libraries/js.ftl"/>
    <script type="text/javascript" src="/js/PasswordValidation.js"></script>
    </html>