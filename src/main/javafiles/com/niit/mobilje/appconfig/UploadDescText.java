package com.niit.mobilje.appconfig;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.niit.mobilje.trans.ProductDetails;


public class UploadDescText {

	public UploadDescText(ProductDetails p){
		String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
		String filename=path+p.getP_id()+".txt";
		
		File f=new File(filename);
		try {
			InputStream is=p.getDesc_text().getInputStream();
			
			FileOutputStream fos= new FileOutputStream(f);
			@SuppressWarnings("resource")
			BufferedOutputStream bos= new BufferedOutputStream(fos);
			int i=0;
			byte[] b=p.getDesc_text().getBytes();
			while((i=is.read(b))!= -1){
				bos.write(b,0,i); 
			}
		} catch ( IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
