<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード自動生成</title>

<link rel="stylesheet" type="text/css" href="CSS/CreatePassword.css">

</head>

<body>
<h1>パスワード自動生成</h1>


<%-- 文字数入力 --%>
<form method="post" action="CreateController">
<label>文字数:<input type="text" name="length" value="1" id="text" readonly="readonly"><br>
<input type="range" value="1" min="1" max="30" id="range" oninput="change('range','text')">
</label>

<%-- チェックボックス --%>
<div>
<input type="checkbox" name="low" value="true" checked>小文字
<input type="checkbox" name="upp" value="true" checked>大文字
<input type="checkbox" name="num" value="true" checked>数字
<input type="checkbox" name="sign" value="true" checked>記号
</div>

<%-- テキストエリアにパスワード生成 --%>
<textarea id="text" name="textarea" rows="4" cols="30" >
<%=request.getAttribute("password") %>
</textarea><br>
<input type="submit" value="パスワード生成実行">
</form>

<button onclick="cp()"id="ICbt">Copy</button>
<br>
<form method="post" action="homecontroller">
<input type="submit" value="ホーム" name="home">
</form>


<script>
function cp() {
	var txt = document.getElementsByName("textarea");
	navigator.clipboard.writeText(txt[0].value);
	document.getElementById("ICbt").innerHTML = "Copied！";
	document.getElementById("ICbt").style.backgroundColor="#9EFA00"
	}

function change(range,text){
	// range値を取得
    var num = document.getElementById(range).value;

    //textに反映
    document.getElementById(text).value = num;
}
</script>

</body>
</html>
