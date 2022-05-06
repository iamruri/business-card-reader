<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String login_id = (String)session.getAttribute("login_id");
	
	 if(login_id == null){
	 	response.sendRedirect("login.jsp");
	 }
	 
	 //有効期限5分
	 session.setMaxInactiveInterval(60*5);
	
	Connection con = null;
	Statement stmt = null;
	StringBuffer SQL = null;
	ResultSet rs = null;
	
	String USER = "root";
	String PASSWORD = "root";
	String URL = "jdbc:mysql://localhost/syu_pre";
	String DRIVER = "com.mysql.jdbc.Driver";
	
	StringBuffer ERMSG = null;
	
	int del_count = 0;
	
	try{
		Class.forName(DRIVER).newInstance();
		con = DriverManager.getConnection(URL,USER,PASSWORD);
		stmt = con.createStatement();
		
		SQL = new StringBuffer();
		
		SQL.append("delete from id_tbl where id="+"'"+login_id+"'");
		
		System.out.println(SQL.toString());
		
		del_count = stmt.executeUpdate(SQL.toString());
	}
	catch(ClassNotFoundException e){
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	}
	catch(SQLException e){
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	}
	catch(Exception e){
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	}
	
	finally{
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(con != null){
				con.close();
			}
		}
		catch(SQLException e){
			ERMSG = new StringBuffer();
			ERMSG.append(e.getMessage());
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTL 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
   		<title>アカウント削除</title>
   		<link rel="stylesheet" type="text/css" href="css/main.css">
	</head>
	<body>
		<div id="wrap">
    		<main>
    			<section>
    			<center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
      			<h3>メイン画面</h3>
					<% 
						if(del_count == 0){
					%>
						削除NG<br>
						<%= "削除処理が失敗しました" %>
					<%
						}else{
					%>
						削除OK
						<%= del_count+"件　削除が完了しました" %>
					<%
						}
					%>
					<br><br>
					<% if(ERMSG != null){ %>
						予期せぬエラーが発生しました<br />
						<%= ERMSG %>
					<% }else{ %>
						エラーは発生しませんでした<br />
					<% } %>
					<form method="post" action="/syu_pre/login.jsp">
						<input type="hidden" name="logout" value="logout">
						<input type="submit" value="ログイン画面へ戻る">
					</form>
				</section>
			</main>
		</div>
	</body> 
</html>