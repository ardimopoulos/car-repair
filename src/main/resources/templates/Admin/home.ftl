<html>
<head>
 <title>Admin panel</title>
 <meta charset="utf-8">
 <link rel="stylesheet" type="text/css" href="style.css">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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

<!--<div class="container">
<h2>${message!""}</h2>
<h2>${errorMessage!""}</h2>


<#if username??>
<h2> Welcome, ${username}</h2>


<#else>
<h1><a href="/register">Sign Up</a></h1>
<h1><a href="/login">Log In</a></h1>
</#if>

</div>-->
<div class="container">
 <h1>Last Services </h1>

 <table class="table table-striped">
   <thead>
     <tr>
       <th>Firstname</th>
       <th>Lastname</th>
       <th>Email</th>
     </tr>
   </thead>
   <tbody>
     <tr>
       <td>John</td>
       <td>Doe</td>
       <td>john@example.com</td>
     </tr>
     <tr>
       <td>Mary</td>
       <td>Moe</td>
       <td>mary@example.com</td>
     </tr>
     <tr>
       <td>July</td>
       <td>Dooley</td>
       <td>july@example.com</td>
     </tr>
   </tbody>
 </table>
</div>

</body>
</html>