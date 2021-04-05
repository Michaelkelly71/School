<html>

<head>
    <title>Insert an employee</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="stylesheet" href="assets/css/main.css" />
  
</head>

<body>
<?php
include("connection.php");
     $gender="";
     $name="";
     $email="";
     $birth_date="";
     $city="";
     $join_date="";
     $basic_pay="";
     $employee_id="";
     

     $genderErr="";
     $nameErr="";
     $emailErr="";
     $birth_dateErr="";
     $cityErr="";
     $join_dateErr="";
     $basic_payErr="";
     $employee_idErr="";
     

    if($_SERVER["REQUEST_METHOD"]=="POST"){
        if (empty($_POST["name"])) {
            $nameErr = "Name is required";
          } else {
            $name = test_input($_POST["name"]);
            // check if name only contains letters and whitespace
            if (!preg_match("/^[a-zA-Z ]*$/",$name)) {
              $nameErr = "Only letters and white space allowed"; 
            }
          }

        
         
        if (empty($_POST["gender"])) {
                $genderErr = "Gender is required";
            } else {
                $gender = test_input($_POST["gender"]);
        }
         
        if(empty($_POST["email"])){
            $emailErr = "Email is required";
        } else {
          $email = test_input($_POST["email"]);
          // check if e-mail address is well-formed
          if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            $emailErr = "Invalid email format"; 
          }
        }
         
        
        
        if (empty($_POST["city"])) {
                $cityErr = "city is required";
              } else {
                $city = test_input($_POST["city"]);
         }
         
      
         
        if (empty($_POST["basic_pay"])) {
            $basic_payErr = "pay is required";
          } else {
            $basic_pay = test_input($_POST["basic_pay"]);
         }
        
         if (empty($_POST["employee_id"])) {
            $employee_idErr = "Id is required";
          } else {
            $employee_id = test_input($_POST["employee_id"]);
         }
         
        
         if (empty($_POST["birth_date"])) {
            $birth_dateErr = "Birth Date is required";
          } else {
            $birth_date = test_input($_POST["birth_date"]);
         }
        
         if (empty($_POST["join_date"])) {
            $join_dateErr = "Date is required";
          } else {
            $join_date = test_input($_POST["join_date"]);
         }
   
         


      



                $name = $conn->real_escape_string($_POST["name"]);
                $gender = $conn->real_escape_string($_POST["gender"]);
                $join_date = $conn->real_escape_string($_POST["join_date"]);
                $birth_date = $conn->real_escape_string($_POST["birth_date"]);
                $employee_id = $conn->real_escape_string($_POST["employee_id"]);
                $basic_pay = $conn->real_escape_string($_POST["basic_pay"]);
                $city = $conn->real_escape_string($_POST["city"]);
                $email = $conn->real_escape_string($_POST["email"]);
                    
                 $sql="INSERT INTO `employee` ( `employee_id`,`name`, `gender`, `birth_date`, `city`, `email`, `join_date`, `annual_basic_pay`) 
                                        VALUES('$employee_id','$name','$gender','$birth_date','$city','$email','$join_date','$basic_pay')";
                   $success = $conn->query($sql);


                   $mysql3="Update employee SET tax = 15 where annual_basic_pay < 45916; ";
                   $mysql4="Update employee SET tax = 20.5 where annual_basic_pay > 45916 AND annual_basic_pay < 91831; ";
                   $mysql5="Update employee SET tax = 26 where annual_basic_pay < 142353 AND annual_basic_pay > 91831; ";
                   $mysql6="Update employee SET tax = 29 where annual_basic_pay < 202800 AND annual_basic_pay > 142353; ";
                   $mysql7="Update employee SET tax = 33 where annual_basic_pay > 202800; ";
                   $conn->query($mysql3);
                   $conn->query($mysql4);
                   $conn->query($mysql5);
                   $conn->query($mysql6);
                   $conn->query($mysql7);



                   
                   $my="Update employee SET tax_amount = (annual_basic_pay/12) * ((tax+100)/100);";
                   $conn->query($my);
                    $mysql2="Update employee SET monthly_pay = (annual_basic_pay/6)- tax_amount;";
                    $conn->query($mysql2);
                   
                   if(!$success && !$conn){
                       die("couldn't enter data: ".$error_log);
         
         
                   }else{
                        //redirectig to the display page. In our case, it is 
		                //header("Location: payroll.php#list");
                        
                   }
                   $conn->close();         



    }
        function test_input($data) {
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return $data;
          }
        
  ?>
  

        <!-- Header -->
        <div id="header">

            <div class="top">

                <!-- Logo -->
                <div id="logo">
                    <span class="image avatar48"><img src="images/avatar.jpg" alt="" /></span>
                    <h1 id="title">Admin</h1>
                    <p>Payroll Manager</p>
                </div>

                <!-- Nav -->
                <nav id="nav">

                    <ul>
                        <li><a href="payroll.php" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Home</span></a></li>
                        <li><a href="payroll.php" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Employee</span></a></li>
                        <li><a href="payroll.php" id="list-link" class="skel-layers-ignoreHref"><span class="icon fa-th">list</span></a></li>
                        <li><a href="payroll.php" id="payslip-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Pay Slip</span></a></li>
                    </ul>
                </nav>

            </div>


        </div>

        <!-- Main -->
        <div id="main">
            <div class="container">

                <form class="well form-horizontal" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post" id="payslip_form">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Add an Employee!</legend>

                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Employee Id</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input name="employee_id" placeholder="Employee Id" class="form-control" type="text" value="<?php echo $employee_id; ?>">
                                </div>
                            </div>
                        </div>

                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Name</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input name="name" placeholder="Employee Name" class="form-control" type="text" value="<?php echo $name; ?>">
                                </div>
                            </div>
                        </div>
                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Birth Date</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input name="birth_date" placeholder="Birth Date" class="form-control" type="date" value="<?php echo $birth_date; ?>">
                                </div>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">E-Mail</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                    <input name="email" placeholder="E-Mail Address" class="form-control" type="text" value="<?php echo $email; ?>">
                                </div>
                            </div>
                        </div>


                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Gender</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                    <select name="gender"  class="form-control" value="<?php echo $gender; ?>">
                                    <option  >Please select your Gender</option>
                          <option>Male</option>
                          <option>Female</option>
                        </select>
                                </div>
                            </div>
                        </div>

                        

                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">City</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                    <input name="city" placeholder="city" class="form-control" type="text" value="<?php echo $city; ?>">
                                </div>
                            </div>
                        </div>

                        


                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Join Date</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                    <input name="join_date" placeholder="Joining Date" class="form-control" type="date" value="<?php echo $join_date; ?>">
                                </div>
                            </div>
                        </div>


                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Annual Pay</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                    <input name="basic_pay" placeholder="Annual basic pay ($)" class="form-control" type="text" value="<?php echo $basic_pay; ?>">
                                </div>
                            </div>
                        </div>
 



                        <!-- Success message -->
                        <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> New Employee Added.</div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label"></label>
                            <div class="col-md-4">
                                <button onclick="document.location.href='payroll.php'" input type="submit" name="submit" value="Submit" >ADD <span class="glyphicon glyphicon-send"></span></button>
                            </div>
                        </div>

                    </fieldset>
                </form>
               
            </div>
        </div>
        <!-- /.container -->

       
        
        <!-- Footer -->
    <div id="footer">

        <!-- Copyright -->
        <ul class="copyright">
        <li>&copy; K&C. All rights reserved.</li>
        <li>Design: Kelly & Carey</a></li>
        </ul>

    </div>

        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/jquery.scrolly.min.js"></script>
        <script src="assets/js/jquery.scrollzer.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="assets/js/main.js"></script>
    
       
</body>
</html>