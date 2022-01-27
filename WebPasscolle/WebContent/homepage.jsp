<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="model.PassEntity" %>
	<%@ page import="model.UserBean" %>
	<%@ page import="model.ResultEntity" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ホーム</title>
	<%
		List<PassEntity> ue = (List<PassEntity>)session.getAttribute("userentity");
	%>
	<%
		ResultEntity re = (ResultEntity)session.getAttribute("UEObj");
	%>
	<%
		UserBean ub = (UserBean)session.getAttribute("userbean");
	%>


	<link rel="stylesheet" href="CSS/HomePageStyle.css">
</head>
<body>

	<div class="container">
		<div id="left">
			<div class="highpoint">
				<div><img src="img/adminman.png"></div>
				<div><br><%= ub.getName() %></div>
			</div>
			<form method="post" action="homecontroller">
			<ul>
				<li><input type="submit" value="パスワード登録" name="touroku"></li>

				<li><input type="submit" value="パスワード自動生成" name="seisei"></li>

				<li><input type="submit" value="ログアウト" name="logout"></li>
			</ul>
			</form>
			<br>
			<form  method ="post" action="Searchcontroller" name="Search"> <%-- --%>
				<div class="search">
					<label class="CSh">
						<input id="input_name" type="text" name="sch" value="<%=request.getAttribute("searchbox")%>">
					</label>
					<br>
				</div>
				<div class="CShBt">
					<input type="submit" value="検索"	>
				</div>
			</form>
		</div>
		<div id="center">
		<%--真ん中 --%>

		<form method="post" action="resultcontroller">
		<%if (ue != null){%>
		<ul>
		<% for(PassEntity pe : ue) { %>

        		<li><input class="btn"type="submit" value="<%=pe.getName()%>" name="syID" readonly></li>

    	<% } %>
    	</ul>
    	<%}else{%>
    	<%}%>
    	</form>
		</div>
		<div id="right">
		<%--右 --%>
		<%if (re != null){%>

		<h1><%= re.getName()%></h1>

		<div class="IdM">
		<p>ID</p>
		<table>
		<tr>
			<th><%= re.getId()%></th>

		</tr>
		</table>
		<button id="ICbt" class="ICbt" onclick="Idcp()">Copy</button>
		</div>

		<div class="PassM">
		<p>PassWord</p>
		<table>
		<tr>
			<th><%= re.getPass()%></th>
		</tr>
		</table>
		<button id="PCbt" class="PCbt" onclick="Passcp()">Copy</button>
		</div>

		<br>
		<div class="CDdiv">
		<div class="CDcont">
		<form method="post" action="cangecontroller">
			<button  type="submit"  value="<%=re.getName()%>"name="Change">変更</button>
		</form>

		</div>
		<div class="CDcont">
		<form method="post" action="deletecontroller">
			<button type="submit"  value="<%=re.getName()%>"name="Delete">削除</button>
		</form>
		</div>
		</div>
	<%}else{ %>


	<%} %>


		</div>
	</div>

	<%--スクリプト--%>
	<script>
	document.getElementById('input_name').focus();
	document.getElementById('input_name').setSelectionRange( 100,100) ;
		<%-- コピーボタン機能--%>
		<%if (re != null){%>
			function Idcp() { <%-- IDコピー --%>
				navigator.clipboard.writeText("<%= re.getId()%>");
				document.getElementById("ICbt").innerHTML = "Copied！";
				document.getElementById("ICbt").style.backgroundColor="#9EFA00"
			}

			function Passcp() { <%-- PASSコピー --%>
				navigator.clipboard.writeText("<%= re.getPass()%>");
				document.getElementById("PCbt").innerHTML = "Copied！";
				document.getElementById("PCbt").style.backgroundColor="#9EFA00"

			}
		<%}%>




	</script>

</body>
</html>