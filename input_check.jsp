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
		SQL.append("select affiliation,name,subject,report_to,contents,extra from report_tbl where userid = " + "'" + login_id + "'" );
		
		rs = stmt.executeQuery(SQL.toString());
		
		while(rs.next()){
			map = new HashMap<String,String>();
			map.put("affiliation",rs.getString("affiliation"));
			map.put("name",rs.getString("name"));
			map.put("subject",rs.getString("subject"));
			map.put("report_to",rs.getString("report_to"));
			map.put("contents",rs.getString("contents"));
			map.put("extra",rs.getString("extra"));
			
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
   <title>報告書一覧表示画面</title>
   <link rel="stylesheet" type="text/css" href="css/main.css">
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
      <h3>報告書一覧</h3>
     </section>
      <%
			for(int i = 0;i<list.size();i++){
	  %>
	  <form method="post">
	  <section>
          <table>
              <tr>
                <th>件名</th>
                <td colspan="3"><textarea name="subject" cols="49" readonly><%= list.get(i).get("subject")%></textarea></td>
              </tr>
              <tr>
                <th>報告先</th>
                <td colspan="3"><input name="report_to" type="text" cols="49" value="<%= list.get(i).get("report_to")%>"　readonly>印</td>
              </tr>
              <tr>
                <th colspan="4">1)詳細</th>
              </tr>
              <!--<tr>
                <th>訪問先</th>
                <td colspan="3"><input name="destination" type="text" cols="49" value="<%= list.get(i).get("companyname") %>" ></td>
              </tr>-->
              <tr>
                <th>部署名</th>
                <td><input name="affiliation" type="text" value="<%= list.get(i).get("affiliation") %>" readonly></td>
                <th>氏名</th>
                <td><input name="name" type="text" value="<%= list.get(i).get("name") %>" readonly></td>
              </tr>
              <!-- <tr>
                <th>日時</th>
                <td colspan="3"><input name="time" type="text"></td>
              </tr> -->
              <tr>
                <th>内容</th>
                <td colspan="3"><textarea name="contents" cols="49" rows="8" readonly><%= list.get(i).get("contents")%></textarea></td>
              </tr>
              <tr>
                <th>特記事項</th>
                <td colspan="3"><textarea name="extra" cols="49" rows="8" readonly><%= list.get(i).get("extra")%></textarea></td>
              </tr>
              <tr>
              	<td colspan="4" align="center"><input type="submit" value="Excelファイルダウンロード" formaction="/syu_pre/servlet/newexcel" class="button2"></td>
              </tr>
          </table>
        </section>
		</form>
       <%
			}
	   %>
	   <form method="post">
	    <p id="botan3">
	     <input type="submit" value="戻る" formaction="main.jsp" class="button">
	    </p>
      </form>
     </section>
    </main>
   </div>
  </body>
</html>