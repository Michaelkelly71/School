<?php

    $servername = "127.0.0.1";
    $username = "root";
    $password = "mack1234";
    $dbname = "payroll";
         
    // Create connection
    $conn = mysqli_connect($servername, $username, $password,$dbname);

    if ($conn->connect_error) {
        die("Connection failed: " . mysqli_error());
    }
    //echo "Connected successfully";

?>