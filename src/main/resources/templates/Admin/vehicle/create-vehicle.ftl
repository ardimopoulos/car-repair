<#import "/spring.ftl" as spring/>
<html>
<head>
<title>Add user</title>
    <#include "/base_libraries/head.ftl"/>
</head>

<body>
<#include "/admin/menu_bar.ftl"/>

<h1> </h2>
<h4>${message!""}</h4>
<form action="/admin/create-vehicle" id="mainForm" method="post" name="vehicleForm">
<#if userId??>
<@spring.bind "vehicleForm.userId"/>
     <input type="hidden" id="fname" name="userId" value="${userId!""}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
         <span style="color:red">${error}</span>
    </#list><br>
<#else>
<@spring.bind "vehicleForm.vat"/>
<label for="vat">VAT</label>
     <input type="text" id="fname" name="vat" placeholder="Type vat.." value="${vehicleForm.vat!""}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
         <span style="color:red">${error}</span>
    </#list><br>
</#if>
<@spring.bind "vehicleForm.plate"/>
<label for="plate">Plate</label>
     <input type="text" id="fname" name="plate" placeholder="Type plate.." value="${vehicleForm.plate!""}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
         <span style="color:red">${error}</span>
    </#list><br>

<@spring.bind "vehicleForm.brand"/>
<label for="brand">Brand</label>
     <input type="text" id="lname" name="brand" placeholder="Type brand.." value="${vehicleForm.brand!""}"/><br>
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>

<@spring.bind "vehicleForm.model"/>
<label for="model">Model</label>
     <input type="text" id="email" name="model" placeholder="Type model.." value="${vehicleForm.model!""}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>

<@spring.bind "vehicleForm.color"/>
<label for ="color">Color</label>
    <input type="text" id="UserP" name="color" placeholder="color.." value="${vehicleForm.color!""}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>

<@spring.bind "vehicleForm.yearOfModel"/>
<label for="address">Year</label>
    <input type="text" id="Address" name="yearOfModel" placeholder="Type address.." value="${vehicleForm.yearOfModel!""}"/><br>
<#list spring.status.errorMessages as error>
     <span style="color:red">${error}</span>
</#list><br>
<!--<label for="TaxNum">Plate number</label>
    <input type="text" id="platenum" name="platenum" placeholder="Type plate number.." /><br>-->

    <input type="submit" value="Submit">
    </form>
</body>

</html>