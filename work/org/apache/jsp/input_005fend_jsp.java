package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class input_005fend_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTL 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>報告書を登録しました</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("\t\t<meta HTTP-EQUIV=\"content-type\" CONTENT=\"text/html;charset=UTF-8\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t　<div id=\"wrap\">\r\n");
      out.write("    \t<main>\r\n");
      out.write("     \t\t<section>\r\n");
      out.write("     \t\t\t");
      out.print( login_id );
      out.write(" さんでログイン中<br />\r\n");
      out.write("     \t\t\t<center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("\t\t      ");

					if(ins_count == 0){
			  
      out.write("\r\n");
      out.write("\t\t\t\t\t<h3>報告書入力失敗</h3>\r\n");
      out.write("\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<p id=\"a\">");
      out.print( "登録処理が失敗しました" );
      out.write("</p>\r\n");
      out.write("\t\t\t  ");

					}else{
			  
      out.write("\r\n");
      out.write("\t\t\t  \t\t<h3>報告書入力完了</h3>\r\n");
      out.write("\t\t\t  \t\t<form>\r\n");
      out.write("\t\t\t  \t\t<p id=\"a\">報告書を記録しました。</p>\r\n");
      out.write("\t\t\t  ");

					}
			  
      out.write("\r\n");
      out.write("\t\t\t  <p id=\"aa\">\r\n");
      out.write("\t      \t\t<input type=\"submit\" value=\"もう一度入力する\" formaction=\"input_st.jsp\" class=\"button\">\r\n");
      out.write("\t      \t\t<input type=\"submit\" value=\"完了\" formaction=\"main.jsp\" class=\"button\">\r\n");
      out.write("\t   \t\t　　</p><br><br>\r\n");
      out.write("\t   \t\t</form>\r\n");
      out.write("     \t　　</section>\r\n");
      out.write("    　　　　　　</main>\r\n");
      out.write("   \t　</div>\r\n");
      out.write("  </body>\r\n");
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
