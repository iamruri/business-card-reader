package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class read2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String idstr = request.getParameter("id");
	System.out.println(idstr);

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTL 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\"><!DOCTYPE html>\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write(" <head>\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <title>名刺入力画面</title>\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("   <div id=\"wrap\">\r\n");
      out.write("    <main>\r\n");
      out.write("     <section>\r\n");
      out.write("      <h2>名刺読み取り機</h2>\r\n");
      out.write("      <h3>名刺情報入力</h3>\r\n");
      out.write("      <form method=\"post\" action=\"/syu_pre/read_end.jsp\">\r\n");
      out.write("\t   <p id=\"midashi\">会社名</p>\r\n");
      out.write("\t   <p><input type=\"text\" name=\"companyname\" size=\"30\"></p>\r\n");
      out.write("\t   <p id=\"midashi\">部署名</p>\r\n");
      out.write("\t   <p><input type=\"text\" name=\"department\" size=\"30\"></p>\r\n");
      out.write("\t   <p id=\"midashi\">役職</p>\r\n");
      out.write("\t   <p><input type=\"text\" name=\"position\" size=\"30\"></p>\r\n");
      out.write("\t   <p id=\"midashi\">氏名</p>\r\n");
      out.write("\t   <p><input type=\"text\" name=\"name\" size=\"30\"></p>\r\n");
      out.write("\t   <p id=\"botan\">\r\n");
      out.write("\t   \t  <input type=\"hidden\" name=\"id\" value=\"");
      out.print( idstr );
      out.write("\">\r\n");
      out.write("\t      <input type=\"submit\" value=\"完了\" class=\"button\">\r\n");
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
