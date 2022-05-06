<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String login_id = (String)session.getAttribute("login_id");
	if(login_id == null){
	 	response.sendRedirect("login.jsp");
	}
	
	//有効期限5分
	session.setMaxInactiveInterval(60*5);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
 <head>
   <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
   <title>名刺読み取り画面</title>
   <link rel="stylesheet" type="text/css" href="css/main.css">
  </head>
  <body>
   <div id="wrap">
    <main>
     <section>
      <%= login_id %> さんでログイン中<br />
      <center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
      <h3>名刺読み取り</h3>
      <form method="post" enctype="multipart/form-data" action="\syu_pre\servlet\read">
	   <p>読み取るファイルを選択してください。</p>
	   <p><input type="file" name="filename"></p>
	   <p id="botan">
	      <input type="submit" value="読み取り開始" class="button">
	   </p><br><br>
      </form>
     </section>
    </main>
   </div>
  </body>
</html>