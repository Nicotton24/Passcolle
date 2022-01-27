<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.ResultEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<% ResultEntity de = (ResultEntity)session.getAttribute("Delete"); %>
<link rel="stylesheet" href="CSS/DeleteStyle.css">
</head>
<body>
	<h1>こちらの内容を削除してよろしいでしょうか?</h1>
	<%if (de != null){%>

	<div class="center">
		<div class = "main">
		<table border="1">
		<tr>
			<th>Name:</th><td><%= de.getName()%></td>
		</tr>
		<tr>
			<th>ID :</th><td><%= de.getId()%></td>
		</tr>
		<tr>
			<th>Password:</th><td><%= de.getPass()%></td>
		</tr>
		</table>

	<div class="Dbt">
		<form method="post" action="deletecontroller2">
			<button type="submit"  value="<%=de.getName()%>"name="Delete2">削除</button>
		</form>
		</div>
		</div>
		</div>
		<br>
		<div class="Dbt2">
		<form method="post" action="homecontroller">
			<input type="submit" value="戻る" name="home">
		</form>

		</div>
	<%}else{ %>

	<p>該当なし<p>

	<%} %>
</body>
</html>