<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<html>
 <head>
   <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
   <title>メイン画面</title>
   <link rel="stylesheet" type="text/css" href="css/main.css">
  </head>
  <body>
   <div id="wrap">
    <main>
     <section>
               ようこそ <%= login_id %> さん<br />
      <center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
      <h3>メイン画面</h3>
      <form method="post">
    		<p id="aa" ><input type="submit" value="名刺入力" formaction="read.jsp" class="button"></p>
    		<p id="aa" ><input type="submit" value="名刺一覧" formaction="list.jsp" class="button"></p>
    		<p id="aa" ><input type="submit" value="報告書入力" formaction="input_st.jsp" class="button"></p>
    		<p id="aa" ><input type="submit" value="報告書入力履歴" formaction="input_check.jsp" class="button"></p>
    		<!--<p id="aa" ><input type="submit" value="ファイルダウンロード" formaction="/syu_pre/download.jsp" class="button"></p>-->
      </form>
      <form method="post" action="/syu_pre/account.jsp">
    		<p id="aa" ><input type="submit" value="アカウント管理画面" class="button"></p>
      </form>
     </section>
    </main>
   </div>
  </body>
</html>