<#import "/spring.ftl" as spring/>
<head>
    <title>Sign-Up/Update Form</title>
        <#include "/base_libraries/head.ftl"/>
</head>
    <body>
    <#include "/admin/menu_bar.ftl"/>

        <div class="col-md-2"></div>
        <div class="col-md-8">
        <#if member??>
        <header><h1>User Update form</h1>
        <h4>Please fill all the following fields</h4></header>
    <form action="/admin/update-user" id="updateForm" method="post" name="updateForm">

        <@spring.bind "updateForm.vat"/>
        <label for="vat">VAT</label>
            <input type="text" id="vat" name="vat" placeholder="Vat" value="${member.vat}"/><br>
        <#list spring.status.errorMessages as error>
            <span>${error}</span>
        </#list>

    <label for="firstname">First name</label>
         <input type="text" id="fname" name="firstname" placeholder="Type first name.." value="${member.firstname}"/>

    <label for="lastname">Last name</label>
         <input type="text" id="lname" name="lastname" placeholder="Type last name.." value="${member.lastname}"/><br>

    <label for="email">e-mail</label>
         <input type="email" id="email" name="email" placeholder="Type e-mail.." value="${member.getUser().getEmail()}">

    <label for="address">Address</label>
        <input type="text" id="Address" name="address" placeholder="Type address.." value="${member.address}"/><br>
<input type="hidden" name="vat_hidden" id="vat_hidden" value="${member.getUser().getUserId()}">
    <input type="submit" class="btn btn-info" value="Update">
        </form>
        <#else>
        <h3>There isn t a user with this VAT</h3>
        </#if>

<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>