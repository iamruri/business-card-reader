import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.util.List;
import java.util.Iterator;

import net.sourceforge.tess4j.*;

public class read extends HttpServlet{
	public void doPost(				//ポスト送信なのでdoPostで値を受け取る
			HttpServletRequest request,
			HttpServletResponse response )
	throws ServletException,IOException{
		PrintWriter out;
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    out=response.getWriter();

	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload sfu = new ServletFileUpload(factory);

	    String filename = "";
	    
	    try {
	      List list = sfu.parseRequest(request);
	      Iterator iterator = list.iterator();

	      while(iterator.hasNext()){
	        FileItem item = (FileItem)iterator.next();

	        if (!item.isFormField()){
	          filename = item.getName();

	          if ((filename != null) && (!filename.equals(""))){
	            filename = (new File(filename)).getName();
	            item.write(new File("C:\\java_workspace\\syu_pre\\images\\" + filename));
	          }

	          out.println("<p>");
	          out.println("ファイル名" + item.getName() + "を");
	          out.println("C:\\java_workspace\\syu_pre\\images\\" + filename + "に保存しました");
	          out.println("</p>");
	        }
	      }
	    }catch (FileUploadException e) {
	      e.printStackTrace();
	    }catch (Exception e) {
	      e.printStackTrace();
	    }
		
		ITesseract instance = new Tesseract();
		String array[];
		int x = 0;
		int length = 0;
		//tessdataフォルダパスの指定
		instance.setDatapath("C:\\java_workspace\\syu_pre\\tessdata");
		instance.setLanguage("jpn");
		//画像ファイルのパス
		File imageFile = new File("C:\\java_workspace\\syu_pre\\images\\" + filename);
		
		out.println("<html><body>");
		
		try{
			String result = instance.doOCR(imageFile);
			array = result.split("\n");
			length = array.length;
			out.println("<p>");
			out.println("<form method='post' action='/syu_pre/read_select.jsp'>");
			for(x = 0; x < length; x++){
				out.println("<input type='hidden' name='datano_" + x + "' value='" + array[x] + "'>");
			}
			out.println("<input type='hidden' name='loopnumber' value='" + length + "'>");
			out.println("<input type='submit' value='次へ'>");
			out.println("</form>");
			out.println("</p>");
		}catch(TesseractException e){
			System.err.println(e.getMessage());
		}
		out.println("</body></html>");
	}
}
