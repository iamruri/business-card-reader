<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String idstr = request.getParameter("id");
	String pwstr = request.getParameter("pw");
	String emailstr = request.getParameter("email");
	String seistr = request.getParameter("sei");
	String meistr = request.getParameter("mei");
	
	String namestr = seistr + meistr;
	
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

		SQL.append("insert into id_tbl(id,pw,name,email)");
		SQL.append(" values('");
		SQL.append(idstr);
		SQL.append("','");
		SQL.append(pwstr);
		SQL.append("','");
		SQL.append(namestr);
		SQL.append("','");
		SQL.append(emailstr);
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
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	  　　　 <title>新規登録</title>
	   　　　<link rel="stylesheet" type="text/css" href="css/main.css">
	</head>
	<body>
	 <div id="wrap">
	  <main>
       <section>
        <center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
        <h3>新規登録</h3><br>
        <form method="post" action="/syu_pre/login.jsp">
		<%
			if(ins_count == 0){
		%>
				<p>追加NG</p>
				<p><%= "登録処理が失敗しました" %></p>
		<%
			}else{
		%>
				<p>追加OK</p>
				<p><%= ins_count + "件 登録完了しました" %></p>
		<%
			}
		%>
		<br><br>
		<p id="botan6">
			<input type="submit" class="button" value="ログイン画面へ戻ります">
		</p><br><br>
		</form>
	　　　</section>
    　　　　</main>
   　　　</div>
　　</body>
</html>