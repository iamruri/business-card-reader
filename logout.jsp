<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String login_id = (String)session.getAttribute("login_id");
	if(login_id == null){
	 	response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
 <head>
   <meta charset="utf-8">
   <title>ログアウト画面</title>
   <link rel="stylesheet" type="text/css" href="css/main.css">
  </head>
  <body>
   <div id="wrap">
    <main>
     <section>
      <center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
      <h3>ログアウト</h3>
      <form>
       <p id="aaa">ログアウトしますか</p><br><br><br><br>
	   <p id="botan5"><input type="submit" value="いいえ" formaction="account.jsp" class="button"></p>
	  </form>
	  <form>
	  	 <input type="hidden" name="logout" value="logout">
       　　　　　  <p id="botan"><input type="submit" value="はい" formaction="login.jsp" class="button"></p>
      </form>
     </section>
    </main>
   </div>
  </body>
</html>