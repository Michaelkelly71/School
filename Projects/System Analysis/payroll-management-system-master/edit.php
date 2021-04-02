<?php
// including the database connection file
include_once("connection.php");

if(isset($_POST['update']))
{	

	$employee_id = mysqli_real_escape_string($conn, $_POST['employee_id']);
	
	$name = mysqli_real_escape_string($conn, $_POST['name']);
	$gender = mysqli_real_escape_string($conn, $_POST['gender']);
	$email = mysqli_real_escape_string($conn, $_POST['email']);	
    $city = mysqli_real_escape_string($conn, $_POST['city']);
    $birth_date = mysqli_real_escape_string($conn, $_POST['birth_date']);
    $join_date = mysqli_real_escape_string($conn, $_POST['join_date']);
    $basic_pay = mysqli_real_escape_string($conn, $_POST['basic_pay']);

    
	// checking empty fields
	if(empty($name) || empty($gender) || empty($email) || empty($city) || 
    empty($birth_date) || empty($join_date) || empty($basic_pay) || empty($employee_id)) {	
			
		
			echo "<font color='red'>field is empty.</font><br/>";
	
			
	} else {	
		//updating the table
		$result = mysqli_query($conn, "UPDATE employee SET name='$name',
        gender='$gender',email='$email',birth_date='$birth_date'
        ,join_date='$join_date',birth_date='$birth_date',annual_basic_pay='$basic_pay' 
        WHERE employee_id=$employee_id");
		
		//redirectig to the display page. In our case, it is 
		header("Location: payroll.php#list");
	}
}
?>
<?php
//getting id from url
$employee_id = $_GET['employee_id'];

//selecting data associated with this particular id
$result = mysqli_query($conn, "SELECT * FROM employee WHERE employee_id=$employee_id");

//echo "<table><tr><th>ID</th><th>Name</th><th>E-mail</th><th>Gender</th><th>Birth Date</th><th>Website</th><th>Address</th><th>Province</th><th>Zip Code</th><th>City</th><th>Join Date</th><th>Annual Basic Pay</th></tr>";

while($res = mysqli_fetch_array($result))
{
    $employee_id = $res['employee_id'];
	$name = $res['name'];
	$gender = $res['gender'];
    $email = $res['email'];
    $birth_date = $res['birth_date'];
    $city = $res['city'];
    $join_date = $res['join_date'];
    $basic_pay = $res['annual_basic_pay'];

}
?>
<html>
<head>	
    <title>Edit Data</title>
    <link rel="stylesheet" href="assets/css/main.css" />
</head>

<body>
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
                    <li><a href="payroll.php#portfolio" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Employee</span></a></li>
                    <li><a href="payroll.php#list" id="list-link" class="skel-layers-ignoreHref"><span class="icon fa-th">list</span></a></li>
                    <li><a href="payroll.php#payslip" id="payslip-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Pay Slip</span></a></li>
                </ul>
            </nav>

        </div>

        

    </div>

	

    <div id="main">
            <div class="container">

                <form class="well form-horizontal" action="edit.php" method="post" id="payslip_form">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Edit an Employee!</legend>

                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Employee Id</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input name="employee_id"  class="form-control" type="text" value="<?php echo $employee_id; ?>">
                                    
                                </div>
                            </div>
                        </div>

                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Name</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input name="name"  class="form-control" type="text" value="<?php echo $name; ?>">
                                   
                                </div>
                            </div>
                        </div>
                        <!-- Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Birth Date</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input name="birth_date"  class="form-control" type="date" value="<?php echo $birth_date; ?>">
                                    
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
                                    <span style="color: red;">* <?php echo $emailErr;?></span>
                                    
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
                                    <input name="city" class="form-control" type="text" value="<?php echo $city; ?>">
                                    
                                </div>
                            </div>
                        </div>



                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Join Date</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                    <input name="join_date"  class="form-control" type="date" value="<?php echo $join_date; ?>">
                                  
                                </div>
                            </div>
                        </div>


                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Annual Pay</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                    <input name="basic_pay"  class="form-control" type="text" value="<?php echo $basic_pay; ?>">
                                    
                                </div>
                            </div>
                        </div>




                        <!-- Success message -->
                        <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Employee Updated.</div>
                        

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label"></label>
                            <div class="col-md-4">
                                <button onclick="alert('Employee Update Successfull!')" input type="submit" name="update" value="Update">Update <span class="glyphicon glyphicon-send"></span></button>
                            </div>
                        </div>

                    </fieldset>
                </form>
               
            </div>
        </div>

    <!-- Footer -->
    <div id="footer">

        <!-- Copyright -->
        <ul class="copyright">
        <li>&copy; K&C. All rights reserved.</li>
        <li>Design: Kelly & Carey</a></li>
        </ul>

    </div>


</body>
</html>
