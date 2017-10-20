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
    <div class="col-md-1"></div>
    <div class="col-md-10">


            <h1>User registration form</h1>
            <h4>Please fill all the following fields</h4>

        <#if userId??>
        <a href="/admin/create-vehicle?id=${userId!""}">Go to vehicle form</a>
        ${message!""}
        </#if>
        <form action="/admin/create-user" id="mainForm" method="post" name="userForm">
            <div class="col-md-12">
                <div class="side">
                    <div class="col-md-12">
                   <div class="col-md-6">
                    <@spring.bind "userForm.firstname"/>
                    <label for="firstname">First name</label>
                         <input type="text" id="fname" name="firstname" placeholder="Type first name.." value="${userForm.firstname!""}"/>
                    <#list spring.status.errorMessages as error>
                             <span style="color:red">${error}</span>
                        </#list>
                        </div>
                    <div class="col-md-6">
                    <@spring.bind "userForm.lastname"/>
                    <label for="lastname">Last name</label>
                         <input type="text" id="lname" name="lastname" placeholder="Type last name.." value="${userForm.lastname!""}"/><br>
                    <#list spring.status.errorMessages as error>
                         <span style="color:red">${error}</span>
                    </#list>
                        </div>
                    <div class="col-md-6">
                     <label for="vat">VAT</label>
                         <@spring.bind "userForm.vat"/>
                            <input type="text" id="TaxNum" name="vat" placeholder="Type vat.." value="${userForm.vat!""}"/><br>
                            <#list spring.status.errorMessages as error>
                                <span style="color:red">${error}</span>
                                </#list>
                        </div>
                    <div class="col-md-6">
                    <label for="UserType">User Type</label>
                    <select id="UserType" name="UserType">
                        <option value="dis" disabled selected>---</option>
                        <option value="Admin">Admin</option>
                        <option value="Simple User">Simple user</option>
                    </select>
                    </div>
                    </div>
                    <div class="col-md-12">
                    <div class="col-md-6">
                    <@spring.bind "userForm.password"/>
                        <label for ="password">User password</label>
                        <input type="text" id="UserP" name="password" placeholder="Set new password.." />
                        <#list spring.status.errorMessages as error>
                <span style="color:red">${error}</span>
                            </#list></div>
                    <div class="col-md-6">
                    <label for="configpassword">Confirm password</label>
        <input type="text" id="ConfPass" name="configpassword" placeholder="Confirm password number.." required /></div>
    <div class="col-md-6">
                    <@spring.bind "userForm.address"/>
                    <label for="address">Address</label>
                    <input type="text" id="Address" name="address" placeholder="Type        address.." value="${userForm.address!""}"/><br>
                    <#list spring.status.errorMessages as error>
                        <span style="color:red">${error}</span>
                            </#list>
                    </div>
        <div class="col-md-6">
                    <@spring.bind "userForm.email"/>
                        <label for="email">e-mail</label>
                             <input type="email" id="email" name="email" placeholder="Type e-mail.." value="${userForm.email!""}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <#list spring.status.errorMessages as error>
                             <span style="color:red">${error}</span>
                        </#list>
                        </div>
                    </div>
                    &nbsp;<br>
                    <input type="submit" value="Submit"><br><br>
                    Select if you want to add vehicle :
                    <input type="button" value="Open vehicle form " onclick="openWin()">


                </div>

            </div>

        </form>
    </div>
    <div class="col-md-1"></div>


    </body>

    </html>
