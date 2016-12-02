package com.niit.mobilje.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mobilje.appconfig.DescpText;
import com.niit.mobilje.appconfig.Images;
import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

@Controller
public class Product {
	
	@Autowired
	ProductDao prod;
	
	Images img=new Images();
	
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
			
			/*for (int j = 1; j <= number; j++) {
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
			
			if(prod.saveProduct(p)){
				img.DisplMultiImage(p);
				@SuppressWarnings("unused")
				DescpText upoad =new DescpText(p);
			}
			
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
			
			DescpText.DeleteText(pid);
			img.DeleteImg(pid);
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
			
			
				p.setImage1(p.getP_id()+"_1.jpg");
				p.setImage2(p.getP_id()+"_2.jpg");
				p.setImage3(p.getP_id()+"_3.jpg");
				
				prod.updateProduct(p);
				
				if(prod.updateProduct(p)){
					img.DeleteImg(p.getP_id());
					img.DisplMultiImage(p);
					@SuppressWarnings("unused")
					DescpText upoad =new DescpText(p);
				}
				
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

