package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	
	String login_id = (String)session.getAttribute("login_id");
	
	 if(login_id == null){
	 	response.sendRedirect("login.jsp");
	 }
	 
	 //有効期限5分
	 session.setMaxInactiveInterval(60*5);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write(" <head>\r\n");
      out.write("   <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n");
      out.write("   <title>メイン画面</title>\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("   <div id=\"wrap\">\r\n");
      out.write("    <main>\r\n");
      out.write("     <section>\r\n");
      out.write("               ようこそ ");
      out.print( login_id );
      out.write(" さん<br />\r\n");
      out.write("      <center><img src=\"imagehtml/logo.png\" alt=\"ロゴ\" width=\"300\" height=\"68\"></center>\r\n");
      out.write("      <h3>メイン画面</h3>\r\n");
      out.write("      <form method=\"post\">\r\n");
      out.write("    \t\t<p id=\"aa\" ><input type=\"submit\" value=\"名刺入力\" formaction=\"read.jsp\" class=\"button\"></p>\r\n");
      out.write("    \t\t<p id=\"aa\" ><input type=\"submit\" value=\"名刺一覧\" formaction=\"list.jsp\" class=\"button\"></p>\r\n");
      out.write("    \t\t<p id=\"aa\" ><input type=\"submit\" value=\"報告書入力\" formaction=\"input_st.jsp\" class=\"button\"></p>\r\n");
      out.write("    \t\t<p id=\"aa\" ><input type=\"submit\" value=\"報告書入力履歴\" formaction=\"input_check.jsp\" class=\"button\"></p>\r\n");
      out.write("    \t\t<!--<p id=\"aa\" ><input type=\"submit\" value=\"ファイルダウンロード\" formaction=\"/syu_pre/download.jsp\" class=\"button\"></p>-->\r\n");
      out.write("      </form>\r\n");
      out.write("      <form method=\"post\" action=\"/syu_pre/account.jsp\">\r\n");
      out.write("    \t\t<p id=\"aa\" ><input type=\"submit\" value=\"アカウント管理画面\" class=\"button\"></p>\r\n");
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
