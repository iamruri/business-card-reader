package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class login2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTL 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>ログイン処理完了</title>\r\n");
      out.write("\t\t<meta HTTP-EQUIV=\"content-type\" CONTENT=\"text/html;charset=UTF-8\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t");

			if(flg == 1){
		
      out.write("\r\n");
      out.write("\t\t\t\tログイン成功しました。<br>\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"/syu_pre/main.jsp\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"メイン画面へ\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t");

			}else if(flg == 0){
		
      out.write("\r\n");
      out.write("\t\t\t\tログイン失敗<br>\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"/syu_pre/login.jsp\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"ログイン画面に戻る\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t");

				}
		
      out.write("\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t");
 if(ERMSG != null){ 
      out.write("\r\n");
      out.write("\t\t\t予期せぬエラーが発生しました<br />\r\n");
      out.write("\t\t\t");
      out.print( ERMSG );
      out.write("\r\n");
      out.write("\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\tエラーは発生しませんでした<br />\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
