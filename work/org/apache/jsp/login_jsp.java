package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String logout = request.getParameter("logout");
	
	if(logout != null){
		//セッション変数を削除
		session.removeAttribute("login_id");
	}
	String login_id = (String)session.getAttribute("login_id");
	
	if(login_id != null){
		response.sendRedirect("main.jsp");
	}	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n");
      out.write("\t\t<title>ログイン画面</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t<div id=\"wrap\">\r\n");
      out.write("\t\t\t<main>\r\n");
      out.write("\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t<center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("\t\t\t\t\t<h3>ログイン</h3>\r\n");
      out.write("\t\t\t\t\t<form method=\"post\" action=\"/syu_pre/login2.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<p id=\"midashi\">ID</p>\r\n");
      out.write("\t\t\t\t\t\t<p><input type=\"text\" name=\"id\" size=\"30\"></p>\r\n");
      out.write("\t\t\t\t\t\t<p id=\"midashi\">パスワード</p>\r\n");
      out.write("\t\t\t\t\t\t<p><input type=\"text\" name=\"pw\" size=\"30\"></p>\r\n");
      out.write("\t\t\t\t\t\t<p id=\"pass\"><a href=\"changepassin.jsp\">パスワードを忘れた場合</a></p>\r\n");
      out.write("\t\t\t\t\t\t<p><input type=\"submit\" value=\"新規作成\" formaction=\"new.jsp\" class=\"button\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"ログイン\" class=\"button\">\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
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
