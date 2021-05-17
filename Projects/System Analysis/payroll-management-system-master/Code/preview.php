<?php

?>

<html>
<head>	
    <title>Previewing Payslip</title>
    <link rel="stylesheet" href="assets/css/main.css" />

</head>
    <body>
    <section>
           

        <header>
            <h2>Pay Slip</h2>
        </header>
        <?php

        include("connection.php");

        //getting id of the data from url
        $employee_id = $_GET['employee_id'];

        //selecting the row from table
        $result = mysqli_query($conn, "Select * from employee WHERE employee_id='$employee_id'");

        echo "<table><tr><th>ID</th><th>Name</th><th>E-mail</th><th>Department</th><th>City</th><th>Join Date</th><th>Monthly Pay</th><th>Tax</th><th>Tax Amount</th><th>Gender";
        while($res = mysqli_fetch_array($result)) { 		
            
            echo "<tr><td>" . $res["employee_id"]. "</td><td>" . $res["name"]. "</td><td> " . $res["email"]. "</td><td> ". $res["department"]. "</td><td> " . $res["city"]. "</td><td> " . $res["join_date"]. "</td><td> " . $res["monthly_pay"]." $". "</td><td> " . $res["tax"]." %". "</td><td> " . $res["tax_amount"]. "</td><td>". $res["gender"];
        }
            echo "</table>";
            
            $name = mysqli_query($conn, "Select name from employee WHERE employee_id='$employee_id';");
            $salary = mysqli_query($conn, "Select monthly_pay from employee WHERE employee_id='$employee_id';");
            
            while($res = mysqli_fetch_array($salary)){
                echo ("Paying salary ".$res["monthly_pay"]." to employee above this and every month ");
            }
            
        ?>

            
    </section>
        
</body>
</html>







