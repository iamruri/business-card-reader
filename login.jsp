<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String logout = request.getParameter("logout");
	
	if(logout != null){
		//セッション変数を削除
		session.removeAttribute("login_id");
	}
	String login_id = (String)session.getAttribute("login_id");
	
	if(login_id != null){
		response.sendRedirect("main.jsp");
	}	
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>ログイン画面</title>
		<link rel="stylesheet" type="text/css" href="css/main.css">
	</head>
	<body bgcolor="#FFFFFF">
		<div id="wrap">
			<main>
				<section>
					<center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
					<h3>ログイン</h3>
					<form method="post" action="/syu_pre/login2.jsp">
						<p id="midashi">ID</p>
						<p><input type="text" name="id" size="30"></p>
						<p id="midashi">パスワード</p>
						<p><input type="text" name="pw" size="30"></p>
						<p id="pass"><a href="changepassin.jsp">パスワードを忘れた場合</a></p>
						<p><input type="submit" value="新規作成" formaction="new.jsp" class="button">
							<input type="submit" value="ログイン" class="button">
						</p>
					</form>
				</section>
			</main>
		</div>
	</body>
</html>