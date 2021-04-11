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
                    <li><a href="#top" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Home</span></a></li>
                    <li><a href="#portfolio" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Employee</span></a></li>
                    <li><a href="#list" id="list-link" class="skel-layers-ignoreHref"><span class="icon fa-th">List</span></a></li>
                    <li><a href="#payslip" id="payslip-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Pay Slip</span></a></li>
                </ul>
            </nav>

        </div>

        <div class="bottom">
            <a href="index.php" h4>Logout / Back to login</a>

        </div>
    </div>

    <!-- Main -->
    <div id="main">

        <!-- Intro -->
        <section id="top" class="one dark cover">
            <div class="container">

                <header>
                    <h2 class="alt">VVU Payroll Management System</strong> <br />designed by Kelly & Carey.</h2>
                    <p>Insert/Update/Delete</p>
                </header>

                <footer>
                    <a href="#portfolio" class="button scrolly">Employee(s)</a>
                </footer>

            </div>
        </section>

        <!-- Portfolio -->
        <section id="portfolio" class="two">
            <div class="container">

                <header>
                    <h2>Employee</h2>
                </header>

                <p>Here you can add,delete or update any number of employees.</p>

                <div class="row">
                    <div class="4u 12u$(mobile)">
                        <article class="item">
                            <a href="insert.php" class="image fit"><img src="images/pic02.png" alt="" />
                            <header>
                                <h3>Insert</h3></a>
                            </header>
                            
                        </article>

                    </div>
                    <div class="4u 12u$(mobile)">
                        <article class="item">
                            <a href="delete1.php" class="image fit"><img src="images/pic03.png" alt="" />
                            <header>
                                <h3>Delete</h3></a>
                            </header>
                        </article>

                    </div>
                    <div class="4u$ 12u$(mobile)">
                        <article class="item">
                            <a href="edit1.php" class="image fit"><img src="images/pic04.png" alt="" />
                            <header>
                                <h3>Update</h3></a>
                            </header>
                        </article>

                    </div>
                </div>

            </div>
        </section>

        <!-- list Me -->
        <section id="list" class="three">
            <div class="container">

                <header>
                    <h2>List</h2>
                </header>

                <p>List of all employees</p>
                <?php
//including the database connection file
include("connection.php");

 $result = mysqli_query($conn, "SELECT * FROM employee ORDER BY employee_id ASC"); // using mysqli_query instead
    //while($res = mysql_fetch_array($result)) { // mysql_fetch_array is deprecated, we need to use mysqli_fetch_array 
        echo "<table><tr><th>ID</th><th>Name</th><th>E-mail</th><th>City</th><th>Join Date</th><th>Annual Basic Pay</th></tr>";
	while($res = mysqli_fetch_array($result)) { 		
        
        echo "<tr><td>" . $res["employee_id"]. "</td><td>" . $res["name"]. "</td><td> " . $res["email"]. "</td><td> " . $res["city"]. "</td><td> " . $res["join_date"]. "</td><td> " . $res["annual_basic_pay"]. "</td></tr>";
         }
        echo "</table>";
	
	
?>
            </div>
        </section>

        <!-- payslip -->
        <section id="payslip" class="four">
            <div class="container">

                <header>
                    <h2>Pay Slip</h2>
                </header>
                <?php
//including the database connection file
include("connection.php");

     $result = mysqli_query($conn, "SELECT * FROM employee ORDER BY employee_id ASC"); // using mysqli_query instead
   
        echo "<table><tr><th>ID</th><th>Name</th><th>E-mail</th><th>Join Date</th><th>Annual Basic Pay</th><th>Monthly Pay(after_tax)</th><th>Tax</th><th>Tax Amount</th><th>Single Out</th></tr>";
	while($res = mysqli_fetch_array($result)) { 		
        
        echo "<tr><td>" . $res["employee_id"]. "</td><td>" . $res["name"]. "</td><td> " . $res["email"]. "</td><td> " . $res["join_date"]. "</td><td> " . $res["annual_basic_pay"]." $". "</td><td> " . $res["monthly_pay"]." $". "</td><td> " . $res["tax"]." %". "</td><td> " . $res["tax_amount"]. "</td><td><a href=\"export1.php?employee_id=$res[employee_id]\">Preview</a></td></tr>";
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