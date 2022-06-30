package com.barcode.test;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;


public class Barcode_PDF {

	public static void main(String[] args) {
		Barcode_PDF.createPDF("barcode.pdf","Ramesh");
	}
	private static void createPDF(String pdfFileName,String myString) {
		Document doc = new Document();
		PdfWriter pdfWriter = null;

		try {
			pdfWriter = PdfWriter.getInstance(doc,new FileOutputStream("D:\\BARCODE\\" + pdfFileName));
			doc.addAuthor("Ramesh");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("ramesh.com");
			doc.addTitle("Barcode Test");
			doc.setPageSize(PageSize.LETTER);
			doc.open();
			//doc.add(new Paragraph("Get Barcode though Barcode128"));
			PdfContentByte cb = pdfWriter.getDirectContent();
			
			
//*********************Get Barcode though Barcode128*********************************
			
			Barcode128 code128 = new Barcode128();
			code128.setCode(myString.trim());
			code128.setCodeType(Barcode128.CODE128);
			Image code128Image = code128.createImageWithBarcode(cb, null, null);
			code128Image.setAbsolutePosition(10, 700);
			code128Image.scalePercent(125);
			doc.add(code128Image);
			
			
//*********************Get Barcode though BarcodeEAN*********************************	
			
			BarcodeEAN codeEAN = new BarcodeEAN();
			codeEAN.setCode(myString.trim());
			codeEAN.setCodeType(BarcodeEAN.EAN8);
			Image codeEANImage = code128.createImageWithBarcode(cb, null, null);
			codeEANImage.setAbsolutePosition(10, 600);
			codeEANImage.scalePercent(125);
			doc.add(codeEANImage);
			
			doc.close();
			
			System.out.println("Generated Successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
