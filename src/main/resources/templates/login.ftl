<#import "/spring.ftl" as spring/>


<head>

    <title>Sign-Up/Login Form</title>

        <#include "/base_libraries/head.ftl"/>

    <link rel="stylesheet" type="text/css" href="css/style.css">


</head>

    <body>
             <header>
                     <h1>Welcome to Car Repairs</h1>
                     </header>
                     <h2>${message!""}</h2>

                     <h2 style="color: red;">${errorMessage!""}</h2>

             <div class="row"  >
                 <div class="col-md-2"></div>
                 <div class="col-md-8">
                       <form name="loginForm" action="/login"  method="post" >
                         <div class="login">
                          <!-- <label for="username">Email:</label>-->
                           <input type="email" class="form-control"  id="username" placeholder="Enter email" autocomplet="off" name="username" required/><br>

                          <!-- <label for="password">Password:</label> -->
                           <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required/><br>
                         </div>
                           <button type="submit" class="btn">Let me in!</button>
                       </form>
                     </div>
                 </div>
            <div class="col-md-2"></div>

<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
    </body>
