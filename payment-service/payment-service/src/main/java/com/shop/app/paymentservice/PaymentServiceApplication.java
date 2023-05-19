package com.shop.app.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * 
 * Redis acting as database and cache when we use @Enable aching
 * @Cacheable ->get
 * @CacheEvict->delete
 * @CcahePut->update
 */
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
