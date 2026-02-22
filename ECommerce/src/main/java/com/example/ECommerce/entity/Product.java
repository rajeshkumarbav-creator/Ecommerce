package com.example.ECommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="Product")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Long id;
@Column(name="product_name",nullable = false)
String name;
@Column(name="product_description",nullable=false)
String description;
@Min(1)
@Column(name="product_price",nullable=false)
float price;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

}
