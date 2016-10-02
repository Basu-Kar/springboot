package com.ksoft.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksoft.product.models.Product;
import com.ksoft.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/save")
	public boolean saveProductDetails(@RequestBody Product product){
		return true;
	}
	
	@RequestMapping("/product/get/{prodId}")
	public Product getProductDetails(@PathVariable int prodId){
		return new Product();
	}
	
	@RequestMapping("/product/getAllProducts/{departmentId}")
	public List<Product> getAllProductByDepartment(@PathVariable int deptId){
		return new ArrayList<Product>();
	}
}
