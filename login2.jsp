<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String idstr = request.getParameter("id");
	String pwstr = request.getParameter("pw");
	
	Connection con = null;
	Statement stmt = null;
	StringBuffer SQL = null;
	ResultSet rs = null;
	
	String USER = "root";
	String PASSWORD = "root";
	String URL = "jdbc:mysql://localhost/syu_pre";
	String DRIVER = "com.mysql.jdbc.Driver";
	
	StringBuffer ERMSG = null;
	
	HashMap<String,String>map = null;
	
	ArrayList<HashMap>list = null;
	list = new ArrayList<HashMap>();
	
	try{
		Class.forName(DRIVER).newInstance();
		con = DriverManager.getConnection(URL,USER,PASSWORD);
		stmt = con.createStatement();
		
		SQL = new StringBuffer();
		SQL.append("select id,pw from id_tbl");
		
		rs = stmt.executeQuery(SQL.toString());
		
		while(rs.next()){
			map = new HashMap<String,String>();
			map.put("id",rs.getString("id"));
			map.put("pw",rs.getString("pw"));
			
			list.add(map);
		}
		
		System.out.println(SQL.toString());
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
	
	int flg = 0;
	int i=0;
	
	for(i = 0 ; i < list.size() ; i++){
		if(list.get(i).get("id") .equals (idstr)){
			if(list.get(i).get("pw") .equals (pwstr)){
				flg = 1;
			}
		}
	}
	
	if(flg == 1){
		//有効期限1分
	    session.setMaxInactiveInterval(60*5);
	
		//セッションにバインド
		session.setAttribute("login_id",idstr);
		
		//メインページへ遷移
	    response.sendRedirect("/syu_pre/main.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTL 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>ログイン処理完了</title>
		<meta HTTP-EQUIV="content-type" CONTENT="text/html;charset=UTF-8">
	</head>
	<body bgcolor="#FFFFFF">
		<%
			if(flg == 1){
		%>
				ログイン成功しました。<br>
				<form method="post" action="/syu_pre/main.jsp">
					<input type="submit" value="メイン画面へ">
				</form>
		<%
			}else if(flg == 0){
		%>
				ログイン失敗<br>
				<form method="post" action="/syu_pre/login.jsp">
					<input type="submit" value="ログイン画面に戻る">
				</form>
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
		
	</body>
</html>