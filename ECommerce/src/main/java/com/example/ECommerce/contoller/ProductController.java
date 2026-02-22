package com.example.ECommerce.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ECommerce.entity.Product;
import com.example.ECommerce.service.ProductService;

@RestController
@RestControllerAdvice
public class ProductController {
	List<String> products=new ArrayList<>();
	
	@Autowired
	ProductService productService;
	
    @GetMapping("/hello")
	public String hello()
	{
		return "Hello World";
	}

    @PostMapping("/products")
    public String createProduct(@RequestBody Product product)
    {
    	return productService.createProduct(product);
    	
    }
    @GetMapping("/products")
    public List<Product> getProduct()
    {
    	return productService.getProducts();
    }
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable int id,@RequestBody String product)
    {
    	if(id>=0&& id<products.size())
    	{
    		products.set(id, product);
    	return "Product updated";
    	}
    	else
    	{
    		return "Product not updated";
    	}
    	
    }
    @DeleteMapping("/products")
    public String deleteProduct(@RequestParam int id)
    {
    	if(id>=0 & products.size()>0)
    	{
    		products.remove(id);
    		return "Product removed";
    	}
    	else
    	{
    		return "Product not found";
    	}
    }
    
    @GetMapping("/products/search")
    public List<Product> findByNameAndPrice(@RequestParam String name,@RequestParam float price)
    {
    	return productService.findByNameAndPrice(name, price);
    }
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e)
    {
    	return "An error occured:"+e.getLocalizedMessage();
    }
}
