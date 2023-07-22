package com.arti08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arti08.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
