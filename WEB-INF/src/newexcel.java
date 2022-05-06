import javax.servlet.*;
import javax.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class newexcel extends HttpServlet{
	public void doPost(				//ポスト送信なのでdoPostで値を受け取る
			HttpServletRequest req,
			HttpServletResponse res )
	throws ServletException,IOException{
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out=res.getWriter();
		
		String subjectstr = req.getParameter("subject");
		String report_tostr = req.getParameter("report_to");
		String destinationstr = req.getParameter("destination");
		String affiliationstr = req.getParameter("affiliation");
		String namestr = req.getParameter("name");
		String contentsstr = req.getParameter("contents");
		String extrastr = req.getParameter("extra");

		// Excelファイルを作成
	    Workbook outputWorkbook = new XSSFWorkbook();
	    // シートを作成
	    Sheet outputSheet = outputWorkbook.createSheet("user_data");
	    
	    // 行を作成
	    Row outputRow = outputSheet.createRow(0);
	    //セルを作成
	    Cell department = outputRow.createCell(0);
	    Cell department_parameter = outputRow.createCell(1);
	    Cell name = outputRow.createCell(4);
	    Cell name_parameter = outputRow.createCell(5);
	    //セルに値を設定
	    department.setCellValue("部署名");
	    department_parameter.setCellValue(affiliationstr);
	    name.setCellValue("名前");
	    name_parameter.setCellValue(namestr);
	    
	    // 行を作成
	    Row outputRow2 = outputSheet.createRow(2);
	    //セルを作成
	    Cell Subject = outputRow2.createCell(0);
	    Cell Subject_parameter = outputRow2.createCell(1);
	    //セルに値を設定
	    Subject.setCellValue("件名");
	    Subject_parameter.setCellValue(subjectstr);
	    
	    // 行を作成
	    Row outputRow3 = outputSheet.createRow(4);
	    //セルを作成
	    Cell report_to = outputRow3.createCell(0);
	    Cell report_to_parameter = outputRow3.createCell(1);
	    //セルに値を設定
	    report_to.setCellValue("報告先");
	    report_to_parameter.setCellValue(report_tostr);
	  
	    // 行を作成
	    Row outputRow4 = outputSheet.createRow(6);
	    //セルを作成
	    Cell Details = outputRow4.createCell(3);
	    //セルに値を設定
	    Details.setCellValue("1)詳細");
	    
	    // 行を作成
	    Row outputRow7 = outputSheet.createRow(12);
	    //セルを作成
	    Cell contents = outputRow7.createCell(0);
	    Cell contents_parameter = outputRow7.createCell(1);
	    //セルに値を設定
	    contents.setCellValue("内容");
	    contents_parameter.setCellValue(contentsstr);
	    
	    // 行を作成
	    Row outputRow8 = outputSheet.createRow(19);
	    //セルを作成
	    Cell extra = outputRow8.createCell(0);
	    Cell extra_parameter = outputRow8.createCell(1);
	    //セルに値を設定
	    extra.setCellValue("特記事項");
	    extra_parameter.setCellValue(extrastr);
	    
	    
	    //出力用のストリームを用意
	    FileOutputStream out1 = new FileOutputStream("C:\\java_workspace\\syu_pre\\excelfile\\report_excel.xlsx");
	    //ファイルへ出力
	    outputWorkbook.write(out1);
	    
	    res.sendRedirect("/syu_pre/download.jsp");
	}
}
