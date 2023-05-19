package com.shop.app.inventoryservice.controller;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.app.inventoryservice.entity.Product;
import com.shop.app.inventoryservice.repository.ProductDAO;
import com.shop.app.inventoryservice.service.ProductService;

@RestController
@RequestMapping("/shop")
@EnableCaching 
public class ProductController {
	
		private final ProductService service;
	 	public  ProductController(ProductService service)
	 	{
	 		this.service=service;
	 	}
	    
	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return service.createProduct(product);
	    }

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return service.getAllProducts();
	    }

	    @GetMapping("/{id}")	   
	    public Product findProductById(@PathVariable int id) {
	        return service.findProductById(id);
	    }
	    @DeleteMapping("/{id}")	   
	    public String removeProduct(@PathVariable int id)   {
	    	return service.removeProduct(id);
		}
	    
	    @PutMapping
	    @CacheEvict(key="#id",value="Product")
	    public String updateProduct(@RequestBody Product product)   {
	    	return service.updateProduct(product);
		}


}
