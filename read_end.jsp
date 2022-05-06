<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
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
	String[] datatype = new String[loopnumber];
	
	int lp=0;
	
	for(lp = 0 ; lp < loopnumber ; lp++){
		data[lp] = request.getParameter("data_"+ lp);
		datatype[lp] = request.getParameter("datatype_"+ lp);
	}
	
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
		
		SQL.append("insert into card_tbl(companyname,name,department,position,userid)");
		SQL.append("values('");
		for(lp = 0; lp < loopnumber; lp++){
			if(datatype[lp].equals("2")){
				SQL.append(data[lp]);
			}
		}
		SQL.append("','");
		for(lp = 0; lp < loopnumber; lp++){
			if(datatype[lp].equals("5")){
				SQL.append(data[lp]);
			}
		}
		SQL.append("','");
		for(lp = 0; lp < loopnumber; lp++){
			if(datatype[lp].equals("3")){
				SQL.append(data[lp]);
			}
		}
		SQL.append("','");
		for(lp = 0; lp < loopnumber; lp++){
			if(datatype[lp].equals("4")){
				SQL.append(data[lp]);
			}
		}
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
<html lang="ja">
 <head>
   <meta charset="utf-8">
   <title>名刺読み取り完了画面</title>
   <link rel="stylesheet" type="text/css" href="css/main.css">
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
					<h3>名刺入力失敗</h3>
					<form>
					<p id="a"><%= "登録処理が失敗しました" %></p>
			  <%
					}else{
			  %>
			  		<h3>名刺入力完了</h3>
			  		<form>
			  		<p id="a">名刺情報を記録しました。</p>
			  <%
					}
			  %>
	   <p id="aa">
	      <input type="submit" value="もう一度読み取る" formaction="read.jsp" class="button">
	      <input type="submit" value="完了" formaction="main.jsp" class="button">
	   </p><br><br>
      </form>
     </section>
    </main>
   </div>
  </body>
</html>