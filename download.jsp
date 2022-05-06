<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>
<%

	FileInputStream fIn = new FileInputStream("C:\\java_workspace\\syu_pre\\excelfile\\report_excel.xlsx");
	BufferedInputStream bufIn = new BufferedInputStream(fIn);
	byte[] buf = new byte[1000000];
	
	OutputStream os = response.getOutputStream();
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment; filename=report.xlsx");
	for (;;) {
		int end = bufIn.read(buf, 0, buf.length);
		if (end < 0) {
			break;
		}
		os.write(buf, 0, end);
	}
	fIn.close();
	os.flush();
	os.close();
	
	File dl = new File("C:\\java_workspace\\syu_pre\\excelfile\\report_excel.xlsx");
	dl.delete();
%>
