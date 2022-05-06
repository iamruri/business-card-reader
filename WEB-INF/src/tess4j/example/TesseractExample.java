package tess4j.example;

import java.io.File;
import net.sourceforge.tess4j.*;

public class TesseractExample {
	public static void main(String[] args){
		ITesseract instance = new Tesseract();
		String[] array;
		
		//tessdataフォルダパスの指定
		instance.setDatapath("C:\\Users\\nhs10109\\Desktop\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		instance.setLanguage("jpn");
		
		//画像ファイルのパス
		File imageFile = new File("c:\\bc172ym-L.jpg");
		
		try{
			String result = instance.doOCR(imageFile);
			array = result.split("\n");
			System.out.println(result);
			for(int x = 0; x <= array.length; x++){
				System.out.println(array[0]);
			}
		}catch(TesseractException e){
			System.err.println(e.getMessage());
		}
	}
}