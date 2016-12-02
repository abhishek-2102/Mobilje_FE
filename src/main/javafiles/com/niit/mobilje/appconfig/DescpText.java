package com.niit.mobilje.appconfig;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import com.niit.mobilje.trans.ProductDetails;


public class DescpText {

	public DescpText(ProductDetails p){
		String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
		String textname=p.getP_id()+".txt";
		String filename=path+textname;
		File f=new File(filename);
		
		try {
			
			InputStream is=p.getDesc_text().getInputStream();
			
			FileOutputStream fos= new FileOutputStream(f);
			BufferedOutputStream bos= new BufferedOutputStream(fos);
			int i=0;
			byte[] b=p.getDesc_text().getBytes();
			
			while((i=is.read(b))!= -1){
				bos.write(b,0,i);
				bos.flush();
				System.out.println(bos);
			}
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}// end constructor
	
	public static void DeleteText(String id){
		String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
		String textname=id+".txt";
		String filename=path+textname;
		File f=new File(filename);
		
		if(f.exists()){
			f.delete();
			}//end delete 
	}//end delete text
	
	public static String DisplText(String id){
		String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
		String filename=path+id+".txt";
		File f=new File(filename);
		StringBuffer sb =new StringBuffer();
		String text=null;
		try {
				@SuppressWarnings("resource")
				BufferedReader br=new BufferedReader(new FileReader(f));	
				while((text=br.readLine())!= null){
					sb.append(text);
					sb.append("\n");
				}
			} catch (IOException e) {
			e.printStackTrace();
		}//end while
		return sb.toString();
	}//end disp
}
