<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String idstr = request.getParameter("id");
	String emailstr = request.getParameter("email");
	String newpwstr = request.getParameter("newpw");
	String newpw2str = request.getParameter("newpw2");
	
	Connection con = null;
	Statement stmt = null;
	StringBuffer SQL = null;
	ResultSet rs = null;
	
	String USER = "root";
	String PASSWORD = "root";
	String URL = "jdbc:mysql://localhost/syu_pre";
	String DRIVER = "com.mysql.jdbc.Driver";
	
	StringBuffer ERMSG = null;

	int upd_count = 0;
	
	try{
		Class.forName(DRIVER).newInstance();
		con = DriverManager.getConnection(URL,USER,PASSWORD);
		stmt = con.createStatement();
		
		SQL = new StringBuffer();
		SQL.append("update id_tbl set pw=" + "'" + newpwstr + "' where id = " + "'" + idstr + "'");
		
		System.out.println(SQL.toString());
		
		upd_count = stmt.executeUpdate(SQL.toString());
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
   		<title>パスワード変更</title>
   		<link rel="stylesheet" type="text/css" href="css/main.css">
	</head>
	<body>
	<div id="wrap">
    <main>
     <section>
      <center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
	<%
			if(upd_count == 0){
	%>
		<h3>パスワード変更失敗</h3>
		<form method="post" action="/syu_pre/login.jsp">
		<p id="a">
			更新NG<br>
			<%= "更新処理が失敗しました" %>
		</p>
	<%
		}else{
	%>
		<h3>パスワード変更成功</h3>
		<form method="post" action="/syu_pre/login.jsp">
		<p id="a">更新OK<br>
		<%= upd_count + "件 登録完了しました" %></p>
	<%
		}
	%>
	<br><br>
	<% if(ERMSG != null){ %>
			<p id="a">予期せぬエラーが発生しました<br />
			<%= ERMSG %></p>
	<% }else{ %>
			<p id="a">エラーは発生しませんでした<br /></p>
	<% } %>
	<br><br>
		<p id="aa">
			<input type="submit" value="ログイン画面に戻る" class="button">
		</p><br><br>
	</form>
	</body>
</html>