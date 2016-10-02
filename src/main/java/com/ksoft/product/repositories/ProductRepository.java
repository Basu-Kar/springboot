package com.ksoft.product.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ksoft.product.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
