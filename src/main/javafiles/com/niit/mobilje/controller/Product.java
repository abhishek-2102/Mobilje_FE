package com.niit.mobilje.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

@Controller
public class Product {
	
	@Autowired
	ProductDao prod;
	
	@RequestMapping(value="productPage",method = RequestMethod.GET)
	public String viewProdPage(Map<String,Object> model,Model m,HttpSession sess)
	{	
		m.addAttribute("whenSave",true);	
		m.addAttribute("onclickProduct",1);
		ProductDetails prod= new ProductDetails();
		model.put("prod_form",prod);
		
		String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
		String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
		String prodData=this.prod.productList(new ProductDetails());  //instance variable
		
		m.addAttribute("categoryData",cateData);
		m.addAttribute("supplierData",supData);
		m.addAttribute("productData",prodData);
		return "AdminHome";
	}//end get

	@RequestMapping(value="productPage", method = RequestMethod.POST)
	public String prosProd(@ModelAttribute("prod_form") ProductDetails p, Map<String,Object> model,Model m)
	{		
		m.addAttribute("whenSave",true);
		
		if(p.getImage().size()==3){
			
			m.addAttribute("onclickProduct",1);
			m.addAttribute("entry", true);
			m.addAttribute("proMessage", "Product entred succesfully");
			
			String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
			System.out.println("No of images "+p.getImage().size());
			
			int i = 1;
			
			
		/*	for (int j = 1; j <= number; j++) {
				String photoName=p.getP_id()+"_"+j+".jpg";
					try {
						p.getClass().getMethod("setImage"+j,String.class).invoke(p,photoName);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
					
						e.printStackTrace();
					}//end try catch
			}//end for loop for upload image to database
			*/
			
			p.setImage1(p.getP_id()+"_1.jpg");
			p.setImage2(p.getP_id()+"_2.jpg");
			p.setImage3(p.getP_id()+"_3.jpg");
			prod.saveProduct(p);
			System.out.println("No of images got "+p.getImage().size());
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
			
			String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
			String supData=this.prod.supplierList(new SupplierDetails());   //instance variable
			String prodData=this.prod.productList(new ProductDetails());    //instance variable
			
			m.addAttribute("categoryData",cateData);
			m.addAttribute("supplierData",supData);
			m.addAttribute("productData",prodData);
		}//end save product
		
		else
			{	
			if(p.getImage().size()!=3){
				m.addAttribute("PhotoNo",true);
				m.addAttribute("PhotoMessage","Upload 3 photos only");
				}
		
			m.addAttribute("whenSave",true);		
			m.addAttribute("onclickProduct",1);

			String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
			String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
			String prodData=this.prod.productList(new ProductDetails());  //instance variable
				
			m.addAttribute("categoryData",cateData);
			m.addAttribute("supplierData",supData);
			m.addAttribute("productData",prodData);	
			
			}//end else
			return "AdminHome";
	}//end post
	
	@RequestMapping(value="/deleteProd", method=RequestMethod.GET)
	public String deleteProd(@RequestParam("pid") String pid,Model m,Map<String,Object> model)
	{	
		if(this.prod.deleteProduct(pid))
		{
			m.addAttribute("whenSave",true);
			m.addAttribute("onclickProduct",1);
			m.addAttribute("proMessage","Product Deleted");
			m.addAttribute("delete",true);
			String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
			
			for(int j=1;j<=3;j++){
			String photoName=pid+"_"+j+".jpg";
			
			String filename=path+photoName;
			System.out.println(filename);
			File f=new File(filename);
			
			if(f.exists()){
				f.delete();
				System.out.println("Delted photo "+j);
				}//end delete if
			}//end for loop
			String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
			String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
			String prodData=this.prod.productList(new ProductDetails());  //instance variable
			
			m.addAttribute("categoryData",cateData);
			m.addAttribute("supplierData",supData);
			m.addAttribute("productData",prodData);
			ProductDetails prod= new ProductDetails();
			model.put("prod_form",prod);
		}//end if
		else
		{	
			m.addAttribute("whenSave",true);
			m.addAttribute("onclickProduct",1);
			m.addAttribute("message","Error while deleting product");
			m.addAttribute("delete",false);
			
			String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
			String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
			String prodData=this.prod.productList(new ProductDetails());  //instance variable
			
			m.addAttribute("categoryData",cateData);
			m.addAttribute("supplierData",supData);
			m.addAttribute("productData",prodData);
		
			ProductDetails prod= new ProductDetails();
			model.put("prod_form",prod);
		}//end else
		return "AdminHome";
	}//end delete product
	
	@RequestMapping(value="/updateProd", method=RequestMethod.GET)
	public String getProduct(@RequestParam("pid") String pid,Model m,Map<String,Object> map)
	{	
		
		m.addAttribute("whenUpdate",true);
		m.addAttribute("onclickProduct",1);	
		
		String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
		String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
		String prodData=this.prod.productList(new ProductDetails());  //instance variable
		
		m.addAttribute("categoryData",cateData);
		m.addAttribute("supplierData",supData);
		m.addAttribute("productData",prodData);
		ProductDetails prod=this.prod.getProduct(pid);
		
		map.put("prod_form",prod);
		return "AdminHome";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String upateProduct(@ModelAttribute("prod_form") ProductDetails p, Map<String,Object> model,Model m)
	{
			
			if(p.getImage().size()==3)
			{	
				System.out.println("Update Begins");
				m.addAttribute("whenUpdate",true);
				m.addAttribute("onclickProduct",1);
				m.addAttribute("proMessage", "updated succesfully");
				m.addAttribute("update", true);
				
				String path="E:\\maven workspace\\MobiljeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\Uploads\\";
	
				int i = 1;
				
				int number=p.getImage().size();
				for (int j = 1; j <= number; j++) {
					String photoName=p.getP_id()+"_"+j+".jpg";
						try {
							p.getClass().getMethod("setImage"+j,String.class).invoke(p,photoName);
						} catch (Exception e) {
							e.printStackTrace();
							break;
						}//end try catch
				}//end for loop for upload image to database
				
				this.prod.updateProduct(p);
				
				for( MultipartFile img:p.getImage())
				{	
					System.out.println(img);
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
					
					i++;
				}//end for loop	
				
				String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
				String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
				String prodData=this.prod.productList(new ProductDetails());  //instance variable
				
				m.addAttribute("categoryData",cateData);
				m.addAttribute("supplierData",supData);
				m.addAttribute("productData",prodData);
				
				return "AdminHome";
			}//end if
	
			else
			{
				if(p.getImage().size()!=3){
					m.addAttribute("PhotoNo",true);
					m.addAttribute("PhotoMessage","Upload 3 photos only");
					}
				
				m.addAttribute("whenSave",true);
				m.addAttribute("onclickProduct",1);
				
				m.addAttribute("entry", true);
				
				String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
				String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
				String prodData=this.prod.productList(new ProductDetails());  //instance variable
				
				m.addAttribute("categoryData",cateData);
				m.addAttribute("supplierData",supData);
				m.addAttribute("productData",prodData);
				
				return "AdminHome";
					
				}//end else
		}//end update 
}

