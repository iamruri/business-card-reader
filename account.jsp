<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
   <meta charset="utf-8">
   <title>メイン画面</title>
   <link rel="stylesheet" type="text/css" href="css/main.css">
  </head>
  <body>
   <div id="wrap">
    <main>
     <section>
      <%= login_id %> さんでログイン中<br />
      <center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
      <h3>アカウント管理画面</h3>
      <form method="post">
    		<p id="aa" ><input type="submit" value="アカウント削除" formaction="delete.jsp" class="button"></p>
    		<p id="aa" ><input type="submit" value="ログアウト" formaction="logout.jsp" class="button"></p>
    		<p id="aa"><input type="submit" value="メイン画面へ戻る" formaction="main.jsp" class="button"></p>
      </form>
     </section>
    </main>
   </div>
  </body>
</html>