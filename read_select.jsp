<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String login_id = (String)session.getAttribute("login_id");
	if(login_id == null){
	 	response.sendRedirect("login.jsp");
	}
	//有効期限1分
	session.setMaxInactiveInterval(60*5);
	
	int loopnumber = Integer.parseInt(request.getParameter("loopnumber"));
	
	String[] data = new String[loopnumber];
	
	for(int lp = 0; lp < loopnumber ; lp++){
		data[lp] = request.getParameter("datano_"+ lp);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>名刺情報選択</title>
		<link rel="stylesheet" type="text/css" href="css/main2.css">
	</head>
	<body>
		<div id="wrap">
			<main>
				<section>
					<%= login_id %> さんでログイン中<br />
					<center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
					<h3>名刺情報選択</h3><br>
					<form method="post" action="/syu_pre/read_end.jsp">
						<% for(int x = 0 ; x < loopnumber ; x++){ %>
							<p>
							   <input type="text" name="data_<%= x %>" value="<%= data[x] %>" size=30>
							   <select size=1 name="datatype_<%= x %>">
							   		<option value="1">　　　　</option>
							   		<option value="2">会社名</option>
							   		<option value="3">部署名</option>
							   		<option value="4">役職</option>
							   		<option value="5">氏名</option>
							   </select>
							</p>
						<% } %>
						<p id="botan">
							<input type="hidden" name="loopnumber" value="<%= loopnumber %>">
							
						    <input type="submit" value="登録" class="button">
					   	</p><br><br>
					</form>
				</section>
			</main>
		</div>
	</body>
</html>