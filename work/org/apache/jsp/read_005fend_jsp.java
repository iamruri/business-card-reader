package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class read_005fend_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTL 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write(" <head>\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <title>名刺読み取り完了画面</title>\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("   <div id=\"wrap\">\r\n");
      out.write("    <main>\r\n");
      out.write("     <section>\r\n");
      out.write("     \t\t  ");
      out.print( login_id );
      out.write(" さんでログイン中<br />\r\n");
      out.write("\t\t      <center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("\t\t      ");

					if(ins_count == 0){
			  
      out.write("\r\n");
      out.write("\t\t\t\t\t<h3>名刺入力失敗</h3>\r\n");
      out.write("\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<p id=\"a\">");
      out.print( "登録処理が失敗しました" );
      out.write("</p>\r\n");
      out.write("\t\t\t  ");

					}else{
			  
      out.write("\r\n");
      out.write("\t\t\t  \t\t<h3>名刺入力完了</h3>\r\n");
      out.write("\t\t\t  \t\t<form>\r\n");
      out.write("\t\t\t  \t\t<p id=\"a\">名刺情報を記録しました。</p>\r\n");
      out.write("\t\t\t  ");

					}
			  
      out.write("\r\n");
      out.write("\t   <p id=\"aa\">\r\n");
      out.write("\t      <input type=\"submit\" value=\"もう一度読み取る\" formaction=\"read.jsp\" class=\"button\">\r\n");
      out.write("\t      <input type=\"submit\" value=\"完了\" formaction=\"main.jsp\" class=\"button\">\r\n");
      out.write("\t   </p><br><br>\r\n");
      out.write("      </form>\r\n");
      out.write("     </section>\r\n");
      out.write("    </main>\r\n");
      out.write("   </div>\r\n");
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
