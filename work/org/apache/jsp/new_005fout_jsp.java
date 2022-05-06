package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class new_005fout_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTL 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n");
      out.write("\t  　　　 <title>新規登録</title>\r\n");
      out.write("\t   　　　<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t <div id=\"wrap\">\r\n");
      out.write("\t  <main>\r\n");
      out.write("       <section>\r\n");
      out.write("        <center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("        <h3>新規登録</h3><br>\r\n");
      out.write("        <form method=\"post\" action=\"/syu_pre/login.jsp\">\r\n");
      out.write("\t\t");

			if(ins_count == 0){
		
      out.write("\r\n");
      out.write("\t\t\t\t<p>追加NG</p>\r\n");
      out.write("\t\t\t\t<p>");
      out.print( "登録処理が失敗しました" );
      out.write("</p>\r\n");
      out.write("\t\t");

			}else{
		
      out.write("\r\n");
      out.write("\t\t\t\t<p>追加OK</p>\r\n");
      out.write("\t\t\t\t<p>");
      out.print( ins_count + "件 登録完了しました" );
      out.write("</p>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<p id=\"botan6\">\r\n");
      out.write("\t\t\t<input type=\"submit\" class=\"button\" value=\"ログイン画面へ戻ります\">\r\n");
      out.write("\t\t</p><br><br>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t　　　</section>\r\n");
      out.write("    　　　　</main>\r\n");
      out.write("   　　　</div>\r\n");
      out.write("　　</body>\r\n");
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
