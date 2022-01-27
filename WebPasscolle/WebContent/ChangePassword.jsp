<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.PassChangeEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
<% PassChangeEntity re = (PassChangeEntity)session.getAttribute("changename"); %>
<link rel="stylesheet" href="CSS/Change Password.css">
</head>
<body>

	<h2 class="contents">パスワード変更</h2>

	<div class="center">
		<div class="main">
		<p>ご登録のパスワードを変更することが出来ます。</p>

		<form method="POST" action="Newcangecontroller">

			<table border="1">
				<tr>
					<td class="pass"><p class=nowpass>現在のパスワード<span class=important>必須&nbsp;</span></p></td>
					<td class="input"><%= re.getPass()%></td>
				</tr>
				<tr>
					<td class="pass"><p class=newpass>新しいパスワード<span class=important>必須&nbsp;</span></p></td>
					<td class="input"><input class="passwidth" type="password" name="Npass"></td>
				</tr>
				<tr>
					<td class="pass"><p class=Verification>新しいパスワードの確認<span class=important>必須&nbsp;</span></p></td>
					<td class="input"><input class="passwidth" type="password" name="Vpass"></td>
				</tr>
			</table>

			<br>
			<input class="passwidth" type="hidden" value="<%= re.getName()%>" name="pass">
			<input class="button" type="submit" value="パスワード変更">

		</form>
		</div>
	</div>

	<br>
	<br>

	<div class="bottombutton">
		<!--推移先ページ指定(.jsp)-->
		<form method="post" action="homecontroller">
			<input type="submit" value="ホーム" name="home">
		</form>
	</div>

</body>
</html>