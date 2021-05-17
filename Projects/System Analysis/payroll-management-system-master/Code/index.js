function validateForm() {
    var un = document.loginform.usr.value;
    var pw = document.loginform.pword.value;
    var username = "kelly";
    var password = "kelly123";
    var username1 = "carey";
    var password1 = "carey123";
    
    if (((un == username) && (pw == password))||((un == username1) && (pw == password1))) {
        window.location = "payroll.php";
        return true;
    } else {
        alert("Login was unsuccessful, please check your username and password");
        return false;
    }
}