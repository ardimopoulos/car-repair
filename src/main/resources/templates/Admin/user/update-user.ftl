<#import "/spring.ftl" as spring/>
<head>
    <title>Sign-Up/Update Form</title>
        <#include "/base_libraries/head.ftl"/>
</head>
    <body>
    <#include "/admin/menu_bar.ftl"/>
    ${member.firstname}

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


</div>
<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>