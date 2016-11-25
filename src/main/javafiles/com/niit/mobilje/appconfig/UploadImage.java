package com.niit.mobilje.appconfig;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadImage {
	
	public UploadImage(MultipartFile img,String pid){
		
		String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
		
		String filename=path+pid+".jpg";
		File f=new File(filename);
		
		try {
			byte[] byt=img.getBytes();
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(f));
			bos.write(byt);
			bos.close();
			System.out.println("Upload");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
