package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	//有効期限1分
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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTL 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write(" <head>\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <title>名刺一覧表示画面</title>\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"css/list.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  ");
 if(ERMSG != null){ 
      out.write("\r\n");
      out.write("\t\t予期せぬエラーが発生しました。<br/>\r\n");
      out.write("\t\t");
      out.print( ERMSG );
      out.write('\r');
      out.write('\n');
      out.write('	');
 } 
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("   <div id=\"wrap\">\r\n");
      out.write("    <main>\r\n");
      out.write("     <section>\r\n");
      out.write("      ");
      out.print( login_id );
      out.write(" さんでログイン中<br />\r\n");
      out.write("      <center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("      <h3>名刺情報一覧</h3>\r\n");
      out.write("      ");

			for(int i = 0;i<list.size();i++){
	  
      out.write("\r\n");
      out.write("\t  \t\t<section>\r\n");
      out.write("\t      \t\t<table>\r\n");
      out.write("\t      \t\t\t<!--<tr>\r\n");
      out.write("\t      \t\t\t\t<th>\r\n");
      out.write("\t      \t\t\t\t\t名刺No.\r\n");
      out.write("\t      \t\t\t\t</th>\r\n");
      out.write("\t      \t\t\t\t<td>\r\n");
      out.write("\t      \t\t\t\t\t");
      out.print( list.get(i).get("cardid") );
      out.write("\r\n");
      out.write("\t      \t\t\t\t</td>\r\n");
      out.write("\t      \t\t\t</tr>-->\r\n");
      out.write("\t      \t\t\t<tr>\r\n");
      out.write("\t      \t\t\t\t<th>\r\n");
      out.write("\t      \t\t\t\t\t会社名\r\n");
      out.write("\t      \t\t\t\t</th>\r\n");
      out.write("\t      \t\t\t\t<td>\r\n");
      out.write("\t      \t\t\t\t\t");
      out.print( list.get(i).get("companyname") );
      out.write("\r\n");
      out.write("\t      \t\t\t\t</td>\r\n");
      out.write("\t      \t\t\t</tr>\r\n");
      out.write("\t      \t\t\t<tr>\r\n");
      out.write("\t      \t\t\t\t<th>\r\n");
      out.write("\t      \t\t\t\t\t名前\r\n");
      out.write("\t      \t\t\t\t</th>\r\n");
      out.write("\t      \t\t\t\t<td>\r\n");
      out.write("\t      \t\t\t\t\t");
      out.print( list.get(i).get("name") );
      out.write("\r\n");
      out.write("\t      \t\t\t\t</td>\r\n");
      out.write("\t      \t\t\t</tr>\r\n");
      out.write("\t      \t\t\t<tr>\r\n");
      out.write("\t      \t\t\t\t<th>\r\n");
      out.write("\t      \t\t\t\t\t部署名\r\n");
      out.write("\t      \t\t\t\t</th>\r\n");
      out.write("\t      \t\t\t\t<td>\r\n");
      out.write("\t      \t\t\t\t\t");
      out.print( list.get(i).get("department") );
      out.write("\r\n");
      out.write("\t      \t\t\t\t</td>\r\n");
      out.write("\t      \t\t\t</tr>\r\n");
      out.write("\t      \t\t\t<tr>\r\n");
      out.write("\t      \t\t\t\t<th>\r\n");
      out.write("\t      \t\t\t\t\t役職\r\n");
      out.write("\t      \t\t\t\t</th>\r\n");
      out.write("\t      \t\t\t\t<td>\r\n");
      out.write("\t      \t\t\t\t\t");
      out.print( list.get(i).get("position") );
      out.write("\r\n");
      out.write("\t      \t\t\t\t</td>\r\n");
      out.write("\t      \t\t\t</tr>\r\n");
      out.write("\t      \t\t</table>\r\n");
      out.write("\t      \t</section>\r\n");
      out.write("\t   ");

			}
	   
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      <form>\r\n");
      out.write("      <p id=\"botan2\">\r\n");
      out.write("\t     <input type=\"submit\" value=\"戻る\" formaction=\"main.jsp\" class=\"button\">\r\n");
      out.write("\t    </p>\r\n");
      out.write("      </form>\r\n");
      out.write("      </section>\r\n");
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
