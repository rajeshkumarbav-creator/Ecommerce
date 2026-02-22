package com.example.ECommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.entity.Product;
import com.example.ECommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts()
	{
		return productRepository.findAll();
	}
	public String createProduct(Product prod)
	
	{
		productRepository.save(prod);
		return "Product created";
	}
	
	public List<Product> findByName(String name)
	{
		return productRepository.findByName(name);
	}
	
	public List<Product> findByNameAndPrice(String name,float price)
	{
		return productRepository.findByNameAndPrice(name,price);
	}

}
