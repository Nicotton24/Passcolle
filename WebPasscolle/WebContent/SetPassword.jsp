<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード登録画面</title>

<link rel="stylesheet" href="CSS/Change Password.css">
</head>
<body>

<% if(request.getAttribute("error") != null){%>
<p><%= request.getAttribute("error") %><p>
<% }%>
	<h2 class="contents">パスワード登録</h2>
	
	<div class="center">
		<div class="main">
	<form method="post" action="SetController">
	<table border="1">
				<tr>
					<td class="pass"><p class=nowpass>Name<span class=important>必須&nbsp;</span></p></td>
					<td class="input"><input class="passwidth" type="text"  name="name"></td>
				</tr>
				<tr>
					<td class="pass"><p class=newpass>ID<span class=important>必須&nbsp;</span></p></td>
					<td class="input"><input class="passwidth" type="text" name="id"></td>
				</tr>
				<tr>
					<td class="pass"><p class=Verification>PassWord<span class=important>必須&nbsp;</span></p></td>
					<td class="input"><input class="passwidth" type="password" name="pass"></td>
				</tr>
			</table>

			<br>

			<input class="button" type="submit" value="登録">
	</form>
	</div>
	</div>
	<br>
	<br>
	<div class="bottombutton">
		<form method="post" action="homecontroller">
			<input type="submit" value="ホーム" name="home">
		</form>
	</div>
</body>
</html>