<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ログインフォーム</title> 

	<link rel="stylesheet" href=CSS/loginform.css>
</head>
<body>
	<div id="login">
     <form method="post" action="logincontroller">
        <span class="fontawesome-user"></span>
          <input type="text" name="user" placeholder="Username">


        <span class="fontawesome-lock"></span>
          <input type="password" name="pass" placeholder="Password">
        <input type="submit" value="Login">

	</form>
	</div>

</body>
</html>