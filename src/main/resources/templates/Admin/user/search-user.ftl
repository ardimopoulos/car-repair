<#import "/spring.ftl" as spring/>
<head>
    <title>Sign-Up/Search Form</title>
        <#include "/base_libraries/head.ftl"/>
</head>
    <body>
    <h4>${errormessage!""}</h4>
    <#include "/admin/menu_bar.ftl"/>
             <header>
             <div class="row"  >
                 <div class="col-md-2"></div>
                 <div class="col-md-8">
                       <form name="searchForm" action="/admin/search-user"  method="post" >
                          <!-- <label for="vat">VAT:</label>-->
                           <input type="text" class="form-control"  id="vat" placeholder="Enter VAT" autocomplet="off" name="vat" /><br>

                          <!-- <label for="email">Email:</label> -->
                           <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" /><br>
                           <button type="submit" class="btn">Search</button>
                        </form>

                 </div>
            <div class="col-md-2"></div>

<#if member??>
            <div>
            <ul>
                <li>${member.vat}</li>
                <li>${member.firstname}</li>
                <li>${member.lastname}</li>
                <li>${member.email}</li>
                <li><a href="/admin/edit-user?v=${member.vat}">edit</a></li>
                <li><a href="/admin/delete-user?v=${member.vat}">delete</a></li>
            </ul>
            </div>
</#if>

</div>
<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>