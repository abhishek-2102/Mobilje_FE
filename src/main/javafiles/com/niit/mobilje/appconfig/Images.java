package com.niit.mobilje.appconfig;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.niit.mobilje.trans.ProductDetails;

public class Images {
	String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
	
	public void DisplMultiImage(ProductDetails p){
		
		System.out.println("No of images "+p.getImage().size());
		
		int i = 1;
		
		for( MultipartFile img:p.getImage())
		{	
			
			System.out.println("Storing images");
			String photoName=p.getP_id()+"_"+i+".jpg";
			
			String filename=path+photoName;
			System.out.println(filename);
			File f=new File(filename);
			try {
				
				byte[] byt= img.getBytes();
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(f));
				bos.write(byt);
				bos.close();
				System.out.println("No of image "+i);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} 
			i++;//
		}//end for loop	
	}//end display
	
	public void DeleteImg(String pid){
		
		for(int j=1;j<=3;j++)
		{
		String photoName=pid+"_"+j+".jpg";
		
		String filename=path+photoName;
		System.out.println(filename);
		File f=new File(filename);
		
		if(f.exists()){
			f.delete();
			}//end delete if
		}//end for loop
	}//end delete image
}
