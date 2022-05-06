package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class read_005fselect_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	
	String login_id = (String)session.getAttribute("login_id");
	if(login_id == null){
	 	response.sendRedirect("login.jsp");
	}
	//有効期限1分
	session.setMaxInactiveInterval(60*5);
	
	int loopnumber = Integer.parseInt(request.getParameter("loopnumber"));
	
	String[] data = new String[loopnumber];
	
	for(int lp = 0; lp < loopnumber ; lp++){
		data[lp] = request.getParameter("datano_"+ lp);
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n");
      out.write("\t\t<title>名刺情報選択</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main2.css\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div id=\"wrap\">\r\n");
      out.write("\t\t\t<main>\r\n");
      out.write("\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t");
      out.print( login_id );
      out.write(" さんでログイン中<br />\r\n");
      out.write("\t\t\t\t\t<center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("\t\t\t\t\t<h3>名刺情報選択</h3><br>\r\n");
      out.write("\t\t\t\t\t<form method=\"post\" action=\"/syu_pre/read_end.jsp\">\r\n");
      out.write("\t\t\t\t\t\t");
 for(int x = 0 ; x < loopnumber ; x++){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t   <input type=\"text\" name=\"data_");
      out.print( x );
      out.write("\" value=\"");
      out.print( data[x] );
      out.write("\" size=30>\r\n");
      out.write("\t\t\t\t\t\t\t   <select size=1 name=\"datatype_");
      out.print( x );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t   \t\t<option value=\"1\">　　　　</option>\r\n");
      out.write("\t\t\t\t\t\t\t   \t\t<option value=\"2\">会社名</option>\r\n");
      out.write("\t\t\t\t\t\t\t   \t\t<option value=\"3\">部署名</option>\r\n");
      out.write("\t\t\t\t\t\t\t   \t\t<option value=\"4\">役職</option>\r\n");
      out.write("\t\t\t\t\t\t\t   \t\t<option value=\"5\">氏名</option>\r\n");
      out.write("\t\t\t\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<p id=\"botan\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"loopnumber\" value=\"");
      out.print( loopnumber );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t    <input type=\"submit\" value=\"登録\" class=\"button\">\r\n");
      out.write("\t\t\t\t\t   \t</p><br><br>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</main>\r\n");
      out.write("\t\t</div>\r\n");
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
