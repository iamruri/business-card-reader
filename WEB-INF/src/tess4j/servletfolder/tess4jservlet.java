package tess4j.servletfolder;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import net.sourceforge.tess4j.*;

public class tess4jservlet extends HttpServlet{
	public void doPost(				//ポスト送信なのでdoPostで値を受け取る
			HttpServletRequest req,
			HttpServletResponse res )
	throws ServletException,IOException{
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out=res.getWriter();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html><body>");
		sb.append("<center><h1>");
		sb.append("コンソールにtess4jの動作結果が出ているか確認してください");
		sb.append("<br>");
		sb.append("</h1></center>");
		sb.append("<a href='/syu_pre/main.jsp'>");
		sb.append("メイン画面へ戻る");
		sb.append("</a>");
		sb.append("</body></html>");
		out.println(sb.toString());
	}
}
