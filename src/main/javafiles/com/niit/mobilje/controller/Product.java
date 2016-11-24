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
import org.springframework.web.multipart.MultipartFile;

import com.niit.mobilje.appconfig.UploadImage;
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
			if(prod.saveProduct(p))
			{	
				m.addAttribute("whenSave",true);
				m.addAttribute("onclickProduct",1);
				m.addAttribute("proMessage", "Product entred succesfully");
				m.addAttribute("entry", true);
				String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
				String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
				String prodData=this.prod.productList(new ProductDetails());  //instance variable
				m.addAttribute("categoryData",cateData);
				m.addAttribute("supplierData",supData);
				m.addAttribute("productData",prodData);
				
				@SuppressWarnings("unused")
				UploadImage up=new UploadImage(p.getImage(), p.getP_id());				
				return "AdminHome";
			}//end if
			else
			{	
				m.addAttribute("whenSave",true);		
				m.addAttribute("proMessage", "Error");
				m.addAttribute("error", true);
				m.addAttribute("onclickProduct",1);
				String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
				String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
				String prodData=this.prod.productList(new ProductDetails());  //instance variable
				m.addAttribute("categoryData",cateData);
				m.addAttribute("supplierData",supData);
				m.addAttribute("productData",prodData);
				return "AdminHome";	
			}//end else
	}//end post
	
	@RequestMapping(value="/deleteProd", method=RequestMethod.GET)
	public String deleteProd(@RequestParam("pid") String pid,Model m,Map<String,Object> model)
	{	
		if(this.prod.deleteProduct(pid))
		{
			m.addAttribute("whenSave",true);
			m.addAttribute("onclickProduct",1);
			m.addAttribute("message","Product Deleted");
			m.addAttribute("delete",true);
			String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
			String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
			String prodData=this.prod.productList(new ProductDetails());  //instance variable
			m.addAttribute("categoryData",cateData);
			m.addAttribute("supplierData",supData);
			m.addAttribute("productData",prodData);
			System.out.println("Entry Deleted");
			ProductDetails prod= new ProductDetails();
			model.put("prod_form",prod);
			return "AdminHome";
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
			System.out.println("Entry Deleted");
			ProductDetails prod= new ProductDetails();
			model.put("prod_form",prod);
			return "AdminHome";
		}//end else
		
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
	
	@RequestMapping(value="/updatePage", method=RequestMethod.POST)
	public String upateProduct(@ModelAttribute("prod_form") ProductDetails p, Map<String,Object> model,Model m)
	{
			if(this.prod.updateProduct(p))
			{	
				m.addAttribute("whenSave",true);
				m.addAttribute("onclickProduct",1);
				m.addAttribute("proMessage", "updated succesfully");
				m.addAttribute("entry", true);
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
				m.addAttribute("whenSave",true);
				m.addAttribute("onclickProduct",1);
				m.addAttribute("proMessage", "Product entred succesfully");
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
