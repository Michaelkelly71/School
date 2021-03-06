<html>

<head>
    <title>Payrol management system</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="stylesheet" href="assets/css/main.css" />

</head>

<body>

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
                    <li><a href="payroll.php#portfolio" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Employee</span></a></li>
                    <li><a href="payroll.php#list" id="list-link" class="skel-layers-ignoreHref"><span class="icon fa-th">list</span></a></li>
                    <li><a href="payroll.php#payslip" id="payslip-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Pay Slip</span></a></li>
                </ul>
            </nav>

        </div>

            <div class="bottom">
                <a href="index.php" h4>Logout / Back to login</a>

            </div>

    </div>

    <!-- Main -->
    <div id="main">

        <!-- list -->
        <section id="list" class="three">
            <div class="container">

                <header>
                    <h2>Delete</h2>
                </header>

                <p>List of all employees</p>
                <?php
//including the database connection file
       include("connection.php");
        $result = mysqli_query($conn, "SELECT * FROM employee ORDER BY employee_id ASC"); // using mysqli_query instead
    //while($res = mysql_fetch_array($result)) { // mysql_fetch_array is deprecated, we need to use mysqli_fetch_array 
        echo "<table><tr><th>ID</th><th>Name</th><th>E-mail</th><th>Bank(PBL)</th><th>Join Date</th><th>Annual Basic Pay</th><th>Del</th></tr>";
	while($res = mysqli_fetch_array($result)) { 		
        
        echo "<tr><td>" . $res["employee_id"]. "</td><td>" . $res["name"]. "</td><td> " . $res["email"]. "</td><td> " . $res["bank"]. "</td><td> " . $res["join_date"]. "</td><td> " ."GH??? ". $res["annual_basic_pay"]. "</td><td> <a href=\"delete.php?employee_id=$res[employee_id]\" onClick=\"return confirm('Are you sure you want to delete?')\">Delete</a></td></tr>";
         }
        echo "</table>";
	
	
?>
            </div>
        </section>
        

    </div>

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