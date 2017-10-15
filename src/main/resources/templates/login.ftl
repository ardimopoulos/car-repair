<#import "/spring.ftl" as spring/>


<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

    <body>
             <header>
                     <h1>Welcome to Car Repairs</h1>
                     </header>
                     <h2>${message!""}</h2>
                     <#if username??>
                     <h1> Welcome, ${username!"guest"}</h1>
                     <h1> Welcome, ${type!"guest"}</h1>
                     <h2><a href="/logout">Logout</a></h2>
                     <#else>
                     <h1><a href="/register">Sign Up</a></h1>
                     <h1><a href="/login">Log In</a></h1>
                     </#if>

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

         <footer>Copyright Coding School - Team 10</footer>
    </body>
