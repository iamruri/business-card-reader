package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class input_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	
	String login_id = (String)session.getAttribute("login_id");
	
	 if(login_id == null){
	 	response.sendRedirect("login.jsp");
	 }
	 
	 //有効期限5分
	 session.setMaxInactiveInterval(60*5);
	
	String cardidstr = request.getParameter("cardid");
	
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
		SQL.append("select companyname,name,department,position from card_tbl where cardid = " + "'" + cardidstr + "'" );
		
		rs = stmt.executeQuery(SQL.toString());
		
		while(rs.next()){
			map = new HashMap<String,String>();
			map.put("companyname",rs.getString("companyname"));
			map.put("name",rs.getString("name"));
			map.put("department",rs.getString("department"));
			map.put("position",rs.getString("position"));
			
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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTL 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write(" <head>\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <title>報告書入力画面</title>\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("   <div id=\"wrap\">\r\n");
      out.write("    <main>\r\n");
      out.write("\r\n");
      out.write("     <section>\r\n");
      out.write("      ");
      out.print( login_id );
      out.write(" さんでログイン中<br />\r\n");
      out.write("      <center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("      <h3>報告書入力</h3>\r\n");
      out.write("     </section>\r\n");
      out.write("\r\n");
      out.write("      <form>\r\n");
      out.write("        <section id=\"table01\">\r\n");
      out.write("          <table>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th>件名</th>\r\n");
      out.write("                <td colspan=\"3\"><textarea name=\"subject\" cols=\"49\"></textarea></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th>報告先</th>\r\n");
      out.write("                <td colspan=\"3\"><input name=\"report_to\" type=\"text\" cols=\"49\">印</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th colspan=\"4\">1)詳細</th>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th>訪問先</th>\r\n");
      out.write("                <td colspan=\"3\"><input name=\"destination\" type=\"text\" cols=\"50\" value=\"");
      out.print( list.get(0).get("companyname") );
      out.write("\"></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th>部署名</th>\r\n");
      out.write("                <td><input name=\"affiliation\" type=\"text\" value=\"");
      out.print( list.get(0).get("department") );
      out.write("\"></td>\r\n");
      out.write("                <th>氏名</th>\r\n");
      out.write("                <td><input name=\"name\" type=\"text\" value=\"");
      out.print( list.get(0).get("name") );
      out.write("\"></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <!-- <tr>\r\n");
      out.write("                <th>日時</th>\r\n");
      out.write("                <td colspan=\"3\"><input name=\"time\" type=\"text\"></td>\r\n");
      out.write("              </tr> -->\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th>内容</th>\r\n");
      out.write("                <td colspan=\"3\"><textarea name=\"contents\" cols=\"49\" rows=\"8\"></textarea></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th>特記事項</th>\r\n");
      out.write("                <td colspan=\"3\"><textarea name=\"extra\" cols=\"49\" rows=\"8\"></textarea></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </section>\r\n");
      out.write("        <p id=\"botan3\">\r\n");
      out.write("  \t     <input type=\"submit\" value=\"登録\" formaction=\"input_end.jsp\" class=\"button\">\r\n");
      out.write("  \t    </p>\r\n");
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
