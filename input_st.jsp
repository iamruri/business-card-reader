<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String login_id = (String)session.getAttribute("login_id");
	
	 if(login_id == null){
	 	response.sendRedirect("login.jsp");
	 }
	 
	 //有効期限5分
	 session.setMaxInactiveInterval(60*5);

	String cardidstr="";
	
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
		SQL.append("select companyname,name,department,position,cardid from card_tbl where userid = " + "'" + login_id + "'" );
		
		rs = stmt.executeQuery(SQL.toString());
		
		while(rs.next()){
			map = new HashMap<String,String>();
			map.put("companyname",rs.getString("companyname"));
			map.put("name",rs.getString("name"));
			map.put("department",rs.getString("department"));
			map.put("position",rs.getString("position"));
			map.put("cardid",rs.getString("cardid"));
			
			list.add(map);
		}
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
   <title>名刺一覧表示画面</title>
   <link rel="stylesheet" type="text/css" href="css/list.css">
  </head>
  <% if(ERMSG != null){ %>
		予期せぬエラーが発生しました。<br/>
		<%= ERMSG %>
	<% } %>
  <body>
   <div id="wrap">
    <main>
     <section>
     <%= login_id %> さんでログイン中<br />
      <center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
      <h3>使用する名刺情報を選択してください</h3>
      
      <%
			for(int i = 0;i<list.size();i++){
	  %>
	  		<section>
	      		<table>
	      			<tr>
	      				<th>
	      					会社名
	      				</th>
	      				<td>
	      					<%= list.get(i).get("companyname") %>
	      				</td>
	      			</tr>
	      			<tr>
	      				<th>
	      					名前
	      				</th>
	      				<td>
	      					<%= list.get(i).get("name") %>
	      				</td>
	      			</tr>
	      			<tr>
	      				<th>
	      					部署名
	      				</th>
	      				<td>
	      					<%= list.get(i).get("department") %>
	      				</td>
	      			</tr>
	      			<tr>
	      				<th>
	      					役職
	      				</th>
	      				<td>
	      					<%= list.get(i).get("position") %>
	      				</td>
	      			</tr>
	      			<tr>
	      				<td colspan="2" id="sentaku">
	      					<form method="post" action="\syu_pre\input.jsp">
	      						<input type="hidden" name="cardid" value="<%= list.get(i).get("cardid") %>">
	      						<input type="submit" value="選択" class="button2">
	      					</form>
	      				</td>
	      			</tr>
	      		</table>
	      	</section>
	   <%
			}
	   %>
      
      <form>
      <p id="botan2">
	     <input type="submit" value="戻る" formaction="main.jsp" class="button">
	    </p>
      </form>
     </section>
    </main>
   </div>
  </body>
</html>