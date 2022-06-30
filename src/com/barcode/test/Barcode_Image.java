package com.barcode.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class Barcode_Image {

	public static void main(String[] args) {
	Barcode_Image.createImage("www.png", "9999999999");
	System.out.println("SUccess");
	}

	public static void createImage(String image, String myString) {
		try {
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "Image/x.png",300, BufferedImage.TYPE_BYTE_BINARY,false,180);
			code128.generateBarcode(canvas, myString);
			canvas.finish();
			
			//Write to PNG file
			
			FileOutputStream fos = new FileOutputStream("D:\\BARCODE\\" + image);
			fos.write(baos.toByteArray());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
}
