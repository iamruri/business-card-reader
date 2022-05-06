<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String affiliationstr = request.getParameter("affiliation");
	String namestr = request.getParameter("name");
	String subjectstr = request.getParameter("subject");
	String report_tostr = request.getParameter("report_to");
	String contentsstr = request.getParameter("contents");
	String extrastr = request.getParameter("extra");
	
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
	
	int ins_count = 0;
	
	try{
		Class.forName(DRIVER).newInstance();
		
		con = DriverManager.getConnection(URL,USER,PASSWORD);
		
		stmt = con.createStatement();
		
		SQL = new StringBuffer();
		
		SQL.append("insert into report_tbl(affiliation,name,subject,report_to,contents,extra,userid)");
		SQL.append(" values('");
		SQL.append(affiliationstr);
		SQL.append("','");
		SQL.append(namestr);
		SQL.append("','");
		SQL.append(subjectstr);
		SQL.append("','");
		SQL.append(report_tostr);
		SQL.append("','");
		SQL.append(contentsstr);
		SQL.append("','");
		SQL.append(extrastr);
		SQL.append("','");
		SQL.append(login_id);
		SQL.append("')");
		
		System.out.println(SQL.toString());
		
		ins_count = stmt.executeUpdate(SQL.toString());
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
		<title>報告書を登録しました</title>
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<meta HTTP-EQUIV="content-type" CONTENT="text/html;charset=UTF-8">
	</head>
	<body>
	　<div id="wrap">
    	<main>
     		<section>
     			<%= login_id %> さんでログイン中<br />
     			<center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
		      <%
					if(ins_count == 0){
			  %>
					<h3>報告書入力失敗</h3>
					<form>
					<p id="a"><%= "登録処理が失敗しました" %></p>
			  <%
					}else{
			  %>
			  		<h3>報告書入力完了</h3>
			  		<form>
			  		<p id="a">報告書を記録しました。</p>
			  <%
					}
			  %>
			  <p id="aa">
	      		<input type="submit" value="もう一度入力する" formaction="input_st.jsp" class="button">
	      		<input type="submit" value="完了" formaction="main.jsp" class="button">
	   		　　</p><br><br>
	   		</form>
     	　　</section>
    　　　　　　</main>
   	　</div>
  </body>
</html>