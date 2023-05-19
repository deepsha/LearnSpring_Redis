package com.shop.app.inventoryservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.shop.app.inventoryservice.entity.Product;

@Repository
public class ProductDAO {

	public static final String HASH_KEY = "Product";
	@Autowired
	private RedisTemplate template;
	
	 public Product save(Product product){
	        template.opsForHash().put(HASH_KEY,product.getId(),product);
	        return product;
	 }

	public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
    	System.out.println("calling findProductById:");
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteProduct(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }

	public String updateProduct(Product product) {
		save(product);
		return "Product"+product.getName()+" is updated";
	}

}
