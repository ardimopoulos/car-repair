<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/serviceReg.css">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Car Repairs</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/admin">Home</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Owners<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/admin/new-customer">Create User</a></li>
                    <li><a href="/admin/search-customer">Search User</a></li>
                    <li><a href="/admin/update-customer">Edit User</a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Repairs<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/admin/new-service">Create Service</a></li>
                    <li><a href="/admin/update-service">Edit Service</a></li>
                    <li><a href="/admin/search-service">Search Service</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="/logout"> <span class="glyphicon glyphicon-log-in"></span>&nbsp; Logout</a>
            </li>
        </ul>
    </div>
</nav>
<div class="col-md-1"></div>
<div class="col-md-10">

    
       <h1>New Service Form</h1><br>
    <form action="insert.php" method="post">
        <div class="col-md-12">
            <div class="side">
                <div class="col-md-12">
                   <div class="col-md-6">
                <label for="VAT">VAT</label>
                    <input type="number" id="taxNum" name="taxNumber" placeholder="Type the VAT of the Owner.." required></div>
                <div class="col-md-6">
                <label for="dateService">Service Date</label>
            <input type="date" id="dateServ" name="dateService" placeholder="Select a date" required></div>
                <div class="col-md-6">
                 <label for="Status of Service">Status of Service</label>
            <select id="statusServ" name="statusService" required>
                    <option value="standby" selected>Waiting</option>
                    <option value="inprogress">In progress</option>
                    <option value="completed">Completed </option>
            </select>
                    </div>
             <div class="col-md-6">
                    <label for="Address">Address</label>
                        <input type="text" id="Address" name="Address" placeholder="Type address.." required>
                </div>
                </div>
                <div class="col-md-12">
                <div class="col-md-6">
                 <label for="Type of Service">Type of Service</label>
            <select id="typeServ" name="typeService" required>
                    <option value="long">Long</option>
                    <option value="short">Short</option>
            </select>
                    </div>
                <div class="col-md-6">
                <label for="Cost">Service Cost</label>
            <input type="number" id="costServ" name="serviceCost" placeholder="Type the cost of Service.." required>
                    </div>
                
              
                </div>
                &nbsp;
            <div class="serviceRegistration">
                 
            <textarea class="form-control" rows="4" id="comment" placeholder="Type comments for the service here.." ></textarea>
                </div>
                <input type="submit" value="Submit"><br><br>
                
                

            </div>

        </div>

    </form>
</div>
<div class="col-md-1"></div>


</body>

</html>