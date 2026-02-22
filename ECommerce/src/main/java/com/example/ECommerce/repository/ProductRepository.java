package com.example.ECommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ECommerce.entity.Product;

import jakarta.persistence.Id;

public interface ProductRepository extends JpaRepository<Product, Id> {
List<Product> findByName(String name);
List<Product> findByPrice(float price);
List<Product> findByNameAndPrice(String name,float price);

@Query("select p from Product p where p.name=:name")
List<Product> findByNameJPQL(@Param("name") String name);

@NativeQuery(value="select * from product where name=:name")
List<Product> findByNameNative(@Param("name") String name);


}
