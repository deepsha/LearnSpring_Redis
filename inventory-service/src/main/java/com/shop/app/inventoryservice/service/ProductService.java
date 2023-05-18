package com.shop.app.inventoryservice.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shop.app.inventoryservice.entity.Product;
import com.shop.app.inventoryservice.repository.ProductDAO;

@Service
public class ProductService {
	
	private final ProductDAO dao;
 	public ProductService(ProductDAO dao)
 	{
 		this.dao=dao;
 	}
 	
 	
	public Product createProduct(Product product) {		
		return dao.save(product);
	}
	
	public List<Product> getAllProducts() {		
		return dao.findAll();
	}
	
	@Cacheable(key="#id",value="Product",unless = "#result.price >10") // first time, product will be loaded from db and secondtime, it will come from cache
	public Product findProductById(int id) {
		
		return dao.findProductById(id);
	}
	@CacheEvict(key="#id",value="Product")
	public String removeProduct(int id) {		
		return dao.deleteProduct(id);
	}
	
	@CachePut(value="Product",key = "#id",condition = "#result != null")
	public String updateProduct(Product product) {
		return dao.updateProduct(product);
	}

}
