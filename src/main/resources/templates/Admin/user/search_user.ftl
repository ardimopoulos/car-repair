<#import "/spring.ftl" as spring/>
<head>
    <title>Sign-Up/Search Form</title>
        <#include "/base_libraries/head.ftl"/>
</head>
    <body>
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

</div>
<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>