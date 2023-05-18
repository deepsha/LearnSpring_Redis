package com.shop.app.inventoryservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.app.inventoryservice.entity.Product;
import com.shop.app.inventoryservice.repository.ProductDAO;

@RestController
@RequestMapping("/shop")
public class ProductController {
	
		private final ProductDAO dao;
	 	public  ProductController(ProductDAO dao)
	 	{
	 		this.dao=dao;
	 	}
	    
	    @PostMapping
	    public Product save(@RequestBody Product product) {
	        return dao.save(product);
	    }

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return dao.findAll();
	    }

	    @GetMapping("/{id}")
	    public Product findProduct(@PathVariable int id) {
	        return dao.findProductById(id);
	    }
	    @DeleteMapping("/{id}")
	    public String remove(@PathVariable int id)   {
	    	return dao.deleteProduct(id);
		}


}
